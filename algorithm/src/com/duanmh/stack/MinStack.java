/************************* ��Ȩ���� *********************************
 * 
 * ��Ȩ���У�XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* �����¼ *********************************
 *
 * �����ߣ�XXXXXXXXXX   �������ڣ� 2014��11��20��
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

package com.duanmh.stack;

import java.util.Stack;

/**
 * @author duanmh
 * @param <E>
 * @param <E>
 * @param <T>
 * 
 */
public class MinStack {
	private Stack<Integer> m_data = new Stack<Integer>();
	private Stack<Integer> m_min = new Stack<Integer>();

	public boolean push(Integer value) {

		m_data.push(value);
		if (m_min.isEmpty() || m_min.peek() >= value) {
			m_min.push(value);
		}

		return true;

	}

	public Integer pop() {
		if (m_data.peek().equals(m_min.peek())) {
			m_min.pop();
		}
		Integer pop = m_data.pop();

		return pop;
	}

	public Integer getMin() {
		if (!m_min.isEmpty()) {
			return m_min.peek();
		}
		return null;
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		init(stack);
		System.out.println("\n" + stack.getMin());

		int tmp = 10;
		while (tmp-- > 0) {
			Integer pop = stack.pop();
			System.out.println("pop: " + pop + " min: " + stack.getMin() + " ");
		}

		// int[] push = { 1, 2, 3, 4, 5 };
		// int[] pop = { 4, 3, 1, 2, 5 };
		// System.out.println("\n" + isPosibleOrder(push, pop));
	}

	/**
	 * @param stack
	 */
	private static void init(MinStack stack) {
		for (int i = 0; i < 10; i++) {
			int value = (int) (Math.random() * 100);
			stack.push(value);
			System.out.print(value + " ");
		}
	}

	public static boolean isPosibleOrder(int[] push, int[] pop) {
		if (push == null || pop == null) {
			return false;
		}

		if (push.length != pop.length) {
			return false;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int popIndex = 0;
		int pushIndex = 0;
		while (popIndex < pop.length) {

			while (stack.empty() || stack.peek() != pop[popIndex]) {
				if (pushIndex == push.length) {
					break;
				}

				stack.push(push[pushIndex]);

				pushIndex++;

			}

			if (stack.peek() != pop[popIndex]) {
				break;
			}

			stack.pop();

			popIndex++;

		}

		if (stack.empty() && popIndex == pop.length) {
			return true;
		}

		return false;

	}

}
