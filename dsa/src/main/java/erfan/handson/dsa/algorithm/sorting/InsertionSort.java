package erfan.handson.dsa.algorithm.sorting;

class InsertionSort implements SortingAlgorithm {
    @Override
    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int gapIndex = i;
            while (gapIndex > 0 && array[gapIndex - 1] > tmp) {
                array[gapIndex] = array[gapIndex - 1];
                gapIndex--;
            }
            array[gapIndex] = tmp;
        }
        return array;
    }
}
