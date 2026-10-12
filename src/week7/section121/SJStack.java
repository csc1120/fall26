/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week7.section121;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * Adaptor class for simple Stack
 * @param <E>
 */
public class SJStack<E> implements PureStack<E> {
    private final LinkedList<E> data;

    public SJStack() {
        data = new LinkedList<>();
    }

    /**
     * getting from the top
     *
     * @return
     */
    @Override
    public E peek() {
        if(data.isEmpty()) {
            throw new EmptyStackException();
        }
        return data.peek();
    }

    /**
     * removing from the top
     *
     * @return
     */
    @Override
    public E pop() {
        if(data.isEmpty()) {
            throw new EmptyStackException();
        }
        return data.pop();
    }

    /**
     * adding to the top
     *
     * @param e
     * @return
     */
    @Override
    public E push(E e) {
        data.push(e);
        return e;
    }

    /**
     * is empty?
     *
     * @return
     */
    @Override
    public boolean empty() {
        return data.isEmpty();
    }
}
