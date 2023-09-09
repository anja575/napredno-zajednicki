package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public long getKorisnikID() {
		return korisnikID;
	}

	public void setKorisnikID(long korisnikID) {
		this.korisnikID = korisnikID;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
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
			Korisnik k = new Korisnik(rs.getLong("KorisnikID"), rs.getString("Ime"),
					rs.getString("Prezime"), rs.getString("Username"), rs.getString("Password"));

			lista.add(k);
		}

		rs.close();
		return lista;
	}

	@Override
	public String koloneZaInsert() {
		return " (Ime, Prezime, Username, Password) ";
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
		return " Ime = '" + ime + "', Prezime = '" + prezime + "', " + "Username = '" + username + "', Password = '"
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