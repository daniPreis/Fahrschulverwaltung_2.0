package fold_logic;

import javafx.beans.InvalidationListener;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Drivingstudent extends Person{

	
	//Observer 
	//List<Observer> oL = new ArrayList<Observer>();
	private int state = 0;
	
	private String theoryPassed;
	private String praxisPassed;
	private int numTheLes;
	private int numPraLes;
	private int openAmounts = 0;
	private Drivinginstructor drivinginstructor;
	private String nameOfDrivinginstr;
	private String thPa;
	private String prPa;

	public Drivingstudent(String name, String firstname, Adress adress, int numTheLes, String theoryPassed,
			Drivinginstructor drivinginstructor, int numPraLes, String praxisPassed) {
		super(name, firstname, adress);
		this.setNumTheLes(numTheLes);
		this.setTheoryPassed(theoryPassed);
		this.setDrivinginstructor(drivinginstructor);
		this.setNumPraLes(numPraLes);
		openAmounts = numPraLes * 60;
		this.setPraxisPassed(praxisPassed);
		this.setOpenAmounts(openAmounts);
		if (drivinginstructor != null) {
			drivinginstructor.addStudent();
			nameOfDrivinginstr = drivinginstructor.getName();
		}

	}

	public String isTheoryPassed() {
		return theoryPassed;
	}

	public void setTheoryPassed(String theoryPassed) {
		this.theoryPassed = theoryPassed;

	}

	public String isPraxisPassed() {
		return praxisPassed;
	}

	public void setPraxisPassed(String praxisPassed) {
		this.praxisPassed = praxisPassed;
	}

	public int getNumTheLes() {
		return numTheLes;
	}

	public void setNumTheLes(int numTheLes) {
		this.numTheLes = numTheLes;
	}

	public int getNumPraLes() {
		return numPraLes;
	}

	public void setNumPraLes(int numPraLes) {
		this.numPraLes = numPraLes;
		openAmounts = numPraLes * 60;
	}

	public Drivinginstructor getDrivinginstructor() {
		return drivinginstructor;
	}

	public void setDrivinginstructor(Drivinginstructor drivinginstructor) {
		this.drivinginstructor = drivinginstructor;
	}

	public int getOpenAmounts() {
		return openAmounts;
	}

	public void setOpenAmounts(int openAmounts) {
		this.openAmounts = openAmounts;
	}

	public void writeInFile() {
		String s = "Name: " + getName() + "\n Vorname: " + getFirstname() + " \n Adresse: \n PLZ: "
				+ getAdress().getPLZ() + "\n Stadt: " + getAdress().getCity() + "\n Straäe:  " + getAdress().getStreet()
				+ "\n Hausnummer: " + getAdress().getHousenr() + "\n Abgelegte Theoriestunden: " + numTheLes
				+ "\n Theorie abgelegt: " + theoryPassed + "\n Fahrlehrer: " + drivinginstructor
				+ "\n Abgelegte Praxisstunden: " + numPraLes + "\n Praxis abgelegt: " + praxisPassed
				+ "\n OffeneBeträge: " + openAmounts;
		try (PrintWriter out = new PrintWriter(
				"C:\\Users\\Dani\\Documents\\Uni\\4.Semester\\SWT2\\Fahrschule\\Rechnungen\\" + getName() + ".txt")) {
			out.println(s);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public String getThPa() {
		return thPa;
	}

	public void setThPa(String thPa) {
		this.thPa = thPa;
	}

	public String getPrPa() {
		return prPa;
	}

	public void setPrPa(String prPa) {
		this.prPa = prPa;
	}

	public String getNameOfDrivinginstr() {
		return nameOfDrivinginstr;
	}

	public void setNameOfDrivinginstr(String nameOfDrivinginstr) {
		this.nameOfDrivinginstr = nameOfDrivinginstr;
	}


	@Override
	public void addListener(InvalidationListener listener) {

	}

	@Override
	public void removeListener(InvalidationListener listener) {

	}
}
