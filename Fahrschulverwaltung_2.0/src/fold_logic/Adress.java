package fold_logic;

public class Adress {

	private int pLZ;
	private String city;
	private String street;
	private int housenr;

	public Adress(int pLZ, String city, String street, int housenr) {
		this.setPLZ(pLZ);
		this.setCity(city);
		this.setStreet(street);
		this.setHousenr(housenr);
	}

	public int getPLZ() {
		return pLZ;
	}

	public void setPLZ(int pLZ) {
		this.pLZ = pLZ;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHousenr() {
		return housenr;
	}

	public void setHousenr(int housenr) {
		this.housenr = housenr;
	}

	public String toString() {
		return pLZ + " " + city + " " + street + " " + housenr;
	}
}
