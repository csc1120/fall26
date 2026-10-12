/*
 * Course: CSC-1020
 * PureStack
 */
package week7.section111;

/**
 * A pure Stack interface with only Stack methods.
 * @param <E> the element type stored in the Stack
 */
public interface PureStack<E> {
    /**
     * Look at top of stack.
     * @return return the top of the stack
     */
    E peek();

    /**
     * Remove from top of stack.
     * @return return the top of the stack
     */
    E pop();

    /**
     * put element on top of the stack.
     *
     * @param e the element to add.
     * @return the element you just added
     */
    E push(E e);

    /**
     * Returns if the stack is empty.
     * @return true if empty, false otherwise
     */
    boolean empty();
}
