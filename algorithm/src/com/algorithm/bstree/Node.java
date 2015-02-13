package com.algorithm.bstree;

/**
 * 二叉搜索树结点
 * 
 * @author duanmh
 * 
 */
public class Node {
	/**
	 * 键值
	 */
	public String key;
	/**
	 * 值
	 */
	public int value;
	/**
	 * 左子树，右子树及当前结点的结点数目和
	 */
	public int size;
	/**
	 * 左子结点
	 */
	public Node left;
	/**
	 * 右子结点
	 */
	public Node right;

	public Node(String key, int value, int size) {
		this.key = key;
		this.value = value;
		this.size = size;
	}

}
