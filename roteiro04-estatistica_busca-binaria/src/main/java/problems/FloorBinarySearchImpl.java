package problems;

import util.Util;

import java.util.Arrays;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if (array.length < 1)
			return null;

		// ordena o array
		quickSort(array, 0, array.length - 1);
		if (array[0].compareTo(x) > 0)
			return null;

		return floorBinarySearch(array, x, 0, array.length - 1, Integer.MAX_VALUE);
	}

	private Integer floorBinarySearch(Integer[] array, Integer x, int left, int right, Integer floor) {
		if (left > right)
			return floor;

		int middle = (left + right) / 2;

		if (array[middle].compareTo(x) > 0) {
			return floorBinarySearch(array, x, left, middle - 1, floor);
		} else if (array[middle].compareTo(x) < 0) {
			return floorBinarySearch(array, x, middle + 1, right, array[middle]);
		}

		return x;
	}

	private void quickSort(Integer[] array, int left, int right) {
		if (left < right) {
			int i_pivot = partition(array, left, right);
			quickSort(array, left, i_pivot - 1);
			quickSort(array, i_pivot + 1, right);
		}
	}

	private int partition(Integer[] array, int left, int right) {
		int i_pivot = getRandomPivot(left, right);
		Util.swap(array, left, i_pivot);

		Integer pivot = array[left];
		int i = left;

		for (int j = i + 1; j <= right; j++) {
			if (array[j].compareTo(pivot) <= 0)
				Util.swap(array, ++i, j);
		}

		Util.swap(array, left, i);
		return i;
	}

	private int getRandomPivot(int left, int right) {
		int range = right - left + 1;
		return (int) (Math.random() * range) + left;
	}

}
