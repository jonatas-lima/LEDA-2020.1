package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		if (array == null || array.length < 1)
			return null;

		this.fillTree(array, 0);
		return floor(this.getRoot(), (int) numero, Integer.MAX_VALUE);
	}

	private Integer floor(BSTNode<Integer> node, int numero, Integer currentFloor) {
		if (node.isEmpty())
			return currentFloor;

		Integer nodeData = node.getData();
		if (nodeData > numero) {
			return floor((BSTNode<Integer>) node.getLeft(), numero, currentFloor);
		} else if (nodeData < numero) {
			return floor((BSTNode<Integer>) node.getRight(), numero, nodeData); // o novo floor eh o nó
		} else {
			return numero;
		}

	}

	private void fillTree(Integer[] array, int i) {
		if (i < array.length) {
			this.insert(array[i++]);
			fillTree(array, i);
		}
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		if (array == null || array.length < 1) {
			return null;
		}

		fillTree(array, 0);
		return ceil(this.getRoot(), (int) numero, Integer.MIN_VALUE);
	}

	private Integer ceil(BSTNode<Integer> node, int numero, Integer currentCeil) {
		if (node.isEmpty())
			return currentCeil;

		Integer nodeData = node.getData();
		if (nodeData > numero) {
			return ceil((BSTNode<Integer>) node.getLeft(), numero, nodeData); // o novo ceil eh o valor do nó
		} else if (nodeData < numero) {
			return ceil((BSTNode<Integer>) node.getRight(), numero, currentCeil);
		} else {
			return numero;
		}
	}
}
