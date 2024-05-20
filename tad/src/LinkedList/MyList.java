package LinkedList;

public interface MyList <T>{
    void add(T value);

    T getPosition(int position);

    boolean contains(T value);

    void remove(T value);

    int size();

    T getValue(T value);
}
