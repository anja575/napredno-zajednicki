package domen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SkolaTest {
	
	Skola skola;

	@BeforeEach
	void setUp() throws Exception {
		skola = new Skola();
	}

	@AfterEach
	void tearDown() throws Exception {
		skola = null;
	}

	@Test
	public void testKonstruktor() {
		skola = new Skola(77l, "Gimnazija", "Nemanjina 70");

		assertEquals(77l, skola.getSkolaID());
		assertEquals("Gimnazija", skola.getNaziv());
		assertEquals("Nemanjina 70", skola.getAdresa());
	}
	
	@Test
	public void testSkolaID() {
		skola.setSkolaID(77l);

		assertEquals(77l, skola.getSkolaID());
	}

	@Test
	public void testNazivIspravan() {
		skola.setNaziv("Gimnazija");

		assertEquals("Gimnazija", skola.getNaziv());
	}
	
	@Test
	public void testNazivNull() {
		assertThrows(java.lang.NullPointerException.class, () -> skola.setNaziv(null));
	}
	
	@Test
	public void testAdresaIspravna() {
		skola.setAdresa("Nemanjina 70");

		assertEquals("Nemanjina 70", skola.getAdresa());
	}
	
	@Test
	public void testAdresaNull() {
		assertThrows(java.lang.NullPointerException.class, () -> skola.setAdresa(null));
	}
	
	@Test
	public void testToString() {
		skola = new Skola(77l, "Gimnazija", "Nemanjina 70");
		
		String s = skola.toString();

		assertTrue(s.contains("Gimnazija"));
	}
	
	@Test
	public void testNazivTabele() {
		String s = skola.nazivTabele();
		
		assertTrue(s.toLowerCase().contains("skola"));
	}
	
	@Test
	public void testAlijas() {
		String s = skola.alijas();
		
		assertTrue(s.toLowerCase().contains("s"));
	}
	
	@Test
	public void testJoin() {
		assertEquals("", skola.join());
	}
	
	@Test
	public void testKoloneZaInsert() {
		assertEquals(" (NazivSkole, Adresa) ", skola.koloneZaInsert());
	}
	
	@Test
	public void testPrimarniKljuc() {
		skola.setSkolaID(77);

		String s = skola.vrednostZaPrimarniKljuc();
		
		assertTrue(s.contains("77"));
	}

	@Test
	public void testVrednostiZaInsert() {
		skola = new Skola(77l, "Gimnazija", "Nemanjina 70");

		String s = skola.vrednostiZaInsert();
		
		assertTrue(s.contains("Gimnazija"));
		assertTrue(s.contains("Nemanjina 70"));
	}

	@Test
	public void testVrednostiZaUpdate() {
		skola = new Skola(77l, "Gimnazija", "Nemanjina 70");

		String s = skola.vrednostiZaInsert();
		
		assertTrue(s.contains("Gimnazija"));
		assertTrue(s.contains("Nemanjina 70"));
	}
	
	@Test
	public void testUslov() {
		assertEquals("", skola.uslov());
	}

	
	

}
