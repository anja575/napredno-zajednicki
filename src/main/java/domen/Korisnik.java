package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * Korisnik predstavlja pedagoga koji je zapravo administrator sistema. Korisnik 
 * ima svoj id, ime, prezime, username i password. 
 * 
 * Ova klasa nasledjuje apstraktnu klasu OpstiDomenskiObjekat i implementira sve njene apstraktne metode.
 * 
 * @author Anja
 *
 */

public class Korisnik extends OpstiDomenskiObjekat{

	/**
	 * ID korisnika kao Long.
	 */
	private long korisnikID;
	/**
	 * Ime korisnika kao String.
	 */
	private String ime;
	/**
	 * Prezime korisnika kao String.
	 */
	private String prezime;
	/**
	 * Username korisnika kao String.
	 */
	private String username;
	/**
	 * Password korisnika kao String.
	 */
	private String password;

	/**
	 * Neparametrizovani konstruktor koji inicijalizuje novog korisnika.
	 */
	public Korisnik() {
	}
	/**
	 * Parametrizovani konstrukor koji kreira novog korisnika i postavlja mu zadate vrednosti.
	 * 
	 * @param korisnikID  vrednost za ID korisnika tipa Long.
	 * @param ime		  vrednost za Ime korisnika tipa String.
	 * @param prezime	  vrednost za Prezime korisnika tipa String.
	 * @param username    vrednost za Username korisnika tipa String.
	 * @param password    vrednost za Password korisnika tipa String.
	 */
	public Korisnik(long korisnikID, String ime, String prezime, String username, String password) {
		setKorisnikID(korisnikID);
		setIme(ime);
		setPrezime(prezime);
		setUsername(username);
		setPassword(password);
	}
	/**
     * Vraca ID korisnika.
     * 
     * @return ID korisnika kao Long.
     */
	public long getKorisnikID() {
		return korisnikID;
	}
	/**
	 * Postavlja ID korisnika.
	 * 
	 * @param korisnikID kao vrednost za ID korisnika.
	 */
	public void setKorisnikID(long korisnikID) {
		this.korisnikID = korisnikID;
	}
	/**
     * Vraca ime korisnika.
     * 
     * @return ime korisnika kao String.
     */
	public String getIme() {
		return ime;
	}
	/**
	 * Postavlja ime korisnika.
	 * 
	 * @param ime kao vrednost za ime korisnika.
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
	 * Vraca prezime korisnika.
	 * 
	 * @return prezime korisnika kao String.
	 */
	public String getPrezime() {
		return prezime;
	}
	/**
	 * Postavlja prezime korisnika.
	 * 
	 * @param prezime kao vrednost za prezime korisnika.
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
	 * Vraca username korisnika sistema, koji mu je potreban za logovanje na sistem.
	 * 
	 * @return username korisnika kao String.
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Postavlja username korisnika sistema, koji mu je potreban za logovanje na sistem.
	 * 
	 * @param username kao vrednost za username korisnika.
	 * 
	 * @throws NullPointerException ako je uneti username null.
	 * @throws IllegalArgumentException ako je duzina unetog username-a manja od cetiri karaktera ili ako je prazan string.
	 * 
	 */
	public void setUsername(String username) {
		if(username==null) throw new NullPointerException();
        if(username.length()<4 || username.equals("")) throw new IllegalArgumentException();
        this.username = username;
	}
	/**
	 * Vraca password korisnika sistema, koji mu je potreban za logovanje na sistem.
	 * 
	 * @return password korisnika kao String.
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Postavlja password korisnika sistema, koji mu je potreban za logovanje na sistem.
	 * 
	 * @param password kao vrednost za password korisnika.
	 * 
	 * @throws NullPointerException ako je uneti password null.
	 * @throws IllegalArgumentException ako je duzina unetog password-a manja od osam karaktera ili ako je prazan string.
	 * 
	 */
	public void setPassword(String password) {
		if(password==null) throw new NullPointerException();
        if(password.length()<8 || password.equals("")) throw new IllegalArgumentException();
        this.password = password;
	}

	@Override
	public String nazivTabele() {
		return " korisnik ";
	}

	@Override
	public String alijas() {
		return " k ";
	}

	@Override
	public String join() {
		return "";
	}

	@Override
	public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
		ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

		while (rs.next()) {
			Korisnik k = new Korisnik(rs.getLong("KorisnikID"), rs.getString("ImeKorisnika"),
					rs.getString("PrezimeKorisnika"), rs.getString("Username"), rs.getString("Password"));

			lista.add(k);
		}

		rs.close();
		return lista;
	}

	@Override
	public String koloneZaInsert() {
		return " (ImeKorisnika, PrezimeKorisnika, Username, Password) ";
	}

	@Override
	public String vrednostZaPrimarniKljuc() {
		return " KorisnikID = " + korisnikID;
	}

	@Override
	public String vrednostiZaInsert() {
		return "'" + ime + "', '" + prezime + "', " + "'" + username + "', '" + password + "'";
	}

	@Override
	public String vrednostiZaUpdate() {
		return " ImeKorisnika = '" + ime + "', PrezimeKorisnika = '" + prezime + "', " + "Username = '" + username + "', Password = '"
				+ password + "' ";
	}

	@Override
	public String uslov() {
		return "";
	}

	/**
	 * Vraca string sa imenom i prezimenom korisnika.
	 * 
	 * @return ime i prezime korisnika kao String. 
	 */
	@Override
	public String toString() {
		return ime + " " + prezime;
	}	
	
	
}