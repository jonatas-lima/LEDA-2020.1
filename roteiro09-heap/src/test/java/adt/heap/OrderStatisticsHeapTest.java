package adt.heap;

import orderStatistic.OrderStatistics;
import orderStatistic.OrderStatisticsHeapImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderStatisticsHeapTest {

    private OrderStatistics<Integer> orderStatistics;

    @Before
    public void setUp() {
        this.orderStatistics = new OrderStatisticsHeapImpl<>();
    }

    @Test
    public void testOrderStatistics_ArrayVazio() {
        Integer[] array = {};
        Assert.assertNull(this.orderStatistics.getOrderStatistics(array, 1));
        Assert.assertNull(this.orderStatistics.getOrderStatistics(array, 2));
        Assert.assertNull(this.orderStatistics.getOrderStatistics(array, 3));
        Assert.assertNull(this.orderStatistics.getOrderStatistics(array, -1));
    }

    @Test
    public void testOrderStatistics01() {
        Integer[] array = {1, 5, 0, 414, 84, 9, -1};
        Assert.assertNull(this.orderStatistics.getOrderStatistics(array, 20));
        Assert.assertNull(this.orderStatistics.getOrderStatistics(array, 0));
        Assert.assertNull(this.orderStatistics.getOrderStatistics(array, -1));

        Assert.assertEquals(new Integer(-1), this.orderStatistics.getOrderStatistics(array, 1));
        Assert.assertEquals(new Integer(414), this.orderStatistics.getOrderStatistics(array, 7));
        Assert.assertEquals(new Integer(0), this.orderStatistics.getOrderStatistics(array, 2));
    }
}
