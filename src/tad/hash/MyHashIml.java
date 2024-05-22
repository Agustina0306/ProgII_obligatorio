package tad.hash;
import tad.LinkedList.MyLinkedListIml;
import tad.LinkedList.MyList;

import java.util.HashMap;
import java.util.Map;


public class MyHashIml <Key, Value> implements MyHash<Key, Value> {

    private Map<Key, Value> map;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR_THRESHOLD = 0.75f;

    public MyHashIml() {
        this.map = new HashMap<>(DEFAULT_CAPACITY);
    }

    public MyHashIml(int initialCapacity) {
        this.map = new HashMap<>(initialCapacity);
    }

    @Override
    public MyList<Key> keys() {
        MyList<Key> keyList = new MyLinkedListIml<>();
        for (Key key : map.keySet()) {
            keyList.add(key);
        }
        return keyList;
    }

    @Override
    public MyList<Value> values() {
        MyList<Value> valueList = new MyLinkedListIml<>();
        for (Value value : map.values()) {
            valueList.add(value);
        }
        return valueList;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void insert(Key key, Value value) {
        map.put(key, value);
        if (size() > map.size() * LOAD_FACTOR_THRESHOLD) {
            resize(map.size() * 2);
        }
    }

    @Override
    public Value get(Key key) {
        return map.get(key);
    }

    @Override
    public boolean contains(Key key) {
        return map.containsKey(key);
    }

    @Override
    public void delete(Key key) {
        map.remove(key);
    }

    private void resize(int newCapacity) {
        Map<Key, Value> newMap = new HashMap<>(newCapacity);
        for (Map.Entry<Key, Value> entry : map.entrySet()) {
            newMap.put(entry.getKey(), entry.getValue());
        }
        map = newMap;
    }


}
