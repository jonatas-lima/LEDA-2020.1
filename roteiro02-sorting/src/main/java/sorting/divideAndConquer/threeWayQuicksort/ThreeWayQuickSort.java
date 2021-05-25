package sorting.divideAndConquer.threeWayQuicksort;

import sorting.divideAndConquer.QuickSort;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		QuickSort<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitos elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex || array.length <= 1) return;
		
		int index_pivot = partition(array, leftIndex, rightIndex);
		sort(array, leftIndex, index_pivot - 1);
		sort(array, index_pivot + 1, rightIndex);
	}

	@Override
	protected int partition(T[] array, int left, int right) {
		int pivot_index = this.getRandomPivot(left, right);
		Util.swap(array, left, pivot_index);
		
		T pivot = array[left];
		int i = left;
		
		for (int j = i + 1; j <= right; j++) {
			if (array[j].compareTo(pivot) < 0) {
				Util.swap(array, ++i, j);
			}
		}
		
		Util.swap(array, left, i);
		
		pivot = array[i];
		int k = i;
		
		for (int j = i + 1; j <= right; j++) {
			if (array[j].compareTo(pivot) == 0) {
				Util.swap(array, ++k, j);
			}
		}
		
		Util.swap(array, i, k);
		
		return k;
	}

}
