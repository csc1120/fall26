package week7.section121;

public interface PureQueue<E> {
    boolean offer(E e);
    boolean add(E e);

    E poll();
    E remove();

    E peek();
    E element();

    boolean empty();
}
