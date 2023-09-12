package domen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MestoTest {
	
	Mesto mesto;

	@BeforeEach
	void setUp() throws Exception {
		mesto = new Mesto();
	}

	@AfterEach
	void tearDown() throws Exception {
		mesto = null;
	}

	@Test
	public void testKonstruktor() {
		mesto = new Mesto(77l, "Priboj", "31330");

		assertEquals(77l, mesto.getMestoID());
		assertEquals("Priboj", mesto.getNaziv());
		assertEquals("31330", mesto.getPostanskiBroj());
	}
	
	@Test
	public void testMestoID() {
		mesto.setMestoID(77l);

		assertEquals(77l, mesto.getMestoID());
	}

	@Test
	public void testNazivIspravan() {
		mesto.setNaziv("Priboj");

		assertEquals("Priboj", mesto.getNaziv());
	}
	
	@Test
	public void testNazivNull() {
		assertThrows(java.lang.NullPointerException.class, () -> mesto.setNaziv(null));
	}
	
	@Test
	public void testPostanskiBrojIspravan() {
		mesto.setPostanskiBroj("31330");

		assertEquals("31330", mesto.getPostanskiBroj());
	}
	
	@Test
	public void testPostanskiBrojNijeIspravan() {
		assertThrows(java.lang.IllegalArgumentException.class, () ->  mesto.setPostanskiBroj("11"));
		assertThrows(java.lang.IllegalArgumentException.class, () -> mesto.setPostanskiBroj(""));
	}
	
	@Test
	public void testPostanskiBrojNUll() {
		assertThrows(java.lang.NullPointerException.class, () -> mesto.setPostanskiBroj(null));
	}
	
	@Test
	public void testToString() {
		mesto = new Mesto(77l, "Priboj", "31330");
		
		String s = mesto.toString();

		assertTrue(s.contains("Priboj"));
	}
	
	@Test
	public void testNazivTabele() {
		String s = mesto.nazivTabele();
		
		assertTrue(s.toLowerCase().contains("mesto"));
	}
	
	@Test
	public void testAlijas() {
		String s = mesto.alijas();
		
		assertTrue(s.toLowerCase().contains("m"));
	}
	
	@Test
	public void testJoin() {
		assertEquals("", mesto.join());
	}
	
	@Test
	public void testKoloneZaInsert() {
		assertEquals(" (NazivMesta, PostanskiBroj) ", mesto.koloneZaInsert());
	}
	
	@Test
	public void testPrimarniKljuc() {
		mesto.setMestoID(77);

		String s = mesto.vrednostZaPrimarniKljuc();
		
		assertTrue(s.contains("77"));
	}

	@Test
	public void testVrednostiZaInsert() {
		mesto = new Mesto(77l, "Priboj", "31330");

		String s = mesto.vrednostiZaInsert();
		
		assertTrue(s.contains("Priboj"));
		assertTrue(s.contains("31330"));
	}

	@Test
	public void testVrednostiZaUpdate() {
		mesto = new Mesto(77l, "Priboj", "31330");

		String s = mesto.vrednostiZaUpdate();
		
		assertTrue(s.contains("Priboj"));
		assertTrue(s.contains("31330"));
	}
	
	@Test
	public void testUslov() {
		assertEquals("", mesto.uslov());
	}

}
