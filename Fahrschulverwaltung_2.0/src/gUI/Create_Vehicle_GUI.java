package gUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Create_Vehicle_GUI extends Vehicle_GUI {

	Button create = new Button("Hinzufügen");


	public Create_Vehicle_GUI(int language) {

		label = new Label("Neues Fahrzeug hinzufügen");
		if(language==1){
			label.setText("add new vehicle");
			create.setText("add");
		}
	}

	@Override
	VBox setButtons() {
		create.setPrefSize(75, 75);
		vb.getChildren().add(create);
		return vb;
	}

}
