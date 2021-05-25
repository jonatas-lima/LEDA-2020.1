package adt.bst;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleBSTManipulationTest {

    private SimpleBSTManipulation<Integer> bstManipulation;
    private BST<Integer> tree1;
    private BST<Integer> tree2;

    @Before
    public void setUp() {
        this.tree1 = new BSTImpl<>();
        this.tree2 = new BSTImpl<>();
        this.bstManipulation = new SimpleBSTManipulationImpl<>();
    }

    private void fillTree(BST<Integer> tree, Integer[] array) {
        for (Integer num : array)
            tree.insert(num);
    }

    @Test
    public void testIsEqual_DuasArvoresIguais_TamanhosIguais() {
        fillTree(tree1,  new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40});
        fillTree(tree2,  new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40});

        assertTrue(bstManipulation.equals(tree1, tree2));
    }

    @Test
    public void testIsEqual_DuasArvores_TamanhosDiferentes() {
        fillTree(tree1,  new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40});
        fillTree(tree2,  new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12});

        assertFalse(bstManipulation.equals(tree1, tree2));
    }

    @Test
    public void testIsEqual_DuasArvoresDiferentes_TamanhosIguais() {
        fillTree(tree1,  new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40});
        fillTree(tree2,  new Integer[]{65, 24, 234, -45, 9, 2, 0, 76, 12, 67, 232, -40});

        assertFalse(bstManipulation.equals(tree1, tree2));
    }

    @Test
    public void testIsEqual_PeloMenosUmaArvoreVazia() {
        assertTrue(bstManipulation.equals(tree1, tree2));

        fillTree(tree1,  new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40});
        assertFalse(bstManipulation.equals(tree1, tree2));
    }

    @Test
    public void testIsSimilar_DuasArvoresIguais_TamanhosIguais() {

    }

    @Test
    public void testIsSimilar_DuasArvoresIguais_TamanhosDiferentes() {

    }

    @Test
    public void testIsSimilar_DuasArvoresDiferentes_TamanhosIguais() {

    }

    @Test
    public void testIsSimilar_DuasArvoresDiferentes_TamanhosDiferentes() {

    }

    @Test
    public void testIsSimilar_PeloMenosUmaArvoreVazia() {

    }

    @Test
    public void testOrderStatistic_ForaDoConjunto() {
        fillTree(tree1,  new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40}); // size : 12

        assertNull(bstManipulation.orderStatistic(tree1, 13));
        assertNull(bstManipulation.orderStatistic(tree1, 0));
        assertNull(bstManipulation.orderStatistic(tree1, -1));
        assertNull(bstManipulation.orderStatistic(tree1, 90));
    }

    @Test
    public void testOrderStatistic() {
        fillTree(tree1,  new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40});

        assertEquals(-40, bstManipulation.orderStatistic(tree1, 1), 0.1);
        assertEquals(232, bstManipulation.orderStatistic(tree1, 12), 0.1);
        assertEquals(5, bstManipulation.orderStatistic(tree1, 5), 0.1);
        assertEquals(0, bstManipulation.orderStatistic(tree1, 3), 0.1);
        assertEquals(12, bstManipulation.orderStatistic(tree1, 8), 0.1);
    }
}
