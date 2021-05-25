package testing;

import orderStatistic.KLargest;
import orderStatistic.KLargestOrderStatisticsImpl;
import orderStatistic.QuickSelect;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import problems.Floor;
import problems.FloorBinarySearchImpl;

import java.util.Arrays;

public class OrderStatisticsTest {

    private KLargest<Integer> kLargest;
    private QuickSelect<Integer> quickSelect;
    private Floor floor;

    private Integer[] arrayOrdenado;
    private Integer[] arrayOrdenadoReverso;
    private Integer[] arrayPadrao;
    private Integer[] arrayNumerosRepetidos;
    private Integer[] arrayVazio;
    private Integer[] arrayUnicoValor;

    private void getKLargestImpl() {
        this.kLargest = new KLargestOrderStatisticsImpl<>();
    }

    private void getQuickSelectImpl() {
        this.quickSelect = new QuickSelect<>();
    }

    private void getFloorImpl() {
        this.floor = new FloorBinarySearchImpl();
    }

    @Before
    public void setUp() {
        getKLargestImpl();
        getQuickSelectImpl();
        getFloorImpl();

        preencheArrayOrdenado(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8});
        preencheArrayOrdenadoReverso(new Integer[] {8, 7, 6, 5, 4, 3, 2, 1});
        preencheArrayPadrao(new Integer[] {100, 5, 2, 9, 3, 90, 12, 55});
        preencheArrayNumerosRepetidos(new Integer[] {10, 9, 8, 12, 10, 45, 9});
        preencheArrayValorUnico(new Integer[] {6, 6, 6, 6, 6, 6});
        this.arrayVazio = new Integer[]{};
    }

    private void preencheArrayOrdenado(Integer[] array) {
        this.arrayOrdenado = Arrays.copyOf(array, array.length);
    }

    private void preencheArrayOrdenadoReverso(Integer[] array) {
        this.arrayOrdenadoReverso = Arrays.copyOf(array, array.length);
    }

    private void preencheArrayPadrao(Integer[] array) {
        this.arrayPadrao = Arrays.copyOf(array, array.length);
    }

    private void preencheArrayNumerosRepetidos(Integer[] array) {
        this.arrayNumerosRepetidos = Arrays.copyOf(array, array.length);
    }

    private void preencheArrayValorUnico(Integer[] array) {
        this.arrayUnicoValor = Arrays.copyOf(array, array.length);
    }

    @Test
    public void testQuickSelect01() {
        Assert.assertEquals(5, this.quickSelect.quickSelect(this.arrayOrdenado, 5), 0);
    }

    @Test
    public void testQuickSelect02() {
        Assert.assertEquals(5, this.quickSelect.quickSelect(this.arrayOrdenadoReverso, 5), 0);
    }

    @Test
    public void testQuickSelect03() {
        Assert.assertEquals(1, this.quickSelect.quickSelect(this.arrayOrdenado, 1), 0);
    }

    @Test
    public void testQuickSelect04() {
        Assert.assertEquals(100, this.quickSelect.quickSelect(this.arrayPadrao, 8), 0);
    }

    @Test
    public void testQuickSelect05() {
        Assert.assertEquals(5, this.quickSelect.quickSelect(this.arrayOrdenado, 5), 0);
    }

    @Test
    public void testQuickSelect06() {
        Assert.assertEquals(5, this.quickSelect.quickSelect(this.arrayOrdenado, 5), 0);
    }

    @Test
    public void testFloorBinarySearch01() {
        Assert.assertEquals(5, this.floor.floor(this.arrayPadrao, 5), 0);
    }

    @Test
    public void testFloorBinarySearch02() {
        Assert.assertEquals(100, this.floor.floor(this.arrayPadrao, 101), 0);
    }

    @Test
    public void testFloorBinarySearch03() {
        Assert.assertEquals(12, this.floor.floor(this.arrayPadrao, 54), 0);
    }

    @Test
    public void testFloorBinarySearch04() {
        Assert.assertNull(this.floor.floor(this.arrayPadrao, -1293123));
    }

    @Test
    public void testFloorBinarySearch05() {
        Assert.assertEquals(3, this.floor.floor(this.arrayPadrao, 4), 0);
    }

    @Test
    public void testFloorBinarySearch06() {
        Assert.assertEquals(55, this.floor.floor(this.arrayPadrao, 89), 0);
    }

    @Test
    public void testKLargestOrderStatistics01() {
        Integer[] result = Arrays.copyOf(this.kLargest.getKLargest(this.arrayPadrao, 5), 5);
        Assert.assertArrayEquals(new Integer[] { 9, 12, 55, 90, 100 }, result);
    }

    @Test
    public void testKLargestOrderStatistics02() {
        Integer[] result = Arrays.copyOf(this.kLargest.getKLargest(this.arrayOrdenado, 5), 5);
        Assert.assertArrayEquals(new Integer[] { 4, 5, 6, 7, 8 }, result);
    }

    @Test
    public void testKLargestOrderStatistics03() {
        Assert.assertArrayEquals(new Integer[] {}, this.kLargest.getKLargest(this.arrayVazio, 5));
    }

    @Test
    public void testKLargestOrderStatistics04() {
        Assert.assertArrayEquals(new Integer[] {}, this.kLargest.getKLargest(this.arrayPadrao, 500));
    }

    @Test
    public void testKLargestOrderStatistics05() {
        Assert.assertArrayEquals(new Integer[] {}, this.kLargest.getKLargest(this.arrayPadrao, -500));
    }
}
