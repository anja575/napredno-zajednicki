package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Odeljenje extends OpstiDomenskiObjekat {
	
	private long odeljenjeID;
	private String naziv;
	private Skola skola;
	private Smer smer;
	private Korisnik korisnik;
	private ArrayList<Ucenik> ucenici;
	
	public Odeljenje() {
	}

	public Odeljenje(long odeljenjeID, String naziv, Skola skola, Smer smer, Korisnik korisnik, ArrayList<Ucenik> ucenici) {
		setOdeljenjeID(odeljenjeID);
		setNaziv(naziv);
		setSkola(skola);
		setSmer(smer);
		setKorisnik(korisnik);
		setUcenici(ucenici);
	}

	public long getOdeljenjeID() {
		return odeljenjeID;
	}

	public void setOdeljenjeID(long odeljenjeID) {
		this.odeljenjeID = odeljenjeID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if(naziv==null) throw new NullPointerException();
        this.naziv = naziv;
	}

	public Skola getSkola() {
		return skola;
	}

	public void setSkola(Skola skola) {
		this.skola = skola;
	}

	public Smer getSmer() {
		return smer;
	}

	public void setSmer(Smer smer) {
		this.smer = smer;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	

	public ArrayList<Ucenik> getUcenici() {
		return ucenici;
	}

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
	
	@Override
	public String toString() {
		return naziv;
	}

}

