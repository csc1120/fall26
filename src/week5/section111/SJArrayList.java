/*
 * Course: CSC-1020
 * SJArrayList
 */
package week5.section111;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A simple ArrayList implementation.
 * @param <E> the element stored in the List
 */
public class SJArrayList<E> implements List<E>  {
    private static final int STARTING_CAPACITY = 10;
    private E[] data;
    private int size;

    public SJArrayList() {
        this.size = 0;
        this.data = (E[]) new Object[STARTING_CAPACITY];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) { // O(n)
        for (int i = 0; i < size; i++) {
            if(data[i].equals(o)) {
                // found it
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        // week 6
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) { // O(1) - amortized
        if(this.size == this.data.length) {
            // I'm full
            reallocate();
        }
        // add the thing, increment size, return true
        this.data[size++] = e;
        return true;
    }

    private void reallocate() { // O(n)
        // make new array of size * 2 + 1
        E[] newArray = (E[]) new Object[size * 2 + 1];
        // copy all data in order to new array
        System.arraycopy(this.data, 0, newArray, 0, this.data.length);
        // replace old array with the new array
        this.data = newArray;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
