package adt.bst;

import static org.junit.Assert.*;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;
import org.junit.Before;
import org.junit.Test;

public class BSTVerifierTest {

    BSTVerifierImpl<Integer> verifier;
    BSTImpl<Integer> bst1;
    BSTImpl<Integer> bst2;

    @Before
    public void setUp() {
        bst1 = new BSTImpl<Integer>();
        bst2 = new BSTImpl<Integer>();
    }

    @Test
    public void testIsBST() {
        verifier = new BSTVerifierImpl<Integer>(bst1);
        BSTNode<Integer> aux;

        assertTrue(verifier.isBST());

        bst1.insert(44);
        assertTrue(verifier.isBST());

        bst1.insert(17);
        assertTrue(verifier.isBST());

        aux = bst1.search(17);
        aux.setData(100);
        assertFalse(verifier.isBST());
        aux.setData(17);
        assertTrue(verifier.isBST());

        bst1.insert(79);
        assertTrue(verifier.isBST());
        bst1.insert(16);
        assertTrue(verifier.isBST());
        bst1.insert(48);
        assertTrue(verifier.isBST());
        bst1.insert(88);
        assertTrue(verifier.isBST());
        bst1.insert(78);
        assertTrue(verifier.isBST());
        bst1.insert(83);
        assertTrue(verifier.isBST());
        bst1.insert(52);
        assertTrue(verifier.isBST());
        bst1.insert(67);
        assertTrue(verifier.isBST());
        assertArrayEquals(new Integer[] { 44, 17, 16, 79, 48, 78, 52, 67, 88, 83 }, bst1.preOrder());

        aux = bst1.search(16);
        aux.setLeft(new BSTNode.Builder<Integer>().data(100).left(new BSTNode<Integer>()).right(new BSTNode<Integer>()).parent(aux).build());

        assertFalse(verifier.isBST());

    }

    @Test
    public void testIsBST2() {
        verifier = new BSTVerifierImpl<Integer>(bst1);
        BSTNode<Integer> aux;

        bst1.insert(20);
        assertTrue(verifier.isBST());

        aux = bst1.search(20);
        aux.setLeft(new BSTNode.Builder<Integer>().data(100).left(new BSTNode<Integer>()).right(new BSTNode<Integer>()).parent(aux).build());

        System.out.println(aux);
        assertFalse(verifier.isBST());

    }

    @Test
    public void testIsBST3() {
        verifier = new BSTVerifierImpl<Integer>(bst1);
        BSTNode<Integer> aux;

        assertTrue(verifier.isBST());

        bst1.insert(44);
        assertTrue(verifier.isBST());

        bst1.insert(17);
        assertTrue(verifier.isBST());

        aux = bst1.search(17);
        aux.setData(100);
        assertFalse(verifier.isBST());

        bst1.insert(79);
        assertFalse(verifier.isBST());
        bst1.insert(16);
        assertFalse(verifier.isBST());
        bst1.insert(48);
        assertFalse(verifier.isBST());
        bst1.insert(88);
        assertFalse(verifier.isBST());
        bst1.insert(78);
        assertFalse(verifier.isBST());
        bst1.insert(83);
        assertFalse(verifier.isBST());
        bst1.insert(52);
        assertFalse(verifier.isBST());
        bst1.insert(67);
        assertFalse(verifier.isBST());
    }

    @Test
    public void testIsBST4() {
        verifier = new BSTVerifierImpl<Integer>(bst1);
        BSTNode<Integer> aux;

        assertTrue(verifier.isBST());

        bst1.insert(44);
        assertTrue(verifier.isBST());
        bst1.insert(17);
        assertTrue(verifier.isBST());
        bst1.insert(79);
        assertTrue(verifier.isBST());
        bst1.insert(16);
        assertTrue(verifier.isBST());
        bst1.insert(48);
        assertTrue(verifier.isBST());
        bst1.insert(88);
        assertTrue(verifier.isBST());
        bst1.insert(78);
        assertTrue(verifier.isBST());
        bst1.insert(83);
        assertTrue(verifier.isBST());
        bst1.insert(52);
        assertTrue(verifier.isBST());
        bst1.insert(67);
        assertTrue(verifier.isBST());
        assertArrayEquals(new Integer[] { 44, 17, 16, 79, 48, 78, 52, 67, 88, 83 }, bst1.preOrder());

        aux = bst1.search(16);
        aux.setData(100);
        assertFalse(verifier.isBST());

        aux.setData(1);
        assertTrue(verifier.isBST());

        aux = bst1.search(44);
        assertTrue(verifier.isBST());
        aux.setData(10000);
        assertFalse(verifier.isBST());
        aux.setData(44);
        assertTrue(verifier.isBST());

    }
}