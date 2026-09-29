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
        Object[] result = new Object[this.size];
        System.arraycopy(this.data, 0, result, 0, this.size);
        return result;
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
    public boolean remove(Object o) { // O()
        // find object
        for (int i = 0; i < this.size; i++) {
            if(this.data[i].equals(o)) {
                // remove
                // shift remaining indexes to the left
                for(int j = i + 1; j < this.size; ++j) {
                    // copy left
                    this.data[j - 1] = this.data[j];
                }
                --this.size;
                return true;
            }
        }
        // if object doesn't exist
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
    public E get(int index) { // random access O(1)
        // validate index
        validateIndex(index);
        return this.data[index];
    }

    private void validateIndex(int index) {
        if(index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Size: " + this.size + " Index: " + index);
        }
    }

    @Override
    public E set(int index, E element) { // O(1)
        validateIndex(index);
        E old = this.data[index];
        this.data[index] = element;
        return old;
    }

    @Override
    public void add(int index, E element) { // O(n)
        if(index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Size: " + this.size + " Index: " + index);
        }
        if(this.size == this.data.length) {
            reallocate();
        }
        // move stuff over
        for(int i = this.size - 1; i >= index; --i) {
            this.data[i + 1] = this.data[i];
        }
        // add element
        this.data[index] = element;
        ++this.size;
    }

    @Override
    public E remove(int index) {
        validateIndex(index);
        // store old value
        E result = this.data[index];
        // shift stuff over
        for(int i = index + 1; i < this.size; ++i) {
            this.data[i - 1] = this.data[i];
        }
        --this.size;
        return result;
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
