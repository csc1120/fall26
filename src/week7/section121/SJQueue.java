/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week7.section121;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SJQueue<E> implements PureQueue<E> {
    private final LinkedList<E> data;

    public SJQueue() {
        data = new LinkedList<>();
    }

    @Override
    public boolean offer(E e) {
        return data.offer(e);
    }

    @Override
    public boolean add(E e) {
        return data.add(e);
    }

    @Override
    public E poll() {
        if(data.isEmpty()) {
            return null;
        }
        return data.poll();
    }

    @Override
    public E remove() {
        if(data.isEmpty()) {
            throw new NoSuchElementException();
        }
        return data.poll();
    }

    @Override
    public E peek() {
        if(data.isEmpty()) {
            return null;
        }
        return data.peek();
    }

    @Override
    public E element() {
        if(data.isEmpty()) {
            throw new NoSuchElementException();
        }
        return data.element();
    }

    @Override
    public boolean empty() {
        return data.isEmpty();
    }
}
