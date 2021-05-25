package adt.heap.extended;

import adt.heap.ComparatorMaxHeap;
import adt.heap.ComparatorMinHeap;
import adt.heap.HeapImpl;

import java.util.Comparator;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		if (array == null)
			return null;

		fillHeapFloor(array, numero);
		return floor(numero, this.rootElement());
	}

	private Integer floor(double numero, Integer currentFloor) {
		if (this.comparator instanceof ComparatorMaxHeap) {
			return this.extractRootElement();
		} else {
			if (currentFloor == null) {
				return null;
			} else if (numero == currentFloor || this.isEmpty()) {
				return currentFloor;
			} else if (this.rootElement() > currentFloor) {
				return floor(numero, this.extractRootElement());
			} else {
				return floor(numero, currentFloor);
			}
		}
	}

	private void fillHeapCeil(Integer[] array, double numero) {
		for (Integer num : array) {
			if (num >= numero)
				this.insert(num);
		}
	}

	private void fillHeapFloor(Integer[] array, double numero) {
		for (Integer num : array) {
			if (num <= numero)
				this.insert(num);
		}
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		if (array == null) {
			return null;
		}

		fillHeapCeil(array, numero);
		return ceil(numero, this.extractRootElement());
	}

	private Integer ceil(double numero, Integer currentCeil) {
		if (this.comparator instanceof ComparatorMinHeap) {
			return this.extractRootElement();
		} else {
			if (currentCeil == null) {
				return null;
			} else if (numero == currentCeil || this.isEmpty()) { // para quando o heap esta vazio ou quando achou o numero
				return currentCeil;
			} else if (this.rootElement() > currentCeil) {
				return ceil(numero, currentCeil);
			} else {
				return ceil(numero, this.extractRootElement());
			}
		}
	}

}
