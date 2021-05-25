package adt.avltree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class AVLTreeVerifierTest {

    AVLTreeVerifierImpl<Integer> verifier;
    AVLTreeImpl<Integer> avl1;
    AVLTreeImpl<Integer> avl2;
    BSTImpl<Integer> bst1;

    @Before
    public void setUp() {
        avl1 = new AVLTreeImpl<Integer>();
        avl2 = new AVLTreeImpl<Integer>();
        bst1 = new BSTImpl<Integer>();
    }

    @Test
    public void testIsAVL01() {

        verifier = new AVLTreeVerifierImpl<Integer>(avl1);
        assertTrue(verifier.isAVLTree());

        avl1.insert(0);
        avl1.insert(2);
        avl1.insert(3);

        avl1.insert(4);
        avl1.insert(5);
        avl1.insert(6);

//		         4
//		     2       5
//		 0     3        6


        assertTrue(verifier.isAVLTree());

        // Muda o valor do no 3 para 30, violando as propriedades de bst
        avl1.getRoot().getLeft().getRight().setData(30);

        assertFalse(verifier.isAVLTree());
    }

    @Test
    public void testIsAVL02() {
        verifier = new AVLTreeVerifierImpl<Integer>(avl1);
        BSTNode<Integer> aux;

        assertTrue(verifier.isBST());
        assertTrue(verifier.isAVLTree());

        avl1.insert(1);
        assertTrue(verifier.isBST());
        assertTrue(verifier.isAVLTree());
        avl1.insert(2);
        assertTrue(verifier.isBST());
        assertTrue(verifier.isAVLTree());
        avl1.insert(3);
        assertTrue(verifier.isBST());
        assertTrue(verifier.isAVLTree());
        avl1.insert(4);
        assertTrue(verifier.isBST());
        assertTrue(verifier.isAVLTree());
        avl1.insert(5);
        assertTrue(verifier.isBST());
        assertTrue(verifier.isAVLTree());
        avl1.insert(6);
        assertTrue(verifier.isBST());
        assertTrue(verifier.isAVLTree());
        avl1.insert(7);
        assertTrue(verifier.isBST());
        assertTrue(verifier.isAVLTree());
        avl1.insert(8);
        assertTrue(verifier.isBST());
        assertTrue(verifier.isAVLTree());
        avl1.insert(9);
        assertTrue(verifier.isBST());
        assertTrue(verifier.isAVLTree());
        avl1.insert(10);
        assertTrue(verifier.isBST());
        assertTrue(verifier.isAVLTree());
        assertArrayEquals(new Integer[] { 4, 2, 1, 3, 8, 6, 5, 7, 9, 10 }, avl1.preOrder());

        aux = avl1.search(6);
        aux.setData(100);
        assertFalse(verifier.isBST());
        assertFalse(verifier.isAVLTree());

        aux.setData(6);
        assertTrue(verifier.isBST());
        assertTrue(verifier.isAVLTree());

        aux = avl1.search(10);

        aux.setRight(new BSTNode.Builder<Integer>().data(11).left(null).right(null).parent(aux).build());

        aux = avl1.search(11);
        aux.setLeft(new BSTNode.Builder<Integer>().data(null).left(null).right(null).parent(aux).build());
        aux.setRight(new BSTNode.Builder<Integer>().data(null).left(null).right(null).parent(aux).build());

        assertTrue(verifier.isBST());
        assertFalse(verifier.isAVLTree());

        aux = avl1.search(1);
        aux.setLeft(new BSTNode.Builder<Integer>().data(-1).left(null).right(null).parent(aux).build());

        aux = avl1.search(-1);
        aux.setLeft(new BSTNode.Builder<Integer>().data(-2).left(null).right(null).parent(aux).build());
        aux.setRight(new BSTNode.Builder<Integer>().data(0).left(null).right(null).parent(aux).build());

        aux = avl1.search(-2);
        aux.setLeft(new BSTNode.Builder<Integer>().data(null).left(null).right(null).parent(aux).build());
        aux.setRight(new BSTNode.Builder<Integer>().data(null).left(null).right(null).parent(aux).build());

        aux = avl1.search(0);
        aux.setLeft(new BSTNode.Builder<Integer>().data(null).left(null).right(null).parent(aux).build());
        aux.setRight(new BSTNode.Builder<Integer>().data(null).left(null).right(null).parent(aux).build());
        assertTrue(verifier.isBST());
        assertFalse(verifier.isAVLTree());

        aux.setData(-100);
        assertFalse(verifier.isBST());
        assertFalse(verifier.isAVLTree());

        aux = avl1.search(1);
        aux.setLeft(new BSTNode.Builder<Integer>().data(null).left(null).right(null).parent(aux).build());
        aux.setRight(new BSTNode.Builder<Integer>().data(null).left(null).right(null).parent(aux).build());
        assertTrue(verifier.isBST());
        assertFalse(verifier.isAVLTree());

        aux = avl1.search(10);
        aux.setLeft(new BSTNode.Builder<Integer>().data(null).left(null).right(null).parent(aux).build());
        aux.setRight(new BSTNode.Builder<Integer>().data(null).left(null).right(null).parent(aux).build());
        assertTrue(verifier.isBST());
        assertTrue(verifier.isAVLTree());

    }

}