package com.duanmh.stack;

import java.util.Stack;

/**
 * 检查输入括号的合法性
 * 
 * @author duanmh
 * 
 */
public class ValidParentheses {

	public static void main(String[] args) {
		String s = "[";
		System.out.println(isValidA(s));
		System.out.println(isValidB(s));
	}

	public static boolean isValidA(String s) {
		if (s == null || "".equals(s)) {
			return false;
		}

		char[] values = s.toCharArray();
		int length = values.length;
		Stack<Character> in = new Stack<Character>();
		for (int i = 0; i < length; i++) {
			in.push(values[i]);
		}

		Stack<Character> out = new Stack<Character>();
		while (true) {
			if (in.isEmpty() && out.isEmpty()) {
				return true;
			}

			if (out.isEmpty()) {
				Character pop = in.pop();
				out.push(pop);
			}

			if (in.isEmpty()) {
				break;
			}

			if (isPop(in.peek(), out.peek())) {
				in.pop();
				out.pop();
			} else {
				if (!isValidate(in.peek(), out.peek())) {
					break;
				} else {
					Character pop = in.pop();
					out.push(pop);
				}

			}


		}
		return false;
	}

	private static boolean isValidate(Character in, Character out) {
		String invalue = in.toString();
		String outValue = out.toString();
		String left = "{[(";
		String right = "]})";
		if (left.contains(invalue) && left.contains(outValue)) {
			return true;
		}
		if (right.contains(invalue) && right.contains(outValue)) {
			return true;
		}
		return false;

	}

	private static boolean isPop(Character in, Character out) {
		String invalue = in.toString();
		String outValue = out.toString();
		if (invalue.equals("(") && outValue.equals(")")) {
			return true;
		} else if (invalue.equals("[") && outValue.equals("]")) {
			return true;
		} else if (invalue.equals("{") && outValue.equals("}")) {
				return true;
		}
		return false;
	}

	public static boolean isValidB(String s) {
		if (s == null || "".equals(s)) {
			return false;
		}

		char[] values = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < values.length; i++) {
			char tmp = values[i];
			switch (tmp) {
			case '(':
				stack.push(tmp);
				break;
			case '[':
				stack.push(tmp);
				break;
			case '{':
				stack.push(tmp);
				break;
			case ')':
				if (!check(stack, "(")) {
					return false;
				}
				break;
			case '}':
				if (!check(stack, "{")) {
					return false;
				}
				break;
			case ']':
				if (!check(stack, "[")) {
					return false;
				}
				break;
			default:
				break;
			}
		}
		return stack.isEmpty();

	}

	private static boolean check(Stack<Character> stack, String tmp) {
		Character pop = stack.pop();
		String value = pop.toString();
		if (!value.equals(tmp)) {
			return false;
		}
		return true;
	}
}

