package model;

public class Technique implements Comparable<Technique> {
	private String name;
	private double factor;
	private Technique next;
	public Technique(String name, double factor) {
		this.name = name;
		this.factor = factor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFactor() {
		return factor;
	}
	public void setFactor(double factor) {
		this.factor = factor;
	}
	public Technique getNext() {
		return next;
	}
	public void setNext(Technique next) {
		this.next = next;
	}
	
	@Override
	public int compareTo(Technique t) {
		return name.compareTo(t.getName());
	}
	@Override
	public String toString() {
		return name + "," + factor;
	}
	
}
