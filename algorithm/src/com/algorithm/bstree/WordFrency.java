package com.algorithm.bstree;

/**
 * Write a bash script to calculate the frequency of each word in a text file
 * words.txt.
 * 
 * For simplicity sake, you may assume:
 * 
 * words.txt contains only lowercase characters and space ' ' characters. Each
 * word must consist of lowercase characters only. Words are separated by one or
 * more whitespace characters. For example, assume that words.txt has the
 * following content:
 * 
 * the day is sunny the the the sunny is is Your script should output the
 * following, sorted by descending frequency: the 4 is 3 sunny 2 day 1
 * 
 * @author duanmh
 * 
 */
public class WordFrency {

	private Node root;
	private String words = "the day is sunny the the the sunny is da da ";
	public static void main(String[] args) {
		WordFrency f = new WordFrency();
		f.createDic();
	}
	
	
	public  Node createDic(){
		if (root == null) {
			root = new Node('#');
		}
		String[] split = words.split(" ");
		for (String word : split) {
			addWord(word);
		}
		for (String word : split) {
			System.out.println("word: " + word + " count: " + getWordFrency(word));
		}

		System.out.println("word: " + "sun" + " count: " + getWordFrency("sun"));

		return root;
		
	}
	
	public  boolean addWord(String word) {
		if (word == null || "".equals(word)) {
			return false;
		}		
		char[] charArray = word.toLowerCase().toCharArray();
		Node start = root;
		for (int i = 0; i < charArray.length; i++) {			
			Node current = start.getChild()[charArray[i] - 'a'];
			if (current == null) {
				current = new Node(charArray[i]);
				start.getChild()[charArray[i] - 'a'] = current;
			}
			start = current;
			if (i == charArray.length - 1) {
				start.count++;
			}
		}
		return true;
	}

	public int getWordFrency(String word) {
		if (word == null || word.length() == 0) {
			return 0;
		}

		char[] charArray = word.toLowerCase().toCharArray();
		Node start = root;
		for (int i = 0; i < charArray.length; i++) {
			Node current = start.getChild()[charArray[i] - 'a'];
			if (current == null) {
				return 0;
			}
			if (i == charArray.length - 1) {
				return current.count;
			}
			start = current;
		}

		return 0;
	}

	@SuppressWarnings("unused")
	private class Node {
		private Node[] child = new Node[26];
		private int count = 0;
		private char alpa;

		public Node(char alpa) {
			this.alpa = alpa;

		}

		public Node[] getChild() {
			return child;
		}

		public void setChild(Node[] child) {
			this.child = child;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public char getAlpa() {
			return alpa;
		}

		public void setAlpa(char alpa) {
			this.alpa = alpa;
		}

	}

}

