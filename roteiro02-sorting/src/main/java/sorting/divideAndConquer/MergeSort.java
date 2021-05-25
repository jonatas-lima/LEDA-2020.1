package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array.length <= 1 || leftIndex >= rightIndex) return;
		
		int middle = (leftIndex + rightIndex) / 2;
		sort(array, leftIndex, middle);
		sort(array, middle + 1, rightIndex);
		
		merge(array, leftIndex, middle, rightIndex);
	}
	
	private void merge(T[] array, int left, int middle, int right) {
		T[] helper = Arrays.copyOf(array, array.length);
		
		int i = left;
		int j = middle + 1;
		int k = left;
		
		while (i <= middle && j <= right) {
			if (helper[i].compareTo(helper[j]) >= 0)
				array[k++] = helper[j++];
			else
				array[k++] = helper[i++];
		}
		
		while (i <= middle)
			array[k++] = helper[i++];
		
		while (j <= right)
			array[k++] = helper[j++];
	}
}
