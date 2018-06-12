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

	public Detail_Student_GUI() {
		label = new Label("Fahrschüler bearbeiten");
		nameT= new TextField(rowData.getName());
		surnameT = new TextField(rowData.getFirstname());
		cityT = new TextField(rowData.getCity());
		plZT = new TextField(Integer.toString(rowData.getPLZ()));
		streetT = new TextField(rowData.getStreet());
		houseNrT = new TextField(Integer.toString(rowData.getHousenr()));
		numTheLesT = new TextField(Integer.toString(rowData.getNumTheLes()));
		theoryPassedT = new TextField(rowData.getThPa());
		numPraLesT = new TextField(rowData.getPrPa());
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
