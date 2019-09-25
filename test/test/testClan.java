package test;

import static org.junit.jupiter.api.Assertions.*;
import model.*;
import org.junit.jupiter.api.Test;

class testClan {
	private Clan c;
	private void setupEscenary1() {
		c = new Clan("Uchiha");
	}
	@Test
	void testSamePersonage() {
		setupEscenary1();
		Personage p2 = new Personage("Rigo","bobo",451.0,"08/09/2019");
		Personage p3 = new Personage("Rigo","bobo",451.0,"08/09/2019");
		try {
			c.addPersonage(p2);
		} catch (SameObject e) {

		}
		assertTrue(c.samePersonage(p3));
	}
	
	@Test
	void testSamePersonageName() {
		setupEscenary1();
		Personage p2 = new Personage("Rigo","bobo",451.0,"08/09/2019");
		Personage p3 = new Personage("Rigo","bobo",451.0,"08/09/2019");
		try {
			c.addPersonage(p2);
		} catch (SameObject e) {
			
		}
		assertTrue(c.samePersonageName(p3.getName()));
	}
	
	@Test
	void testAddPersonage() {
		setupEscenary1();
		Personage p2 = new Personage("Rigo","bobo",451.0,"08/09/2019");
		Personage p3 = new Personage("Rigo","bobo",451.0,"08/09/2019");
		try {
			assertTrue(c.addPersonage(p2));
		} catch (SameObject e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test 
	void testAddTechnique() {
		setupEscenary1();
		Technique t1 = new Technique("Triple",5.6);
		Personage p2 = new Personage("Rigo","bobo",451.0,"08/09/2019");
		try {
			c.addPersonage(p2);
			assertTrue(c.addTechniques(t1, "Rigo"));
		} catch (SameObject e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test 
	void testDeletePersonage() {
		setupEscenary1();
		Technique t1 = new Technique("Triple",5.6);
		Personage p2 = new Personage("Rigo","bobo",451.0,"08/09/2019");
		try {
			c.addPersonage(p2);
//			c.addTechniques(t1, "Rigo");
			c.deletePersonage("Rigo");
		} catch (SameObject e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoList e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test 
	void testDeleteTechnique() {
		setupEscenary1();
		Technique t1 = new Technique("Triple",5.6);
		Technique t2 = new Technique("BlindPass",8.0);
		Personage p2 = new Personage("Rigo","bobo",451.0,"08/09/2019");
		try {
			c.addPersonage(p2);
			c.addTechniques(t1, "Rigo");
			c.addTechniques(t2, "Rigo");
			assertTrue(c.deleteTechnique("Triple","Rigo"));
		} catch (SameObject e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoList e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
