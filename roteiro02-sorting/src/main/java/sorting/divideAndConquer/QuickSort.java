package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex || array.length <= 1) return;
		
		int index_pivot = partition(array, leftIndex, rightIndex);
		sort(array, leftIndex, index_pivot - 1);
		sort(array, index_pivot + 1, rightIndex);
	}

	protected int getRandomPivot(int left, int right) {
		int range = (right - left) + 1;
		return (int) (Math.random() * range) + left;
	}

	protected int partition(T[] array, int left, int right) {
		int pivot_index = this.getRandomPivot(left, right);
		Util.swap(array, left, pivot_index);
		
		T pivot = array[left];
		int i = left;
		
		for (int j = i + 1; j <= right; j++) {
			if (array[j].compareTo(pivot) <= 0)
				Util.swap(array, ++i, j);
		}
		
		Util.swap(array, left, i);
		return i;
	}
}
