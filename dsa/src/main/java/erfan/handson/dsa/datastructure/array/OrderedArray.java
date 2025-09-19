package erfan.handson.dsa.datastructure.array;

class OrderedArray {
    private final int[] data;
    private int size;

    static OrderedArray ofRange(int lower, int upper) {
        if (upper < lower) {
            throw new IllegalArgumentException();
        }
        int arraySize = upper - lower + 1;
        OrderedArray array = new OrderedArray(arraySize);
        for (int i = lower; i <= upper; i++) {
            array.data[i - lower] = i;
        }
        array.size = arraySize;
        return array;
    }

    public OrderedArray(int capacity) {
        data = new int[capacity];
    }

    void insert(int val) {
        if (size == data.length) {
            throw new UnsupportedOperationException("cannot insert into a full array");
        }
        int targetIndex = findInsertionIndex(val);
        insertAt(val, targetIndex);
    }

    private int findInsertionIndex(int val) {
        if (size == 0) {
            return 0;
        }
        int right = size - 1;
        int left = 0;
        while (left <= right) {
            int midPoint = left + (right - left) / 2;
            if (data[midPoint] == val) {
                return midPoint;
            } else if (data[midPoint] < val) {
                left = midPoint + 1;
            } else {
                right = midPoint - 1;
            }
        }
        return left;
    }

    private void insertAt(int val, int index) {
        int pointer = size - 1;
        while (pointer >= index) {
            data[pointer + 1] = data[pointer];
            pointer--;
        }
        data[index] = val;
        size++;
    }


    int binarySearch(int val) {
        int lowerBound = 0;
        int upperBound = size - 1;
        while (lowerBound <= upperBound) {
            int midPoint = lowerBound + (upperBound - lowerBound) / 2;
            if (data[midPoint] == val) {
                return midPoint;
            }
            if (val > data[midPoint]) {
                lowerBound = midPoint + 1;
            } else {
                upperBound = midPoint - 1;
            }
        }
        return -1;
    }

    int linearSearch(int val) {
        for (int i = 0; i < size; i++) {
            if (data[i] == val) {
                return i;
            }
        }
        return -1;
    }

    int readIndex(int index) {
        assertIndexInBound(index);
        return data[index];
    }

    //prone to memory leaks
    void remove(int index) {
        assertIndexInBound(index);

        while (index < size - 1) {
            data[index] = data[index + 1];
            index++;
        }
        size--;
    }

    private void assertIndexInBound(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }
}
