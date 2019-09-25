package ui;

import java.util.Scanner;

import model.*;

public class Main {
	
	private Game game;
	private Scanner reader;
	
	public Main() {
		game = new Game();
		reader = new Scanner(System.in);
	}
	public static void main(String[] args) {
		Main m = new Main();
		m.showMenu();
	}
	
	public void welcome() {
		System.out.println(" ______________________________________________________________ ");
		System.out.println("|                                                              |");
		System.out.println("|                                                              |");
		System.out.println("|                    WELCOME TO OUR SYSTEM                     |");
		System.out.println("|                                                              |");
		System.out.println("|______________________________________________________________|");
	}

	public void showOptions() {
		System.out.println("Please type the option that you wanna do: ");
		System.out.println("1. Search a object.");
		System.out.println("2. Order objects");
		System.out.println("3. Add a object");
		System.out.println("4. Delete a object");
		System.out.println("5. Salir");
	}
	
	public void showMenu() {
		welcome();
		int userInput = 0;
		while (userInput != 5){
			showOptions();
			System.out.println("________________________________________________________________");
			userInput = reader.nextInt();
			reader.nextLine();
			try {
				switch(userInput) {
				case 1:
					search();
					System.out.println("");
					break;
				case 2:
					order();
					break;
				case 3:
					addObject();
					break;
				case 4:
					deleteObject();
					break;
				}
			}catch(InvalidOption e) {
				
			}
		}
	}
	
	private void deleteObject() throws InvalidOption {
		System.out.println("Please type the option you wish: ");
		System.out.println("1. Delete clan.");
		System.out.println("2. Delete character.");
		System.out.println("3. Delete technique.");
		int option = reader.nextInt();
		reader.nextLine();
		if(option == 1) {
			System.out.println("Type the name of the clan: ");
			String name = reader.nextLine();
			if(game.deleteClans(name)) {
				System.out.println("the clan has been deleted!");
			}else {
				throw new InvalidOption();
			}
			
		} else if(option == 2) {
			System.out.println("Type the name of the character: ");
			String name = reader.nextLine();
			System.out.println("Type the name of  clan to delete the character: ");
			String nameClan = reader.nextLine();
			try {
				if(game.deletePersonages(name, nameClan)) {
					System.out.println("the character has been deleted!");
				}else {
					throw new InvalidOption();
				}
			} catch (NoList e) {
				
			}
		} else if(option == 3) {
			System.out.println("Type the name of the technique: ");
			String name = reader.nextLine();
			System.out.println("Type the name of  character to delete the technique: ");
			String nameC = reader.nextLine();
			try {
				if(game.deleteTechniques(name, nameC)) {
					System.out.println("the technique has been deleted!");
				}else {
					throw new InvalidOption();
				}
			} catch (NoList e) {
				
			}
		} else {
			throw new InvalidOption();
		}
		
	}
	private void addObject() throws InvalidOption {
		System.out.println("Please type the option you wish: ");
		System.out.println("1. Add clan.");
		System.out.println("2. Add character.");
		System.out.println("3. Add technique.");
		int option = reader.nextInt();
		reader.nextLine();
		if(option == 1) {
			System.out.println("Type the name of clan: ");
			String name = reader.nextLine();
			Clan c = new Clan(name);
			game.addClans(c);
		} else if(option == 2) {
			System.out.println("Type the name of character: ");
			String name = reader.nextLine();
			System.out.println("Type the personality: ");
			String perso = reader.nextLine();
			System.out.println("Type the power: ");
			double power = reader.nextDouble();
			reader.nextLine();
			System.out.println("Type the creation date: ");
			String date = reader.nextLine();
			System.out.println("Type the clan's name to add the character: ");
			String nameClan = reader.nextLine();
			Personage p = new Personage(name,perso,power,date);
			try {
				game.addPersonages(p, nameClan);
			} catch (SameObject e) {

			}
		} else if(option == 3) {
			System.out.println("Type the name: ");
			String name = reader.nextLine();
			System.out.println("Type the factor: ");
			double factor = reader.nextDouble();
			reader.nextLine();
			System.out.println("Type the name of character to add technique: ");
			String nameC = reader.nextLine();
			Technique t = new Technique(name,factor);
			try {
				game.addTechniques(t, nameC);
			} catch (SameObject e) {

			}
		} else {
			throw new InvalidOption();
		}
	}
	
	private void order() {
		// TODO Auto-generated method stub
		
	}
	private void search() {
		// TODO Auto-generated method stub
		
	} 
}
