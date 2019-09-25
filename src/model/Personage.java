package model;

import java.awt.image.SampleModel;

public class Personage implements Comparable<Personage>{
	private String name;
	private String personality;
	private double power;
	private String creationDate;
	private double score;
	private Personage next;
	private Personage prev;
	private Technique first;
	public Personage(String name, String personality, double power, String creationDate) {
		this.name = name;
		this.personality = personality;
		this.power = power;
		this.creationDate = creationDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonality() {
		return personality;
	}
	public void setPersonality(String personality) {
		this.personality = personality;
	}
	public double getPower() {
		return power;
	}
	public void setPower(double power) {
		this.power = power;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public Personage getNext() {
		return next;
	}
	public void setNext(Personage next) {
		this.next = next;
	}
	public Personage getPrev() {
		return prev;
	}
	public void setPrev(Personage prev) {
		this.prev = prev;
	}
	public Technique getFirst() {
		return first;
	}
	public void setFirst(Technique first) {
		this.first = first;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	@Override
	public int compareTo(Personage p) {
		return name.compareTo(p.getName());
	}
	
	public boolean addTechnique(Technique t) throws SameObject{
		Technique actual = first;	
		boolean added = false;
		if(actual==null) {
			first = t;
			added = true;
		}else if(!sameTechnique(t)) {
			while(actual!=null && !added) {
				if(actual.getNext()==null) {
					actual.setNext(t);
					added = true;
				}
				actual = actual.getNext();
			}
		
		} else {
			throw new SameObject(); 
		}
		return added;
	}
	
	public boolean sameTechnique(Technique t) {
		boolean same = false;
		Technique actual = first;
		while(actual != null && !same) {
			if(actual.compareTo(t)==0) {
				same = true;
			}
			actual = actual.getNext();
		}
		return same;
	}
	
	public boolean sameTechniqueName(String name) {
		boolean same = false;
		Technique actual = first;
		while(actual != null && !same) {
			if(actual.getName().equals(name)) {
				same = true;
			}
			actual = actual.getNext();
		}
		return same;
	}
	
	public boolean deleteTechnique(String name) throws NoList {
		boolean finded = false;
		Technique actual = first;
		if(actual.getName().equals(name)) {
			first = actual.getNext();
			finded = true;
		}else {
			while(actual!=null && !finded) {
				if(actual.getNext().getName().equals(name)) {
					actual.setNext(actual.getNext().getNext());
					finded = true;
				}else {
					actual = actual.getNext();
				}
			}
		}
		return finded;
	}
	@Override
	public String toString() {
		return name + "," + personality + "," + power + ","
				+ creationDate + "," + score + "," + next + "," + prev + "," + first;
	}
}