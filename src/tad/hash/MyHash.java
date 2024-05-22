package tad.hash;

public interface MyHash <K, V> {
    void insert (K key, V value);

    void delete (K key);

    V get (K key);

    boolean contains (K key);

}
