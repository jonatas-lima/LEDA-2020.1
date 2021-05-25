package adt.bst;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		boolean isBst;
		if (this.bst.isEmpty())
			isBst = true;
		else
			isBst = this.isBST(this.bst.root);
		return isBst;
	}

	private boolean isBST(BSTNode<T> node) {
		boolean isBST;
		if (node.isEmpty()) {
			isBST = true;
		} else {
			T nodeData = node.getData();

			boolean isLeftValid = isBSTLeft((BSTNode<T>) node.getLeft(), nodeData);
			boolean isRightValid = isBSTRight((BSTNode<T>) node.getRight(), nodeData);
			isBST = isLeftValid && isRightValid && isBST((BSTNode<T>) node.getLeft()) && isBST((BSTNode<T>) node.getRight());
		}

		return isBST;
	}

	private boolean isBSTLeft(BSTNode<T> node, T data) {
		boolean isBST = false;
		if (node.isEmpty()) {
			isBST = true;
		} else {
			if (node.getData().compareTo(data) < 0) {
				isBST = isBSTLeft((BSTNode<T>) node.getLeft(), data) && isBSTLeft((BSTNode<T>) node.getRight(), data);;
			}
		}
		return isBST;
	}

	private boolean isBSTRight(BSTNode<T> node, T data) {
		boolean isBST = false;
		if (node.isEmpty()) {
			isBST = true;
		} else {
			if (node.getData().compareTo(data) > 0) {
				isBST = isBSTRight((BSTNode<T>) node.getLeft(), data) && isBSTRight((BSTNode<T>) node.getRight(), data);
			}
		}
		return isBST;
	}

}
