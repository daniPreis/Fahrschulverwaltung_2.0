package gUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public abstract class Object_GUI {

	// Dinge die ich noch brauche
	BorderPane bp = new BorderPane();
	GridPane gp = new GridPane();
	VBox vb = new VBox();
	Label label;


	abstract GridPane addGridPane();

	abstract VBox setButtons();

	public BorderPane showDetails() {

		bp.setPadding(new Insets(20));

		GridPane gp = addGridPane();
		gp.setVgap(20);
		gp.setHgap(40);

		VBox vb = setButtons();
		vb.setSpacing(50);
		vb.setPadding(new Insets(20));

		bp.setRight(vb);
		bp.setCenter(gp);

		return bp;
	}

}
