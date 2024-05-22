package tad.BinarySearchTree;

import tad.LinkedList.MyList;

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

    public TreeNode<K,T> remove (K key){
        TreeNode<K,T> elementToReturn = this;
        if (key.compareTo(this.key) > 0){
            if (rightChild != null){
                rightChild = rightChild.remove(key);
            }
        }else if (key.compareTo(this.key) < 0){
            if (leftChild != null){
                leftChild = leftChild.remove(key);
            }
        } else if (leftChild != null && rightChild != null){
            TreeNode<K,T> min = rightChild.findMin();
            this.key = min.getKey();
            this.value = min.getValue();

            rightChild = rightChild.remove((min.getKey()));
        } else {
            if (leftChild != null){
                elementToReturn = leftChild;
            } else {
                elementToReturn = rightChild;
            }
        }
        return elementToReturn;
    }

    public TreeNode<K,T> findMin(){
        TreeNode<K,T> oReturn = this;
        if (leftChild != null){
            oReturn = leftChild.findMin();
        }
        return oReturn;
    }

    public void inOrderTraverse (MyList<K> list){
        if (leftChild != null){
            leftChild.inOrderTraverse(list);
        }
        list.add(this.getKey());

        if(rightChild != null){
            rightChild.inOrderTraverse(list);
        }
    }

    public void postOrderTraverse(MyList<K> list){
        if (leftChild != null){
            leftChild.postOrderTraverse(list);
        }
        if (rightChild != null){
            rightChild.postOrderTraverse(list);
        }
        list.add(this.getKey());
    }

    public void preOrderTraverse (MyList<K> list){
        list.add(this.getKey());
        if(leftChild != null){
            leftChild.preOrderTraverse(list);
        }
        if (rightChild != null){
            rightChild.preOrderTraverse(list);
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
