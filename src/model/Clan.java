package model;

public class Clan implements Comparable<Clan> {
	private String name;
	private Personage first;
	/**
	 * @param name
	 * @param first
	 */
	public Clan(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the first
	 */
	public Personage getFirst() {
		return first;
	}
	/**
	 * @param first the first to set
	 */
	public void setFirst(Personage first) {
		this.first = first;
	}
	
	public boolean samePersonage(Personage p) {
		boolean same = false;
		Personage actual = first;
		while(actual != null && !same) {
			if(actual.compareTo(p)==0) {
				same = true;
			}
			actual = actual.getNext();
		}
		return same;
	}
	
	public boolean samePersonageName(String name) {
		boolean same = false;
		Personage actual = first;
		while(actual != null && !same) {
			if(actual.getName().equals(name)) {
				same = true;
			}
			actual = actual.getNext();
		}
		return same;
	}
	
	public boolean addPersonage(Personage p) throws SameObject {
		boolean added = false;
		Personage actual = first;
		if(actual == null) {
			added = true;
			first = p;
		}else if(!samePersonage(p)) {
			while(actual!=null && !added) {
				if(actual.getNext()==null) {
					actual.setNext(p);
					actual.getNext().setPrev(actual);
					added = true;
				}
				actual = actual.getNext();
			}
		}else {
			throw new SameObject(); 
		}
		return added;
	}
	
	public boolean addTechniques(Technique t, String name) throws SameObject {
		boolean added = false;
		Personage actual = first;
		while(actual!=null) {
			if(actual.getName().equals(name)){
				added = actual.addTechnique(t);
			}
			actual = actual.getNext();
		}
		return added;
	}
	
	@Override
	public int compareTo(Clan c) {
		return name.compareTo(c.getName());
	}
	
	public boolean deletePersonage(String name)throws NoList {
		boolean finded = false;
		Personage actual = first;
		Personage prev = null;
		if(actual==null) {
			finded = true;
			throw new NoList();
		}else {
			while(actual!=null && !finded) {
				if(actual.getName().equals(name)) {
					if(prev!=null) {
						prev.setNext(actual.getNext());
						prev.getNext().setPrev(prev);
					}else {
						first = actual.getNext();
					}
					finded = true;
				}else {
					actual = actual.getNext();
					prev = actual.getPrev();
				}
			}
		}
		return finded;
	}
	
	public boolean deleteTechnique(String name, String nameC) throws NoList {
		boolean finded = false;
		Personage actual = first;
		while(actual!=null) {
			if(actual.getName().equals(nameC)){
				finded = actual.deleteTechnique(name);
			}
			actual = actual.getNext();
		}
		return finded;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}