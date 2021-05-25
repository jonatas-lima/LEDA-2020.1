package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		if (this.isEmpty())
			return -1;
		return height(this.root);
	}

	private int height(BSTNode<T> node) {
		if (!node.isEmpty()) {
			return 1 + Math.max(this.height((BSTNode<T>) node.getLeft()), this.height((BSTNode<T>) node.getRight()));
		}
		return -1;
	}

	@Override
	public BSTNode<T> search(T element) {
		if (this.isEmpty() || element == null)
			return new BSTNode<>();

		return search(element, this.root);
	}

	private BSTNode<T> search(T element, BSTNode<T> node) {
		if (node.isEmpty())
			return new BSTNode<>();

		T data = node.getData();
		if (element.equals(data))
			return node;
		if (element.compareTo(data) < 0)
			return search(element, (BSTNode<T>) node.getLeft());
		else
			return search(element, (BSTNode<T>) node.getRight());
	}

	@Override
	public void insert(T element) {
		if (element != null) {

			if (this.isEmpty()) {
				this.root = this.buildNewNode(element, new BSTNode<>());
			} else {
				this.insert(element, this.root);
			}
		}
	}

	private void insert(T element, BSTNode<T> node) {
		if (!node.isEmpty()) {
			if (element.compareTo(node.getData()) < 0) {
				if (node.getLeft().isEmpty()) {
					BSTNode<T> newNode = this.buildNewNode(element, node);
					node.setLeft(newNode);
				} else {
					this.insert(element, (BSTNode<T>) node.getLeft());
				}
			} else {
				if (node.getRight().isEmpty()) {
					BSTNode<T> newNode = this.buildNewNode(element, node);
					node.setRight(newNode);
				} else {
					this.insert(element, (BSTNode<T>) node.getRight());
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private BSTNode<T> buildNewNode(T data, BSTNode<T> parent) {
		return (BSTNode<T>) new BSTNode.Builder<T>()
				.data(data)
				.left(new BSTNode<>())
				.right(new BSTNode<>())
				.parent(parent)
				.build();
	}

	@Override
	public BSTNode<T> maximum() {
		if (this.isEmpty())
			return null;

		return maximum(this.root);
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		if (node.getRight() == null || node.getRight().isEmpty())
			return node;
		return maximum((BSTNode<T>) node.getRight());
	}

	@Override
	public BSTNode<T> minimum() {
		if (this.isEmpty())
			return null;

		return minimum(this.root);
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		if (node.getLeft() == null || node.getLeft().isEmpty())
			return node;
		return minimum((BSTNode<T>) node.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		if (this.isEmpty() || element == null)
			return null;

		BSTNode<T> node = this.search(element);
		if (node != null) {
			if (node.getRight() != null && !node.getRight().isEmpty())
				return this.minimum((BSTNode<T>) node.getRight());
			else {
				BSTNode<T> aux = (BSTNode<T>) node.getParent();
				while (!aux.isEmpty() && aux.getData().compareTo(node.getData()) <= 0)
					aux = (BSTNode<T>) aux.getParent();
				return aux.isEmpty() ? null : aux;
			}
		}
		return null;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		if (this.isEmpty())
			return null;

		BSTNode<T> node = this.search(element);
		if (node != null) {
			if (node.getLeft() != null && !node.getLeft().isEmpty())
				return this.maximum((BSTNode<T>) node.getLeft());
			else {
				BSTNode<T> aux = (BSTNode<T>) node.getParent();
				while (!aux.isEmpty() && aux.getData().compareTo(node.getData()) >= 0)
					aux = (BSTNode<T>) aux.getParent();
				return aux.isEmpty() ? null : aux;
			}

		}
		return null;
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty() && element != null) {
			BSTNode<T> nodeToRemove = this.search(element);
			if (!nodeToRemove.isEmpty()) {
				this.remove(element, nodeToRemove);
			}
		}
	}

	private void remove(T element, BSTNode<T> node) {
		if (node.isLeaf()) {
			removeIfLeaf(node);
		} else if (!node.getLeft().isEmpty() && !node.getRight().isEmpty()) {
			removeIfHasTwoChildren(element, node);
		} else if (!node.getLeft().isEmpty() && node.getRight().isEmpty()) {
			removeIfHasOnlyLeftChild(node);
		} else if (node.getLeft().isEmpty() && !node.getRight().isEmpty()) {
			removeIfHasOnlyRightChild(node);
		}
	}

	private void removeIfLeaf(BSTNode<T> child) {
		BSTNode<T> parent = (BSTNode<T>) child.getParent();
		if (child.equals(this.root))
			this.root = new BSTNode<>();
		else if (parent.getRight().equals(child))
			parent.setRight(new BSTNode<>());
		else
			parent.setLeft(new BSTNode<>());
	}

	private void removeIfHasOnlyLeftChild(BSTNode<T> child) {
		BSTNode<T> parent = (BSTNode<T>) child.getParent();
		if (child.equals(this.root)) {
			this.root = (BSTNode<T>) child.getLeft();
			this.root.setParent(new BSTNode<>());
		} else {
			child.getLeft().setParent(parent);
			if (parent.getData().compareTo(child.getData()) > 0) {
				parent.setLeft(child.getLeft());
			} else {
				parent.setRight(child.getLeft());
			}
		}
	}

	private void removeIfHasOnlyRightChild(BSTNode<T> child) {
		BSTNode<T> parent = (BSTNode<T>) child.getParent();
		if (child.equals(this.root)) {
			this.root = (BSTNode<T>) child.getRight();
			this.root.setParent(new BSTNode<>());
		} else {
			child.getRight().setParent(parent);
			if (parent.getData().compareTo(child.getRight().getData()) > 0) {
				parent.setLeft(child.getRight());
			} else {
				parent.setRight(child.getRight());
			}
		}
	}

	private void removeIfHasTwoChildren(T element, BSTNode<T> node) {
		BSTNode<T> sucessor = this.sucessor(node.getData());
		node.setData(sucessor.getData());
		sucessor.setData(element);
		this.remove(sucessor.getData(), sucessor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {
		ArrayList<T> list = new ArrayList<>();
		preOrder(list, this.root);
		return (T[]) list.toArray(new Comparable[0]);
	}

	private void preOrder(ArrayList<T> list, BSTNode<T> node) {
		if (!node.isEmpty()) {
			list.add(node.getData());
			preOrder(list, (BSTNode<T>) node.getLeft());
			preOrder(list, (BSTNode<T>) node.getRight());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] order() {
		ArrayList<T> list = new ArrayList<>();
		order(list, this.root);
		return (T[]) list.toArray(new Comparable[0]);
	}

	private void order(ArrayList<T> list, BSTNode<T> node) {
		if (!node.isEmpty()) {
			order(list, (BSTNode<T>) node.getLeft());
			list.add(node.getData());
			order(list, (BSTNode<T>) node.getRight());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<>();
		postOrder(list, this.root);
		return (T[]) list.toArray(new Comparable[0]);
	}

	private void postOrder(ArrayList<T> list, BSTNode<T> node) {
		if (!node.isEmpty()) {
			postOrder(list, (BSTNode<T>) node.getLeft());
			postOrder(list, (BSTNode<T>) node.getRight());
			list.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
