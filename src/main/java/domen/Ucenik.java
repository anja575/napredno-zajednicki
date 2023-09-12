package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * Ucenik predstavlja ucenika koji pripada odredjenom odeljenju, dolazi iz odredjenog mesta
 * i odredjenog je pola. Ucenik ima odeljenje kome pripada, id, ime, prezime, datum rodjenja,
 * ulicu u kojoj zivi, broj u ulici u kojoj zivi, mesto u kome zivi i pol.
 * 
 * Ova klasa nasledjuje apstraktnu klasu OpstiDomenskiObjekat i implementira sve njene apstraktne metode.
 * 
 * @author Anja
 *
 */
public class Ucenik extends OpstiDomenskiObjekat {
	
	/**
	 * Odeljenje ucenika kao Odeljenje.
	 */
	private Odeljenje odeljenje;
	/**
	 * ID ucenika kao Long.
	 */
	private long ucenikID;
	/**
	 * Ime ucenika kao String.
	 */
	private String ime;
	/**
	 * Prezime ucenika kao String.
	 */
	private String prezime;
	/**
	 * Datum rodjenja ucenika kao Date.
	 */
	private Date datumRodjenja;
	/**
	 * Ulica u kojoj ucenik zivi kao String.
	 */
	private String ulica;
	/**
	 * Broj u ulici gde ucenik zivi kao String.
	 */
	private String broj;
	/**
	 * Mesto u kome zivi ucenik kao Mesto.
	 */
	private Mesto mesto;
	/**
	 * Pol ucenika kao Pol.
	 */
	private Pol pol;
	/**
	 * Neparametrizovani konstruktor koji inicijalizuje novog ucenika.
	 */
	public Ucenik() {
	}
	/**
	 * Parametrizovani konstrukor koji kreira novog ucenika i postavlja mu zadate vrednosti.
	 * 
	 * @param odeljenje       vrednost za odeljenje ucenika tipa Odeljenje.
	 * @param ucenikID        vrednost za ID ucenika tipa Long.
	 * @param ime             vrednost za ime ucenika tipa String.
	 * @param prezime         vrednost za prezime ucenika tipa String.
	 * @param datumRodjenja   vrednost za datum rodjenja ucenika tipa Date.
	 * @param ulica           vrednost za ulicu ucenika tipa String.
	 * @param broj            vrednost za broj ucenika tipa String.
	 * @param mesto           vrednost za mesto ucenika tipa Mesto.
	 * @param pol             vrednost za pol ucenika tipa Pol.
	 */
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
	/**
	 * Vraca ID ucenika.
	 * 
	 * @return ID ucenika kao Long.
	 */
	public long getUcenikID() {
		return ucenikID;
	}
	/**
	 * Postavlja ID ucenika.
	 * 
	 * @param ucenikID kao vrednost za ID ucenika.
	 */
	public void setUcenikID(long ucenikID) {
		this.ucenikID = ucenikID;
	}
	/**
	 * Vraca odeljenje kome ucenik pripada.
	 * 
	 * @return odeljenje kao Odeljenje.
	 */
	public Odeljenje getOdeljenje() {
		return odeljenje;
	}
	/**
	 * Postavlja odeljenje kome ucenik pripada.
	 * 
	 * @param odeljenje kao vrednost za odeljenje ucenika.
	 */
	public void setOdeljenje(Odeljenje odeljenje) {
		this.odeljenje = odeljenje;
	}
	/**
	 * Vraca ime ucenika.
	 * 
	 * @return ime ucenika kao String.
	 */
	public String getIme() {
		return ime;
	}
	/**
	 * Postavlja ime ucenika.
	 * 
	 * @param ime kao vrednost za ime ucenika.
	 * 
	 * @throws NullPointerException ako je uneto ime null.
	 * @throws IllegalArgumentException ako je duzina unetog imena manja od tri karaktera ili ako je prazan string.
	 */
	public void setIme(String ime) {
		if(ime==null) throw new NullPointerException();
    	if(ime.length()<3 || ime.equals("")) throw new IllegalArgumentException();
        this.ime = ime;
	}
	/**
	 * Vraca prezime ucenika.
	 * 
	 * @return prezime ucenika kao String.
	 */
	public String getPrezime() {
		return prezime;
	}
	/**
	 * Postavlja prezime ucenika.
	 * 
	 * @param prezime kao vrednost za prezime ucenika.
	 * 
	 * @throws NullPointerException ako je uneto prezime null.
	 * @throws IllegalArgumentException ako je duzina unetog prezimena manja od tri karaktera ili ako je prazan string.
	 */
	public void setPrezime(String prezime) {
		if(prezime==null) throw new NullPointerException();
    	if(prezime.length()<3 || prezime.equals("")) throw new IllegalArgumentException();
        this.prezime = prezime;
	}
	/**
	 * Vraca datum rodjenja ucenika.
	 * 
	 * @return datum rodjenja ucenika kao Date.
	 */
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	/**
	 * Postavlja datum rodjenja ucenika.
	 * 
	 * @param datumRodjenja kao vrednost za datum rodjenja ucenika.
	 * 
	 * @throws NullPointerException ako je uneti datum null.
	 * @throws IllegalArgumentException ako je uneti datum nakon trenutnog datuma.
	 */
	public void setDatumRodjenja(Date datumRodjenja) {
		if(datumRodjenja==null) throw new NullPointerException();
    	if(datumRodjenja.after(new Date())) throw new IllegalArgumentException();
    	this.datumRodjenja = datumRodjenja;
	}
	/**
	 * Vraca ulicu u kojoj ucenik zivi.
	 * 
	 * @return ulica ucenika kao String.
	 */
	public String getUlica() {
		return ulica;
	}
	/**
	 * Postavlja ulicu u kojoj ucenik zivi.
	 * 
	 * @param ulica kao vrednost za ulicu ucenika.
	 * 
	 * @throws NullPointerException ako je uneta ulica null.
	 */
	public void setUlica(String ulica) {
		if(ulica==null) throw new NullPointerException();
		this.ulica = ulica;
	}
	/**
	 * Vraca broj u ulici gde ucenik zivi.
	 * 
	 * @return broj ucenika kao String.
	 */
	public String getBroj() {
		return broj;
	}
	/**
	 * Postavlja broj u ulici gde ucenik zivi.
	 * 
	 * @param broj kao vrednost za broj ucenika.
	 * 
	 * @throws NullPointerException ako je uneti broj null.
	 */
	public void setBroj(String broj) {
		if(broj==null) throw new NullPointerException();
		this.broj = broj;
	}
	/**
	 * Vraca mesto u kome ucenik zivi.
	 * 
	 * @return mesto kao Mesto.
	 */
	public Mesto getMesto() {
		return mesto;
	}
	/**
	 * Postavlja mesto u kome ucenik zivi.
	 * 
	 * @param mesto kao vrednost za mesto ucenika.
	 */
	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}
	/**
	 * Vraca pol ucenika.
	 * 
	 * @return pol kao Pol.
	 */
	public Pol getPol() {
		return pol;
	}
	/**
	 * Postavlja pol ucenika.
	 * 
	 * @param pol kao vrednost za pol ucenika.
	 */
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
	
	/**
	 * Vraca string sa imenom i prezimenom ucenika.
	 * 
	 * @return ime i prezime ucenika kao String. 
	 */
	@Override
	public String toString() {
		return ime + " " + prezime;
	}
	
}

