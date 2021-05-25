package orderStatistic;

import util.Util;

import java.util.Arrays;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 * 
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 * 
 * @author Adalberto
 *
 */
public class QuickSelect<T extends Comparable<T>> {

	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calclar o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado
	 * array de dados comparaveis. Primeiro ele escolhe um elemento como o pivot
	 * e particiona os daods em duas partes baseado no pivot (exatemente da
	 * mesma forma que o quicksort). Depois disso, ele chama recursivamente o
	 * mesmo algoritmo em apenas uma das metades (a que contem o k-esimo menor
	 * elemento). Isso reduz a completixade de O(n.log n) para O(n).
	 * 
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja
	 * fora do tamanho do array, o metodo deve retornar null.
	 * 
	 * 
	 * @param array
	 *            o array de dados a procurar o k-esimo menor elemento.
	 * @param k
	 *            a ordem do elemento desejado. 1 significa primeiro menor
	 *            elemento, 2 significa segundo menor elemento e assim por
	 *            diante
	 * @return k-esimo menor elemento
	 */
	public T quickSelect(T[] array, int k) {
		if (array.length == 0 || (k > array.length + 1 || k < 1)) return null;
		T[] copy = array.clone();

		return quickSelectRecursivo(copy, k, 0, array.length - 1);
	}

	private T quickSelectRecursivo(T[] array, int k, int left, int right) {
		int order = partition(array, left, right);

		if (order > k - 1) {
			return quickSelectRecursivo(array, k, left, order - 1);
		} else if (order < k - 1) {
			return quickSelectRecursivo(array, k, order + 1, right);
		} else {
			return array[order];
		}
	}

	private int partition(T[] array, int left, int right) {
		int pivot_index = getRandomPivot(left, right);
		Util.swap(array, left, pivot_index);

		T pivot = array[left];
		int i = left;

		for (int j = i + 1; j <= right; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				Util.swap(array, ++i, j);
			}
		}

		Util.swap(array, left, i);

		return i;
	}

	private int getRandomPivot(int left, int right) {
		int range = right - left + 1;
		return (int) (Math.random() * range) + left;
	}
}