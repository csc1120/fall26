/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week4.section121;

public class MyObject<E extends Comparable<E>> {
    private E num;

    public MyObject(E e) {
        num = e;
    }

    public E getNum() {
        return num;
    }

    @Override
    public String toString() {
        return num.toString();
    }

    public int compare(E other) {
        return num.compareTo(other);
    }
}
