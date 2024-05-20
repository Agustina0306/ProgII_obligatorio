package Queue;

public interface MyQueue<T>{
    void enqueue(T var1);

    T dequeue() throws EmptyQueueException;

    boolean contains(T var1);

    int size();
}
