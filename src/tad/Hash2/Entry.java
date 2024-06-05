package tad.Hash2;

public class Entry<K,V> {
    K key;
    V value;
    boolean isDeleted;

    Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.isDeleted = true; // comienzo como que todos los valores estan eliminados, al agregarlo
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

