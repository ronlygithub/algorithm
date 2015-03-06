package com.algorithm.bstree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author duanmh
 * 
 */
public class BSTree {
	/**
	 * �����
	 */
	private Node root;
	private List<Node> nodes = new ArrayList<Node>();

	public BSTree(String[] datas) {
		creatrTree(datas);
	}

	/**
	 * ���������������ӽ��
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
	 * ���������������ӽ��
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
	 * ���㵱ǰ���Ϊ���Ķ����������Ľ����Ŀ
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
	 * �ڶ���������н��в���
	 * 
	 * @param key
	 * @return
	 */
	public Node get(String key) {
		return get(root, key);

	}

	/**
	 * �ڶ���������н��в���
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
	 * ��ȡ����������е����ֵ
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
	 * ��ȡ�������������Сֵ
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
	 * ɾ���������������Сֵ
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
	 * ɾ����������������ֵ
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
	 * ɾ�����
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

}

