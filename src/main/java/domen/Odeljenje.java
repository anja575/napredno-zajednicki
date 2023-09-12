package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * Odeljenje predstavlja odeljenje koje kreira jedan korisnik sistema(pedagog), koje pripada 
 * jednoj skoli i jednog je smera, a sadrzi listu ucenika. Odeljenje ima id, naziv, skolu kojoj pripada, smer kojeg je,
 * korisnika koji ga je kreirao i listu ucenika.
 * 
 * Ova klasa nasledjuje apstraktnu klasu OpstiDomenskiObjekat i implementira sve njene apstraktne metode.
 * 
 * @author Anja
 *
 */
public class Odeljenje extends OpstiDomenskiObjekat {
	
	/**
	 * ID odeljenja kao Long.
	 */
	private long odeljenjeID;
	/**
	 * Naziv odeljenja kao String.
	 */
	private String naziv;
	/**
	 * Skola kojoj odeljenje pripada kao Skola.
	 */
	private Skola skola;
	/**
	 * Smer kojeg je odeljenje kao Smer.
	 */
	private Smer smer;
	/**
	 * Korisnik koji je kreirao odeljenje kao Korisnik.
	 */
	private Korisnik korisnik;
	/**
	 * Ucenici odeljenja kao lista ciji su elementi tipa Ucenik.
	 */
	private ArrayList<Ucenik> ucenici;
	/**
	 * Neparametrizovani konstruktor koji inicijalizuje novo odeljenje.
	 */
	public Odeljenje() {
	}
	/**
	 * Parametrizovani konstrukor koji kreira novo odeljenje i postavlja mu zadate vrednosti.
	 * 
	 * @param odeljenjeID  vrednost za ID odeljenja tipa Long.
	 * @param naziv        vrednost za naziv odeljenja tipa String.
	 * @param skola        vrednost za skolu odeljenja tipa Skola.
	 * @param smer         vrednost za smer odeljenja tipa Smer.
	 * @param korisnik     vrednost za korisnika odeljenja tipa Korisnik. 
	 * @param ucenici      vrednost za listu ucenika odeljenja ciji su elementi tipa Ucenik.
	 */
	public Odeljenje(long odeljenjeID, String naziv, Skola skola, Smer smer, Korisnik korisnik, ArrayList<Ucenik> ucenici) {
		setOdeljenjeID(odeljenjeID);
		setNaziv(naziv);
		setSkola(skola);
		setSmer(smer);
		setKorisnik(korisnik);
		setUcenici(ucenici);
	}
	/**
	 * Vraca ID odeljenja.
	 * 
	 * @return ID odeljenja kao Long.
	 */
	public long getOdeljenjeID() {
		return odeljenjeID;
	}
	/**
	 * Postavlja ID odeljenja.
	 * 
	 * @param odeljenjeID kao vrednost za ID odeljenja.
	 */
	public void setOdeljenjeID(long odeljenjeID) {
		this.odeljenjeID = odeljenjeID;
	}
	/**
	 * Vraca naziv odeljenja.
	 * 
	 * @return naziv odeljenja kao String.
	 */
	public String getNaziv() {
		return naziv;
	}
	/**
	 * Postavlja naziv odeljenja.
	 * 
	 * @param naziv kao vrednost za naziv odeljenja.
	 * 
	 * @throws NullPointerException ako je uneti naziv null.
	 */
	public void setNaziv(String naziv) {
		if(naziv==null) throw new NullPointerException();
        this.naziv = naziv;
	}
	/**
	 * Vraca skolu kojoj odeljenje pripada.
	 * 
	 * @return skola odeljenja kao Skola.
	 */
	public Skola getSkola() {
		return skola;
	}
	/**
	 * Postavlja skolu kojoj odeljenje pripada.
	 * 
	 * @param skola kao vrednost za skolu odeljenja.
	 */
	public void setSkola(Skola skola) {
		this.skola = skola;
	}
	/**
	 * Vraca smer kojeg je odeljenje.
	 * 
	 * @return smer odeljenja kao Smer.
	 */
	public Smer getSmer() {
		return smer;
	}
	/**
	 * Postavlja smer kojeg je odeljenje.
	 * 
	 * @param smer kao vrednost za smer odeljenja.
	 */
	public void setSmer(Smer smer) {
		this.smer = smer;
	}
	/**
	 * Vraca korisnika koji je kreirao odeljenje.
	 * 
	 * @return korisnik odeljenja kao Korisnik.
	 */
	public Korisnik getKorisnik() {
		return korisnik;
	}
	/**
	 * Postavlja korisnika koji je kreirao odeljenje.
	 * 
	 * @param korisnik kao vrednost za korisnika odeljenja.
	 */
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	/**
	 * Vraca listu ucenika koji pripadaju odeljenju.
	 * 
	 * @return lista ucenika ciji su elementi tipa Ucenik.
	 */
	public ArrayList<Ucenik> getUcenici() {
		return ucenici;
	}
	/**
	 * Postavlja listu ucenika koji pripadaju odeljenju.
	 * 
	 * @param ucenici kao vrednost za listu ucenika odeljenja.
	 */
	public void setUcenici(ArrayList<Ucenik> ucenici) {
		this.ucenici = ucenici;
	}

	@Override
	public String nazivTabele() {
		return " odeljenje ";
	}

	@Override
	public String alijas() {
		return " o ";
	}

	@Override
	public String join() {
		return " JOIN KORISNIK K ON (K.KORISNIKID = O.KORISNIKID) "
				+ "JOIN SKOLA SK ON (SK.SKOLAID = O.SKOLAID) "
				+ "JOIN SMER SM ON (SM.SMERID = O.SMERID) ";
	}

	@Override
	public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
		ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

		while (rs.next()) {
			Korisnik k = new Korisnik(rs.getLong("KorisnikID"), rs.getString("ImeKorisnika"),
					rs.getString("PrezimeKorisnika"), rs.getString("Username"), rs.getString("Password"));
			
			Smer smer = new Smer(rs.getLong("SmerID"), rs.getString("NazivSmera"));
			
			Skola skola = new Skola(rs.getLong("SkolaID"), rs.getString("NazivSkole"),
					rs.getString("Adresa"));

			Odeljenje o = new Odeljenje(rs.getLong("OdeljenjeID"), rs.getString("NazivOdeljenja"), skola, smer, k, null);

			lista.add(o);
		}

		rs.close();
		return lista;
	}

	@Override
	public String koloneZaInsert() {
		return " (NazivOdeljenja, SkolaID, SmerID , KorisnikID) ";
	}

	@Override
	public String vrednostZaPrimarniKljuc() {
		return " OdeljenjeID = " + odeljenjeID;
	}

	@Override
	public String vrednostiZaInsert() {
		return "'" + naziv + "', '" + skola.getSkolaID() + "', '" + smer.getSmerID() + "', '" + korisnik.getKorisnikID() + "'";
	}

	@Override
	public String vrednostiZaUpdate() {
		return " NazivOdeljenja = '" + naziv + "', SkolaID = '" + skola.getSkolaID() + "', " + "SmerID = '" + smer.getSmerID() + "', KorisnikID = '"
				+ korisnik.getKorisnikID() + "' ";
	}

	@Override
	public String uslov() {
		return "";
	}
	
	/**
	 * Vraca string sa nazivom odeljenja.
	 * 
	 * @return naziv odeljenja kao String. 
	 */
	@Override
	public String toString() {
		return naziv;
	}

}

