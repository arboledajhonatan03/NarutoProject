package model;

public class SameObject extends Exception {

	public SameObject() {
		super();
		System.out.println("This object already exists!");
	}
}
