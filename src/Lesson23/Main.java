package Lesson23;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int[] b = {2, 3, 4, 5, 6, 7, 1};
        int[] c = {0, -1, 2, -3, 1};
        int[] d = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        System.out.println(isSubsetOfOtherArray(a, b));
        System.out.println(checkSumOfElements(c, -2));
        System.out.println(maximumDistanceOfTwoOccurrences(d, 2));
        System.out.println(findTheNthLargestElement(d, 6));
    }

    public static boolean isSubsetOfOtherArray(int[] array, int[] subset) {
        for (int i = 0; i < array.length; i++) {
            if (i <= array.length - subset.length) {
                if (array[i] == subset[0]) {
                    for (int j = 1; j < subset.length; j++) {
                        if (subset[j] != array[i + j]) {
                            break;
                        } else if (subset[j] == array[i + j] && j == subset.length -1) {
                            return true;
                        }
                    }
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public static String checkSumOfElements(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    return "yes";
                }
            }
        }
        return "No";
    }

    public static int maximumDistanceOfTwoOccurrences(int[] arr, int number) {
        for (int i = arr.length -1; i >= 0 ; i--) {
            if (arr[i] == number) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] == number) {
                        return i - j;
                    }
                }
            }
        }
        return 0;
    }

    public static int findTheNthLargestElement(int[] arr, int nthElement) {
        Set<Integer> numbersSet = new TreeSet<>(Comparator.reverseOrder());
        for (int x : arr) {
            numbersSet.add(x);
        }
        int x = (int) numbersSet.toArray()[nthElement -1];
        return x;
     }
}
