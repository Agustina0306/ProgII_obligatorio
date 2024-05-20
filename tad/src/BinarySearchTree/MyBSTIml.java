package BinarySearchTree;

import LinkedList.MyList;

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


    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public T find(K key) {
        return null;
    }

    @Override
    public MyList<K> inOrder() {
        return null;
    }

    @Override
    public MyList<K> postOrder() {
        return null;
    }

    @Override
    public MyList<K> preOrder() {
        return null;
    }

    @Override
    public TreeNode<K, T> getRoot() {
        return null;
    }
}
