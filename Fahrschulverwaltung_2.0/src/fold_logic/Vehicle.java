package fold_logic;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;

public class  Vehicle implements Observable {
	
	private String id;
	private String model;
	private String admissionClass;
	private String manufacturer;
	private int constructionYear;
	
	public  Vehicle(String id,String model, String admissionClass, String manufacturer, int constructionYear) {
		this.setId(id);
		this.setModel(model);
		this.setAdmissionClass(admissionClass);
		this.setManufacturer(manufacturer);
		this.setConstructionYear(constructionYear);
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String getModel() {
		return model;
	}

	public String getAdmissionClass() {
		return admissionClass;
	}

	public void setAdmissionClass(String admissionClass) {
		this.admissionClass = admissionClass;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getConstructionYear() {
		return constructionYear;
	}

	public void setConstructionYear(int constructionYear) {
		this.constructionYear = constructionYear;
	}



	public void writeInFile() {
		String s = "ID: "+ id + "\n" + "Modell: " + " " + model + "\n"+ "Zulassungsklasse: " + admissionClass + "\n" + "Hersteller: " + manufacturer + " \n" +"Baujahr: " + constructionYear;
		try(PrintWriter out = new PrintWriter("C:\\Users\\Dani\\Documents\\Uni\\4.Semester\\SWT2\\Fahrschule\\Fahrzeuge\\" + id + ".txt")) {
			out.println(s);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Override
	public void addListener(InvalidationListener listener) {

	}

	@Override
	public void removeListener(InvalidationListener listener) {

	}
}
