/************************* 版权声明 *********************************
 * 
 * 版权所有：XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* 变更记录 *********************************
 *
 * 创建者：XXXXXXXXXX   创建日期： 2014年11月26日
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

package com.duanmh.list;

/**
 * 复杂链表复制
 * 
 * @author duanmh
 * 
 */
public class ComplexListOpera {

	public static void main(String[] args) {
		RandomListNode head = createList();
		print(head);
		System.out.println("completed");
		RandomListNode copyList = copyRandomList(head);
		// print(copyList);
		// System.out.println("copy completed");
		RandomListNode[] split = split(copyList);
		System.out.println("orige list");
		print(split[0]);
		System.out.println("new list");
		print(split[1]);

	}

	private static RandomListNode createList() {
		RandomListNode head = null;

		int listLength = 0;
		RandomListNode tmp = null;
		while (listLength-- > 0) {
			if (head == null) {
				head = new RandomListNode(9);

				head.next = null;
				head.random = head;
				tmp = head;
			} else {
				RandomListNode node = new RandomListNode(listLength);
				node.next = null;
				node.random = node;
				tmp.next = node;
				tmp = tmp.next;
			}

		}

		tmp = head;
		while (tmp != null) {
			int posi = (int) (Math.random() * 10);
			RandomListNode node = head;
			while (node != null && posi > 0) {
				node = node.next;
				posi--;
			}
			tmp.random = node;

			tmp = tmp.next;
		}

		return head;

	}

	public static RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode tmp = head;

		while (tmp != null) {
			RandomListNode newHead = new RandomListNode(tmp.label);
			newHead.next = tmp.next;
			newHead.random = null;
			tmp.next = newHead;
			tmp = newHead.next;
		}

		tmp = head;
		while (tmp != null && tmp.next != null) {
			RandomListNode tmpNext = tmp.next;
			RandomListNode random = tmp.random;
			RandomListNode next = random == null ? null : random.next;
			tmpNext.random = next;
			tmp = tmpNext.next;
		}
		return head;

	}

	private static void print(RandomListNode head) {
		RandomListNode node = head;
		while (node != null) {
			RandomListNode random = node.random;

			int value = random == null ? -1 : random.label;
			System.out.println("nodeValue: " + node.label + " splingValue: "
					+ value);
			node = node.next;
		}

	}

	private static RandomListNode[] split(RandomListNode head) {
		if (head == null) {
			return null;
		}

		RandomListNode origHead = head;
		RandomListNode newHead = head.next;

		RandomListNode origTmp = origHead;
		RandomListNode newTmp = newHead;

		while (origTmp != null && newTmp != null) {
			origTmp.next = newTmp.next;
			origTmp = origTmp.next;
			if (origTmp != null) {
				newTmp.next = origTmp.next;
				newTmp = newTmp.next;
			}
		}

		RandomListNode[] heads = new RandomListNode[2];
		heads[0] = origHead;
		heads[1] = newHead;
		return heads;

	}

}
