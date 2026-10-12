/*
 * Course: CSC-1020
 * SJ Stack
 */
package week7.section111;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * Adaptor Class that creates a Stack (LIFO).
 * @param <E> element type
 */
public class SJStack<E> implements PureStack<E> {
    private final LinkedList<E> stack;

    /**
     * No-param constructor.
     */
    public SJStack() {
        stack = new LinkedList<>();
    }

    /**
     * Look at top of stack.
     *
     * @return return the top of the stack
     * @throws EmptyStackException if the Stack is empty
     */
    @Override
    public E peek() {
        if(stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.peek();
    }

    /**
     * Remove from top of stack.
     *
     * @return return the top of the stack
     * @throws EmptyStackException if the Stack is empty
     */
    @Override
    public E pop() {
        if(stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.pop();
    }

    /**
     * put element on top of the stack.
     *
     * @param e the element to add
     * @return the element you just added
     */
    @Override
    public E push(E e) {
        stack.push(e);
        return e;
    }

    /**
     * Returns if the stack is empty.
     *
     * @return true if empty, false otherwise
     */
    @Override
    public boolean empty() {
        return stack.isEmpty();
    }
}
