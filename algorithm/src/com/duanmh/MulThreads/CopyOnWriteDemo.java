package com.duanmh.MulThreads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteDemo {

	public static void main(String args[]) {
		String[] ss = { "aa", "bb", "cc" };
		List<String> list1 = new CopyOnWriteArrayList<String>(Arrays.asList(ss));
		List<String> list2 = new ArrayList<String>(Arrays.asList(ss));
		Iterator<String> itor1 = list1.iterator();
		Iterator<String> itor2 = list2.iterator();
		list1.add("New");
		list2.add("New");
		try {
			printAll(itor1);
			list1.add("ee");
			printAll(itor1);
		} catch (ConcurrentModificationException e) {
			System.err.println("Shouldn't get ConcurrentModificationException");
		}
		try {

			printAll(itor2);

		} catch (ConcurrentModificationException e) {
			System.err.println("Will get ConcurrentModificationException");

		}
	}

	/**
	 * @param itor
	 */
	private static void printAll(Iterator<String> itor) {
		while (itor.hasNext()) {
			System.out.println(itor.next());
		}
	}
}
