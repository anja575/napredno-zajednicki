package domen;

import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OdeljenjeTest {
	
	Odeljenje odeljenje;

	@BeforeEach
	void setUp() throws Exception {
		odeljenje = new Odeljenje();
	}

	@AfterEach
	void tearDown() throws Exception {
		odeljenje = null;
	}

	@Test
	public void testKonstruktor() {
        Odeljenje odeljenje = new Odeljenje();
		odeljenje.setOdeljenjeID(77);
		odeljenje.setNaziv("I-2");
		odeljenje.setKorisnik(new Korisnik(1, "Anja", "Cirkovic", "anja", "anja12345"));
		odeljenje.setSkola(new Skola(1, "Ekonomska skola", "Bulevar Kralja Aleksandra 192"));
		odeljenje.setSmer(new Smer(4, "ekonomski tehnicar"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date datum = null;
		try {
			datum = sdf.parse("20.09.2000");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mesto m = new Mesto(1, "Priboj", "31330");
		
		Ucenik u1 = new Ucenik(odeljenje, 1, "Anja", "Cirkovic", datum, "Radnicka", "30", m, Pol.Zenski);          
		Ucenik u2 = new Ucenik(odeljenje, 2, "Mara", "Maric", datum, "Narodnih heroja", "48", m, Pol.Zenski);
		Ucenik u3 = new Ucenik(odeljenje, 3, "Mihailo", "Mihailovic", datum, "Takovska", "50", m, Pol.Muski);
		Ucenik u4 = new Ucenik(odeljenje, 4, "Igor", "Igor", datum, "Humska", "37", m, Pol.Muski);
		Ucenik u5 = new Ucenik(odeljenje, 5, "Eva", "Vidakovic", datum, "Tosin bunar", "147", m, Pol.Zenski);
		
		ArrayList<Ucenik> ucenici = new ArrayList<>();
		ucenici.add(u1);
		ucenici.add(u2);
		ucenici.add(u3);
		ucenici.add(u4);
		ucenici.add(u5);
		
		odeljenje.setUcenici(ucenici);
		
		assertEquals(77, odeljenje.getOdeljenjeID());
		assertEquals("I-2", odeljenje.getNaziv());
		assertEquals(1, odeljenje.getSkola().getSkolaID());
		assertEquals(4, odeljenje.getSmer().getSmerID());
		assertEquals(1, odeljenje.getKorisnik().getKorisnikID());
		assertEquals(ucenici, odeljenje.getUcenici());
		
		
	}
	
	@Test
	public void testOdeljenjeID() {
		odeljenje.setOdeljenjeID(77l);

		assertEquals(77l, odeljenje.getOdeljenjeID());
	}

	@Test
	public void testNazivIspravan() {
		odeljenje.setNaziv("I-2");

		assertEquals("I-2", odeljenje.getNaziv());
	}
	
	@Test
	public void testNazivNull() {
		assertThrows(java.lang.NullPointerException.class, () -> odeljenje.setNaziv(null));
	}
	
	@Test
	public void testSkola() {
		Skola skola = new Skola(1l, "Gimnazija", "Nemanjina 70");
		odeljenje.setSkola(skola);
		
		assertEquals(skola, odeljenje.getSkola());
	}
	
	@Test
	public void testSmer() {
		Smer smer = new Smer(77l, "prirodno-matematicki");
		odeljenje.setSmer(smer);
		
		assertEquals(smer, odeljenje.getSmer());
	}
	
	@Test
	public void testKorisnik() {
		Korisnik korisnik = new Korisnik(77l, "Anja", "Cirkovic", "anja", "anja12345");
		odeljenje.setKorisnik(korisnik);
		
		assertEquals(korisnik, odeljenje.getKorisnik());
	}
	
	@Test
	public void testUcenici() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date datum = null;
		try {
			datum = sdf.parse("20.09.2000");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mesto m = new Mesto(1, "Priboj", "31330");
		
		Ucenik u1 = new Ucenik(odeljenje, 1, "Anja", "Cirkovic", datum, "Radnicka", "30", m, Pol.Zenski);          
		Ucenik u2 = new Ucenik(odeljenje, 2, "Mara", "Maric", datum, "Narodnih heroja", "48", m, Pol.Zenski);
		Ucenik u3 = new Ucenik(odeljenje, 3, "Mihailo", "Mihailovic", datum, "Takovska", "50", m, Pol.Muski);
		Ucenik u4 = new Ucenik(odeljenje, 4, "Igor", "Igor", datum, "Humska", "37", m, Pol.Muski);
		Ucenik u5 = new Ucenik(odeljenje, 5, "Eva", "Vidakovic", datum, "Tosin bunar", "147", m, Pol.Zenski);
		
		ArrayList<Ucenik> ucenici = new ArrayList<>();
		ucenici.add(u1);
		ucenici.add(u2);
		ucenici.add(u3);
		ucenici.add(u4);
		ucenici.add(u5);
		
		odeljenje.setUcenici(ucenici);
		
		assertEquals(ucenici, odeljenje.getUcenici());
	}
	
	@Test
	public void testToString() {
		Odeljenje odeljenje = new Odeljenje();
		odeljenje.setOdeljenjeID(77);
		odeljenje.setNaziv("I-2");
		odeljenje.setKorisnik(new Korisnik(1, "Anja", "Cirkovic", "anja", "anja12345"));
		odeljenje.setSkola(new Skola(1, "Ekonomska skola", "Bulevar Kralja Aleksandra 192"));
		odeljenje.setSmer(new Smer(4, "ekonomski tehnicar"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date datum = null;
		try {
			datum = sdf.parse("20.09.2000");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mesto m = new Mesto(1, "Priboj", "31330");
		
		Ucenik u1 = new Ucenik(odeljenje, 1, "Anja", "Cirkovic", datum, "Radnicka", "30", m, Pol.Zenski);          
		Ucenik u2 = new Ucenik(odeljenje, 2, "Mara", "Maric", datum, "Narodnih heroja", "48", m, Pol.Zenski);
		Ucenik u3 = new Ucenik(odeljenje, 3, "Mihailo", "Mihailovic", datum, "Takovska", "50", m, Pol.Muski);
		Ucenik u4 = new Ucenik(odeljenje, 4, "Igor", "Igor", datum, "Humska", "37", m, Pol.Muski);
		Ucenik u5 = new Ucenik(odeljenje, 5, "Eva", "Vidakovic", datum, "Tosin bunar", "147", m, Pol.Zenski);
		
		ArrayList<Ucenik> ucenici = new ArrayList<>();
		ucenici.add(u1);
		ucenici.add(u2);
		ucenici.add(u3);
		ucenici.add(u4);
		ucenici.add(u5);
		
		odeljenje.setUcenici(ucenici);
		
		String s = odeljenje.toString();
		assertTrue(s.contains("I-2"));
		
	}
	
	@Test
	public void testNazivTabele() {
		String s = odeljenje.nazivTabele();
		
		assertTrue(s.toLowerCase().contains("odeljenje"));
	}
	
	@Test
	public void testAlijas() {
		String s = odeljenje.alijas();
		
		assertTrue(s.toLowerCase().contains("o"));
	}
	
	@Test
	public void testJoin() {
		assertEquals(" JOIN KORISNIK K ON (K.KORISNIKID = O.KORISNIKID) "
				+ "JOIN SKOLA SK ON (SK.SKOLAID = O.SKOLAID) "
				+ "JOIN SMER SM ON (SM.SMERID = O.SMERID) ", odeljenje.join());
	}
	
	@Test
	public void testKoloneZaInsert() {
		assertEquals(" (NazivOdeljenja, SkolaID, SmerID , KorisnikID) ", odeljenje.koloneZaInsert());
	}
	
	@Test
	public void testPrimarniKljuc() {
		odeljenje.setOdeljenjeID(77);

		String s = odeljenje.vrednostZaPrimarniKljuc();
		
		assertTrue(s.contains("77"));
	}

	@Test
	public void testVrednostiZaInsert() {
		Odeljenje odeljenje = new Odeljenje();

		odeljenje.setNaziv("I-2");
		odeljenje.setKorisnik(new Korisnik(2, "Anja", "Cirkovic", "anja", "anja12345"));
		odeljenje.setSkola(new Skola(1, "Ekonomska skola", "Bulevar Kralja Aleksandra 192"));
		odeljenje.setSmer(new Smer(4, "ekonomski tehnicar"));

		String s = odeljenje.vrednostiZaInsert();
		
		assertTrue(s.contains("I-2"));
		assertTrue(s.contains("1"));
		assertTrue(s.contains("4"));	
		assertTrue(s.contains("2"));
	}

	@Test
	public void testVrednostiZaUpdate() {
		Odeljenje odeljenje = new Odeljenje();

		odeljenje.setNaziv("I-2");
		odeljenje.setKorisnik(new Korisnik(2, "Anja", "Cirkovic", "anja", "anja12345"));
		odeljenje.setSkola(new Skola(1, "Ekonomska skola", "Bulevar Kralja Aleksandra 192"));
		odeljenje.setSmer(new Smer(4, "ekonomski tehnicar"));

		String s = odeljenje.vrednostiZaInsert();
		
		assertTrue(s.contains("I-2"));
		assertTrue(s.contains("1"));
		assertTrue(s.contains("4"));	
		assertTrue(s.contains("2"));
	}
	
	@Test
	public void testUslov() {
		assertEquals("", odeljenje.uslov());
	}
	
	
	
	
	

}
