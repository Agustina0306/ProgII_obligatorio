import org.junit.Test;
import tad.Queue.MyQueue;
import tad.Queue.EmptyQueueException;
import tad.LinkedList.MyLinkedListIml;
import tad.Stack.EmptyStackException;


import static org.junit.Assert.*;

public class TestQueue {
    @Test
    public void test_metodos_queue() {
        MyQueue<Integer> queue = new MyLinkedListIml<>();

        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(3);


        assertTrue(queue.contains(3));

        try {
            assertEquals(Integer.valueOf(2), queue.dequeue());
        } catch (EmptyQueueException e) {
            throw new RuntimeException(e);
        }

        assertFalse(queue.contains(2));

        assertFalse(queue.isEmpty());

        assertEquals(2,queue.size());

        assertEquals(Integer.valueOf(3), queue.getPosition(1));

        try {
            assertEquals(Integer.valueOf(1), queue.dequeue());
        } catch (EmptyQueueException e) {
            throw new RuntimeException(e);
        }
        try {
            assertEquals(Integer.valueOf(3), queue.dequeue());
        } catch (EmptyQueueException e) {
            throw new RuntimeException(e);
        }

        assertTrue(queue.isEmpty());

        try {
            assertEquals(Integer.valueOf(3), queue.dequeue());
        } catch (EmptyQueueException e) {
            throw new RuntimeException(e);
        }

    }

}
