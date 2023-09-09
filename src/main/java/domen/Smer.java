package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Smer extends OpstiDomenskiObjekat {
	
	private long smerID;
	private String naziv;
	
	public Smer() {
	}

	public Smer(long smerID, String naziv) {
		setSmerID(smerID);
		setNaziv(naziv);
	}

	public long getSmerID() {
		return smerID;
	}

	public void setSmerID(long smerID) {
		this.smerID = smerID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
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
			Smer s = new Smer(rs.getLong("SmerID"), rs.getString("Naziv"));

			lista.add(s);
		}

		rs.close();
		return lista;
	}

	@Override
	public String koloneZaInsert() {
		return " (Naziv) ";
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
		return " Naziv = '" + naziv + "' ";
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

