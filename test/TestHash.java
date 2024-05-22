import org.junit.Before;
import org.junit.Test;
import tad.LinkedList.MyLinkedListIml;
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


    }

}
