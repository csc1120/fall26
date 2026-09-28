/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week4.section121;

public class MyGenericArray<A> {
    private static final int DEFAULT_SIZE = 10;
    private A[] arr;
    private int index;

    @SuppressWarnings("unchecked")
    public MyGenericArray() {
        arr = (A[]) new Object[DEFAULT_SIZE];
        index = 0;
    }

    public A get(int index) {
        return arr[index];
    }

    public void add(A o) {
        arr[index++] = o;
    }
}
