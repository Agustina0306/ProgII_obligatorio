package tad.LinkedList;

public class Node <T>{
    private T value;
    private Node<T> nextNode;

    public Node(T value) {
        this.value = value;
        this.nextNode = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return nextNode;
    }

    public void setNext(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}
