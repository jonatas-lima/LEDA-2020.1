package adt.heap;

import adt.heap.extended.FloorCeilHeap;
import adt.heap.extended.FloorCeilHeapImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FloorCeilTest {
    private FloorCeilHeap floorCeil;
    private Integer[] array;

    @Before
    public void setUp() {
        this.floorCeil = new FloorCeilHeapImpl(new ComparatorMaxHeap<>());
        this.array = new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40};
    }

    @Test
    public void testFloor_EhRaiz() {
        assertEquals(6, this.floorCeil.floor(array, 7), 0.1);
        assertEquals(6, this.floorCeil.floor(array, 8), 0.1);
    }

    @Test
    public void testFloor_EhFolha() {
        assertEquals(-40, this.floorCeil.floor(array, -40), 0.1);
        assertEquals(-40, this.floorCeil.floor(array, -35), 0.1);
    }

    @Test
    public void testFloor() {
        assertEquals(232, this.floorCeil.floor(array, 233), 0.1);
    }

    @Test
    public void testFloor01() {
        assertEquals(232, this.floorCeil.floor(array, 232), 0.1);

    }

    @Test
    public void testFloor02() {
        assertEquals(232, this.floorCeil.floor(array, 1000), 0.1);
    }

    @Test
    public void testFloor03() {
        assertEquals(0, this.floorCeil.floor(array, 0), 0.1);
    }

    @Test
    public void testFloor04() {
        assertEquals(5, this.floorCeil.floor(array, 5), 0.1);
    }

    @Test
    public void testFloor05() {
        assertEquals(2, this.floorCeil.floor(array, 2), 0.1);
    }

    @Test
    public void testFloor06() {
        assertEquals(0, this.floorCeil.floor(array, 1), 0.1);
    }

    @Test
    public void testFloor07() {
        assertEquals(0, this.floorCeil.floor(array, 1), 0.1);
        assertEquals(-34, this.floorCeil.floor(array, -32), 0.1);
    }

    @Test
    public void testFloor08() {
        assertNull(this.floorCeil.floor(array, Integer.MIN_VALUE));
        assertNull(this.floorCeil.floor(array, -50));
    }

    @Test
    public void testCeil() {
        assertEquals(232, this.floorCeil.ceil(array, 231), 0.1);
        assertEquals(232, this.floorCeil.ceil(array, 232), 0.1);
    }

    @Test
    public void testCeil01() {
        assertNull(this.floorCeil.ceil(array, Integer.MAX_VALUE));
        assertNull(this.floorCeil.ceil(array, 235));
    }

    @Test
    public void testCeil02() {
        assertEquals(6, this.floorCeil.ceil(array, 6), 0.1);
    }

    @Test
    public void testCeil03() {
        assertEquals(-34, this.floorCeil.ceil(array, -35), 0.1);
        assertEquals(-40, this.floorCeil.ceil(array, Integer.MIN_VALUE), 0.1);
    }

    @Test
    public void testCeil_EhRaiz() {
        assertEquals(5, this.floorCeil.ceil(array, 5), 0.1);
    }
}
