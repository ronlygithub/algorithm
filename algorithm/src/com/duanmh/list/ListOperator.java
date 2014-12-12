/************************* 版权声明 *********************************
 * 
 * 版权所有：XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* 变更记录 *********************************
 *
 * 创建者：XXXXXXXXXX   创建日期： 2014年11月19日
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

import java.util.Scanner;

/**
 * @author duanmh
 * 
 */
public class ListOperator {
	public static void main(String[] args) {
		List listA = createList();
		show(listA);
		List insertSort = insertSort(listA);
		show(insertSort);

	}

	public static void show(List head) {

		List tmp = head;
		while (tmp != null) {
			System.out.print(tmp.value + " ");
			tmp = tmp.next;
		}
		System.out.println("\n");
	}

	public static List getLastKth(List head, int k) {
		if (head == null) {
			return null;
		}
		System.out.println("\n 请输入k值: ");
		Scanner s = new Scanner(System.in);
		k = s.nextInt();
		if (k < 1) {
			return null;
		}
		List fast = head;
		List slow = head;
		int count = 0;
		while (count++ < k - 1) {
			if (fast.next != null) {
				fast = fast.next;
			} else {
				return null;
			}
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;

		}
		System.out.print(slow.value + " ");
		return slow;

	}

	public static void reversePrint(List head) {
		if (head == null) {
			return;
		}
		List tmp = head;
		if (tmp.next != null) {
			reversePrint(tmp.next);
		}
		System.out.print(tmp.value + " ");

	}

	private static List createList() {
		List head = new List();
		head.next = null;
		head.value = -1;
		List tmp = head;
		int length = 10;
		while (length-- > 0) {
			List newNode = new List();
			newNode.value = (int) (Math.random() * 20);
			tmp.next = newNode;
			tmp = tmp.next;

		}
		return head;

	}

	public static List mergeList(List listA, List listB) {
		if (listA == null) {
			return listB;
		}

		if (listB == null) {
			return listA;
		}

		if (listA == listB) {
			return listA;
		}

		List newHead = null;
		List posi = null;
		List tmp;
		while (listA != null && listB != null) {
			if (listA.value <= listB.value) {
				tmp = listA;
				listA = listA.next;
			} else {
				tmp = listB;
				listB = listB.next;
			}

			if (newHead == null) {
				newHead = tmp;
				posi = newHead;
			} else {
				posi.next = tmp;
				posi = posi.next;
			}

		}

		if (listA == null) {
			posi.next = listB;
		}

		if (listB == null) {
			posi.next = listA;
		}

		return newHead;

	}

	public static List merge(List listA, List listB) {
		if (listA == null) {
			return listB;
		}

		if (listB == null) {
			return listA;
		}

		if (listA == listB) {
			return listA;
		}
		List newHead = null;
		if (listA.value < listB.value) {
			newHead = listA;
			newHead.next = merge(newHead.next, listB);
		} else {
			newHead = listB;
			newHead.next = merge(listA, newHead.next);
		}

		return newHead;

	}

	public static List insertSort(List head) {
		if (head == null || head.next == null) {
			return head;
		}

		List newHead = null;

		List current = head;
		while (current != null) {
			if (newHead == null) {
				newHead = current;
				current = current.next;
				newHead.next = null;
			} else {
				List tmp = current;
				current = current.next;
				if (tmp.value < newHead.value) {
					tmp.next = newHead;
					newHead = tmp;
				} else {
					List position = null;
					for (List newTmp = newHead; newTmp != null;) {
						if (newTmp.value < tmp.value) {
							position = newTmp;
							newTmp = newTmp.next;
						} else {
							break;
						}
					}

					if (position != null) {
						tmp.next = position.next;
						position.next = tmp;
					}

				}

			}

		}
		return newHead;
	}

	public static List insertSortR(List head) {
		if (head == null) {
			return head;
		}
		insertSortR(head.next);
		return head;

	}
}
