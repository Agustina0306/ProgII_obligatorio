import org.junit.Test;
import tad.Hash2.MyClosedHash;
import tad.Hash2.MyHash;
import tad.LinkedList.MyLinkedListIml;
import tad.LinkedList.MyList;

import static org.junit.Assert.*;


public class TestHash2 {

    @Test
    public void Test_metodos_Hash() {

        MyHash<Integer, String> hash = new MyClosedHash<>();

        hash.insert(1, "One");
        hash.insert(2, "two");
        hash.insert(3, "three");
        hash.insert(1, "segundoOne");

        assertEquals(4, hash.size());

        hash.delete(1);
        assertFalse(hash.contains(1));
        assertEquals(2,hash.size());

        assertTrue(hash.contains(2));

        hash.insert(5, "cinco1");
        hash.insert(5, "cinco2");
        hash.insert(5, "cinco3");
        assertEquals(5, hash.size());

        MyList<String> valuesExpectedList = new MyLinkedListIml<>();
        valuesExpectedList.add("cinco1");
        valuesExpectedList.add("cinco2");
        valuesExpectedList.add("cinco3");
        MyList<String> valuesResultList = hash.get(5);

        for (int i = 0; i < valuesExpectedList.size(); i++){
            assertEquals(valuesExpectedList.getPosition(i), valuesResultList.getPosition(i));
        }

        // Agrego datos para probar el resize
        hash.insert(10,"Prueba10");
        hash.insert(10, "segundo10");
        hash.insert(50, "valor50");
        hash.insert(3, "segundo3");
        hash.insert(4, "valor4");
        assertEquals(10, hash.size());
        assertTrue(hash.contains(50));
        hash.delete(50);
        assertFalse (hash.contains(50));
        assertEquals(9,hash.size());




    }

}
