/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fold_logic;

/**
 *
 * @author Fabian
 */
public class DrivingstudentTO {
    
        private final String name;
	private final String firstname;
        
        private  Adress adress;
        
	private String adressAsString;
        
        private final int pLZ;
	private final String city;
	private final String street;
	private final int housenr;
        
        private String theoryPassed;
	private String praxisPassed;
	private int numTheLes;
	private int numPraLes;
	private int openAmounts = 0;
	private DrivinginstructorTO drivinginstructorTO;
	private String nameOfDrivinginstr;
	private String thPa;
	private String prPa;
        
        public DrivingstudentTO(String name, String firstname, Adress adress, int numTheLes, String theoryPassed,
			DrivinginstructorTO drivinginstructorTO, int numPraLes, String praxisPassed) 
        {
                this.name=name;
		this.firstname=firstname;
		this.adress=adress;
		adressAsString=adress.toString();
                this.drivinginstructorTO=drivinginstructorTO;
                pLZ = adress.getPLZ();
                city = adress.getCity();
                street = adress.getStreet();
                housenr = adress.getHousenr();
                
                this.numPraLes=numPraLes;
                this.numTheLes=numTheLes;
                this.theoryPassed=theoryPassed;
                this.praxisPassed=praxisPassed;
                
                
                
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
        
        public String isTheoryPassed() {
		return theoryPassed;
	}

	
	public String isPraxisPassed() {
		return praxisPassed;
	}

	

	public int getNumTheLes() {
		return numTheLes;
	}

	

	public int getNumPraLes() {
		return numPraLes;
	}

	

	public DrivinginstructorTO getDrivinginstructor() {
		return drivinginstructorTO;
	}


	public int getOpenAmounts() {
		return openAmounts;
	}


	public String getThPa() {
		return thPa;
	}

	

	public String getPrPa() {
		return prPa;
	}


	public String getNameOfDrivinginstr() {
		return nameOfDrivinginstr;
	}

}
