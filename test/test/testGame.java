package test;

import static org.junit.jupiter.api.Assertions.*;
import model.*;
import org.junit.jupiter.api.Test;

class testGame {
	private Game g;
	private void setupEscenary1() {
		g = new Game();
	}
	@Test
	void testAddClan() {
		setupEscenary1();
		Clan c = new Clan("Uchiha");
		Clan c1 = new Clan("Uzumaki");
		g.getClans().add(c1);
		assertTrue(g.addClans(c));
	}
	
	@Test
	void testSameClan() {
		setupEscenary1();
		Clan c = new Clan("Uchiha");
		g.getClans().add(c);
		assertTrue(g.sameClan(c));
	}
	
	@Test
	void testAddPersonage() {
		setupEscenary1();
		Clan c = new Clan("Uchiha");
		g.getClans().add(c);
		Personage p = new Personage("Rigo","bobo",451.0,"08/09/2019");
		try {
			assertTrue(g.addPersonages(p, "Uchiha"));
		} catch (SameObject e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testAddTechnique() {
		setupEscenary1();
		Clan c = new Clan("Uchiha");
		g.getClans().add(c);
		Personage p = new Personage("Rigo","bobo",451.0,"08/09/2019");
		Technique t1 = new Technique("Triple",5.6);
		try {
			g.addPersonages(p, "Uchiha");
			assertTrue(g.addTechniques(t1, "Rigo"));
		} catch (SameObject e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	void testDeleteClan() {
		setupEscenary1();
		Clan c = new Clan("Uchiha");
		g.getClans().add(c);
		assertTrue(g.deleteClans("Uchiha"));
	}
	
	@Test
	void testDeletePersonage() {
		setupEscenary1();
		Clan c = new Clan("Uchiha");
		g.getClans().add(c);
		Personage p = new Personage("Rigo","bobo",451.0,"08/09/2019");
		try {
			g.addPersonages(p, "Uchiha");
		} catch (SameObject e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertTrue(g.deletePersonages("Rigo", "Uchiha"));
		} catch (NoList e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testDeleteTechniques() {
		setupEscenary1();
		Clan c = new Clan("Uchiha");
		g.getClans().add(c);
		Personage p = new Personage("Rigo","bobo",451.0,"08/09/2019");
		Technique t1 = new Technique("Triple",5.6);
		try {
			g.addPersonages(p, "Uchiha");
			g.addTechniques(t1, "Rigo");
		} catch (SameObject e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertTrue(g.deleteTechniques("Triple", "Rigo"));
		} catch (NoList e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
