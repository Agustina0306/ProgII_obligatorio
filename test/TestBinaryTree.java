import org.junit.Test;
import tad.BinarySearchTree.MyBSTIml;
import tad.BinarySearchTree.MyBinarySearchTree;
import tad.LinkedList.MyLinkedListIml;
import tad.LinkedList.MyList;

import static org.junit.Assert.*;
public class TestBinaryTree {
    @Test
    public void test_metodos_binaryTree() {
        MyBinarySearchTree<Integer, Integer> Binarytree = new MyBSTIml();

        Binarytree.add(3, 3);
        Binarytree.add(2, 2);
        Binarytree.add(1, 1);
        Binarytree.add(4, 4);

        assertEquals(Integer.valueOf(3), Binarytree.find(3));

        Binarytree.remove(2);

        assertFalse(Binarytree.contains(2));

        // Prueba de inOrder
        MyList<Integer> inOrderExpectedList = new MyLinkedListIml<>();
        inOrderExpectedList.add(1);
        inOrderExpectedList.add(3);
        inOrderExpectedList.add(4);
        MyList<Integer> inOrderListResult = Binarytree.inOrder();

        // Prueba postOrder
        MyList<Integer> postOrderExpectedList = new MyLinkedListIml<>();
        postOrderExpectedList.add(1);
        postOrderExpectedList.add(4);
        postOrderExpectedList.add(3);
        MyList<Integer> postOrderListResult = Binarytree.postOrder();

        // Prueba preOrder
        MyList<Integer> preOrderExpectedList = new MyLinkedListIml<>();
        preOrderExpectedList.add(3);
        preOrderExpectedList.add(1);
        preOrderExpectedList.add(4);
        MyList<Integer> preOrderListResult = Binarytree.preOrder();

        for (int i = 0; i < inOrderExpectedList.size(); i++){
            assertEquals(inOrderExpectedList.getPosition(i), inOrderListResult.getPosition(i));
            assertEquals(postOrderExpectedList.getPosition(i), postOrderListResult.getPosition(i));
            assertEquals(preOrderExpectedList.getPosition(i), preOrderListResult.getPosition(i));
        }
    }
}
