package fold_logic;

import java.util.LinkedList;
import java.util.List;


public class DrivinginstructorTO {
	
	private int id;
	private static int idcount = 1;
        
        private final String name;
	private final String firstname;
        
	private  Adress adress;
        
	private String adressAsString;
        
        private final int pLZ;
	private final String city;
	private final String street;
	private final int housenr;
        
        
	private int numStudents;
	private List<VehicleTO> licensedVehicles = new LinkedList<VehicleTO>();
	public String vehiclesAsString;
	

	public DrivinginstructorTO(String name, String firstname, Adress adress, VehicleTO licensedVehicle) {
		this.name=name;
		this.firstname=firstname;
		this.adress=adress;
		adressAsString=adress.toString();
		idcount++;
		this.id = idcount ;
                pLZ = adress.getPLZ();
                city = adress.getCity();
                street = adress.getStreet();
                housenr = adress.getHousenr();
		
		licensedVehicles.add(licensedVehicle);
		
		vehiclesAsString = vehicleIdsAsString();
	}
        
        
	public DrivinginstructorTO(String name, String firstname, Adress adress, int id) {
		this.name=name;
		this.firstname=firstname;
		this.adress=adress;
		adressAsString=adress.toString();
		this.id=id;
		pLZ = adress.getPLZ();
                city = adress.getCity();
                street = adress.getStreet();
                housenr = adress.getHousenr();
	}

        public DrivinginstructorTO(String name, String firstname, int pLZ, String city, String street, int housenr, int id)
        {
            this.name=name;
		this.firstname=firstname;
		//this.adress=adress;
		//adressAsString=adress.toString();
		this.id=id;
		this.pLZ = pLZ;
                this.city = city;
                this.street = street;
                this.housenr = housenr;
        } 

    DrivinginstructorTO(String name, String firstname, Adress adress, List<VehicleTO> licensedVehicles) 
    {
                this.name=name;
		this.firstname=firstname;
		this.adress=adress;
		adressAsString=adress.toString();
                idcount++;
		this.id = idcount ;
                pLZ = adress.getPLZ();
                city = adress.getCity();
                street = adress.getStreet();
                housenr = adress.getHousenr();
                this.licensedVehicles=licensedVehicles;
    }
        
        
        
        
	public void addZugelasseneKlasse(VehicleTO licensedVehicle) {
		licensedVehicles.add(licensedVehicle);
	}

	public int getnumStudents() {
		return numStudents;
	}
	

	public String getVehiclesAsString() {
		return vehiclesAsString;
	}

	

	
	public String vehicleIdsAsString() {
		String g = " ";
		for(VehicleTO h : licensedVehicles) {
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
        
        public String getName()
        {
            return name;
        }
        
        public String getFirstname()
        {
            return firstname;
        }
        
        public int getPLZ() {
		return pLZ;
	}

	

	public String getCity() {
		return city;
	}

	

	public String getStreet() {
		return street;
	}


	public int getHousenr() {
		return housenr;
	}
	

	public List<VehicleTO> getlicensedVehicles() {
		
		return licensedVehicles;
	}

	

}
