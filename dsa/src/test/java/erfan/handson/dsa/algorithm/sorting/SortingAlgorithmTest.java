package erfan.handson.dsa.algorithm.sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SortingAlgorithmTest {
    @Test
    void givenAnArray_whenIUseSortTheArray_thenTheResultShouldBeCorrect() {
        int[] unsortedArray = new int[]{5, 6, 5, 1, -2, 3};
        int[] sortedArray = new int[]{-4, -3, -2, -1, 0, 1};
        int[] emptyArray = new int[]{};
        int[] oneElementArray = new int[]{-8};
        SortingAlgorithm bubbleSortAlgorithm = new BubbleSort();
        SortingAlgorithm selectionSortAlgorithm = new SelectionSort();
        SortingAlgorithm insertionSortAlgorithm = new InsertionSort();

        assertThat(bubbleSortAlgorithm.sort(unsortedArray)).isEqualTo(new int[]{-2, 1, 3, 5, 5, 6});
        assertThat(bubbleSortAlgorithm.sort(emptyArray)).isEqualTo(new int[]{});
        assertThat(bubbleSortAlgorithm.sort(oneElementArray)).isEqualTo(new int[]{-8});
        assertThat(bubbleSortAlgorithm.sort(sortedArray)).isEqualTo(new int[]{-4, -3, -2, -1, 0, 1});

        assertThat(selectionSortAlgorithm.sort(unsortedArray)).isEqualTo(new int[]{-2, 1, 3, 5, 5, 6});
        assertThat(selectionSortAlgorithm.sort(emptyArray)).isEqualTo(new int[]{});
        assertThat(selectionSortAlgorithm.sort(oneElementArray)).isEqualTo(new int[]{-8});
        assertThat(selectionSortAlgorithm.sort(sortedArray)).isEqualTo(new int[]{-4, -3, -2, -1, 0, 1});

        assertThat(insertionSortAlgorithm.sort(unsortedArray)).isEqualTo(new int[]{-2, 1, 3, 5, 5, 6});
        assertThat(insertionSortAlgorithm.sort(emptyArray)).isEqualTo(new int[]{});
        assertThat(insertionSortAlgorithm.sort(oneElementArray)).isEqualTo(new int[]{-8});
        assertThat(insertionSortAlgorithm.sort(sortedArray)).isEqualTo(new int[]{-4, -3, -2, -1, 0, 1});
    }
}
