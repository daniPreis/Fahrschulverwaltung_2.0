package gUI;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public abstract class Instructor_GUI extends Object_GUI{

	
	
	TextField nameTI = new TextField("B");
	TextField surnameTI = new TextField("Test");
	TextField plZTI = new TextField("111");
	TextField cityTI = new TextField("Teststadt");
	TextField streetTI = new TextField("Teststraße");
	TextField houseNrTI = new TextField("12");
	TextField vehicleT1 = new TextField("A");
	TextField vehicleT2 = new TextField();
	TextField vehicleT3 = new TextField();
	
	@Override
	GridPane addGridPane(int language) {
		
		Label nameI = new Label("Name: ");
		Label surnameI = new Label("Vorname: ");
		Label plZI = new Label("PLZ: ");
		Label cityI = new Label("Wohnort: ");
		Label adressI = new Label("Adresse: ");
		Label streetI = new Label("Straße: ");
		Label houseNrI = new Label("Hausnummer: ");
		Label vehicleI1 = new Label("Zugewiesene Fahrzeuge: ");

		if (language==1)
		{
			nameI.setText("name");
			surnameI.setText("surname");
			plZI.setText("plz");
			cityI.setText("city");
			adressI.setText("adress");
			streetI.setText("street");
			houseNrI.setText("house number");
			vehicleI1.setText("vehicle");
		}

		gp.addRow(1, label);
		gp.addRow(2, nameI, nameTI);
		gp.addRow(3, surnameI, surnameTI);
		gp.addRow(4, adressI);
		gp.addRow(5, plZI, plZTI);
		gp.addRow(6, cityI, cityTI);
		gp.addRow(7, streetI, streetTI);
		gp.addRow(8, houseNrI, houseNrTI);
		gp.addRow(9, vehicleI1, vehicleT1);
		gp.add(vehicleT2, 1, 10);
		gp.add(vehicleT3, 1, 11);
		
		return gp;
	}

	
	
	

}
