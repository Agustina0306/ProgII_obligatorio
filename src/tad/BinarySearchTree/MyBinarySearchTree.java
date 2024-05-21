package tad.BinarySearchTree;
import tad.LinkedList.MyList;

public interface MyBinarySearchTree<K extends Comparable<K>, T>{
    void add(K key, T value);

    void remove(K key);

    boolean contains(K key);

    T find(K key);

    MyList<K> inOrder();

    MyList<K> postOrder();

    MyList<K> preOrder();

    TreeNode<K, T> getRoot();
}
