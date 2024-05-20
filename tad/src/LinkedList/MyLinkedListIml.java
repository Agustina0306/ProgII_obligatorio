package LinkedList;

import Queue.EmptyQueueException;
import Queue.MyQueue;
import Stack.EmptyStackException;
import Stack.MyStack;

public class MyLinkedListIml<T> implements MyList<T> , MyStack<T>, MyQueue<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;

    public MyLinkedListIml() {
        this.firstNode = null;
        this.lastNode = null;
    }

    @Override
    public void add(T value) {  // Agrega elemento al final de la lista
        if (value != null) {
            Node<T> newNode = new Node<>(value);
            if (this.firstNode == null) {
                this.firstNode = newNode;
                this.lastNode = newNode;
            } else {
                this.lastNode.setNext(newNode);
                this.lastNode = newNode;
            }
        }
    }

    @Override
    public T getPosition (int position) throws DatoInvalido{
        T valueToReturn = null;
        int tempPosition = 0;
        Node<T> tempNode = this.firstNode;

        if (position < 0 || position >= this.size()){
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
    public void remove(T value) throws DatoInvalido, EntidadNoExiste {
        if (value == null){
            throw new DatoInvalido();
        }
        if (this.firstNode == null || !this.contains(value)){
            throw new EntidadNoExiste();
        }
        if (this.firstNode.getValue().equals(value)){
            this.firstNode = this.firstNode.getNext();
        }

        Node<T> current = this.firstNode;
        Node<T> previous = null;

        while (current != null && !current.getValue().equals(value)){
            previous = current;
            current = current.getNext();
        }
        if (current != null && previous != null) {
            previous.setNext(current.getNext());
            if (current == this.lastNode){
                this.lastNode = previous;
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
    public T getValue (T value) throws DatoInvalido{
        Node<T> tempNode = this.firstNode;
        if (value == null){
            throw new DatoInvalido();
        }
        if (this.contains(value)){
            while (tempNode != null) {
                if (tempNode.getValue().equals(value)) {
                    return tempNode.getValue();
                }
                tempNode = tempNode.getNext();
            }
        }
        return null;
    }

    @Override
    public void push(T value) {
        this.add(value);
    }

    @Override
    public T pop() throws EmptyStackException{
        Node<T> current = firstNode;
        Node<T> popNode = null;
        if (this.lastNode == null) {
            throw new EmptyStackException();
        }
        if (this.lastNode == this.firstNode){
            popNode = this.firstNode;
            this.firstNode = null;
            this.lastNode = null;
            return popNode.getValue();
        }
        while(current.getNext() != this.lastNode){
            current = current.getNext();
        }
        popNode = current.getNext();
        current.setNext(null);
        this.lastNode = current;
        return popNode.getValue();
    }

    @Override
    public T peek() {
        T valueToReturn = null;
        if (this.lastNode != null){
            valueToReturn = this.lastNode.getValue();
        }
        return valueToReturn;
    }

    @Override
    public void enqueue(T value) {
        if (value != null){
            Node<T> newNode = new Node<>(value);
            if (this.firstNode == null){
                this.firstNode = newNode;
                this.lastNode = newNode;
            } else {
                newNode.setNext(firstNode);
                this.firstNode = newNode;
            }
        }

    }

    @Override
    public T dequeue() throws EmptyQueueException {
        Node<T> current = firstNode;
        Node<T> deqNode = null;
        if (this.lastNode == null){
            throw new EmptyQueueException();
        }
        while(current.getNext() != this.lastNode){
            current = current.getNext();
        }
        deqNode = current.getNext();
        current.setNext(null);
        this.lastNode = current;
        return deqNode.getValue();
    }
}
