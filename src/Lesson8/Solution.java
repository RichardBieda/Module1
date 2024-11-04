package Lesson8;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] array1 = {19, 7, 3, 0 , 19, 8, 7, -9, 11, 7, -4};

        //The method order below is the same order as the SysOut method calls.
        //Find the common elements between 2 arrays.
        int[] commonElements = getCommonElements(array, array1);
        System.out.println(Arrays.toString(commonElements));

        //Find the second-largest element.
        int secondLargestElement = getSecondLargestElement(array1);
        System.out.println(secondLargestElement);

        //finds out if elements repeat.
        boolean isRepeated = findRepeats(array);
        System.out.println(isRepeated);

        //Removing an element from an array. Well almost, because it creates a new array without the given element. Not even the Arrays class has a remove method.
        //It would work with a static array, or an array as an instance variable. I think, fell free to correct me.
        int[] removedArray = removeElement(array1, 7);
        System.out.println(Arrays.toString(removedArray));

        //Inserting an element to an array.
        int[] insertedArray = insertElement(array,6, 1000);
        System.out.println(Arrays.toString(insertedArray));

        //Finding all elements that are greater than the average
        int[] greaterAsAverage = getGreaterElements(array1);
        System.out.println(Arrays.toString(greaterAsAverage));
    }

    //This method finds the common elements between two int arrays. It returns an Array.
    static int[] getCommonElements(int[] arr1, int[] arr2) {

        int[] commonValueArray = new int[0];                                        //a new int array with zero elements.
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr2[j] == arr1[i]) {                                           //here is the comparison between the two given arrays
                    commonValueArray = internalArray(commonValueArray, arr2[j]);    //If the arrays values are equal, then the values are consign to a helper method where the commonValueArray will be increased
                }
            }
        }
        return commonValueArray;
    }
    //------------------------------------------------------------------------------
    //This method finds the second-largest element in an array, the return typ is an int.
    static int getSecondLargestElement(int[] arr) {
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }
            if (arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }
    //--------------------------------------------------------------------------------------
    //This method finds out if elements repeat, it returns a boolean.
    static boolean findRepeats(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    return true;
                }
            }
        }
        return false;
    }
    //----------------------------------------------------------------------------------
    //This method removes a specific element by its value
    static int[] removeElement(int[] arr, int value) {
        int repeatings = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                repeatings++;
            }
        }

        int[] tmp = new int[arr.length-repeatings];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                j++;
                continue;
            }
            tmp[i-j] = arr[i];
        }
        return tmp;
    }
    //------------------------------------------------------------------------------------
    static int[] insertElement(int[] arr, int index, int value) {
        int[] tmp = new int[arr.length+1];
        int j = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (i == index) {
                j++;
                tmp[i] = value;
                continue;
            }
            tmp[i] = arr[i-j];
        }

        return tmp;
    }
    //---------------------------------------------------------------------------------------
    //This method finds all elements that are greater than the average
    static int[] getGreaterElements(int[] arr) {
        int[] tmp = new int[0];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int average = sum / arr.length;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > average) {
                tmp = internalArray(tmp, arr[i]);
            }
        }
        return tmp;
    }
    //-----------------------------------------------------------------------------------
    //This is only a helper method for the getCommonElements method. It returns an array who is increased by 1.
    private static int[] internalArray(int[] arr, int value) {
        int[] tmp = Arrays.copyOf(arr, arr.length+1);
        tmp[tmp.length-1] = value;

        return tmp;
    }
}
