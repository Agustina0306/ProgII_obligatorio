package tad.BinarySearchTree;

import tad.LinkedList.MyLinkedListIml;
import tad.LinkedList.MyList;

public class MyBSTIml <K extends Comparable<K>, T> implements MyBinarySearchTree<K,T>{
    private TreeNode<K,T> root;

    @Override
    public void add(K key, T value) {
        TreeNode<K,T> newNode = new TreeNode<>(key, value);

        if (this.root == null){
            this.root = newNode;
        }else{
            root.addInArbol(key, value);
        }
    }

    @Override
    public void remove(K key) {
        if (root != null){
            root = root.remove(key);
        }
    }

    @Override
    public boolean contains(K key) {
        return containsRecursive (key, root);
    }

    private boolean containsRecursive(K keyToSearch, TreeNode<K,T> root){
        boolean contains = false;
        if (root != null){
            int tempValue = keyToSearch.compareTo(root.getKey());
            if (tempValue == 0){
                contains = true;
            } else if (tempValue > 0){
                contains = containsRecursive(keyToSearch,root.getRightChild());
            }else{
                contains = containsRecursive(keyToSearch, root.getLeftChild());
            }
        }
        return contains;
    }

    @Override
    public T find(K key) {
        return findRecursive(key, root);
    }

    private T findRecursive(K keyToSearch, TreeNode<K,T> root){
        T valueToReturn = null;
        if (root != null){
            int tempValue = keyToSearch.compareTo(root.getKey());
            if (tempValue == 0){
                valueToReturn = root.getValue();
            }else if (tempValue > 0){
                valueToReturn = findRecursive(keyToSearch, root.getRightChild());
            }else {
                valueToReturn = findRecursive(keyToSearch, root.getLeftChild());
            }
        }
        return valueToReturn;
    }

    @Override
    public MyList<K> inOrder() {
        MyList<K> inOrderTraverse = new MyLinkedListIml<>();
        if (root != null) {
            root.inOrderTraverse(inOrderTraverse);
        }
        return inOrderTraverse;
    }

    @Override
    public MyList<K> postOrder() {
        MyList<K> postOrderTraverse = new MyLinkedListIml<>();
        if (root != null){
            root.postOrderTraverse(postOrderTraverse);
        }
        return postOrderTraverse;
    }

    @Override
    public MyList<K> preOrder() {
        MyList<K> preOrderTraverse = new MyLinkedListIml<>();
        if (root != null){
            root.preOrderTraverse(preOrderTraverse);
        }
        return preOrderTraverse;
    }

    @Override
    public TreeNode<K, T> getRoot() {
        return this.root;
    }
}
