/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week4.section121;

import java.util.List;

public class BigO {
    static void main() {

    }

    private static void method(List<Integer> list) {
        int size = list.size(); // O(1)

        int  count = 0;
        for (int i = 0; i < list.size(); i++) {
            ++count;
        }

    }
}
