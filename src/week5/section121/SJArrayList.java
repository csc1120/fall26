/*
 * Course: CSC-1020
 * SJArrayList
 */
package week5.section121;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * This is a basic Arraylist implementation.
 * @param <E> the element type stored in the List
 */
public class SJArrayList<E> implements List<E> {
    private static final int STARTING_CAPACITY = 10;
    private E[] data;
    private int size;

    public SJArrayList() {
        this.data = (E[]) new Object[STARTING_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {  // O(1)
        return this.size;
    }

    @Override
    public boolean isEmpty() { // O(1)
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) { // O(n)
        for (int i = 0; i < this.size; i++) {
            if(this.data[i].equals(o)) {
                // found it
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
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
    public boolean add(E e) { // O(1)
        if(this.size == this.data.length) {
            // I'm full
            reallocate();
        }
        this.data[size] = e;
        ++size;
        return true;
    }

    private void reallocate() { // O(n)
        // make a bigger array * 2 + 1
        E[] newData = (E[]) new Object[this.data.length * 2 + 1];
        // copy the data to the new array in the same location
        System.arraycopy(this.data, 0, newData, 0, this.data.length);
        // point data to new array
        this.data = newData;
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
