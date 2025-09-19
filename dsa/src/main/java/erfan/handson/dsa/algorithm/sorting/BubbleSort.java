package erfan.handson.dsa.algorithm.sorting;

class BubbleSort implements SortingAlgorithm {
    @Override
    public int[] sort(int[] array) {
        boolean sorted = false;
        int unSortedUntilIndex = array.length - 1;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < unSortedUntilIndex; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    sorted = false;
                }
            }
            unSortedUntilIndex--;
        }
        return array;
    }
}
