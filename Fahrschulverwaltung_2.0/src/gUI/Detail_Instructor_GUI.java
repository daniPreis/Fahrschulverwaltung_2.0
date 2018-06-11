package gUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Detail_Instructor_GUI extends Instructor_GUI{

	Button save = new Button("Speichern");
	Button print = new Button("In Datei speichern");

	public Detail_Instructor_GUI() {
		label = new Label("Fahrlehrer bearbeiten");
	}

	@Override
	VBox setButtons() {

		save.setPrefSize(75, 75);
		print.setPrefSize(75, 75);
		vb.getChildren().addAll(print, save);
		
		return vb;
	}
	
	

}
