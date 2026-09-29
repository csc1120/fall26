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
    public boolean remove(Object o) { // O(n)
        for (int i = 0; i < this.size; i++) {
            if(data[i].equals(o)) {
                // found it
                // remove it
                for (int j = i + 1; j < this.size; j++) { // close the gap
                    data[j - 1] = data[j];
                }
                --this.size;
                return true;
            }
        }
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
        this.size = 0;
    }

    @Override
    public E get(int index) { // O(1) - random access
        validateIndex(index);
        return this.data[index];
    }

    @Override
    public E set(int index, E element) { // O(1)
        // validate index
        validateIndex(index);
        // get the old value
        E old = this.data[index];
        // replace old value with element
        this.data[index] = element;
        // return old value
        return old;
    }

    @Override
    public void add(int index, E element) { // O(n)
        if(index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("List size: " + this.size + " index: " + index);
        }
        if(this.size == this.data.length) {
            reallocate();
        }
        // add at index or insert
        // make a gap at index
        for(int i = this.size - 1; i >= index; --i) {
            this.data[i + 1] = this.data[i];
        }
        // insert element at index
        this.data[index] = element;
        ++this.size;
    }

    @Override
    public E remove(int index) { // O(n)
        validateIndex(index);
        // remove and close the gap
        E result = this.data[index];
        // shift elements over
        for(int i = index + 1; i < this.size; ++i) {
            this.data[i - 1] = this.data[i];
        }
        --this.size;
        return result;
    }

    private void validateIndex(int index) {
        if(index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("List size: " + this.size + " index: " + index);
        }
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
