/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week4.section111;

import java.util.List;

public class BigO {
    static void main() {

    }

    private static void count(List<Integer> list) {
        System.out.println(list.size()); // O(1)

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            ++count; // O(n)
        }
        System.out.println(count);
        // O(n^2)
        for (int i = 0; i < list.size(); i++) { // O(n) n times
            for(int index = i + 1; index < list.size(); ++index) { // 3n - 1 times O(n)
                if(list.get(i) > list.get(index)) {
                    System.out.println("bigger");
                }
                if(list.get(i) > list.get(index)) {
                    System.out.println("bigger");
                }
                if(list.get(i) > list.get(index)) {
                    System.out.println("bigger");
                }
            }
        }
    }
}
