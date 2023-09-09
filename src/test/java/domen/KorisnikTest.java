package domen;

import static org.junit.Assert.*;


import java.sql.ResultSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;



public class KorisnikTest {
	
	private ResultSet rs;
	private Korisnik korisnik;

	@BeforeEach
	public void setUp() throws Exception {
		korisnik = new Korisnik();
	}

	@AfterEach
	public void tearDown() throws Exception {
		korisnik=null;
	}

	@Test
	public void testKonstruktor() {
		korisnik = new Korisnik(1l, "Anja", "Cirkovic", "anja123", "anja123");

		assertEquals(1l, korisnik.getKorisnikID());
		assertEquals("Anja", korisnik.getIme());
		assertEquals("Cirkovic", korisnik.getPrezime());
		assertEquals("anja123", korisnik.getUsername());
		assertEquals("anja123", korisnik.getPassword());
	}
	
	

}
