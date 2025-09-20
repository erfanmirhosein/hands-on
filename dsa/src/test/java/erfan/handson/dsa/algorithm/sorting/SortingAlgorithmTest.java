package erfan.handson.dsa.algorithm.sorting;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortingAlgorithmTest {
    @ParameterizedTest
    @ArgumentsSource(SortingTestArgumentProvider.class)
    void givenAnArray_whenIUseSortTheArray_thenTheResultShouldBeCorrect(int[] unsortedArray, int[] expectedResult) {
        SortingAlgorithm bubbleSortAlgorithm = new BubbleSort();
        SortingAlgorithm selectionSortAlgorithm = new SelectionSort();
        SortingAlgorithm insertionSortAlgorithm = new InsertionSort();

        assertThat(bubbleSortAlgorithm.sort(unsortedArray)).isEqualTo(expectedResult);
        assertThat(selectionSortAlgorithm.sort(unsortedArray)).isEqualTo(expectedResult);
        assertThat(insertionSortAlgorithm.sort(unsortedArray)).isEqualTo(expectedResult);
    }

    static class SortingTestArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(
                            new int[]{5, 6, 5, 1, -2, 3}, new int[]{-2, 1, 3, 5, 5, 6}
                    ), Arguments.of(
                            new int[]{}, new int[]{}
                    ), Arguments.of(
                            new int[]{-8}, new int[]{-8}
                    ), Arguments.of(
                            new int[]{-4, -3, -2, -1, 0, 1}, new int[]{-4, -3, -2, -1, 0, 1}
                    )
            );
        }
    }
}
