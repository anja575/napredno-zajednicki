package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Ucenik extends OpstiDomenskiObjekat {

	private Odeljenje odeljenje;
	private long ucenikID;
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private String ulica;
	private String broj;
	private Mesto mesto;
	private Pol pol;
	
	public Ucenik() {
	}

	public Ucenik(Odeljenje odeljenje, long ucenikID,  String ime, String prezime, Date datumRodjenja, String ulica,
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
		if(ime==null) throw new NullPointerException();
    	if(ime.length()<3 || ime.equals("")) throw new IllegalArgumentException();
        this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		if(prezime==null) throw new NullPointerException();
    	if(prezime.length()<3 || prezime.equals("")) throw new IllegalArgumentException();
        this.prezime = prezime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		if(datumRodjenja==null) throw new NullPointerException();
    	if(datumRodjenja.after(new Date())) throw new IllegalArgumentException();
    	this.datumRodjenja = datumRodjenja;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		if(ulica==null) throw new NullPointerException();
		this.ulica = ulica;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		if(broj==null) throw new NullPointerException();
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
		return " JOIN ODELJENJE O USING (ODELJENJEID) "
				+ "JOIN SMER SM ON (SM.SMERID = O.SMERID) "
				+ "JOIN SKOLA SK ON (SK.SKOLAID = O.SKOLAID) "
				+ "JOIN KORISNIK K ON (K.KORISNIKID = O.KORISNIKID) "
				+ "JOIN MESTO M ON (M.MESTOID = U.MESTOID)" ;
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
			

			Mesto m = new Mesto(rs.getLong("MestoID"), rs.getString("NazivMesta"),
					rs.getString("PostanskiBroj"));
			
			Ucenik u = new Ucenik( o, rs.getLong("UcenikID"),rs.getString("ImeUcenika"), rs.getString("PrezimeUcenika"),
                       rs.getDate("DatumRodjenja"), rs.getString("Ulica"), rs.getString("Broj"), m, 
                       Pol.valueOf(rs.getString("Pol")));

			lista.add(u);
		}

		rs.close();
		return lista;
	}

	@Override
	public String koloneZaInsert() {
		return " (OdeljenjeID, UcenikID, ImeUcenika, PrezimeUcenika, DatumRodjenja, Ulica, Broj, MestoID, Pol) ";
	}

	@Override
	public String vrednostZaPrimarniKljuc() {
		return " OdeljenjeID = " + odeljenje.getOdeljenjeID();  
	}

	@Override
	public String vrednostiZaInsert() {
		return "'" +  odeljenje.getOdeljenjeID() + "', '" + ucenikID + "', '" + ime + "', '" + prezime + "', '" + new java.sql.Date(datumRodjenja.getTime()) 
				+ "', '" + ulica + "', '" + broj + "', '" + mesto.getMestoID() + "', '" + pol.toString() + "'";
	}

	@Override
	public String vrednostiZaUpdate() {
		return " ImeUcenika = '" + ime + "', PrezimeUcenika = '" + prezime  + "', DatumRodjenja = '" + new java.sql.Date(datumRodjenja.getTime()) + "', Ulica = '"
				+ ulica + "', Broj = '" + broj +  "', MestoID = '" + mesto.getMestoID() +   "', Pol = '" + pol.toString() + "' ";
	}

	@Override
	public String uslov() {
		return " WHERE U.ODELJENJEID = " + odeljenje.getOdeljenjeID();
	}
	
	@Override
	public String toString() {
		return ime + " " + prezime;
	}
	
}

