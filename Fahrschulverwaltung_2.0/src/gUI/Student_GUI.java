package gUI;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public abstract class Student_GUI extends Object_GUI{

	TextField nameT = new TextField("C");
	TextField surnameT = new TextField("Test");
	TextField plZT = new TextField("111");
	TextField cityT = new TextField("Teststadt");
	TextField streetT = new TextField("Teststraße");
	TextField houseNrT = new TextField("12");
	TextField theoryPassedT = new TextField("Ja");
	TextField praxisPassedT = new TextField("Ja");
	TextField numTheLesT = new TextField("12");
	TextField numPraLesT = new TextField("12");
	TextField drivinginstructorT = new TextField("B");

	@Override
	GridPane addGridPane(int language) {
		Label name = new Label("Name: ");
		Label surname = new Label("Vorname: ");
		Label plZ = new Label("PLZ: ");
		Label city = new Label("Wohnort: ");
		Label adress = new Label("Adresse: ");
		Label street = new Label("Straße: ");
		Label houseNr = new Label("Hausnummer: ");
		Label theoryPassed = new Label("Theorie absolviert: ");
		Label praxisPassed = new Label("Praxis absolviert: ");
		Label numTheLes = new Label("Anzahl Theoriestunden: ");
		Label numPraLes = new Label("Anzahl Praxisstunden: ");
		Label drivinginstructor = new Label("Fahrlehrer:  ");

		if (language==1) {
			name.setText("name");
			surname.setText("surname");
			plZ.setText("PLZ");
			city.setText("city");
			adress.setText("adress");
			street.setText("street");
			houseNr.setText("housenr");
			theoryPassed.setText("theory passed");
			praxisPassed.setText("praxis passed");
			numTheLes.setText("amount of theory lessons");
			numPraLes.setText("amount of praxis lessons");
			drivinginstructor.setText("drivinginstructor");
		}

		gp.addRow(1, label);
		gp.addRow(2, name, nameT);
		gp.addRow(3, surname, surnameT);
		gp.addRow(4, adress);
		gp.addRow(5, plZ, plZT);
		gp.addRow(6, city, cityT);
		gp.addRow(7, street, streetT);
		gp.addRow(8, houseNr, houseNrT);
		gp.addRow(9, theoryPassed, theoryPassedT);
		gp.addRow(10, praxisPassed, praxisPassedT);
		gp.addRow(11, numTheLes, numTheLesT);
		gp.addRow(12, numPraLes, numPraLesT);
		gp.addRow(13, drivinginstructor, drivinginstructorT);

		return gp;
	}

	
	
	

}
