package gUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Create_Instructor_GUI extends Instructor_GUI {

    Button create = new Button("Hinzufügen");

    public Create_Instructor_GUI() {
        label = new Label("Fahrlehrer hinzufügen");
    }

    @Override
    VBox setButtons() {
        create.setPrefSize(75, 75);
        vb.getChildren().add(create);
        return vb;
    }


}
