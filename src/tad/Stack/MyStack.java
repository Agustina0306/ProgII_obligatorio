package tad.Stack;

public interface MyStack <T> {
    void push(T value);

    T pop() throws EmptyStackException;

    T peek();

    int size();

    boolean isEmpty();
}
