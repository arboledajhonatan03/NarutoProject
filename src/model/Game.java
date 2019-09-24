package model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Game {
	public final static String ARCHIVE = "Data.txt";
	
	private ArrayList<Clan> clans;

	public Game() {
		clans = new ArrayList<>();
		try {
			loadData();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Clan> getClans() {
		return clans;
	}

	public void setClans(ArrayList<Clan> clans) {
		this.clans = clans;
	}
	
	public void loadData() throws IOException, ClassNotFoundException {
		try {
			File file = new File(ARCHIVE);
			ObjectInputStream obj = new ObjectInputStream(new FileInputStream(file));
			try {
				Clan c = (Clan)obj.readObject();
				while(c != null) {
					clans.add(c);
					c = (Clan)obj.readObject();
					
				}
				obj.close();
			}catch(IOException e) {
				
			}
		}catch(EOFException e) {
			
		}
	}
	
	public void edit() throws IOException {
		new File(ARCHIVE).delete();
		new File(ARCHIVE).createNewFile();
		File file = new File(ARCHIVE);
		ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(file));
		for (int i = 0; i < clans.size(); i++) {
			obj.writeObject(clans.get(i));
		}
		obj.close();
	}
	
	public boolean addTechniques(Technique t, String name) throws SameObject {
		boolean added = false;
		for (int i = 0; i < clans.size(); i++) {
			if(clans.get(i).samePersonageName(name)){
				added = clans.get(i).addTechniques(t, name);
			}
		}
		return added;
	}
	
	public boolean deleteTechniques(String name, String nameC) throws NoList {
		boolean deleted = false;
		for (int i = 0; i < clans.size(); i++) {
			if(clans.get(i).samePersonageName(nameC)){
				deleted = clans.get(i).deleteTechnique(name, nameC);
			}
		}
		return deleted;
	}
	
	public boolean addPersonages(Personage p, String nameClan) throws SameObject {
		boolean added = false;
		for (int i = 0; i < clans.size(); i++) {
			if(clans.get(i).getName().equals(nameClan)){
				added = clans.get(i).addPersonage(p);
			}
		}
		return added;
	}
	
	public boolean deletePersonages(String name, String nameClan) throws NoList  {
		boolean added = false;
		for (int i = 0; i < clans.size(); i++) {
			if(clans.get(i).getName().equals(nameClan)){
				added = clans.get(i).deletePersonage(name);
			}
		}
		return added;
	}
	
	public boolean addClans(Clan c) {
		boolean added = false;
		for (int i = 0; i < clans.size(); i++) {
			if(!sameClan(c)) {
				clans.add(c);
				added = true;
			}
		}
		return added;
	}
	
	public boolean deleteClans(String name) {
		boolean deleted = false;
		for (int i = 0; i < clans.size() && !deleted; i++) {
			if(clans.get(i).getName().equals(name)) {
				clans.remove(i);
				deleted = true;
			}
		}
		return deleted;
	}
	
	public boolean sameClan(Clan c) {
		boolean same = false;
		for (int i = 0; i < clans.size() && !same; i++) {
			if(clans.get(i).compareTo(c)==0) {
				same = true;
			}
		}
		return same;
	}
	
}