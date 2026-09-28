/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week4.section121;

import java.util.ArrayList;
import java.util.Scanner;

public class Generics {
    static void main() {
        // no type parameter
        ArrayList list = new ArrayList();
        list.add("hello");
        list.add(5);
        list.add(new Scanner(System.in));
        System.out.println(((String)list.get(0)).length());
        // type parameter
        ArrayList<String> words = new ArrayList<>();
        words.add("hello");
        // on compile, type erasure
        MyGenericArray<Integer> nums = new MyGenericArray<>();
        nums.add(5);
        nums.add(7);
        System.out.println(nums.get(0));
        MyGenericArray<String> arr2 = new MyGenericArray<>();
        MyObject<Integer> obj1 = new MyObject<>(5);
        MyObject<Integer> obj2 = new MyObject<>(7);
        System.out.println(obj1.compare(obj2.getNum()));
        System.out.println("hello".compareTo("abacus"));
    }
}
