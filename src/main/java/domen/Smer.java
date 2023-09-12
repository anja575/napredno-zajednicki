package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * Odnosi se na smer koji pohadja odeljenje u skoli. Smer ima svoj id i naziv.
 * 
 * Ova klasa nasledjuje apstraktnu klasu OpstiDomenskiObjekat i implementira sve njene apstraktne metode.
 * 
 * @author Anja
 *
 */
public class Smer extends OpstiDomenskiObjekat {
	
	/**
	 * ID smera kao Long.
	 */
	private long smerID;
	/**
	 * Naziv smera kao String.
	 */
	private String naziv;
	/**
	 * Neparametrizovani konstruktor koji inicijalizuje novi smer.
	 */
	public Smer() {
	}
	/**
	 * Parametrizovani konstrukor koji kreira novi smer i postavlja mu zadate vrednosti.
	 * 
	 * @param smerID  vrednost za ID smera tipa Long.
	 * @param naziv   vrednost za naziv smera tipa String.
	 */
	public Smer(long smerID, String naziv) {
		setSmerID(smerID);
		setNaziv(naziv);
	}
	/**
	 * Vraca ID smera.
	 * 
	 * @return ID smera kao Long.
	 */
	public long getSmerID() {
		return smerID;
	}
	/**
	 * Postavlja ID smera.
	 * 
	 * @param smerID kao vrednost za ID smera.
	 */
	public void setSmerID(long smerID) {
		this.smerID = smerID;
	}
	/**
	 * Vraca naziv smera.
	 * 
	 * @return naziv smera kao String.
	 */
	public String getNaziv() {
		return naziv;
	}
	/**
	 * Postavlja naziv smera.
	 * 
	 * @param naziv kao vrednost za naziv smera.
	 * 
	 * @throws NullPointerException ako je uneti naziv null.
	 */
	public void setNaziv(String naziv) {
		if(naziv==null) throw new NullPointerException();
        this.naziv = naziv;
	}

	@Override
	public String nazivTabele() {
		return " smer ";
	}

	@Override
	public String alijas() {
		return " s ";
	}

	@Override
	public String join() {
		return "";
	}

	@Override
	public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
		ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

		while (rs.next()) {
			Smer s = new Smer(rs.getLong("SmerID"), rs.getString("NazivSmera"));

			lista.add(s);
		}

		rs.close();
		return lista;
	}

	@Override
	public String koloneZaInsert() {
		return " (NazivSmera) ";
	}

	@Override
	public String vrednostZaPrimarniKljuc() {
		return " SmerID = " + smerID;
	}

	@Override
	public String vrednostiZaInsert() {
		return "'" + naziv +"'";
	}

	@Override
	public String vrednostiZaUpdate() {
		return " NazivSmera = '" + naziv + "' ";
	}

	@Override
	public String uslov() {
		return "";
	}
	
	/**
	 * Vraca string sa nazivom smera.
	 * 
	 * @return naziv smera kao String. 
	 */
	@Override
	public String toString() {
		return naziv;
	}
	

}

