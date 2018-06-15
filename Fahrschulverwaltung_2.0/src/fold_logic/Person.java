package fold_logic;

import javafx.beans.Observable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public abstract class Person implements Observable {

	private String name;
	private String firstname;
	private  Adress adress;
	private String adressAsString;

	public Person(String name, String firstname, Adress adress) {
		this.setName(name);
		this.setFirstname(firstname);
		this.setAdress(adress);
		setAdressAsString(adress.toString());
	}


	public int getPLZ() {
		return adress.getPLZ();
	}
	
	public String getCity() {
		return adress.getCity();
	}
	
	public String getStreet() {
		return adress.getStreet();
	}
	
	public int getHousenr() {
		return adress.getHousenr();
	}
	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void writeInFile() {
		String s = name + " " + firstname + " " + adress.getPLZ() + adress.getCity() + adress.getStreet()
		+ adress.getHousenr();
		try (PrintWriter out = new PrintWriter(
				"C:\\Users\\Dani\\Documents\\Uni\\4. Semester\\SWT2\\Fahrschule\\Fahrzeuge\\" + getName() + ".txt")) {
			out.println(s);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
	public String getAdressAsString() {
		return adressAsString;
	}

	public void setAdressAsString(String adressAsString) {
		this.adressAsString = adressAsString;
	}
	
	
}
