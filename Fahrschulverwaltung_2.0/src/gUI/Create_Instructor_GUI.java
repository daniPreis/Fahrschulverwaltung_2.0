package gUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Create_Instructor_GUI extends Instructor_GUI {

    Button create = new Button("Hinzufügen");

    public Create_Instructor_GUI(int language) {

        label = new Label("Fahrlehrer hinzufügen");

        if (language==1){
            label.setText("add drivinginstructor");
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
