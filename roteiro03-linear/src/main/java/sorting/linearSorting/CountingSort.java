package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex || array.length <= 1) return;

		Integer k = getMaior(array, leftIndex, rightIndex);
		countingSort(array, leftIndex, rightIndex, k, 0);
	}

	protected Integer getMaior(Integer[] array, int leftIndex, int rightIndex) {
		Integer maior = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > maior)
				maior = array[i];
		}
		return maior;
	}

	private void somaCumulativa(int[] array) {
		for (int i = 1; i < array.length; i++)
			array[i] += array[i - 1];
	}

	private void copiaArray(Integer[] src, Integer[] target, int targetStart) {
		for (Integer num : src)
			target[targetStart++] = num;
	}

	private int[] contaFrequencia(Integer[] array, int leftIndex, int rightIndex, Integer maior, Integer menor) {
		int[] frequencies = new int[maior - menor + 1];

		for (int i = leftIndex; i <= rightIndex; i++) {
			frequencies[array[i] - menor]++;
		}

		return frequencies;
	}

	protected void countingSort(Integer[] array, int leftIndex, int rightIndex, int maior, int menor) {
		int[] frequencies = contaFrequencia(array, leftIndex, rightIndex, maior, menor);
		somaCumulativa(frequencies);

		Integer[] sorted = new Integer[rightIndex - leftIndex + 1];
		for (int i = rightIndex; i >= leftIndex; i--) {
			sorted[frequencies[array[i] - menor] - 1] = array[i];
			frequencies[array[i] - menor]--;
		}

		copiaArray(sorted, array, leftIndex);
	}

}
