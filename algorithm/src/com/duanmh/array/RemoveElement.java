package com.duanmh.array;

public class RemoveElement {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 5 };
		removeElement(a, 4);
	}

	public static int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int slow = 0;
		int fast = 0;
		int length = A.length;
		int result = 0;

		for (fast = slow; fast < length; fast++) {
			if (A[fast] != elem) {
				continue;
			}

			while (slow <= fast) {
				if (A[slow] == elem) {
					break;
				}
				slow++;
			}
			while (fast < length) {
				if (A[fast] != elem) {
					break;
				}
				fast++;
			}


			if (fast < length) {
				A[slow] = A[fast];
				result = slow + 1;
			}

		}
		return result;

	}
}
