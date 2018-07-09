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
	GridPane addGridPane(int language) {
		
		Label id = new Label("ID");
		Label model = new Label("Modell: ");
		Label admissionClass = new Label("Zulassungsklasse: ");
		Label manufacturer = new Label("Hersteller: ");
		Label constructionYear = new Label("Baujahr ");
		label.setFont((new Font("Arial", 15)));

		if (language==1)
		{
			id.setText("id");
			model.setText("model");
			admissionClass.setText("admission class");
			manufacturer.setText("manufacturer");
			constructionYear.setText("construction year");
		}
		
		gp.addRow(1, label);
		gp.addRow(2, id, idT);
		gp.addRow(3, model, modelT);
		gp.addRow(4, admissionClass, admissionClassT);
		gp.addRow(5, manufacturer, manufacturerT);
		gp.addRow(6, constructionYear, constructionYearT);

		return gp;
	}



	
}
