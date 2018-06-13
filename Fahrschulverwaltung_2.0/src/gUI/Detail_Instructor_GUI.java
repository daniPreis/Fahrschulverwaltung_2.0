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
  // Drivinginstructor rowData = new Drivinginstructor("", "", new Adress(0, "", "", 0));

    public Detail_Instructor_GUI() {

        label = new Label("Fahrlehrer bearbeiten");

    }


   public void changeView(Drivinginstructor drivinginstructor){




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




}
