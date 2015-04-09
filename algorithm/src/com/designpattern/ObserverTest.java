package com.designpattern;

import java.util.Observable;
import java.util.Observer;

public class ObserverTest extends Observable {

	public static void main(String[] args) {
		ObserverTest t = new ObserverTest();
		ObserverT o = new ObserverT();
		ObserverE e = new ObserverE();
		t.addObserver(o);
		t.addObserver(e);
		t.addObserver(o);
		t.setChanged();
		t.notifyObservers("T");


	}
}

class ObserverT implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(arg);

	}

}

class ObserverE implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("E");
	}

}

