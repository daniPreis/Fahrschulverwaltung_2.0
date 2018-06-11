package gUI;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public abstract class Vehicle_GUI extends Object_GUI {


	TextField idT = new TextField("A");
	TextField modelT = new TextField("Test");
	TextField admissionClassT = new TextField("Test");
	TextField manufacturerT = new TextField("Test");
	TextField constructionYearT = new TextField("12");
	
	
	
	@Override
	GridPane addGridPane() {
		
		Label id = new Label("ID");
		Label model = new Label("Modell: ");
		Label admissionClass = new Label("Zulassungsklasse: ");
		Label manufacturer = new Label("Hersteller: ");
		Label constructionYear = new Label("Baujahr ");
		label.setFont((new Font("Arial", 15)));
		
		gp.addRow(1, label);
		gp.addRow(2, id, idT);
		gp.addRow(3, model, modelT);
		gp.addRow(4, admissionClass, admissionClassT);
		gp.addRow(5, manufacturer, manufacturerT);
		gp.addRow(6, constructionYear, constructionYearT);

		return gp;
	}



	
}
