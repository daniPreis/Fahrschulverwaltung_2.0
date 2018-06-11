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
public class VehicleTO {
	
	private String id;
	private String model;
	private String admissionClass;
	private String manufacturer;
	private int constructionYear;
	
	public  VehicleTO(String id,String model, String admissionClass, String manufacturer, int constructionYear) {
		
            this.id=id;
            this.model=model;
            this.admissionClass=admissionClass;
            this.manufacturer=manufacturer;
            this.constructionYear=constructionYear;
            
	}

	
	
	public String getModel() {
		return model;
	}

	public String getAdmissionClass() {
		return admissionClass;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public int getConstructionYear() {
		return constructionYear;
	}


	public String getId() {
		return id;
	}

	
	
}