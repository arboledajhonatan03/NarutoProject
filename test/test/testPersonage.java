package test;
import model.NoList;
import model.Personage;
import model.SameObject;
import model.Technique;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testPersonage {
	private Personage p;
	private void setupEscenary1() {
		p = new Personage("Tatan","Malgeninado",2114.0,"14/01/2002");
	}
	@Test
	void testAdd() {
		setupEscenary1();
		Technique t1 = new Technique("Triple",5.6);
		try {
			assertTrue(p.addTechnique(t1));
		} catch (SameObject e) {

		}
	}
	@Test
	void testSameTechnique() {
		setupEscenary1();
		Technique t1 = new Technique("Triple",5.6);
		Technique t2 = new Technique("Triple",5.6);
		try {
			p.addTechnique(t1);
		} catch (SameObject e) {
			
		}
		assertTrue(p.sameTechnique(t2));
	}

	@Test
	void testSameTechniqueName() {
		setupEscenary1();
		Technique t1 = new Technique("Triple",5.6);
		Technique t2 = new Technique("Triple",5.6);
		try {
			p.addTechnique(t1);
		} catch (SameObject e) {
			
		}
		assertTrue(p.sameTechniqueName(t2.getName()));
	}
	
	@Test
	void testDeleteTechnique() {
		setupEscenary1();
		Technique t1 = new Technique("Triple",5.6);
		Technique t2 = new Technique("BlindPass",8.0);
		try {
			p.addTechnique(t1);
			p.addTechnique(t2);
		} catch (SameObject e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertTrue(p.deleteTechnique("BlindPass"));
			assertTrue(p.deleteTechnique("Triple"));
		} catch (NoList e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
