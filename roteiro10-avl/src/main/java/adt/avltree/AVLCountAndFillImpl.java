package adt.avltree;

import adt.bst.BSTNode;
import adt.bt.Util;

import java.util.*;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {

	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		if (array != null && array.length > 0) {
			Arrays.sort(array);
			Map<Integer, List<T>> heights = new TreeMap<>();

			fillWithoutRebalance(heights, 0, array.length - 1, 0, array);
			heights.values().forEach(list -> list.forEach(super::insert));
		}
	}

	private void fillWithoutRebalance(Map<Integer, List<T>> levels, int left, int right, int height, T[] array) {
		if (left <= right) {
			int mid = (left + right) / 2;
			if (!levels.containsKey(height)) {
				levels.put(height, new ArrayList<>());
			}
			levels.get(height).add(array[mid]);

			fillWithoutRebalance(levels, left, mid - 1, height + 1, array);
			fillWithoutRebalance(levels, mid + 1, right, height + 1, array);
		}
	}

	@Override
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
		if (this.calculateBalance((BSTNode<T>) node.getLeft()) > 0) {
			this.LLcounter++;
		} else {
			Util.leftRotation((BSTNode<T>) node.getLeft());
			this.LRcounter++;
		}
		rebalancedNode = Util.rightRotation(node);

		if (rebalancedNode.getParent() == null) {
			super.root = rebalancedNode;
		}
	}

	private void hangingRight(BSTNode<T> node) {
		BSTNode<T> rebalancedNode;
		if (this.calculateBalance((BSTNode<T>) node.getRight()) < 0) {
			this.RRcounter++;
		} else {
			Util.rightRotation((BSTNode<T>) node.getRight());
			this.RLcounter++;
		}
		rebalancedNode = Util.leftRotation(node);

		if (rebalancedNode.getParent() == null) {
			super.root = rebalancedNode;
		}
	}

}
