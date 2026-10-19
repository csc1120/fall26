/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week8.section121;

public class BinarySearch {
    static void main() {
        int[] arr = {1, 4, 7, 9, 11, 15, 19, 23, 32};
        System.out.println(binarySearch(arr, 7));
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int middle = (start + end) / 2;
            if(arr[middle] == target) {
                return middle;
            } else if (arr[middle] > target) {
                // look left
                end = middle - 1;
            } else {
                // look right
                start = middle + 1;
            }
        }
        return -1;
    }
}
