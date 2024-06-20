package tad.Hash2;

import tad.LinkedList.MyList;

import java.util.function.Supplier;

public interface MyHash<K,V> {

    int size();

    void insert (K key, V value);

    void delete (K key);

    MyList<V> get (K key);

    boolean contains (K key);

    V insertIfAbsent (K key, Supplier<V> supplier);

    MyList<Entry<K, V>> getTable();

    V getValue (K key);

    MyHash<K, V> clone();

}
