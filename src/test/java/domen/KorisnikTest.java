package domen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KorisnikTest {
	
	Korisnik korisnik;

	@BeforeEach
	void setUp() throws Exception {
		korisnik = new Korisnik();
	}

	@AfterEach
	void tearDown() throws Exception {
		korisnik = null;
	}

	@Test
	public void testKonstruktor() {
		korisnik = new Korisnik(77l, "Anja", "Cirkovic", "anja", "anja12345");

		assertEquals(77l, korisnik.getKorisnikID());
		assertEquals("Anja", korisnik.getIme());
		assertEquals("Cirkovic", korisnik.getPrezime());
		assertEquals("anja", korisnik.getUsername());
		assertEquals("anja12345", korisnik.getPassword());
	}
	
	@Test
	public void testKorisnikID() {
		korisnik.setKorisnikID(77l);

		assertEquals(77l, korisnik.getKorisnikID());
	}

	@Test
	public void testImeIspravno() {
		korisnik.setIme("Anja");

		assertEquals("Anja", korisnik.getIme());
	}
	
	@Test
	public void testImeNijeIspravno() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> korisnik.setIme("an"));
		assertThrows(java.lang.IllegalArgumentException.class, () -> korisnik.setIme(""));
	}
	
	@Test
	public void testImeNUll() {
		assertThrows(java.lang.NullPointerException.class, () -> korisnik.setIme(null));
	}

	@Test
	public void testPrezimeIspravno() {
		korisnik.setPrezime("Cirkovic");

		assertEquals("Cirkovic", korisnik.getPrezime());
	}
	
	
	@Test
	public void testPrezimeNijeIspravno() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> korisnik.setPrezime("an"));
		assertThrows(java.lang.IllegalArgumentException.class, () -> korisnik.setPrezime(""));
	}
	
	@Test
	public void testPrezimeNUll() {
		assertThrows(java.lang.NullPointerException.class, () -> korisnik.setPrezime(null));
	}
	
	@Test
	public void testUsernameIspravan() {
		korisnik.setUsername("anja");

		assertEquals("anja", korisnik.getUsername());
	}
	
	@Test
	public void testUsernameNijeIspravan() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> korisnik.setUsername("an"));
		assertThrows(java.lang.IllegalArgumentException.class, () -> korisnik.setUsername(""));
	}
	
	@Test
	public void testUsernameNUll() {
		assertThrows(java.lang.NullPointerException.class, () -> korisnik.setUsername(null));
	}
	
	@Test
	public void testPassworrdIspravan() {
		korisnik.setPassword("anja12345");

		assertEquals("anja12345", korisnik.getPassword());
	}
	
	@Test
	public void testPasswordNijeIspravan() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> korisnik.setPassword("an"));
		assertThrows(java.lang.IllegalArgumentException.class, () -> korisnik.setPassword(""));
	}
	
	@Test
	public void testPasswordNUll() {
		assertThrows(java.lang.NullPointerException.class, () -> korisnik.setPassword(null));
	}
	
	@Test
	public void testToString() {
		korisnik = new Korisnik(77l, "Anja", "Cirkovic", "anja", "anja12345");
		
		String s = korisnik.toString();

		assertTrue(s.contains("Anja"));
		assertTrue(s.contains("Cirkovic"));
	}
	
	@Test
	public void testNazivTabele() {
		String s = korisnik.nazivTabele();
		
		assertTrue(s.toLowerCase().contains("korisnik"));
	}
	
	@Test
	public void testAlijas() {
		String s = korisnik.alijas();
		
		assertTrue(s.toLowerCase().contains("k"));
	}
	
	@Test
	public void testJoin() {
		assertEquals("", korisnik.join());
	}
	
	@Test
	public void testKoloneZaInsert() {
		assertEquals(" (ImeKorisnika, PrezimeKorisnika, Username, Password) ", korisnik.koloneZaInsert());
	}
	
	@Test
	public void testPrimarniKljuc() {
		korisnik.setKorisnikID(77);

		String s = korisnik.vrednostZaPrimarniKljuc();
		
		assertTrue(s.contains("77"));
	}

	@Test
	public void testVrednostiZaInsert() {
		korisnik = new Korisnik(77l, "Anja", "Cirkovic", "anja", "anja12345");

		String s = korisnik.vrednostiZaInsert();
		
		assertTrue(s.contains("Anja"));
		assertTrue(s.contains("Cirkovic"));
		assertTrue(s.contains("anja"));	
		assertTrue(s.contains("anja12345"));
	}

	@Test
	public void testVrednostiZaUpdate() {
		korisnik = new Korisnik(77l, "Anja", "Cirkovic", "anja", "anja12345");

		String s = korisnik.vrednostiZaUpdate();
		
		assertTrue(s.contains("Anja"));
		assertTrue(s.contains("Cirkovic"));
		assertTrue(s.contains("anja"));	
		assertTrue(s.contains("anja12345"));
	}
	
	@Test
	public void testUslov() {
		assertEquals("", korisnik.uslov());
	}

}
