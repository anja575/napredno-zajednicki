package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.google.gson.annotations.SerializedName;
/**
 * 
 * Odnosi se na skolu u kojoj zaposleni rade i kojoj odeljenja pripadaju.
 * Skola ima svoj id, naziv i adresu.
 * 
 * Ova klasa nasledjuje apstraktnu klasu OpstiDomenskiObjekat i implementira sve njene apstraktne metode.
 * 
 * @author Anja
 *
 */
public class Skola extends OpstiDomenskiObjekat {
	
	/**
	 * ID skole kao Long.
	 */
	private transient long skolaID;
	/**
	 * Naziv skole kao String.
	 */
	@SerializedName("Naziv skole")
	private String naziv;
	/**
	 * Adresa skole kao String.
	 */
	@SerializedName("Adresa skole")
	private String adresa;
	/**
	 * Neparametrizovani konstruktor koji inicijalizuje novu skolu.
	 */
	public Skola() {
	}
	/**
	 * Parametrizovani konstrukor koji kreira novu skolu i postavlja joj zadate vrednosti.
	 * 
	 * @param skolaID  vrednost za ID skole tipa Long.
	 * @param naziv    vrednost za naziv skole tipa String.
	 * @param adresa   vrednost za adresu skole tipa String.
	 */
	public Skola(long skolaID, String naziv, String adresa) {
		setSkolaID(skolaID);
		setNaziv(naziv);
		setAdresa(adresa);
	}
	/**
	 * Vraca ID skole.
	 * 
	 * @return ID skole kao Long.
	 */
	public long getSkolaID() {
		return skolaID;
	}
	/**
	 * Postavlja ID skole.
	 * 
	 * @param skolaID kao vrednost za ID skole.
	 */
	public void setSkolaID(long skolaID) {
		this.skolaID = skolaID;
	}
	/**
	 * Vraca naziv skole.
	 * 
	 * @return naziv skole kao String.
	 */
	public String getNaziv() {
		return naziv;
	}
	/**
	 * Postavlja naziv skole.
	 * 
	 * @param naziv kao vrednost za naziv skole.
	 * 
	 * @throws NullPointerException ako je uneti naziv null.
	 */
	public void setNaziv(String naziv) {
		if(naziv==null) throw new NullPointerException();
        this.naziv = naziv;
	}
	/**
	 * Vraca adresu skole.
	 * 
	 * @return adresa skole kao String.
	 */
	public String getAdresa() {
		return adresa;
	}
	/**
	 * Postavlja adresu skole.
	 * 
	 * @param adresa kao vrednost za adresu skole.
	 * 
	 * @throws NullPointerException ako je uneta adresa null.
	 */
	public void setAdresa(String adresa) {
		if(adresa==null) throw new NullPointerException();
        this.adresa = adresa;
	}

	@Override
	public String nazivTabele() {
		return " skola ";
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
			Skola s = new Skola(rs.getLong("SkolaID"), rs.getString("NazivSkole"),
					rs.getString("Adresa"));

			lista.add(s);
		}

		rs.close();
		return lista;
	}

	@Override
	public String koloneZaInsert() {
		return " (NazivSkole, Adresa) ";
	}

	@Override
	public String vrednostZaPrimarniKljuc() {
		return " SkolaID = " + skolaID;
	}

	@Override
	public String vrednostiZaInsert() {
		return "'" + naziv + "', '" + adresa + "'";
	}

	@Override
	public String vrednostiZaUpdate() {
		return " NazivSkole = '" + naziv + "', Adresa = '" + adresa + "' ";
	}

	@Override
	public String uslov() {
		return "";
	}
	
	/**
	 * Vraca string sa nazivom skole.
	 * 
	 * @return naziv skole kao String. 
	 */
	@Override
	public String toString() {
		return naziv;
	}
	

}
