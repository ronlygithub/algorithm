package com.duanmh.binarytree;

import com.algorithm.bstree.Node;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * @author duanmh
 * 
 */
public class MinNumDepth {
	public int MinmumDepth(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}

		if (node.left == null) {
			return 1 + MinmumDepth(node.right);
		}
		if (node.right == null) {
			return 1 + MinmumDepth(node.left);
		}
		int left = MinmumDepth(node.left);
		int right = MinmumDepth(node.right);
		int min = left > right ? left : right;
		return min + 1;

	}
}

