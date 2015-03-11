package com.algorithm.bstree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author duanmh
 * 
 */
public class BSTree {
	/**
	 * 根结点
	 */
	private Node root;

	public Node getRoot() {
		return root;
	}

	private List<Node> nodes = new ArrayList<Node>();

	public BSTree(String[] datas) {
		creatrTree(datas);
	}

	/**
	 * 向二叉搜索树中添加结点
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Node put(String key, int value) {
		root = put(root, key, value);
		return root;

	}

	/**
	 * 向二叉搜索树中添加结点
	 * 
	 * @param node
	 * @param key
	 * @param value
	 * @return
	 */
	private Node put(Node node, String key, int value) {
		if (node == null) {
			return new Node(key, value, 1);
		}

		int compare = key.compareTo(node.key);
		if (compare < 0) {
			node.left = put(node.left, key, value);
		} else if (compare > 0) {
			node.right = put(node.right, key, value);
		} else {
			node.value = value;
		}
		node.size = size(node.left) + size(node.right) + 1;
		return node;
	}

	public int size() {
		return size(root);
	}

	/**
	 * 计算当前结点为根的二叉搜索树的结点数目
	 * 
	 * @param node
	 * @return
	 */
	public int size(Node node) {
		if (node == null) {
			return 0;
		}
		return size(node.left) + size(node.right) + 1;
	}

	/**
	 * 在二叉查找树中进行查找
	 * 
	 * @param key
	 * @return
	 */
	public Node get(String key) {
		return get(root, key);

	}

	/**
	 * 在二叉查找树中进行查找
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	private Node get(Node node, String key) {
		if (node == null || key == null || "".equals(key)) {
			return null;
		}
		int compare = key.compareTo(node.key);
		if (compare < 0) {
			return get(node.left, key);
		} else if (compare > 0) {
			return get(node.right, key);
		}
		return node;

	}

	/**
	 * 获取二叉查找树中的最大值
	 * 
	 * @return
	 */
	public Node max() {
		return max(root);
	}

	private Node max(Node node) {
		if (node == null) {
			return null;
		}

		if (node.right != null) {
			return max(node.right);
		}
		return node;

	}

	/**
	 * 获取二叉查找树中最小值
	 * 
	 * @return
	 */
	public Node min() {
		return min(root);
	}

	private Node min(Node node) {
		if (node == null) {
			return null;
		}

		if (node.left != null) {
			return min(node.left);
		}
		return node;
	}

	/**
	 * 删除二叉查找树中最小值
	 * 
	 * @return
	 */
	public void deleteMin() {
		root = deleteMin(root);

	}

	private Node deleteMin(Node node) {
		if (node == null) {
			return null;
		}
		if (node.left == null) {
			return node.right;
		}
		node.left = deleteMin(node.left);
		node.size = size(node.left) + size(node.right) + 1;
		return node;

	}

	/**
	 * 删除二叉查找树的最大值
	 * 
	 * @return
	 */
	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node deleteMax(Node node) {
		if (node == null) {
			return null;
		}
		if (node.right == null) {
			return node.left;
		}
		node.right = deleteMax(node.right);
		node.size = size(node.left) + size(node.right) + 1;
		return node;
	}

	public Node delete(String key) {
		return delete(root, key);
	}

	/**
	 * 删除结点
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	private Node delete(Node node, String key) {
		if (node == null) {
			return null;
		}

		int compare = key.compareTo(node.key);
		if (compare < 0) {
			node.left = delete(node.left, key);
		} else if (compare > 0) {
			node.right = delete(node.right, key);
		} else {
			if (node.left == null) {
				return node.right;
			}
			if (node.right == null) {
				return node.left;
			}

			Node t = node;
			node = min(t.right);
			node.right = deleteMin(t.right);
			node.left = t.left;

		}
		node.size = size(node.left) + size(node.right) + 1;
		return node;

	}

	private void creatrTree(String[] datas) {

		if (datas == null || datas.length == 0) {
			return;
		}

		for (int i = 0; i < datas.length; i++) {
			String[] data = datas[i].split(":");
			if (data == null || data.length != 2) {
				continue;
			}
			String key = data[0].trim();
			Integer value = Integer.valueOf(data[1].trim());
			put(key, value);

		}
	}

	public void print() {
		nodes.clear();
		print(root);
	}

	private void print(Node node) {
		if (node == null) {
			return;
		}
		print(node.left);
		nodes.add(node);
		System.out.println("key: " + node.key + " value: " + node.value + " size: " + node.size);
		print(node.right);
	}



	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("D:\\test.txt"));
		String s;
		StringBuffer sb = new StringBuffer();
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}
		BSTree tree = new BSTree(sb.toString().trim().split(","));
		tree.print();
		Node max = tree.max();
		Node min = tree.min();
		System.out.println("max " + max.key + " : " + max.value);
		System.out.println("min " + min.key + " : " + min.value);
		tree.deleteMax();
		tree.print();
		tree.deleteMin();
		tree.get("A");
		max = tree.max();
		min = tree.min();
		System.out.println("max " + max.key + " : " + max.value);
		System.out.println("min " + min.key + " : " + min.value);


	}

	public List<Node> getNodes() {
		print();
		return nodes;
	}

	public int MinmumDepth() {
		return MinmumDepth(root);
	}

	private int MinmumDepth(Node node) {
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

	public boolean isBalanced() {
		return isBalanced(root);
	}

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

	/**
	 * 判断两棵树是否相等
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree(Node p, Node q) {
		if (p == null && q == null) {
			return true;
		}

		if (p == null || q == null) {
			return false;
		}

		if (p.value != q.value) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

	}

	public void levelOrderVist() {
		levelOrderVist(root);
	}

	/**
	 * 层序遍历
	 */
	public void levelOrderVist(Node root) {
		if (root == null) {
			return;
		}
		Node node = root;
		Deque<Node> quen = new LinkedList<Node>();
		Stack<Integer> vist = new Stack<Integer>();

		quen.add(node);
		while (!quen.isEmpty()) {
			if (node.left != null) {
				quen.add(node.left);
			}
			if (node.right != null) {
				quen.add(node.right);
			}
			Node pop = quen.pop();
			vist.add(pop.value);
			node = quen.peek();
		}

	}

	public List<List<Integer>> levelOrderBottom(Node root) {
		LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
		addLevel(list, 0, root);
		return list;
	}

	private void addLevel(LinkedList<List<Integer>> list, int level, Node node) {
		if (node == null) {
			return;
		}
		if (list.size() - 1 < level) {
			list.addLast(new LinkedList<Integer>());
		}
		list.get(list.size() - 1 - level).add(node.value);
		addLevel(list, level + 1, node.left);
		addLevel(list, level + 1, node.right);
	}
}

