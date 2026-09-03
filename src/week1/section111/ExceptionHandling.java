/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week1.section111;

import java.util.Scanner;

public class ExceptionHandling {
    static void main() {
        String input = "";
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Enter an integer for us to square: ");
            input = in.nextLine();
            if(!input.equalsIgnoreCase("q")) {
                try {
                    int square = (int) Math.pow(Integer.parseInt(input), 2);
                    System.out.println("The square is " + square);
                } catch (NumberFormatException e) {
                    System.out.println("Enter an integer");
                }
            }
        } while(!input.equalsIgnoreCase("q"));
    }
}
