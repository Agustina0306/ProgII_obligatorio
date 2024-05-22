package tad.hash;

import tad.LinkedList.MyList;

public interface MyHash <K, V> {
    MyList<K> keys();

    MyList<V> values();

    int size();

    void insert (K key, V value);

    void delete (K key);

    V get (K key);

    boolean contains (K key);

}
