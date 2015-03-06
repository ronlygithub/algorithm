package com.duanmh.binarytree;

import com.algorithm.bstree.Node;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author duanmh
 * 
 */
public class BalanceBT {
	public boolean isBalanced(Node root) {
		if (root == null) {
			return true;
		}

		int tmp = depth(root.left) - depth(root.right);
		if (Math.abs(tmp) > 1) {
			return false;
		}

		return isBalanced(root.left) && isBalanced(root.right);

	}

	private int depth(Node root) {
		if (root == null) {
			return 0;
		}
		int left = depth(root.left);
		int right = depth(root.right);

		return 1 + Math.max(left, right);

	}
}

