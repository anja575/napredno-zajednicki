package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * Mesto koje se odnosi na grad iz koga dolazi ucenik. Mesto ima svoj id, naziv i postanski broj.
 * 
 * Ova klasa nasledjuje apstraktnu klasu OpstiDomenskiObjekat i implementira sve njene apstraktne metode.
 * 
 * @author Anja
 *
 */

public class Mesto extends OpstiDomenskiObjekat {
	
	/**
	 * ID mesta kao Long.
	 */
	private long mestoID;
	/**
	 * Naziv mesta kao String.
	 */
	private String naziv;
	/**
	 * Postanski broj mesta kao String.
	 */
	private String postanskiBroj;
	/**
	 * Neparametrizovani konstruktor koji inicijalizuje novo mesto.
	 */
	public Mesto() {
	}
	/**
	 * Parametrizovani konstrukor koji kreira novo mesto i postavlja mu zadate vrednosti.
	 * 
	 * @param mestoID        vrednost za ID mesta tipa Long.
	 * @param naziv          vrednost za naziv mesta tipa String.
	 * @param postanskiBroj  vrednost za postanski broj mesta tipa String.
	 */
	public Mesto(long mestoID, String naziv, String postanskiBroj) {
		setMestoID(mestoID);
		setNaziv(naziv);
		setPostanskiBroj(postanskiBroj);
	}
	/**
	 * Vraca ID mesta.
	 * 
	 * @return ID mesta kao Long.
	 */
	public long getMestoID() {
		return mestoID;
	}
	/**
	 * Postavlja ID mesta.
	 * 
	 * @param mestoID kao vrednost za ID mesta.
	 */
	public void setMestoID(long mestoID) {
		this.mestoID = mestoID;
	}
	/**
	 * Vraca naziv mesta.
	 * 
	 * @return naziv mesta kao String.
	 */
	public String getNaziv() {
		return naziv;
	}
	/**
	 * Postavlja naziv mesta.
	 * 
	 * @param naziv kao vrednost za naziv mesta.
	 * 
	 * @throws NullPointerException ako je uneti naziv null.
	 */
	public void setNaziv(String naziv) {
		if(naziv==null) throw new NullPointerException();
        this.naziv = naziv;
	}
	/**
	 * Vraca postanski broj mesta.
	 * 
	 * @return postanski broj mesta kao String.
	 */
	public String getPostanskiBroj() {
		return postanskiBroj;
	}
	/**
	 * Postavlja postanski broj mesta.
	 * 
	 * @param postanskiBroj kao vrednost za postanski broj mesta.
	 * 
	 * @throws NullPointerException ako je uneti postanski broj null.
	 * @throws IllegalArgumentException ako je duzina unetog postanskog broja razlicita od pet ili ako je prazan string.
	 */
	public void setPostanskiBroj(String postanskiBroj) {
		if(postanskiBroj==null) throw new NullPointerException();
    	if(postanskiBroj.length()!=5 || postanskiBroj.equals("")) throw new IllegalArgumentException();
        this.postanskiBroj = postanskiBroj;
	}

	@Override
	public String nazivTabele() {
		return " mesto ";
	}

	@Override
	public String alijas() {
		return " m ";
	}

	@Override
	public String join() {
		return "";
	}

	@Override
	public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
		ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

		while (rs.next()) {
			Mesto m = new Mesto(rs.getLong("MestoID"), rs.getString("NazivMesta"),
					rs.getString("PostanskiBroj"));

			lista.add(m);
		}

		rs.close();
		return lista;
	}

	@Override
	public String koloneZaInsert() {
		return " (NazivMesta, PostanskiBroj) ";
	}

	@Override
	public String vrednostZaPrimarniKljuc() {
		return " MestoID = " + mestoID;
	}

	@Override
	public String vrednostiZaInsert() {
		return "'" + naziv + "', '" + postanskiBroj +"'";
	}

	@Override
	public String vrednostiZaUpdate() {
		return " NazivMesta = '" + naziv + "', PostanskiBroj = '" + postanskiBroj + "' ";
	}

	@Override
	public String uslov() {
		return "";
	}
	
	/**
	 * Vraca string sa nazivom mesta.
	 * 
	 * @return naziv mesta kao String. 
	 */
	@Override
	public String toString() {
		return naziv;
	}
	

}

