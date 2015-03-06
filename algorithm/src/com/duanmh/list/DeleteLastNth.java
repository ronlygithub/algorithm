package com.duanmh.list;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one pass.
 * 
 * @author duanmh
 * 
 */
public class DeleteLastNth {

	public static void main(String[] args) {
		ListNode head = ListOperator.createList();
		ListOperator.show(head);
		head = removeNthFromEnd(head, 1);
		ListOperator.show(head);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
		int count = 0;
		while (count < n) {
			if (fast != null) {
				fast = fast.next;
			}
			count++;
		}

		if (fast == null) {
			return head.next;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}


			ListNode d = slow.next;
			slow.next = d.next;


		return head;

	}
}
