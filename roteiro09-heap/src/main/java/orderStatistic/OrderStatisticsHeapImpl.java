package orderStatistic;

import adt.heap.ComparatorMaxHeap;

import java.util.PriorityQueue;

public class OrderStatisticsHeapImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Existem diversas formas de se calcular uma estatistica de ordem. 
	 * Voce deve fazer isso usando uma heap restricoes:
	 * - nenhuma copia ou estrutura array auxiliar serah permitida, exceto o uso de
	 *   uma PriorityQueue
	 * - caso a estatistica de ordem procurada nao exista no array o metodo deve retornar null 
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	
	@Override
	public T getOrderStatistics(T[] array, int k) {
		if (array == null || k < 1 || k > array.length) {
			return null;
		}

		PriorityQueue<T> heap = new PriorityQueue<T>(new ComparatorMaxHeap<>());
		for (T el : array)
			heap.add(el);

		T order = null;
		for (int i = 0; i < k; i++)
			order = heap.poll();
		return order;
	}

}
