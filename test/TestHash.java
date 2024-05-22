import org.junit.Before;
import org.junit.Test;
import tad.LinkedList.MyLinkedListIml;
import tad.LinkedList.MyList;
import tad.hash.MyHash;
import tad.hash.MyHashIml;

import static org.junit.Assert.*;
public class TestHash {

    @Test
    public void Test_metodos_Hash() {
        MyHash<String, Integer> hash = new MyHashIml();

        // Test put and get methods
        hash.insert("one", 1);
        hash.insert("two", 2);
        hash.insert("three", 3);

        assertEquals(3, hash.size());

        MyList<String> keys = hash.keys();
        assertTrue(keys.contains("one"));
        assertTrue(keys.contains("three"));
        assertFalse(keys.contains("two"));

        assertEquals(Integer.valueOf(1), hash.get("one"));
        assertEquals(Integer.valueOf(2), hash.get("two"));
        assertEquals(Integer.valueOf(3), hash.get("three"));



        MyList<Integer> values = hash.values();
        assertTrue(values.contains(1));
        assertTrue(values.contains(3));
        assertFalse(values.contains(2));


    }

}
