/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week7.section111;

import week7.section121.PureQueue;

import java.util.NoSuchElementException;

public class CircularQueue<E> implements PureQueue<E> {
    private static final int DEFAULT_SIZE = 10;
    private E[] data;
    private int front;
    private int back;
    private int size;

    public CircularQueue() {
        data = (E[]) new Object[DEFAULT_SIZE];
        front = 0; // next index to be removed
        back = 0; // next index to be added
        size = 0;
    }

    @Override
    public boolean offer(E e) {
        if(size == data.length) {
            // we're full
            return false;
        }
        data[back++ % data.length] = e;
        ++size;
        return true;
    }

    @Override
    public boolean add(E e) {
        if(size == data.length) {
            // we're full
            throw new IllegalStateException();
        }
        return offer(e);
    }

    @Override
    public E poll() {
        if(size == 0) {
            // empty
            return null;
        }
        E result = data[front++ % data.length];
        --size;
        return result;
    }

    @Override
    public E remove() {
        if(size == 0) {
            // empty
            throw new NoSuchElementException();
        }
        return poll();
    }

    @Override
    public E peek() {
        if(size == 0) {
            // empty
            return null;
        }
        return data[front % data.length];
    }

    @Override
    public E element() {
        if(size == 0) {
            // empty
            throw new NoSuchElementException();
        }
        return peek();
    }

    @Override
    public boolean empty() {
        return size == 0;
    }
}
