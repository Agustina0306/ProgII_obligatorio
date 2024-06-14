package tad.Hash2;

import tad.LinkedList.MyLinkedListIml;
import tad.LinkedList.MyList;

import java.util.function.Supplier;

public class MyClosedHash <K,V> implements MyHash<K,V> {
    private static final int DEFAULT_CAPACITY = 10000;
    private static final float LOAD_FACTOR = 0.7f;
    private int size;
    private int capacity;
    private Entry<K, V>[] table;


    public MyClosedHash() {
        this.capacity = DEFAULT_CAPACITY;
        this.table = new Entry [capacity];
        this.size = 0;

        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(K key, V value) {
        float hashLoadFactor = (float) size/capacity;
        if (hashLoadFactor > LOAD_FACTOR){
            this.resize();
        }
        int hashPosition = this.hash(key);
        boolean condition = true;

        while (condition) {

            if (table[hashPosition] == null) { // si no hay nada en la posicion obtenida lo agrego ahi
                table[hashPosition] = new Entry<>(key, value);
                table[hashPosition].isDeleted = false;
                size++;
                return;
            } else if (table[hashPosition].key.equals(key)) {
                if (table[hashPosition].isDeleted) {
                    table[hashPosition].isDeleted = false;
                    table[hashPosition].value = value;
                    size++;
                }
            }
            hashPosition = (hashPosition + 1) % capacity;
            if (hashPosition >= capacity){
                hashPosition = 0;
            }
        }
    }

    @Override
    public void delete(K key) {
        if (this.contains(key)){  // si esa clave esta en la tabla
            int hashPosition = this.hash(key);
            for (int i = 0; i <= capacity; i++){
                if (hashPosition >= capacity){
                    hashPosition = 0; // que vuelva al inicio de la tabla
                }
                if (table[hashPosition] == null) {
                    hashPosition = (hashPosition + 1) % capacity;
                } else if (table[hashPosition].key.equals(key) && table[hashPosition].isDeleted == false){
                    table[hashPosition].isDeleted = true;
                    size --;
                    hashPosition = (hashPosition + 1) % capacity;
                } else {
                    hashPosition = (hashPosition + 1) % capacity;
                }
            }
        }
    }

    @Override
    public MyList<V> get(K key) {
        MyList<V> valuesToReturn = new MyLinkedListIml<>();
        if (this.contains(key)){
            int hashPosition = this.hash(key);
            for (int i = 0; i < capacity; i++){
                if (hashPosition >= capacity){
                    hashPosition = 0;
                }
                if (table[hashPosition] == null){
                    hashPosition = (hashPosition + 1) % capacity;
                } else if (table[hashPosition].key.equals(key) && !table[hashPosition].isDeleted){
                    V tempValue = table[hashPosition].value;
                    valuesToReturn.add(tempValue);
                    hashPosition = (hashPosition + 1) % capacity;
                } else {
                    hashPosition = (hashPosition + 1) % capacity;
                }
            }
        }
        return valuesToReturn;
    }

    @Override
    public V getValue(K key) {
        int hashPosition = this.hash(key);
        for (int i = 0; i < capacity; i++) {
            if (hashPosition >= capacity) {
                hashPosition = 0;
            }
            if (table[hashPosition] == null) {
                hashPosition = (hashPosition + 1) % capacity;
            } else if (table[hashPosition].key.equals(key) && !table[hashPosition].isDeleted) {
                return table[hashPosition].value;
            } else {
                hashPosition = (hashPosition + 1) % capacity;
            }
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        int hashPosition = this.hash(key);
        boolean valueToReturn = false;
        for (int i = 0; i <= capacity; i++){
            if (hashPosition >= capacity){
                hashPosition = 0;
            }
            if (table[hashPosition] == null){
                hashPosition = (hashPosition + 1) % capacity;
            } else if (table[hashPosition].key.equals(key) && table[hashPosition].isDeleted != true){
                valueToReturn = true;
            } else {
                hashPosition = (hashPosition + 1) % capacity;
            }
        }
        return valueToReturn;
    }

    @Override
    public V insertIfAbsent(K key, Supplier<V> supplier) {
        float hashLoadFactor = (float) size/capacity;
        if (hashLoadFactor > LOAD_FACTOR){
            this.resize();
        }
        int hashPosition = this.hash(key);
        for (int i = 0; i < capacity; i++) {
            if (hashPosition >= capacity) {
                hashPosition = 0;
            }
            if (table[hashPosition] == null) {
                V value = supplier.get();
                table[hashPosition] = new Entry<>(key, value);
                table[hashPosition].isDeleted = false;
                size++;
                return value;
            } else if (table[hashPosition].key.equals(key) && !table[hashPosition].isDeleted) {
                return table[hashPosition].value;
            }
            hashPosition = (hashPosition + 1) % capacity;
        }
        return null;
    }

    @Override
    public MyList<Entry<K, V>> getTable() {
        MyList<Entry<K, V>> entries = new MyLinkedListIml<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null && !table[i].isDeleted) {
                entries.add(table[i]);
            }
        }
        return entries;
    }

    private void resize () {
        int newCapacity = capacity * 2;
        Entry<K,V>[] newTable = new Entry[newCapacity];
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null){
                int hashPosition = Math.abs(table[i].key.hashCode()) % newCapacity;
                while (newTable[hashPosition] != null){
                    hashPosition = (hashPosition + 1) % newCapacity;
                }
                newTable[hashPosition] = table[i];
                newTable[hashPosition].key = table[i].key;
                newTable[hashPosition].value = table[i].value;
                newTable[hashPosition].isDeleted = table[i].isDeleted;
            }
        }
        table = newTable;
        capacity = newCapacity;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}
