package gUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Create_Student_GUI extends Student_GUI {

	Button create = new Button("Hinzufügen");

	public Create_Student_GUI() {
		label = new Label("Fahrschüler hinzufügen");
	}
	@Override
	VBox setButtons() {
		create.setPrefSize(75, 75);
		vb.getChildren().add(create);
		return vb;

	}

}
