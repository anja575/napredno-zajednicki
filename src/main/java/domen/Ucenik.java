package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


public class Ucenik extends OpstiDomenskiObjekat {

	private long ucenikID;
	private Odeljenje odeljenje;
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private String ulica;
	private String broj;
	private Mesto mesto;
	private Pol pol;
	
	public Ucenik() {
	}

	public Ucenik(long ucenikID, Odeljenje odeljenje, String ime, String prezime, Date datumRodjenja, String ulica,
			String broj, Mesto mesto, Pol pol) {
		setUcenikID(ucenikID);
		setOdeljenje(odeljenje);
		setIme(ime);
		setPrezime(prezime);
		setDatumRodjenja(datumRodjenja);
		setUlica(ulica);
		setBroj(broj);
		setMesto(mesto);
		setPol(pol);
	}

	public long getUcenikID() {
		return ucenikID;
	}

	public void setUcenikID(long ucenikID) {
		this.ucenikID = ucenikID;
	}

	public Odeljenje getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(Odeljenje odeljenje) {
		this.odeljenje = odeljenje;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public Mesto getMesto() {
		return mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}

	public Pol getPol() {
		return pol;
	}

	public void setPol(Pol pol) {
		this.pol = pol;
	}

	@Override
	public String nazivTabele() {
		return " ucenik ";
	}

	@Override
	public String alijas() {
		return " u ";
	}

	@Override
	public String join() {
		return "";
	}

	@Override
	public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
		ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

		while (rs.next()) {
			Korisnik k = new Korisnik(rs.getLong("KorisnikID"), rs.getString("Ime"),
					rs.getString("Prezime"), rs.getString("Username"), rs.getString("Password"));
			
			Smer smer = new Smer(rs.getLong("SmerID"), rs.getString("Naziv"));
			
			Skola skola = new Skola(rs.getLong("SkolaID"), rs.getString("Naziv"),
					rs.getString("Adresa"));

			Odeljenje o = new Odeljenje(rs.getLong("OdeljenjeID"), rs.getString("Naziv"), skola, smer, k, null);
			

			Mesto m = new Mesto(rs.getLong("MestoID"), rs.getString("Naziv"),
					rs.getString("PostanskiBroj"));
			
			Ucenik u = new Ucenik(rs.getLong("UcenikID"), o, rs.getString("Ime"), rs.getString("Prezime"),
                       rs.getDate("DatumRodjenja"), rs.getString("Ulica"), rs.getString("Broj"), m, 
                       Pol.valueOf(rs.getString("Pol")));

			lista.add(u);
		}

		rs.close();
		return lista;
	}

	@Override
	public String koloneZaInsert() {
		return " (OdeljenjeID, UcenikID, Ime, Prezime, Ulica, Broj, MestoID, Pol) ";
	}

	@Override
	public String vrednostZaPrimarniKljuc() {
		return " OdeljenjeID = " + odeljenje.getOdeljenjeID();
	}

	@Override
	public String vrednostiZaInsert() {
		return "'" +  ucenikID + "', '" + odeljenje.getOdeljenjeID() + "', '" + ime + "', '" + prezime + "', '" + new java.sql.Date(datumRodjenja.getTime()) 
				+ "', '" + ulica + "', '" + broj + "', '" + mesto.getMestoID() + "', '" + pol.name() + "'";
	}

	@Override
	public String vrednostiZaUpdate() {
		return " Ime = '" + ime + "', Prezime = '" + prezime  + "', DatumRodjenja = '" + new java.sql.Date(datumRodjenja.getTime()) + "', Ulica = '"
				+ ulica + "', Broj = '" + broj +  "', MestoID = '" + mesto.getMestoID() +   "', Pol = '" + pol.name() + "' ";
	}

	@Override
	public String uslov() {
		return "";
	}
	
	@Override
	public String toString() {
		return ime + " " + prezime;
	}
	
}

