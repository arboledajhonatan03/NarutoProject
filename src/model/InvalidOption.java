package model;

public class InvalidOption extends Exception {
	
	public InvalidOption() {
		super();
		System.out.println("This option is not valid! Please type correctly.");
	}
}
