import org.junit.Test;
import tad.LinkedList.MyLinkedListIml;
import tad.Stack.EmptyStackException;
import tad.Stack.MyStack;
import static org.junit.Assert.assertEquals;


public class TestStack {

    @Test
    public void Test_metodos_Stack(){
        MyStack<Integer> Stack = new MyLinkedListIml<>();

        Stack.push(1);
        Stack.push(3);
        Stack.push(4);

        assertEquals(Integer.valueOf(3), Stack.peek());

        try {
            assertEquals(Integer.valueOf(3), Stack.pop());
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }


        assertEquals(Integer.valueOf(4), Stack.peek());

        try {
            assertEquals(Integer.valueOf(4), Stack.pop());
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }



        assertEquals(Integer.valueOf(1), Stack.peek());

        try {
            assertEquals(Integer.valueOf(1), Stack.pop());
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }

        assertEquals(0, Stack.size());

    }
}
