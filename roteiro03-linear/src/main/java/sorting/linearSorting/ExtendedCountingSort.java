package sorting.linearSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends CountingSort {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex || array.length <= 1) return;

		Integer maiorElemento = getMaior(array, leftIndex, rightIndex);
		Integer menorElemento = getMenor(array, leftIndex, rightIndex);
		countingSort(array, leftIndex, rightIndex, maiorElemento, menorElemento);
	}

	private Integer getMenor(Integer[] array, int leftIndex, int rightIndex) {
		Integer menor = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] < menor) {
				menor = array[i];
			}
		}
		return menor;
	}

}
