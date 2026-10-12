package week7.section121;

public interface PureStack<E> {
    /**
     * getting from the top
     * @return
     */
    E peek();

    /**
     * removing from the top
     * @return
     */
    E pop();

    /**
     * adding to the top
     * @param e
     * @return
     */
    E push(E e);

    /**
     * is empty?
     * @return
     */
    boolean empty();
}
