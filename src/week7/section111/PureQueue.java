/*
 * Course: CSC-1020
 * Pure Queue
 */
package week7.section111;

import java.util.NoSuchElementException;

/**
 * A pure Queue interface with queue and java queue methods.
 * @param <E> the element type stored in the Queue
 */
public interface PureQueue<E> {
    /**
     * Adds an element to the back of the Queue.
     *
     * @param e the element to add
     * @return true if the element was added, false otherwise
     */
    boolean offer(E e);
    /**
     * Adds an element to the back of the Queue.
     *
     * @param e the element to add
     * @return true if the element was added
     * @throws IllegalStateException if the element cannot be added
     */
    boolean add(E e);

    /**
     * Removes the element at the front of the Queue.
     * @return the element at the front of the queue or null if the Queue is empty
     */
    E poll();

    /**
     * Removes the element at the front of the Queue.
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the Queue is empty
     */
    E remove();

    /**
     * Gets the element at the front of the Queue.
     * @return the element at the front of the queue or null if the Queue is empty
     */
    E peek();

    /**
     * Gets the element at the front of the Queue.
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the Queue is empty
     */
    E element();

    /**
     * Checks if the Queue is empty.
     * @return true if the Queue is empty, false otherwise
     */
    boolean empty();
}
