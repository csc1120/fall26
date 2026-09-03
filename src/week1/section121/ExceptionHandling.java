/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week1.section121;

import java.util.Scanner;

public class ExceptionHandling {
    static void main() {
        String input = "";
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Enter an integer to square: ");
            input = in.nextLine();
            if(!input.equalsIgnoreCase("q")) {
                try {
                    System.out.println(Math.pow(Integer.parseInt(input), 2));
                } catch (NumberFormatException e) {
                    System.out.println("Not an integer");
                }
            }
        } while (!input.equalsIgnoreCase("q"));
    }
}
