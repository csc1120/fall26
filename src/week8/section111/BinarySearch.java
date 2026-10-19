/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week8.section111;

public class BinarySearch {
    static void main() {
        // array must be sorted
        int[] arr = {1, 3, 6, 9, 11, 14, 18, 21, 35};
        System.out.println(binarySearch(arr, 9));
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int middle = (start + end) / 2;
            if(arr[middle] == target) {
                return middle;
            } else if (arr[middle] < target) {
                // middle is less than target, go right
                start = middle + 1;
            } else {
                // middle is greater that target, go left
                end = middle - 1;
            }
        }
        return -1;
    }
}
