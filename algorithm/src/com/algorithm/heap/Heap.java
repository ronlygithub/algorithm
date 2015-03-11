package com.algorithm.heap;

/**
 * 堆
 * 
 * @author duanmh
 * 
 */
public class Heap {
	public Heap(int[] values) {

	}

	public static void main(String[] args) {
		int[] values = new int[1000000];
		for (int i = 0; i < values.length; i++) {
			values[i] = (int) (Math.random() * 1000000);
		}
		long start = System.currentTimeMillis();
		heapSort(values);
		long end = System.currentTimeMillis();
		System.out.println("time " + (end - start));

	}

	public static int[] buildHeap(int[] values) {
		if (values == null || values.length == 0) {
			return values;
		}
		for (int i = values.length / 2 - 1; i >= 0; i--) {
			adjuestHeap(values, i, values.length);
		}
		return values;
	}

	/**
	 * 从最后一个非叶子节点开始调整，构建堆
	 * 
	 * @param values
	 * @param posi
	 * @param size
	 */
	public static void adjuestHeap(int[] values, int posi, int size) {
		if (values == null || values.length == 0) {
			return;
		}

		int left = (posi << 1) + 1;
		int right = (posi << 1) + 2;
		if (left >= size) {
			return;
		}
		int smallest = left;
		if (right < size) {
			smallest = values[left] > values[right] ? left : right;
		}

		if (values[posi] < values[smallest]) {
			int tmp = values[posi];
			values[posi] = values[smallest];
			values[smallest] = tmp;
			adjuestHeap(values, smallest, size);
		}
	}

	/**
	 * 时间复杂度最坏 O(lgN),平均O(lgN),最好O(lgN)。 
	 * 空间复杂度O(n) 
	 * @param values
	 */
	public static void heapSort(int values[]) {
		if (values == null || values.length == 0) {
			return;
		}
		buildHeap(values);
		for (int i = values.length - 1; i >= 0; i--) {
			System.out.println(values[0]);
			values[0] = values[i];
			adjuestHeap(values, 0, i);
		}


	}



}

