package com.algorithm.bstree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example:
 *      Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 * 
 * @author duanmh
 * 
 */
public class RightSideView {

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private List<Integer> result = new ArrayList<Integer>();
	public List<Integer> rightSideView(TreeNode root) {
		if (root == null) {
			return result;
		}
		return null;

	}
}



