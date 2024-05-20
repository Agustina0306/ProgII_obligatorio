package LinkedList;

public class MyLinkedListIml<T> implements MyList<T> {

    private Node<T> firstNode;

    public MyLinkedListIml() {
        this.firstNode = null;
    }

    @Override
    public void add(T value) {
        if (value != null) {
            Node<T> newNode = new Node<>(value);
            if (this.firstNode == null) {
                this.firstNode = newNode;
            } else {
                Node<T> tempNode = firstNode;
                while (tempNode.getNext() != null) {
                    tempNode = tempNode.getNext();
                }
                tempNode.setNext(newNode);
            }
        }
    }

    @Override
    public T get(int position) {
        return null;
    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    @Override
    public void remove(T value) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T get(T value) {
        return null;
    }
}
