/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week6.section111;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/**
 * A simplified DoubleLinkedList implementation.
 * @param <E> the element type stored in the List
 */
public class DoubleLinkedList<E> implements List<E> {
    private static final class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        private Node(E e) {
            this.data = e;
            this.next = null;
            this.prev = null;
        }

        private Node(E e, Node<E> prev, Node<E> next) {
            this.data = e;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "data: " + this.data.toString() + " prev: "
                    + prev.data.toString() + " next: "
                    + next.data.toString();
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * A no-param constructor that sets the size to 0 and the head and tail to null.
     */
    public DoubleLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
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
    public boolean contains(Object o) {
        Node<E> current = this.head;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
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
    public Object @NotNull [] toArray() {
        Node<E> current = this.head;
        final Object[] result = new Object[this.size];
        for(int i = 0; i < size; i++) {
            result[i] = current.data;
            current = current.next;
        }
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if(this.head == null) {
            this.head = new Node<>(e);
            this.tail = this.head;
        } else {
            this.tail.next = new Node<>(e, this.tail, null);
            this.tail = this.tail.next;
        }
        ++this.size;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> current = this.head;
        Node<E> prev = null;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                if(prev == null) {
                    this.head = current.next;
                } else {
                    prev.next = current.next;
                }

                if(current.next == null) {
                    this.tail = prev;
                } else {
                    current.next.prev = prev;
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
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public E get(int index) {
        validateIndex(index);
        Node<E> target = getNode(index);
        return target.data;
    }

    @Override
    public E set(int index, E element) {
        validateIndex(index);
        Node<E> target = getNode(index);
        E oldData = target.data;
        target.data = element;
        return oldData;
    }

    @Override
    public void add(int index, E element) {
        validateAddIndex(index);

        if (index == 0) {
            Node<E> oldHead = this.head;
            Node<E> newNode = new Node<>(element, null, oldHead);
            this.head = newNode;

            if (oldHead == null) {
                this.tail = newNode;
            } else {
                oldHead.prev = newNode;
            }
        } else if (index == this.size) {
            Node<E> oldTail = tail;
            Node<E> newNode = new Node<>(element, oldTail, null);
            tail = newNode;

            if (oldTail == null) {
                head = newNode;
            } else {
                oldTail.next = newNode;
            }
        } else {
            Node<E> current = getNode(index);
            Node<E> previous = current.prev;

            Node<E> newNode = new Node<>(element, previous, current);
            previous.next = newNode;
            current.prev = newNode;
        }
        ++this.size;
    }

    @Override
    public E remove(int index) {
        validateIndex(index);
        Node<E> current = getNode(index);
        E result = current.data;

        if (current.prev == null) {
            this.head = current.next;
        } else {
            current.prev.next = current.next;
        }

        if (current.next == null) {
            this.tail = current.prev;
        } else {
            current.next.prev = current.prev;
        }
        --this.size;
        return result;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> current = this.head;
        for(int i = 0; i < size; ++i) {
            if (Objects.equals(current.data, o)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<E> current = this.tail;
        for(int i = size - 1; i >= 0; --i) {
            if (Objects.equals(current.data, o)) {
                return i;
            }
            current = current.prev;
        }
        return -1;
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

    private Node<E> getNode(int index) {
        final int lastIndex = this.size - 1;
        final int midpoint = this.size / 2;

        Node<E> current;

        if (index <= midpoint) {
            current = this.head;
            for (int i = 0; i < index; ++i) {
                current = current.next;
            }
        } else {
            current = this.tail;
            for (int i = lastIndex; i > index; --i) {
                current = current.prev;
            }
        }

        return current;
    }

    private void validateAddIndex(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void validateIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
