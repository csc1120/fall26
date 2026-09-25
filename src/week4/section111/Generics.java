/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week4.section111;

import java.util.ArrayList;
import java.util.Scanner;

public class Generics {
    static void main() {
        ArrayList list = new ArrayList(); // stores Object with no type parameter
        list.add("Hello");
        list.add(5);
        list.add(new Scanner(System.in));
        System.out.println(((String)list.get(0)).toUpperCase());
        // with type parameter
        ArrayList<String> words = new ArrayList<>();

        // cannot create primitives
//        ArrayList<int>  must be cast as an object
        MyObject<Integer> obj = new MyObject<>(5);
        MyObject<Integer> obj2 = new MyObject<>(7);
        // compareTo first compares to second
        // if first is bigger, some positive
        // if first is smaller, some negative
        // if equal, return 0
        System.out.println(obj.compare(obj2.getNum()));
        System.out.println("hello".compareTo("abacus"));

        MyGenericArray<String> arr = new MyGenericArray<>();
        arr.add("hello");
        arr.add("goodbye");
        System.out.println(arr.get(0));
    }
}
