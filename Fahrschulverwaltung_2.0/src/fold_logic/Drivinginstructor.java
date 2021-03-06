package fold_logic;

import javafx.beans.InvalidationListener;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class Drivinginstructor extends Person {
	
	private int id;
	private static int idcount = 1;
	private int numStudents;
	private List<Vehicle> licensedVehicles = new LinkedList<Vehicle>();
	public String vehiclesAsString;
	public int sizeOflV = getlicensedVehicles().size();
	static final Logger debugLog = Logger.getLogger("debugLogger");
	static final Logger infoLog = Logger.getLogger("infoLogger");



	public Drivinginstructor(String name, String firstname, Adress adress, Vehicle licensedVehicle) {
		super(name, firstname, adress);
		idcount++;
		setId(idcount);
		
		licensedVehicles.add(licensedVehicle);
		
		vehiclesAsString = vehicleIdsAsString();
	}
        
        public Drivinginstructor(String name, String firstname, Adress adress) {
		super(name, firstname, adress);
		idcount++;
		setId(idcount);
	}
	
	public Drivinginstructor(String name, String firstname, Adress adress, int id) {
		super(name, firstname, adress);
		setId(id);
		
	}

	public void addZugelasseneKlasse(Vehicle licensedVehicle) {
		licensedVehicles.add(licensedVehicle);
	}

	public int getnumStudents() {
		return numStudents;
	}

	public void addStudent() {
		numStudents++;
	}
	
	public void deleteStudent() {
		numStudents--;
	}
	
	public void writeInFile() {
		String s = "Name: " + getName() + "\n Vorname: " + getFirstname() + " \n Adresse: \n PLZ: " + getAdress().getPLZ() + "\n Stadt: " + getAdress().getCity() + "\n Straße:  "
				+ getAdress().getStreet() + "\n Hausnummer: " + getAdress().getHousenr() + "\n Zugelassene Fahrezeuge:  " + vehiclesAsString;
		try (PrintWriter out = new PrintWriter(
				"C:\\Users\\Dani\\Documents\\Uni\\4.Semester\\SWT2\\Fahrschule\\Fahrlehrer\\" + getName() + ".txt")) {
			out.println(s);
		} catch (FileNotFoundException e) {
			debugLog.error("Cannot write in File", e);

		}

	}

	public String getVehiclesAsString() {
		return vehiclesAsString;
	}

	public void setVehiclesAsString(String vehiclesAsString) {
		this.vehiclesAsString = vehiclesAsString;
	}

	
	public String vehicleIdsAsString() {
		String g = " ";
		for(Vehicle h : licensedVehicles) {
			g = g + " " + h.getId();
		}
		return g;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	public List<Vehicle> getlicensedVehicles() {
		
		return licensedVehicles;
	}


    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
