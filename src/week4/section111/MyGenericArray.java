/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week4.section111;

public class MyGenericArray<A> {
    private static final int DEFAULT_SIZE = 10;
    private final A[] arr;
    private int index;

    public MyGenericArray() {
        arr = (A[]) new Object[DEFAULT_SIZE];
        index = 0;
    }

    public void add(A a) {
        arr[index++] = a;
    }

    public A get(int index) {
        return arr[index];
    }
}
