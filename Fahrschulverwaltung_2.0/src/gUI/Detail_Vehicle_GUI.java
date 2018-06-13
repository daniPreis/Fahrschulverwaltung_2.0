package gUI;

import fold_logic.Vehicle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Detail_Vehicle_GUI extends Vehicle_GUI {

	Button save = new Button("Speichern");
	Button print = new Button("In Datei speichern");
	Vehicle rowData = new Vehicle("","","","",0);


	@Override
	VBox setButtons() {

		save.setPrefSize(75, 75);
		print.setPrefSize(75, 75);
		vb.getChildren().addAll(print, save);

		return vb;
	}

	public void setVehicle(Vehicle v) {
		this.rowData = v;
	}
}
