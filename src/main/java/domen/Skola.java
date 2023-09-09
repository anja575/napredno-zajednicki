package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Skola extends OpstiDomenskiObjekat {
	
	private long skolaID;
	private String naziv;
	private String adresa;
	
	public Skola() {
	}

	public Skola(long skolaID, String naziv, String adresa) {
		setSkolaID(skolaID);
		setNaziv(naziv);
		setAdresa(adresa);
	}

	public long getSkolaID() {
		return skolaID;
	}

	public void setSkolaID(long skolaID) {
		this.skolaID = skolaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
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
			Skola s = new Skola(rs.getLong("SkolaID"), rs.getString("Naziv"),
					rs.getString("Adresa"));

			lista.add(s);
		}

		rs.close();
		return lista;
	}

	@Override
	public String koloneZaInsert() {
		return " (Naziv, Adresa) ";
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
		return " Naziv = '" + naziv + "', Adresa = '" + adresa + "' ";
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
