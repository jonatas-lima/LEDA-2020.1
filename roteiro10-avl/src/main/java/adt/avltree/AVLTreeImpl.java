package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	@Override
	public void insert(T element) {
		if (element != null) {
			this.insert(element, this.root);
		}
	}

	protected void insert(T element, BSTNode<T> node) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setRight(this.buildNewNode(null, node));
			node.setLeft(this.buildNewNode(null, node));
		} else {
			T data = node.getData();
			if (data.compareTo(element) > 0) {
				insert(element, (BSTNode<T>) node.getLeft());
			} else {
				insert(element, (BSTNode<T>) node.getRight());
			}
			rebalance(node);
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty()) {
			BSTNode<T> nodeToRemove = this.search(element);
			super.remove(element);
			this.rebalanceUp(nodeToRemove);
		}
	}

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int fb = 0;
		if (node != null && !node.isEmpty())
			fb = this.height((BSTNode<T>) node.getLeft()) - this.height((BSTNode<T>) node.getRight());
		return fb;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int fb = this.calculateBalance(node);
		if (fb > 1) {
			this.hangingLeft(node);
		} else if (fb < -1) {
			this.hangingRight(node);
		}
	}

	private void hangingLeft(BSTNode<T> node) {
		BSTNode<T> rebalancedNode;
		if (this.calculateBalance((BSTNode<T>) node.getLeft()) < 0) {
			Util.leftRotation((BSTNode<T>) node.getLeft());
		}
		rebalancedNode = Util.rightRotation(node);

		if (rebalancedNode.getParent() == null) {
			super.root = rebalancedNode;
		}
	}

	private void hangingRight(BSTNode<T> node) {
		BSTNode<T> rebalancedNode;
		if (this.calculateBalance((BSTNode<T>) node.getLeft()) > 0) {
			Util.rightRotation((BSTNode<T>) node.getLeft());
		}
		rebalancedNode = Util.leftRotation(node);

		if (rebalancedNode.getParent() == null) {
			super.root = rebalancedNode;
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		BSTNode<T> aux = (BSTNode<T>) node.getParent();

		while (aux != null) {
			rebalance(aux);
			aux = (BSTNode<T>) aux.getParent();
		}
	}
}
