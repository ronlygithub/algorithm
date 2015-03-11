/************************* ��Ȩ���� *********************************
 * 
 * ��Ȩ���У�XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* �����¼ *********************************
 *
 * �����ߣ�XXXXXXXXXX   �������ڣ� 2014��11��19��
 * ������¼��������ṹ��
 * 
 * �޸��ߣ�       �޸����ڣ�
 * �޸ļ�¼��
 *
 * �޸��ߣ�       �޸����ڣ�
 * �޸ļ�¼��
 * ����
 ************************* To  Do *********************************
 *
 * 1��ʵ������δʵ�ֵķ������׳�UnsupportedOperationException�ķ�������
 * 
 ************************* ��   �� *********************************
 *
 * �������дд���룬�п�������ʲô�ġ�
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
		ListNode listA = createList();
		show(listA);
		// ListNode insertSort = insertSort(listA);
		ListNode deleteDuplicates = deleteDuplicates(listA);
		show(deleteDuplicates);

	}

	public static void show(ListNode head) {

		ListNode tmp = head;
		while (tmp != null) {
			System.out.print(tmp.value + " ");
			tmp = tmp.next;
		}
		System.out.println("\n");
	}

	public static ListNode getLastKth(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		System.out.println("\n ������kֵ: ");
		Scanner s = new Scanner(System.in);
		k = s.nextInt();
		if (k < 1) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
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

	public static void reversePrint(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode tmp = head;
		if (tmp.next != null) {
			reversePrint(tmp.next);
		}
		System.out.print(tmp.value + " ");

	}

	public static ListNode createList() {
		ListNode head = null;
		ListNode tmp = null;
		int length = 2;
		while (length-- > 0) {
			if (head == null) {
				head = new ListNode((int) (Math.random() * 5));
				head.value = 1;
				tmp = head;
				continue;
			}

			ListNode newNode = new ListNode((int) (Math.random() * 5));
			newNode.value = 1;

			tmp.next = newNode;
			tmp = tmp.next;

		}
		return head;

	}

	public static ListNode mergeList(ListNode listA, ListNode listB) {
		if (listA == null) {
			return listB;
		}

		if (listB == null) {
			return listA;
		}

		if (listA == listB) {
			return listA;
		}

		ListNode newHead = null;
		ListNode posi = null;
		ListNode tmp;
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

	public static ListNode merge(ListNode listA, ListNode listB) {
		if (listA == null) {
			return listB;
		}

		if (listB == null) {
			return listA;
		}

		if (listA == listB) {
			return listA;
		}
		ListNode newHead = null;
		if (listA.value < listB.value) {
			newHead = listA;
			newHead.next = merge(newHead.next, listB);
		} else {
			newHead = listB;
			newHead.next = merge(listA, newHead.next);
		}

		return newHead;

	}

	public static ListNode insertSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = null;

		ListNode current = head;
		while (current != null) {
			if (newHead == null) {
				newHead = current;
				current = current.next;
				newHead.next = null;
			} else {
				ListNode tmp = current;
				current = current.next;
				if (tmp.value < newHead.value) {
					tmp.next = newHead;
					newHead = tmp;
				} else {
					ListNode position = null;
					for (ListNode newTmp = newHead; newTmp != null;) {
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

	public static ListNode insertSortR(ListNode head) {
		if (head == null) {
			return head;
		}
		insertSortR(head.next);
		return head;

	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null) {
			if (fast.value == slow.value) {
				fast = fast.next;
				if (fast == null) {
					slow.next = fast;
					slow = fast;
				}
				continue;
			}
			slow.next = fast;
			slow = fast;
		}
		return head;

	}
}
