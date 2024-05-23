package tad.Queue;

public interface MyQueue<T>{
    void enqueue(T value);

    T dequeue() throws EmptyQueueException;

    boolean contains(T value);

    int size();

    T getValueQueue (int position);

    boolean isEmpty();
}
