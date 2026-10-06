/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week6.section121;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SJLinkedList<E> implements List<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private int size;
    private Node<E> head;

    public SJLinkedList() {
        this.size = 0;
        this.head = null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) { // O(n)
        Node<E> current = this.head;
        while(current != null) {
            if(current.data.equals(o)) {
                return true;
            }
            current = current.next;
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
    public boolean add(E e) { // O(n)
        // get to the end
        Node<E> current = this.head;
        Node<E> prev = null;
        while(current != null) {
            prev = current;
            current = current.next;
        }
        // make new node
        Node<E> target = new Node<>(e);
        // add new node at the end
        if(prev == null) {
            this.head = target;
        } else {
            prev.next = target;
        }
        // increment size
        ++this.size;
        // return true
        return true;
    }

    @Override
    public boolean remove(Object o) { // O(n)
        // find the object, if it exists
        Node<E> current = this.head;
        Node<E> prev = null;
        while(current != null) {
            if(current.data.equals(o)) {
                // found it, remove it
                if(prev == null) {
                    this.head = current.next;
                } else {
                    prev.next = current.next;
                }
                --this.size;
                return true;
            }
            prev = current;
            current = current.next;
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

    }

    @Override
    public E get(int index) { // O(n)
        if(index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<E> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public E set(int index, E element) { // O(n)
        if(index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<E> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E old = current.data;
        current.data = element;
        return old;
    }

    @Override
    public void add(int index, E element) { // O(n), add at head O(1)
        if(index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        // make new node
        Node<E> prev = this.head;
        Node<E> target = new Node<>(element);
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        if(index == 0) {
            // adding at head
            target.next = this.head;
            this.head = target;
        } else {
            target.next = prev.next;
            prev.next = target;
        }
        ++this.size;
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
