package Lesson16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        System.out.println(sumOfNumbersInAString( "as!d123ad%jsk2358 Akja9sd"));
        System.out.println(sumOfNumbersInAString( "a1aa114ff3"));

        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] arr2 = {11, 2, 13, 14, 15, 9, 17, 18, 19, 20};
        System.out.println(findIntersections(arr1, arr2));
        System.out.println(findUnion(arr1, arr2));
    }

    public static int sumOfNumbersInAString(String str) {
        int sum = 0;
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c > 47 && c < 58) {
                sum += c - 48;
            }
        }
        return sum;
    }

    public static ArrayList<Integer> findIntersections(Integer[] array1, Integer[] array2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>(Arrays.asList(array1));
        for (Integer x : array2) {
            if (set.contains(x))
                list.add(x);
        }
        return list;
    }

    public static HashSet<Integer> findUnion(Integer[] array1, Integer[] array2) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(array1));
        set.addAll(Arrays.asList(array2));
        return set;
    }
}
