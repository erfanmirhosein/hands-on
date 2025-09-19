package erfan.handson.dsa.datastructure.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderedArrayTest {
    @Test
    void givenALongArray_whenIPerformLinearSearch_ThenItShouldTakeALongTime() {
        var longArray = OrderedArray.ofRange(0, 2900000);
        Assertions.assertThrows(
                AssertionError.class,
                () -> Assertions.assertTimeoutPreemptively(Duration.ofMillis(1), () -> longArray.linearSearch(5000000)));
    }

    @Test
    void givenALongArray_whenIPerformBinarySearch_ThenItReturnsQuickly() {
        var longArray = OrderedArray.ofRange(0, 2900000);
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1), () -> longArray.binarySearch(5000000));
    }

    @Test
    void givenAnArray_whenISearchTheArray_thenTheCorrectIndexShouldBeReturned() {
        var testArray = OrderedArray.ofRange(2, 2);
        assertEquals(0, testArray.binarySearch(2));
        assertEquals(-1, testArray.binarySearch(3));
        assertEquals(0, testArray.linearSearch(2));
        assertEquals(-1, testArray.linearSearch(5));

        testArray = OrderedArray.ofRange(25, 55);

        assertEquals(0, testArray.binarySearch(25));
        assertEquals(30, testArray.binarySearch(55));
        assertEquals(5, testArray.binarySearch(30));
        assertEquals(-1, testArray.binarySearch(18));

        assertEquals(0, testArray.linearSearch(25));
        assertEquals(30, testArray.linearSearch(55));
        assertEquals(5, testArray.linearSearch(30));
        assertEquals(-1, testArray.linearSearch(18));
    }

    @Test
    void givenAnArray_whenIRemoveAnElement_ThenTheResultShouldBeCorrect() {
        var testArray = OrderedArray.ofRange(2, 10);

        testArray.remove(4);
        testArray.remove(7);
        assertEquals(7, testArray.readIndex(4));
        assertEquals(9, testArray.readIndex(6));
    }

    @Test
    void givenAnArray_whenIInsertAnElement_ThenTheResultShouldBeCorrect() {
        var testArray = new OrderedArray(5);

        testArray.insert(1);
        testArray.insert(12);
        testArray.insert(3);
        testArray.insert(4);
        testArray.insert(-1);
        assertEquals(1, testArray.readIndex(1));
        assertEquals(12, testArray.readIndex(4));
        assertEquals(3, testArray.readIndex(2));
        assertEquals(4, testArray.readIndex(3));
        assertEquals(-1, testArray.readIndex(0));
    }
}
