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
    public T getPosition (int position) throws DatoInvalido{
        T valueToReturn = null;
        int tempPosition = 0;
        Node<T> tempNode = this.firstNode;

        if (position < 0){
            throw new DatoInvalido();
        }

        while (tempNode != null && tempPosition != position){
            tempNode = tempNode.getNext();
            tempPosition ++;
        }
        if (tempPosition == position && tempNode != null){
            valueToReturn = tempNode.getValue();
        }
        return valueToReturn;
    }

    @Override
    public boolean contains(T value) {
        Node<T> tempNode = this.firstNode;
        while (tempNode != null) {
            if (tempNode.getValue().equals(value)) {
                return true;
            }
            tempNode = tempNode.getNext();
        }
        return false;
    }

    @Override
    public void remove(T value) throws DatoInvalido {
        if (value == null){
            throw new DatoInvalido();
        }

        if (this.firstNode == null || !this.contains(value)){
            // throw new EntidadNoExiste();
            System.out.println("Lo pongo para no olvidarnos");
            return;
        }

        if (this.firstNode.getValue().equals(value)){
            this.firstNode = this.firstNode.getNext();
        } else {
            Node<T> current = this.firstNode;
            Node<T> previous = null;

            while (current != null && !current.getValue().equals(value)){
                previous = current;
                current = current.getNext();
            }
            if (current != null && previous != null) {
                previous.setNext(current.getNext());
            }
        }
    }

    @Override
    public int size() {
        int size = 0;
        for (Node<T> tempNode = this.firstNode; tempNode != null; ++size) {
            tempNode = tempNode.getNext();
        }
        return size;
    }

    @Override
    public T getValue (T value) {

        return null;
    }
}
