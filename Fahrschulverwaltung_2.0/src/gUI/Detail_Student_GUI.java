package gUI;

import fold_logic.Adress;
import fold_logic.Drivingstudent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Detail_Student_GUI extends Student_GUI {

	Button save = new Button("Speichern");
	Button print = new Button("In Datei speichern");
	Drivingstudent rowData = new Drivingstudent("","",new Adress(0,"","",0),0,"",null, 0,"");

	public Detail_Student_GUI(int language) {

		if (language==1){
			save.setText("save");
			print.setText("save in file");
		}

		//drivinginstructorT = new TextField(rowData.getDrivinginstructor().getName());
	}

	@Override
	VBox setButtons() {

		save.setPrefSize(75, 75);
		print.setPrefSize(75, 75);
		vb.getChildren().addAll(print, save);

		return vb;
	}

	public void setDrivingstudent(Drivingstudent s) {
		this.rowData = s;
	}
}
