package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (rightIndex > array.length)
			rightIndex = array.length - 1;
		
		for (int i = leftIndex; i < rightIndex; i++) {
			int i_menor = getIndexMenor(array, i, rightIndex);
			Util.swap(array, i, i_menor);
		}
	}
	
	private int getIndexMenor(T[] array, int leftIndex, int rightIndex) {
		int i_menor = leftIndex;
		for (int i = leftIndex; i <= rightIndex; i++)
			if (array[i].compareTo(array[i_menor]) == -1)
				i_menor = i;
		return i_menor;
	}
}
