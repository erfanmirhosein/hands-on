package erfan.handson.dsa.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class WarmupProblems {
    static int findChessBordPositionInLogTime(int numberOfGrains) {
        int grainsPlaced = 1;
        int currentPosition = 1;
        while (grainsPlaced < numberOfGrains) {
            grainsPlaced *= 2;
            currentPosition++;
        }
        return currentPosition;
    }

    static String[] filterStringsStartingWithA(String[] strings) {
        List<String> result = new ArrayList<>();
        for (String s : strings) {
            if (s.startsWith("A")) {
                result.addLast(s);
            }
        }
        return result.toArray(new String[0]);
    }

    static int getMedian(int[] array) {
        int middle = (array.length - 1) / 2;
        if (array.length % 2 == 0) {
            return (array[middle] + array[middle]) / 2;
        }
        return array[middle];
    }

    private WarmupProblems() {
    }

    static int[] twoSum(int[] array, int sum) {
        HashMap<Integer, Integer> sumMinusElementsMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (sumMinusElementsMap.containsKey(array[i])) {
                return new int[]{sumMinusElementsMap.get(array[i]), i};
            }
            sumMinusElementsMap.put(sum - array[i], i);
        }
        return new int[0];
    }

    static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static int[] mergeSortedArrays(int[] a, int[] b) {
        int[] mergedArray = new int[a.length + b.length];

        int mergedAUntilIndex = 0;
        int mergedBUntilIndex = 0;

        for (int i = 0; i < mergedArray.length; i++) {
            if (mergedAUntilIndex < a.length && mergedBUntilIndex < b.length) {
                if (a[mergedAUntilIndex] > b[mergedBUntilIndex]) {
                    mergedArray[i] = b[mergedBUntilIndex];
                    mergedBUntilIndex++;
                } else {
                    mergedArray[i] = a[mergedAUntilIndex];
                    mergedAUntilIndex++;
                }
            } else if (mergedAUntilIndex < a.length) {
                mergedArray[i] = a[mergedAUntilIndex];
                mergedAUntilIndex++;
            } else {
                mergedArray[i] = b[mergedBUntilIndex];
                mergedBUntilIndex++;
            }
        }
        return mergedArray;
    }

    static boolean containsSubstring(String s, String substring) {
        int substringLength = substring.length();
        char[] charArray = s.toCharArray();
        for (int i = 0; i + substringLength - 1 < charArray.length; i++) {
            int substringIndex = 0;
            while (substring.charAt(substringIndex) == charArray[i + substringIndex]) {
                if (substringIndex == substringLength - 1) {
                    return true;
                }
                substringIndex++;
            }
        }
        return false;
    }

}
