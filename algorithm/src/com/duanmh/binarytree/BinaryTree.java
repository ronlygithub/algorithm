/************************* 版权声明 *********************************
 * 
 * 版权所有：XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* 变更记录 *********************************
 *
 * 创建者：XXXXXXXXXX   创建日期： 2014年11月20日
 * 创建记录：创建类结构。
 * 
 * 修改者：       修改日期：
 * 修改记录：
 *
 * 修改者：       修改日期：
 * 修改记录：
 * ……
 ************************* To  Do *********************************
 *
 * 1、实现所有未实现的方法（抛出UnsupportedOperationException的方法）。
 * 
 ************************* 随   笔 *********************************
 *
 * 这里可以写写感想，感慨，疑问什么的。
 * 
 ******************************************************************
 */

package com.duanmh.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author duanmh
 * 
 */
public class BinaryTree {

	public static void main(String[] args) {
		TreeNode bt1 = creatrBT();
		postVistTree(bt1);
		System.out.println("树高度" + getBTHeight(bt1));
		// TreeNode revse = bt1;
		// preOrderVist(revse);
		// TreeNode mirrorTree = getMirrorTree(revse);
		// System.out.println("\n");
		// preOrderVist(mirrorTree);
		// getMirrorTreeFor(mirrorTree);
		// System.out.println("\n");
		// preOrderVist(mirrorTree);
		// System.out.println("tree A complete");
		// TreeNode bt2 = creatrBT();
		// System.out.println("tree B complete");
		// TreeNode rootA = bt1;
		// TreeNode rootB = bt2;
		// preOrderVist(bt1);
		// System.out.println(isSubTree(rootA, rootB));
		// isSubTree(rootA, rootB);

	}

	@SuppressWarnings("resource")
	public static TreeNode creatrBT() {
		System.out.println("请输入节点:");
		Scanner s = new Scanner(System.in);

		int value = s.nextInt();
		if (value == -1) {
			return null;
		}
		TreeNode root = new TreeNode();
		root.value = value;
		root.leftChild = creatrBT();

		root.rightChild = creatrBT();
		return root;
	}

	public static void preOrderVist(TreeNode bt) {
		if (bt == null) {
			return;
		}
		System.out.print(bt.value + " ");
		preOrderVist(bt.leftChild);
		preOrderVist(bt.rightChild);
	}

	/**
	 * 树b是否是树a的子结构
	 * 
	 * @param rootA
	 * @param rootB
	 * @return
	 */
	public static boolean isSubTree(TreeNode rootA, TreeNode rootB) {
		if (rootB == null) {
			return true;
		} else if (rootA == null) {
			return false;
		}

		boolean resutlt = false;
		if (rootA.value == rootB.value) {
			resutlt = doseHas(rootA, rootB);
		}
		if (!resutlt) {
			resutlt = isSubTree(rootA.leftChild, rootB);
		}
		if (!resutlt) {
			resutlt = isSubTree(rootA.rightChild, rootB);
		}
		return resutlt;
	}

	public static boolean doseHas(TreeNode rootA, TreeNode rootB) {
		if (rootB == null) {
			return true;
		}

		if (rootA == null) {
			return false;
		}

		if (rootA.value != rootB.value) {
			return false;
		}

		return doseHas(rootA.leftChild, rootB.leftChild)
				&& doseHas(rootA.rightChild, rootB.rightChild);

	}

	/**
	 * 树高度
	 * 
	 * @param root
	 * @return
	 */
	public static int getBTHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = getBTHeight(root.leftChild);
		int rightHeight = getBTHeight(root.rightChild);
		return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;

	}

	/**
	 * 递归获取树镜像
	 * 
	 * @param root
	 * @return
	 */
	public static TreeNode getMirrorTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode tmp = root.leftChild;
		root.leftChild = root.rightChild;
		root.rightChild = tmp;
		getMirrorTree(root.leftChild);
		getMirrorTree(root.rightChild);

		return root;

	}

	/**
	 * 循环方法获取树镜像
	 * 
	 * @param root
	 * @return
	 */
	public static TreeNode getMirrorTreeFor(TreeNode root) {
		if (root == null) {
			return null;
		}

		Queue<TreeNode> deque = new LinkedList<TreeNode>();
		deque.add(root);
		while (!deque.isEmpty()) {
			TreeNode poll = deque.poll();
			if (poll != null) {
				TreeNode tmp = poll.leftChild;
				poll.leftChild = poll.rightChild;
				poll.rightChild = tmp;

				deque.add(poll.leftChild);
				deque.add(poll.rightChild);

			}

		}
		return root;

	}

	public static class TreeNodeStack {
		public TreeNode node;
		public int count;

		public TreeNodeStack(TreeNode node) {
			this.node = node;
		}
	}

	private static void postVistTree(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNodeStack> stack = new Stack<TreeNodeStack>();
		TreeNodeStack node = new TreeNodeStack(root);
		stack.push(node);
		while (stack.size() > 0) {
			TreeNodeStack peek = stack.peek();
			peek.count++;

			if (peek.node == null) {
				stack.pop();
			} else if (peek.count == 1) {
				stack.push(new TreeNodeStack(peek.node.leftChild));
			} else if (peek.count == 2) {
				stack.push(new TreeNodeStack(peek.node.rightChild));
			} else if (peek.count == 3) {
				TreeNodeStack pop = stack.pop();
				System.out.println(pop.node.value);

			}
		}

	}
}
