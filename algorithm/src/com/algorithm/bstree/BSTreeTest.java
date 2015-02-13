package com.algorithm.bstree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BSTreeTest {
	private String[] split;
	private BSTree tree;

	@Test(dataProvider = "dp")
	public void f(Integer n, String s) {
	}

	@BeforeMethod
	public void beforeMethod() {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("D:\\test.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s;
		StringBuilder sb = new StringBuilder();
		try {
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		split = sb.toString().split(",");
		tree = new BSTree(split);
	}

	@AfterMethod
	public void afterMethod() {
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@BeforeClass
	public void beforeClass() throws IOException {

	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() throws IOException {


	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

	@Test
	public void BSTree() {
		System.out.println("succ");
	}

	@Test
	public void deleteString() {

	}



	@Test
	public void getString() {

	}

	@Test
	public void max() {
		Node max = tree.max();
		assert (max != null);
		assert (max.key.equals("X"));
	}

	@Test
	public void min() {
		Node min = tree.min();
		assert (min != null);
		assert (min.key.equals("A"));
	}

	@Test
	public void putStringint() {

	}

	@Test
	public void size() {
		beforeMethod();
		int size = tree.size();
		assert (size == split.length);
	}

	@Test
	public void deleteMax() {
		beforeMethod();
		List<Node> nodes = tree.getNodes();
		 ListIterator<Node> li = nodes.listIterator();// 获得ListIterator对象
         for (li = nodes.listIterator(); li.hasNext();) {// 将游标定位到列表结尾
             li.next();
         }
         for (; li.hasPrevious();) {// 逆序输出列表中的元素
			Node node = li.previous();
			Node max = tree.max();
			assert (max == node);
			tree.deleteMax();
		}
	}

	@Test
	public void deleteMin() {
		beforeMethod();
		List<Node> nodes = tree.getNodes();
		for (Node node : nodes) {
			Node min = tree.min();
			assert (min == node);
			tree.deleteMin();
		}

	}
}
