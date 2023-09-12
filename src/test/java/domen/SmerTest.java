package domen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmerTest {
	
	Smer smer;

	@BeforeEach
	void setUp() throws Exception {
		smer = new Smer();
	}

	@AfterEach
	void tearDown() throws Exception {
		smer = null;
	}

	@Test
	public void testKonstruktor() {
		smer = new Smer(77l, "prirodno-matematicki");

		assertEquals(77l, smer.getSmerID());
		assertEquals("prirodno-matematicki", smer.getNaziv());
	}
	
	@Test
	public void testSmerID() {
		smer.setSmerID(77l);

		assertEquals(77l, smer.getSmerID());
	}

	@Test
	public void testNazivIspravan() {
		smer.setNaziv("prirodno-matematicki");

		assertEquals("prirodno-matematicki", smer.getNaziv());
	}
	
	@Test
	public void testNazivNull() {
		assertThrows(java.lang.NullPointerException.class, () -> smer.setNaziv(null));
	}
	
	@Test
	public void testToString() {
		smer = new Smer(77l, "prirodno-matematicki");
		
		String s = smer.toString();

		assertTrue(s.contains("prirodno-matematicki"));
	}
	
	@Test
	public void testNazivTabele() {
		String s = smer.nazivTabele();
		
		assertTrue(s.toLowerCase().contains("smer"));
	}
	
	@Test
	public void testAlijas() {
		String s = smer.alijas();
		
		assertTrue(s.toLowerCase().contains("s"));
	}
	
	@Test
	public void testJoin() {
		assertEquals("", smer.join());
	}
	
	@Test
	public void testKoloneZaInsert() {
		assertEquals(" (NazivSmera) ", smer.koloneZaInsert());
	}
	
	@Test
	public void testPrimarniKljuc() {
		smer.setSmerID(77);

		String s = smer.vrednostZaPrimarniKljuc();
		
		assertTrue(s.contains("77"));
	}

	@Test
	public void testVrednostiZaInsert() {
		smer = new Smer(77l, "prirodno-matematicki");

		String s = smer.vrednostiZaInsert();
		
		assertTrue(s.contains("prirodno-matematicki"));
	}

	@Test
	public void testVrednostiZaUpdate() {
		smer = new Smer(77l, "prirodno-matematicki");

		String s = smer.vrednostiZaInsert();
		
		assertTrue(s.contains("prirodno-matematicki"));
	}
	
	@Test
	public void testUslov() {
		assertEquals("", smer.uslov());
	}

}
