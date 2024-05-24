package tad.Hash2;

import tad.LinkedList.MyList;

public interface MyHash<K,V> {

    int size();

    void insert (K key, V value);

    void delete (K key);

    MyList<V> get (K key);

    boolean contains (K key);

}
