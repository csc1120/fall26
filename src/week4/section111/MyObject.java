/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week4.section111;

public class MyObject<E extends Comparable<E>> {
    private final E num;

    public MyObject(E i) {
        this.num = i;
    }

    public E getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "" + num;
    }

    public int compare(E other) {
        Comparable<E> useless = other;
        return num.compareTo(other);
    }
}
