package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Profesor extends OpstiDomenskiObjekat{
	
	private long profesorID;
	private String ime;
	private String prezime;
	private String email;
	private Skola skola;
	
	public Profesor() {
	}

	public Profesor(long profesorID, String ime, String prezime, String email, Skola skola) {
		setProfesorID(profesorID);
		setIme(ime);
		setPrezime(prezime);
		setEmail(email);
		setSkola(skola);
	}

	public long getProfesorID() {
		return profesorID;
	}

	public void setProfesorID(long profesorID) {
		this.profesorID = profesorID;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email==null) throw new NullPointerException();
    	if(!email.contains("@")) throw new IllegalArgumentException();
    	this.email = email;
	}

	public Skola getSkola() {
		return skola;
	}

	public void setSkola(Skola skola) {
		this.skola = skola;
	}

	@Override
	public String nazivTabele() {
		return " profesor ";
	}

	@Override
	public String alijas() {
		return " P ";
	}

	@Override
	public String join() {
		 return " JOIN SKOLA S ON (P.SKOLAID = S.SKOLAID)";
	}

	@Override
	public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
		ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
		while (rs.next()) {
		Skola s = new Skola(rs.getLong("SkolaID"), rs.getString("NazivSkole"),
				rs.getString("Adresa"));

		Profesor p = new Profesor(rs.getLong("ProfesorID"), rs.getString("ImeProfesora"),
				rs.getString("PrezimeProfesora"), rs.getString("Email"), s);

		lista.add(p);
		}
		rs.close();
		return lista;
	}

	@Override
	public String koloneZaInsert() {
		return " (ImeProfesora, PrezimeProfesora, Email , SkolaID) ";
	}

	@Override
	public String vrednostZaPrimarniKljuc() {
		return " ProfesorID = " + profesorID;
	}

	@Override
	public String vrednostiZaInsert() {
		return "'" + ime + "', '" + prezime + "', '" + email + "', '" + skola.getSkolaID() + "'";
	}

	@Override
	public String vrednostiZaUpdate() {
		return " ImeProfesora = '" + ime + "', PrezimeProfesora = '" + prezime + "', " + "Email = '" + email + "', SkolaID = '"
				+ skola.getSkolaID() + "' ";
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
