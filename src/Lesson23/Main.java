package Lesson23;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {2, 4, 3};
        int[] c = {0, -1, 2, -3, 1};
        int[] d = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        System.out.println(isSubsetOfOtherArrayInGivenOrder(a, b));
        System.out.println(isSubsetOfOtherArray(a, b));
        System.out.println(checkSumOfElements(c, -2));
        System.out.println(maximumDistanceOfTwoOccurrences(d));
        System.out.println(findTheNthLargestElement(d, 4));
    }

    //This method returns ONLY true if the all elements are in the right order.
    // array[1, 2, 3, 4, 5], subSet[1, 2, 3] = true , subSet[3, 2, 1] = false
    public static boolean isSubsetOfOtherArrayInGivenOrder(int[] array, int[] subset) {
        if (array.length == 0 || subset.length == 0) return false;

        for (int i = 0; i < array.length; i++) {
            if (i > array.length - subset.length) return false;
            if (array[i] == subset[0]) {
                for (int j = 0; j < subset.length; j++) {
                    if (subset[j] != array[i + j]) {
                        break;
                    } else {
                        if (subset[j] == array[i + j] && j == subset.length -1) {// checks whether the order of elements in the subset is right.
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean isSubsetOfOtherArray(int[] array, int[] subset) {
        if (subset.length > array.length || (array.length == 0 || subset.length == 0)) return false;

        Set<Integer> mainSet = new HashSet<>();
        for (int i : array) {
            mainSet.add(i);
        }
        for (int i : subset) {
            if (!mainSet.contains(i)) {
                return false;
            }
        }
        return true;
    }

    //This method is actually the same as skylars, that's probably the best approach
    public static String checkSumOfElements(int[] arr, int sum) {
        Set<Integer> numberSet = new HashSet<>();
        for (int element : arr) {
            if (numberSet.contains(sum - element)) {
                return "Yes";
            }
            numberSet.add(element);
        }
        return "No";
    }

    public static Map<Integer, Integer> maximumDistanceOfTwoOccurrences(int[] arr) {
        Map<Integer, Integer> resultMap = new TreeMap<>();
        Map<Integer, Integer> calculatingMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!calculatingMap.containsKey(arr[i])) {
                calculatingMap.put(arr[i], i);// stores the index of first approach.
                resultMap.put(arr[i], 0);
            } else {
                resultMap.put(arr[i], i - calculatingMap.get(arr[i]));
            }
        }
        return resultMap;
    }

    public static int findTheNthLargestElement(int[] arr, int nthElement) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }
        Integer[] result = new Integer[set.size()];
        set.toArray(result);
        int elementCount = result.length - nthElement;

        return result[elementCount];
     }
}
