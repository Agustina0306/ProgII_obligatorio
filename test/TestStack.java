import org.junit.Test;
import tad.LinkedList.MyLinkedListIml;
import tad.Queue.EmptyQueueException;
import tad.Stack.EmptyStackException;
import tad.Stack.MyStack;

import static org.junit.Assert.*;


public class TestStack {

    @Test
    public void Test_metodos_Stack(){
        MyStack<Integer> Stack = new MyLinkedListIml<>();

        Stack.push(1);
        Stack.push(3);
        Stack.push(4);

        assertEquals(Integer.valueOf(4), Stack.peek());

        try {
            assertEquals(Integer.valueOf(4), Stack.pop());
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }

        assertEquals(2, Stack.size());

        assertEquals(Integer.valueOf(3), Stack.peek());

        try {
            assertEquals(Integer.valueOf(3), Stack.pop());
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }

        assertFalse(Stack.isEmpty());

        assertEquals(Integer.valueOf(1), Stack.peek());

        try {
            assertEquals(Integer.valueOf(1), Stack.pop());
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }

        assertEquals(0, Stack.size());
        assertTrue(Stack.isEmpty());

        assertEquals(null, Stack.peek());

        assertThrows(EmptyStackException.class, Stack::pop);

    }
}
