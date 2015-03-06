package com.duanmh.array;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
 * 
 * @author duanmh
 * 
 */
public class RemoveDuplicate {

	public static void main(String[] args) {
		RemoveDuplicate instance = new RemoveDuplicate();
		int A[] = { 1, 2, 2 };
		instance.removeDuplicates(A);
	}
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[i - 1]) {
				count++;
			} else {
				A[i - count] = A[i];
			}
		}
		return A.length - count;

	}
	// public int removeDuplicates(int[] A) {
	// if (A == null || A.length == 0) {
	// return 0;
	// }
	//
	// int start = 0;
	// int end = 0;
	// while (end < A.length) {
	// if (A[start] == A[end]) {
	// end++;
	// continue;
	// }
	// if (end - start == 1) {
	// start++;
	//
	// continue;
	// }
	//
	// A[++start] = A[end++];
	//
	// }
	// return start + 1;
	//
	// }
}

