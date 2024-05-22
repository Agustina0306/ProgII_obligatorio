import org.junit.Test;
import tad.LinkedList.MyLinkedListIml;
import tad.LinkedList.MyList;

import java.util.Optional;

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
        assertEquals(Integer.valueOf(1), lista.getPosition(0));
        assertEquals(Integer.valueOf(2), lista.getPosition(1));

        assertFalse(lista.contains(6));
        assertTrue(lista.contains(3));

        lista.remove(2);

        assertFalse(lista.contains(2));
        assertEquals(Integer.valueOf(3), lista.getPosition(1));

        assertEquals(Integer.valueOf(1), lista.getValue(1));

    }
}