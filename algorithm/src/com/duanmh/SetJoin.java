package com.duanmh;

public class SetJoin {


	public static void main(String[] args) {

		Element[] ea = { new Element(1, 2), new Element(4, 6), new Element(9, 12) };
		Element[] eb = { new Element(0, 2), new Element(1, 5), new Element(7, 10) };
		join(ea, eb);
	}

	private static void join(Element[] ea, Element[] eb) {
		if (ea == null || ea.length == 0) {
			return;
		}

		if (eb == null || eb.length == 0) {
			return;
		}

		for (Element elementa : ea) {
			for (Element elementb : eb) {
				if (elementb.start >= elementa.end) {
					continue;
				}
				int low = elementa.start > elementb.start ? elementa.start : elementb.start;
				int high = elementa.end < elementb.end ? elementa.end : elementb.end;
				if (low < high) {
					System.out.println("[" + low + "," + high + "]");
				}
			}
		}
	}

}

class Element {
	int start;
	int end;

	public Element(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

