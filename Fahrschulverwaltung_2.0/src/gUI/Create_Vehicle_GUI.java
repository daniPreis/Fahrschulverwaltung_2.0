package gUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Create_Vehicle_GUI extends Vehicle_GUI {

	Button create = new Button("Hinzufügen");

	public Create_Vehicle_GUI() {
		label = new Label("Neues Fahrzeug hinzufügen");
	}

	@Override
	VBox setButtons() {
		create.setPrefSize(75, 75);
		vb.getChildren().add(create);
		return vb;
	}

}
