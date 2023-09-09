package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Mesto extends OpstiDomenskiObjekat {
	
	private long mestoID;
	private String naziv;
	private String postanskiBroj;
	
	public Mesto() {
	}

	public Mesto(long mestoID, String naziv, String postanskiBroj) {
		setMestoID(mestoID);
		setNaziv(naziv);
		setPostanskiBroj(postanskiBroj);
	}

	public long getMestoID() {
		return mestoID;
	}

	public void setMestoID(long mestoID) {
		this.mestoID = mestoID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPostanskiBroj() {
		return postanskiBroj;
	}

	public void setPostanskiBroj(String postanskiBroj) {
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
			Mesto m = new Mesto(rs.getLong("MestoID"), rs.getString("Naziv"),
					rs.getString("PostanskiBroj"));

			lista.add(m);
		}

		rs.close();
		return lista;
	}

	@Override
	public String koloneZaInsert() {
		return " (Naziv, PostanskiBroj) ";
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
		return " Naziv = '" + naziv + "', PostanskiBroj = '" + postanskiBroj + "' ";
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

