package com.duanmh.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StdOut {
	public static void main(String[] args) throws IOException {
		int[] a = { 1, 2, 3, 1 };
		writeFile("g:/add.txt", a);
		System.out.println(readFile("g:/add.txt"));

	}

	public static int[] readFile(String filePathAndName) {
		String fileContent = "";
		try {
			File f = new File(filePathAndName);
			if (f.isFile() && f.exists()) {
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(f), "UTF-8");
				BufferedReader reader = new BufferedReader(read);
				String line;
				while ((line = reader.readLine()) != null) {
					fileContent += line;
				}
				
				String[] values = fileContent.split(",");
				int[] realValues = new int[values.length];
				for (int i = 0; i < realValues.length; i++) {
					realValues[i] = Integer.parseInt(values[i]);
				}
				read.close();
				return realValues;
			}
		} catch (Exception e) {
			System.out.println("读取文件内容操作出错");
			e.printStackTrace();
		}
		return null;
	}

	public static void writeFile(String filePathAndName, int[] fileContent) {
		System.out.println("写入文件：" + filePathAndName);

		try {
			File f = new File(filePathAndName);
			if (!f.exists()) {
				f.createNewFile();
			}
			OutputStreamWriter write = new OutputStreamWriter(
					new FileOutputStream(f), "GBK");
			for (int i = 0; i < fileContent.length; i++) {
				String value = String.valueOf(fileContent[i]);
				if (i != fileContent.length-1) {					
					value += ",";
				}
				write.write(value);
			}

			write.close();

		} catch (Exception e) {
			System.out.println("写文件内容操作出错");
			e.printStackTrace();
		}
		System.out.println("写入完成");

	}

}
