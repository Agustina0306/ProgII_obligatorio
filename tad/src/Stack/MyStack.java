package Stack;

public interface MyStack <T> {
    void push(T var1);

    T pop() throws EmptyStackException;

    T peek();

    int size();
}
