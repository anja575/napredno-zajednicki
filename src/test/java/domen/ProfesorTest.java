package domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfesorTest {
	
	Profesor profesor;

	@BeforeEach
	void setUp() throws Exception {
		profesor = new Profesor();
	}

	@AfterEach
	void tearDown() throws Exception {
		profesor = null;
	}

	@Test
	public void testKonstruktor() {
		Skola skola = new Skola(1l, "Gimnazija", "Nemanjina 70");
		Profesor profesor = new Profesor(2l, "Anja", "Cirkovic", "anja@gmail.com", skola);

		assertEquals(2l, profesor.getProfesorID());
		assertEquals("Anja", profesor.getIme());
		assertEquals("Cirkovic", profesor.getPrezime());
		assertEquals("anja@gmail.com", profesor.getEmail());
		assertEquals(skola, profesor.getSkola());
	}
	
	@Test
	public void testProfesorID() {
		profesor.setProfesorID(77l);

		assertEquals(77l, profesor.getProfesorID());
	}

	@Test
	public void testImeIspravno() {
		profesor.setIme("Anja");

		assertEquals("Anja", profesor.getIme());
	}
	
	@Test
	public void testImeNijeIspravno() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> profesor.setIme("an"));
		assertThrows(java.lang.IllegalArgumentException.class, () -> profesor.setIme(""));
	}
	
	@Test
	public void testImeNUll() {
		assertThrows(java.lang.NullPointerException.class, () -> profesor.setIme(null));
	}

	@Test
	public void testPrezimeIspravno() {
		profesor.setPrezime("Cirkovic");

		assertEquals("Cirkovic", profesor.getPrezime());
	}
	
	@Test
	public void testPrezimeNijeIspravno() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> profesor.setPrezime("an"));
		assertThrows(java.lang.IllegalArgumentException.class, () -> profesor.setPrezime(""));
	}
	
	@Test
	public void testPrezimeNUll() {
		assertThrows(java.lang.NullPointerException.class, () -> profesor.setPrezime(null));
	}
	
	@Test
	public void testEmailIspravan() {
		profesor.setEmail("anja@gmail.com");

		assertEquals("anja@gmail.com", profesor.getEmail());
	}
	
	@Test
	public void testEmailNijeIspravan() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> profesor.setEmail("anja.gmail.com"));
	}
	
	@Test
	public void testEmailNUll() {
		assertThrows(java.lang.NullPointerException.class, () -> profesor.setEmail(null));
	}
	
	@Test
	public void testSkola() {
		Skola skola = new Skola(1l, "Gimnazija", "Nemanjina 70");
		profesor.setSkola(skola);
		
		assertEquals(skola, profesor.getSkola());
	}
	
	@Test
	public void testToString() {
		Skola skola = new Skola(1l, "Gimnazija", "Nemanjina 70");
		Profesor profesor = new Profesor(2l, "Anja", "Cirkovic", "anja@gmail.com", skola);
		
		String s = profesor.toString();

		assertTrue(s.contains("Anja"));
		assertTrue(s.contains("Cirkovic"));
	}
	
	@Test
	public void testNazivTabele() {
		String s = profesor.nazivTabele();
		
		assertTrue(s.toLowerCase().contains("profesor"));
	}
	
	@Test
	public void testAlijas() {
		String s = profesor.alijas();
		
		assertTrue(s.toLowerCase().contains("p"));
	}
	
	@Test
	public void testJoin() {
		assertEquals(" JOIN SKOLA S ON (P.SKOLAID = S.SKOLAID)", profesor.join());
	}
	
	@Test
	public void testKoloneZaInsert() {
		assertEquals(" (ImeProfesora, PrezimeProfesora, Email , SkolaID) ", profesor.koloneZaInsert());
	}
	
	@Test
	public void testPrimarniKljuc() {
		profesor.setProfesorID(77);

		String s = profesor.vrednostZaPrimarniKljuc();
		
		assertTrue(s.contains("77"));
	}

	@Test
	public void testVrednostiZaInsert() {
		Skola skola = new Skola(1l, "Gimnazija", "Nemanjina 70");
		Profesor profesor = new Profesor(2l, "Anja", "Cirkovic", "anja@gmail.com", skola);

		String s = profesor.vrednostiZaInsert();
		
		assertTrue(s.contains("Anja"));
		assertTrue(s.contains("Cirkovic"));
		assertTrue(s.contains("anja@gmail.com"));	
		assertTrue(s.contains("1"));
	}

	@Test
	public void testVrednostiZaUpdate() {
		Skola skola = new Skola(1l, "Gimnazija", "Nemanjina 70");
		Profesor profesor = new Profesor(2l, "Anja", "Cirkovic", "anja@gmail.com", skola);

		String s = profesor.vrednostiZaInsert();
		
		assertTrue(s.contains("Anja"));
		assertTrue(s.contains("Cirkovic"));
		assertTrue(s.contains("anja@gmail.com"));	
		assertTrue(s.contains("1"));
	}
	
	@Test
	public void testUslov() {
		assertEquals("", profesor.uslov());
	}
	

}
