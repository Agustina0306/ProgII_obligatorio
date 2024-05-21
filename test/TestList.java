import org.junit.Test;
import tad.LinkedList.MyLinkedListIml;
import tad.LinkedList.MyList;

import static org.junit.Assert.*;
public class TestList {

    @Test
    public void Test_metodos_lista(){
        MyList<Integer> lista = new MyLinkedListIml<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        assertEquals(5, lista.size());
        assertEquals(1, lista.getPosition(0));
        assertEquals(4, lista.getPosition(3));

        assertFalse(lista.contains(6));
        assertTrue(lista.contains(3));

        lista.remove(2);

        assertFalse(lista.contains(2));
        assertEquals(3, lista.getPosition(1));

        assertEquals(1, lista.getValue(1));

    }
}