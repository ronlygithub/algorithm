package com.algorithm.bstree;

/**
 * �������������
 * 
 * @author duanmh
 * 
 */
public class Node {
	/**
	 * ��ֵ
	 */
	public String key;
	/**
	 * ֵ
	 */
	public int value;
	/**
	 * ������������������ǰ���Ľ����Ŀ��
	 */
	public int size;
	/**
	 * ���ӽ��
	 */
	public Node left;
	/**
	 * ���ӽ��
	 */
	public Node right;

	public Node(String key, int value, int size) {
		this.key = key;
		this.value = value;
		this.size = size;
	}

}
