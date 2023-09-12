package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * Profesor predstavlja profesora koji je zaposlen u jednoj skoli. Profesor ima
 * svoj id, ime, prezime, email kao i skolu u kojoj radi.
 * 
 * Ova klasa nasledjuje apstraktnu klasu OpstiDomenskiObjekat i implementira sve njene apstraktne metode.
 * 
 * @author Anja
 *
 */
public class Profesor extends OpstiDomenskiObjekat{
	
	/**
	 * ID profesora kao Long.
	 */
	private long profesorID;
	/**
	 * Ime profesora kao String.
	 */
	private String ime;
	/**
	 * Prezime profesora kao String.
	 */
	private String prezime;
	/**
	 * Email profesora kao String.
	 */
	private String email;
	/**
	 * Skola u kojoj profesor radi kao Skola.
	 */
	private Skola skola;
	/**
	 * Neparametrizovani konstruktor koji inicijalizuje novog profesora.
	 */
	public Profesor() {
	}
	/**
	 * Parametrizovani konstrukor koji kreira novog profesora i postavlja mu zadate vrednosti.
	 * 
	 * @param profesorID  vrednost za ID profesora tipa Long.
	 * @param ime         vrednost za ime profesora tipa String.
	 * @param prezime     vrednost za prezime profesora tipa String.
	 * @param email       vrednost za email profesora tipa String.
	 * @param skola       vrednost za skolu profesora tipa Skola.
	 */
	public Profesor(long profesorID, String ime, String prezime, String email, Skola skola) {
		setProfesorID(profesorID);
		setIme(ime);
		setPrezime(prezime);
		setEmail(email);
		setSkola(skola);
	}
	/**
	 * Vraca ID profesora.
	 * 
	 * @return ID profesora kao Long.
	 */
	public long getProfesorID() {
		return profesorID;
	}
	/**
	 * Postavlja ID profesora.
	 * 
	 * @param profesorID kao vrednost za ID profesora.
	 */
	public void setProfesorID(long profesorID) {
		this.profesorID = profesorID;
	}
	/**
	 * Vraca ime profesora.
	 * 
	 * @return ime profesora kao String.
	 */
	public String getIme() {
		return ime;
	}
	/**
	 * Postavlja ime profesora.
	 * 
	 * @param ime kao vrednost za ime profesora.
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
	 * Vraca ime profesora.
	 * 
	 * @return ime profesora kao String.
	 */
	public String getPrezime() {
		return prezime;
	}
	/**
	 * Postavlja prezime profesora.
	 * 
	 * @param prezime kao vrednost za prezime profesora.
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
	 * Vraca email profesora.
	 * 
	 * @return email profesora kao String.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Postavlja email profesora.
	 * 
	 * @param email kao vrednost za email profesora. 
	 * 
	 * @throws NullPointerException ako je uneti email null.
	 * @throws IllegalArgumentException ako uneti email nije u dobrom formatu tj. ako ne sadrzi '@'.
	 */
	public void setEmail(String email) {
		if(email==null) throw new NullPointerException();
    	if(!email.contains("@")) throw new IllegalArgumentException();
    	this.email = email;
	}
	/**
	 * Vraca skolu u kojoj profesor radi.
	 * 
	 * @return skola profesora kao Skola.
	 */
	public Skola getSkola() {
		return skola;
	}
	/**
	 * Postavlja skolu u kojoj profesor radi.
	 * 
	 * @param skola kao vrednost za skolu profesora.
	 */
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
	
	/**
	 * Vraca string sa imenom i prezimenom profesora.
	 * 
	 * @return ime i prezime profesora kao String. 
	 */
	@Override
	public String toString() {
		return ime + " " + prezime;
	}


	
	

}
