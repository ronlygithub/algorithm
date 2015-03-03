package com.leetcode.datastruct;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. set(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * @author duanmh
 * 
 */
public class LRUCache {
	private int capacity;
	private Map<Integer, Node> m;
	private Node head, tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		m = new HashMap<Integer, LRUCache.Node>();
	}

	public int get(int key) {
		if (m.containsKey(key)) {
			Node node = m.get(key);
			delete(node);
			add(node);
			return node.value;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (m.containsKey(key)) {
			Node node = m.get(key);
			delete(node);
			node.value = value;
			add(node);
		} else {
			int size = m.size();
			if (size >= capacity) {
				Node tmp = head;
				head = head.next;
				delete(tmp);
			}
			add(new Node(key, value));

		}
	}

	public void delete(Node node) {
		if (node == null) {
			return;
		}

		if (!m.containsKey(node.key)) {
			return;
		}
		Node next = node.next;
		Node prev = node.prev;
		m.remove(node.key);
		if (head == node) {
			head = next;
			if (head != null) {
				head.prev = null;
			}
		} else if (tail == node) {
			tail = prev;
			if (tail != null) {
				tail.next = null;
			}
		}
		prev.next = next;
		next.prev = prev;


	}

	public void add(Node node) {
		if (node == null) {
			return;
		}
		if (head == null) {
			head = node;
		}

		if (tail == null) {
			tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = tail.next;
		}
		m.put(node.key, node);

	}

	private class Node {
		private int key;
		private int value;
		private Node prev, next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

}

