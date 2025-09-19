package erfan.handson.dsa.algorithm.sorting;

class SelectionSort implements SortingAlgorithm {
    @Override
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minValIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minValIndex]) {
                    minValIndex = j;
                }
            }
            if (minValIndex != i) {
                int tmp = array[i];
                array[i] = array[minValIndex];
                array[minValIndex] = tmp;
            }
        }
        return array;
    }
}
