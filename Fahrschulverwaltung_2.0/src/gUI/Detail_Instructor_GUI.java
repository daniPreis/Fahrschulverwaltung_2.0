package gUI;

import fold_logic.Adress;
import fold_logic.Drivinginstructor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Detail_Instructor_GUI extends Instructor_GUI {

    Button save = new Button("Speichern");
    Button print = new Button("In Datei speichern");
    Drivinginstructor rowData = new Drivinginstructor("", "", new Adress(0, "", "", 0));

    public Detail_Instructor_GUI() {
        label = new Label("Fahrlehrer bearbeiten");
        nameTI = new TextField(rowData.getName());
        surnameTI = new TextField(rowData.getFirstname());
        cityTI = new TextField(rowData.getCity());
        plZTI = new TextField(Integer.toString(rowData.getPLZ()));
        streetTI = new TextField(rowData.getStreet());
        houseNrTI = new TextField(Integer.toString(rowData.getHousenr()));


        if (!rowData.getlicensedVehicles().isEmpty()) {
            vehicleT1 = new TextField(rowData.getlicensedVehicles().get(1).getId());
        }
        if (rowData.sizeOflV > 1) {
            vehicleT2 = new TextField(rowData.getlicensedVehicles().get(2).getId());
        }
        if (rowData.sizeOflV > 2) {
            vehicleT3 = new TextField(rowData.getlicensedVehicles().get(3).getId());
        }

        vehicleT2 = new TextField();
        vehicleT3 = new TextField();

    }

    @Override
    VBox setButtons() {

        save.setPrefSize(75, 75);
        print.setPrefSize(75, 75);
        vb.getChildren().addAll(print, save);

        return vb;
    }


    public void setDrivinginstructor(Drivinginstructor i) {
        this.rowData = i;
    }


}
