package domen;

import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UcenikTest {

	Ucenik ucenik;
	
	@BeforeEach
	void setUp() throws Exception {
		ucenik = new Ucenik();
	}

	@AfterEach
	void tearDown() throws Exception {
		ucenik = null;
	}

	@Test
	public void testKonstruktor() {
		Odeljenje odeljenje = new Odeljenje();
		odeljenje.setOdeljenjeID(1);
		
		Mesto mesto = new Mesto();
		mesto.setMestoID(2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date datum = null;
		try {
			datum = sdf.parse("20.09.2000");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ucenik ucenik = new Ucenik(odeljenje, 3, "Anja", "Cirkovic", datum, "Radnicka", "30", mesto, Pol.Zenski);

		assertEquals(odeljenje, ucenik.getOdeljenje());
		assertEquals(3, ucenik.getUcenikID());
		assertEquals("Anja", ucenik.getIme());
		assertEquals("Cirkovic", ucenik.getPrezime());
		assertEquals(datum, ucenik.getDatumRodjenja());
		assertEquals("Radnicka", ucenik.getUlica());
		assertEquals("30", ucenik.getBroj());
		assertEquals(mesto, ucenik.getMesto());
		assertEquals(Pol.Zenski, ucenik.getPol());
		
	}
	
	@Test
	public void testOdeljenje() {
		Odeljenje odeljenje = new Odeljenje();
		odeljenje.setOdeljenjeID(1);
		
		ucenik.setOdeljenje(odeljenje);

		assertEquals(odeljenje, ucenik.getOdeljenje());
	}

	@Test
	public void testUcenikID() {
		ucenik.setUcenikID(2);

		assertEquals(2, ucenik.getUcenikID());
	}
	
	@Test
	public void testImeIspravno() {
		ucenik.setIme("Anja");

		assertEquals("Anja", ucenik.getIme());
	}
	
	@Test
	public void testImeNijeIspravno() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ucenik.setIme("an"));
		assertThrows(java.lang.IllegalArgumentException.class, () -> ucenik.setIme(""));
	}
	
	@Test
	public void testImeNUll() {
		assertThrows(java.lang.NullPointerException.class, () -> ucenik.setIme(null));
	}

	@Test
	public void testPrezimeIspravno() {
		ucenik.setPrezime("Cirkovic");

		assertEquals("Cirkovic", ucenik.getPrezime());
	}
	
	@Test
	public void testPrezimeNijeIspravno() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ucenik.setPrezime("an"));
		assertThrows(java.lang.IllegalArgumentException.class, () -> ucenik.setPrezime(""));
	}
	
	@Test
	public void testPrezimeNUll() {
		assertThrows(java.lang.NullPointerException.class, () -> ucenik.setPrezime(null));
	}
	
	@Test
	public void testDatumIspravan() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date datum = null;
		try {
			datum = sdf.parse("20.09.2000");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ucenik.setDatumRodjenja(datum);
		
		assertEquals(datum, ucenik.getDatumRodjenja());
		
	}
	
	@Test 
	public void testDatumNijeIspravan() {
		Date datum = Date.from(LocalDate.of(2085, 9, 9).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		assertThrows(java.lang.IllegalArgumentException.class, () -> ucenik.setDatumRodjenja(datum));
	}
	
	@Test 
	public void testSetDatumRodjenjaNull() {
		assertThrows(java.lang.NullPointerException.class, () -> ucenik.setDatumRodjenja(null));
	}
	
	@Test 
	public void testUlica() {
		ucenik.setUlica("Radnicka");
		
		assertEquals("Radnicka", ucenik.getUlica());
	}
	
	@Test 
	public void testUlicaNull() {
		assertThrows(java.lang.NullPointerException.class, () -> ucenik.setUlica(null));
	}
	
	@Test 
	public void testBroj() {
		ucenik.setBroj("30");
		
		assertEquals("30", ucenik.getBroj());
	}
	
	@Test 
	public void testBrojNull() {
		assertThrows(java.lang.NullPointerException.class, () -> ucenik.setBroj(null));
	}
	
	@Test 
	public void testMesto() {
		Mesto mesto = new Mesto();
		mesto.setMestoID(1);
		ucenik.setMesto(mesto);
		
		assertEquals(mesto, ucenik.getMesto());
	}
	
	@Test 
	public void testPol() {
		ucenik.setPol(Pol.Zenski);
		
		assertEquals(Pol.Zenski, ucenik.getPol());
	}
	
	@Test
	public void testToString() {
		Odeljenje odeljenje = new Odeljenje();
		odeljenje.setOdeljenjeID(1);
		
		Mesto mesto = new Mesto();
		mesto.setMestoID(2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date datum = null;
		try {
			datum = sdf.parse("20.09.2000");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ucenik ucenik = new Ucenik(odeljenje, 3, "Anja", "Cirkovic", datum, "Radnicka", "30", mesto, Pol.Zenski);
		
		String s = ucenik.toString();

		assertTrue(s.contains("Anja"));
		assertTrue(s.contains("Cirkovic"));
	}
	
	@Test
	public void testNazivTabele() {
		String s = ucenik.nazivTabele();
		
		assertTrue(s.toLowerCase().contains("ucenik"));
	}
	
	@Test
	public void testAlijas() {
		String s = ucenik.alijas();
		
		assertTrue(s.toLowerCase().contains("u"));
	}
	
	@Test
	public void testJoin() {
		assertEquals(" JOIN ODELJENJE O USING (ODELJENJEID) "
				+ "JOIN SMER SM ON (SM.SMERID = O.SMERID) "
				+ "JOIN SKOLA SK ON (SK.SKOLAID = O.SKOLAID) "
				+ "JOIN KORISNIK K ON (K.KORISNIKID = O.KORISNIKID) "
				+ "JOIN MESTO M ON (M.MESTOID = U.MESTOID)", ucenik.join());
	}
	
	@Test
	public void testKoloneZaInsert() {
		assertEquals(" (OdeljenjeID, UcenikID, ImeUcenika, PrezimeUcenika, DatumRodjenja, Ulica, Broj, MestoID, Pol) ", ucenik.koloneZaInsert());
	}
	
	@Test
	public void testPrimarniKljuc() {
		Odeljenje odeljenje = new Odeljenje();
		odeljenje.setOdeljenjeID(1);
		ucenik.setOdeljenje(odeljenje);

		String s = ucenik.vrednostZaPrimarniKljuc();
		
		assertTrue(s.contains("1"));
	}

	@Test
	public void testVrednostiZaInsert() {
		Odeljenje odeljenje = new Odeljenje();
		odeljenje.setOdeljenjeID(1);
		
		Mesto mesto = new Mesto();
		mesto.setMestoID(2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date datum = null;
		try {
			datum = sdf.parse("20.09.2000");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ucenik ucenik = new Ucenik(odeljenje, 3, "Anja", "Cirkovic", datum, "Radnicka", "30", mesto, Pol.Zenski);

		String s = ucenik.vrednostiZaInsert();
		
		assertTrue(s.contains("1"));
		assertTrue(s.contains("3"));
		assertTrue(s.contains("Anja"));	
		assertTrue(s.contains("Cirkovic"));	
		assertTrue(s.contains("2000-09-20"));	
		assertTrue(s.contains("Radnicka"));	
		assertTrue(s.contains("30"));
		assertTrue(s.contains("2"));	
		assertTrue(s.contains("Zenski"));	
	}

	@Test
	public void testVrednostiZaUpdate() {
		Odeljenje odeljenje = new Odeljenje();
		odeljenje.setOdeljenjeID(1);
		
		Mesto mesto = new Mesto();
		mesto.setMestoID(2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date datum = null;
		try {
			datum = sdf.parse("20.09.2000");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ucenik ucenik = new Ucenik(odeljenje, 3, "Anja", "Cirkovic", datum, "Radnicka", "30", mesto, Pol.Zenski);

		String s = ucenik.vrednostiZaInsert();
		
		assertTrue(s.contains("1"));
		assertTrue(s.contains("3"));
		assertTrue(s.contains("Anja"));	
		assertTrue(s.contains("Cirkovic"));	
		assertTrue(s.contains("2000-09-20"));	
		assertTrue(s.contains("Radnicka"));	
		assertTrue(s.contains("30"));
		assertTrue(s.contains("2"));	
		assertTrue(s.contains("Zenski"));
	}
	
	@Test
	public void testUslov() {
		Odeljenje odeljenje = new Odeljenje();
		odeljenje.setOdeljenjeID(1);
		ucenik.setOdeljenje(odeljenje);
		
		String s = ucenik.uslov();
		
		assertTrue(s.contains("1"));
	}
	
	
	
	
	
	

}
