/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week1.section121;

import java.util.Scanner;

public class ExceptionCreation {
    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        try {
            int num = one(in.nextLine());
            System.out.println(num);
        } catch(NumberFormatException e) {
            System.err.println("Need an integer");
        }

    }

    private static int one(String s) {
        return two(s);
    }

    private static int two(String s) {
        return Integer.parseInt(s);
    }
}
