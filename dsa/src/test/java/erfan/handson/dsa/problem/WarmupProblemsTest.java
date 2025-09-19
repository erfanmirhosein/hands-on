package erfan.handson.dsa.problem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

import static erfan.handson.dsa.problem.WarmupProblems.*;
import static org.assertj.core.api.Assertions.assertThat;

class WarmupProblemsTest {

    @Test
    void testFindChessBordPositionInLogTime() {
        assertThat(findChessBordPositionInLogTime(16)).isEqualTo(5);
        assertThat(findChessBordPositionInLogTime(1)).isEqualTo(1);
        assertThat(findChessBordPositionInLogTime(4)).isEqualTo(3);
    }

    @Test
    void testFilterStringsStartingWithA() {
        assertThat(filterStringsStartingWithA(new String[]{"Ali", "Mohamed"})).isEqualTo(new String[]{"Ali"});
        assertThat(filterStringsStartingWithA(new String[]{"Karim", "Mohamed"})).isEmpty();
        assertThat(filterStringsStartingWithA(new String[]{})).isEqualTo(new String[]{});
    }

    @Test
    void testGetMedium() {
        assertThat(getMedian(new int[]{1, 2, 3, 4})).isEqualTo(2);
        assertThat(getMedian(new int[]{1, 2, 3, 4, 5})).isEqualTo(3);
        assertThat(getMedian(new int[]{6})).isEqualTo(6);
    }

    @Test
    void testTwoSum() {
        assertThat(twoSum(new int[]{1, 4, 5, 6}, 7)).containsExactlyInAnyOrder(0, 3);
        assertThat(twoSum(new int[]{1, 4, 3, -6}, 2)).isEmpty();
        assertThat(twoSum(new int[]{-3, 11, 10, 9}, 20)).containsExactlyInAnyOrder(1, 3);
        assertThat(twoSum(new int[]{1, 2, 5, 1, 6}, 2)).containsExactlyInAnyOrder(0, 3);
    }

    @ParameterizedTest
    @CsvSource({"kayak,true", "ali,false", "a,true", "'',true", "ccc,true", "dd,true", "Aba, false"})
    void testIsPalindrome(String s, boolean expectedResult) {
        assertThat(isPalindrome(s)).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @ArgumentsSource(MergeSortedArraysArgumentProvider.class)
    void testMergeSortedArrays(int[] a, int[] b, int[] expectedResult) {
        assertThat(mergeSortedArrays(a, b)).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({"Erfan,rf,true", "Ali,Ali2,false", "abc,abc,true", "cuba, ubs, false", "world,o,true"})
    void testContainsSubstring(String s, String sub, boolean expectedResult) {
        assertThat(containsSubstring(s, sub)).isEqualTo(expectedResult);
    }

    static class MergeSortedArraysArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(
                            new int[]{1, 3, 4, 8}, new int[]{2, 3, 6, 9}, new int[]{1, 2, 3, 3, 4, 6, 8, 9}
                    ),
                    Arguments.of(
                            new int[]{4, 4, 4}, new int[]{4, 4,}, new int[]{4, 4, 4, 4, 4}
                    ),
                    Arguments.of(
                            new int[]{}, new int[]{-6, 7, 8}, new int[]{-6, 7, 8}
                    ),
                    Arguments.of(
                            new int[]{}, new int[]{}, new int[]{}
                    )
            );
        }
    }
}
