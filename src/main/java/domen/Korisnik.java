package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * 
 * Korisnik predstavlja pedagoga koji je zapravo administrator sistema. Korisnik 
 * ima svoj id, ime, prezime, username i password. 
 * 
 * @author Anja
 *
 */

public class Korisnik extends OpstiDomenskiObjekat{

	/**
	 * ID korisnika.
	 */
	private long korisnikID;
	/**
	 * Ime korisnika.
	 */
	private String ime;
	/**
	 * Prezime korisnika
	 */
	private String prezime;
	/**
	 * Username korisnika.
	 */
	private String username;
	/**
	 * Password korisnika.
	 */
	private String password;
	
	/**
	 * Neparametrizovani konstruktor koji inicijalizuje novog clana.
	 */
	public Korisnik() {
	}

	/**
	 * Parametrizovani konstrukor koji kreira novog clana i prosledjuje mu zadate vrednosti.
	 * 
	 * @param korisnikID  ID korisnika tipa Long.
	 * @param ime		  Ime korisnika tipa String.
	 * @param prezime	  Prezime korisnika tipa String.
	 * @param username    Username korisnika tipa String.
	 * @param password    Password korisnika tipa String.
	 */
	public Korisnik(long korisnikID, String ime, String prezime, String username, String password) {
		setKorisnikID(korisnikID);
		setIme(ime);
		setPrezime(prezime);
		setUsername(username);
		setPassword(password);
	}
	/**
     * Vraca ID korisnika..
     * 
     * @return ID korisnika kao Long.
     */
	public long getKorisnikID() {
		return korisnikID;
	}
	/**
	    * Postavlja ID korisnika.
	    * 
	    * @param korisnikID kao ID korisnika.
	    */
	public void setKorisnikID(long korisnikID) {
		this.korisnikID = korisnikID;
	}
	/**
     * Vraca ime korisnika..
     * 
     * @return ime korisnika kao String.
     */
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if(username==null) throw new NullPointerException();
        if(username.length()<4 || username.equals("")) throw new IllegalArgumentException();
        this.username = username;
	}

	public String getPassword() {
		return password;
	}

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

	@Override
	public String toString() {
		return ime + " " + prezime;
	}	
	
	
}