package BinarySearchTree;

public class TreeNode <K extends Comparable<K>, T> {

    private K key;
    private T value;
    private TreeNode<K,T> leftChild;
    private TreeNode<K,T> rightChild;

    public TreeNode(K key, T value) {
        this.key = key;
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void addInArbol (K key, T value){
        TreeNode<K,T> newNode = new TreeNode<>(key, value);
        if (key.compareTo(this.key) > 0 ){
            if (rightChild == null){
                rightChild = newNode;
            } else {
                rightChild.addInArbol(key, value);
            }
        } else{
            if (leftChild == null){
                leftChild = newNode;
            } else {
                leftChild.addInArbol(key, value);
            }
        }
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<K, T> rightChild) {
        this.rightChild = rightChild;
    }
}
