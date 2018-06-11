package gUI;

import fold_logic.Drivinginstructor;
import fold_logic.Drivingstudent;
import fold_logic.Vehicle;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.converter.IntegerStringConverter;

public class Main_GUIs {

	BorderPane bpI = new BorderPane();
	Button addI = new Button("Neu");

	TableView<Drivinginstructor> tableI;
	MenuBar mbI;
	Menu dataI = new Menu("Datei");
	Menu home1I;
	Menu drivingstudent1I;
	Menu vehicle1I;
	MenuItem loadI = new MenuItem("Laden");
	MenuItem saveI = new MenuItem("Speichern");
	MenuItem homeI;
	MenuItem drivingstudentI;
	MenuItem vehicleI;

	BorderPane bpH = new BorderPane();
	MenuBar mbH = new MenuBar();
	Menu drivingstudentListmH = new Menu("Fahrschüler");
	Menu dtListmH = new Menu("Fahrlehrer");
	Menu vehiclesmH = new Menu("Fahrzeuge");
	MenuItem drivingstudentListeH = new Menu("Fahrschüler");
	MenuItem vehiclesH = new Menu("Fahrzeuge");
	Menu dtListH = new Menu("Fahrlehrer");
	MenuItem loadH = new MenuItem("Laden");
	MenuItem saveH = new MenuItem("Speichern");
	Menu dataH = new Menu("Datei");

	Button addVehicleH;
	Button adddrivingstudentH;
	Button adddrivingInstructorH;

	TableView<Drivingstudent> tableS;
	BorderPane bpS = new BorderPane();

	MenuBar mbS;
	Menu home1S;
	Menu drivinginstructor1S;
	Menu vehicles1S;
	MenuItem loadS = new MenuItem("Laden");
	MenuItem saveS = new MenuItem("Speichern");
	Menu dataS = new Menu("Datei");

	MenuItem homeS;
	MenuItem drivinginstructorS;
	MenuItem vehiclesS;

	Button addS;

	TableView<Vehicle> tableV;

	BorderPane bpV = new BorderPane();

	// MenüLeiste
	MenuBar mbV;
	Menu home1V;
	Menu drivingstudent1V;
	Menu drivingInstructor1V;
	MenuItem loadV = new MenuItem("Laden");
	MenuItem saveV = new MenuItem("Speichern");
	Menu dataV = new Menu("Datei");

	MenuItem homeV;
	MenuItem drivingstudentV;
	MenuItem drivingInstructorV;

	Button addV = new Button("Neu");
	
	

	public BorderPane createVhGUI(ObservableList<Vehicle> oLV) {

		mbV = new MenuBar();
		home1V = new Menu("Home");
		drivingstudent1V = new Menu("Fahrschüler");
		drivingInstructor1V = new Menu("Fahrlehrer");

		homeV = new MenuItem("Home");
		drivingstudentV = new MenuItem("Fahrschüler");
		drivingInstructorV = new MenuItem("Fahrlehrer");

		mbV.getMenus().add(dataV);
		mbV.getMenus().add(home1V);
		mbV.getMenus().add(drivingstudent1V);
		mbV.getMenus().add(drivingInstructor1V);

		dataV.getItems().add(saveV);
		dataV.getItems().add(loadV);
		home1V.getItems().add(homeV);
		drivingstudent1V.getItems().add(drivingstudentV);
		drivingInstructor1V.getItems().add(drivingInstructorV);
		bpV.setTop(mbV);

		tableV = new TableView<Vehicle>();
		// dataV = getInitialTableData();
		tableV.setItems(oLV);
		tableV.setPrefWidth(450);
		tableV.setPrefHeight(300);

		TableColumn<Vehicle, String> idColV = new TableColumn<Vehicle, String>("ID: ");
		idColV.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("id"));
		idColV.setMinWidth(150);

		TableColumn<Vehicle, String> modelCol = new TableColumn<Vehicle, String>("Modell");
		modelCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("model"));
		modelCol.setMinWidth(150);

		TableColumn<Vehicle, String> admissionClassCol = new TableColumn<Vehicle, String>("Zulassungsklasse");
		admissionClassCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("admissionClass"));
		admissionClassCol.setMinWidth(150);

		TableColumn<Vehicle, String> manufacturerCol = new TableColumn<Vehicle, String>("Hersteller");
		manufacturerCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("manufacturer"));
		manufacturerCol.setMinWidth(150);

		TableColumn<Vehicle, Integer> constructionYearCol = new TableColumn<Vehicle, Integer>("Baujahr");
		constructionYearCol.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("constructionYear"));
		constructionYearCol.setMinWidth(150);

		tableV.getColumns().addAll(idColV, modelCol, admissionClassCol, manufacturerCol, constructionYearCol);
		

		bpV.setCenter(tableV);
		addV.setPrefSize(50, 50);
		bpV.setRight(addV);

		return bpV;
	}

	public BorderPane createDSGUI(ObservableList<Drivingstudent> oLS) {
		bpS = new BorderPane();

		// MenüLeiste
		mbS = new MenuBar();
		home1S = new Menu("Home");
		drivinginstructor1S = new Menu("Fahrlehrer");
		vehicles1S = new Menu("Fahrzeug");

		homeS = new MenuItem("Home");
		drivinginstructorS = new MenuItem("Fahrlehrer");
		vehiclesS = new MenuItem("Fahrzeug");

		mbS.getMenus().add(dataS);
		mbS.getMenus().add(home1S);
		mbS.getMenus().add(drivinginstructor1S);
		mbS.getMenus().add(vehicles1S);
	
		dataS.getItems().add(saveS);
		dataS.getItems().add(loadS);
		home1S.getItems().add(homeS);
		drivinginstructor1S.getItems().add(drivinginstructorS);
		vehicles1S.getItems().add(vehiclesS);
		bpS.setTop(mbS);

		// TableView
		tableS = new TableView<Drivingstudent>();
		tableS.setItems(oLS);
		tableS.setPrefWidth(450);
		tableS.setPrefHeight(300);

		TableColumn<Drivingstudent, String> NameCol = new TableColumn<Drivingstudent, String>("Name");
		NameCol.setCellValueFactory(new PropertyValueFactory<Drivingstudent, String>("name"));
		NameCol.setMinWidth(150);

		TableColumn<Drivingstudent, String> firstNameCol = new TableColumn<Drivingstudent, String>("Vorname");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Drivingstudent, String>("firstname"));
		firstNameCol.setMinWidth(150);

		TableColumn<Drivingstudent, Integer> PLZCol = new TableColumn<Drivingstudent, Integer>("PLZ");
		PLZCol.setCellValueFactory(new PropertyValueFactory<Drivingstudent, Integer>("pLZ"));
		PLZCol.setMinWidth(150);
		PLZCol.setCellFactory(TextFieldTableCell.<Drivingstudent, Integer>forTableColumn(new IntegerStringConverter()));
		/*PLZCol.setOnEditCommit(new EventHandler<CellEditEvent<Drivingstudent, Integer>>() {
			@Override
			public void handle(CellEditEvent<Drivingstudent, Integer> evt) {
				Integer neuWert = evt.getNewValue();
				evt.getTableView().getItems().get(evt.getTablePosition().getRow()).getAdress().setPLZ(neuWert);
			}
		});*/

		TableColumn<Drivingstudent, String> CityCol = new TableColumn<Drivingstudent, String>("Stadt");
		CityCol.setCellValueFactory(new PropertyValueFactory<Drivingstudent, String>("city"));
		CityCol.setMinWidth(150);
		CityCol.setCellFactory(TextFieldTableCell.forTableColumn());
		/*CityCol.setOnEditCommit(new EventHandler<CellEditEvent<Drivingstudent, String>>() {
			@Override
			public void handle(CellEditEvent<Drivingstudent, String> t) {
				((Drivingstudent) t.getTableView().getItems().get(t.getTablePosition().getRow())).getAdress()
						.setCity(t.getNewValue());
			}
		});*/

		TableColumn<Drivingstudent, String> StreetCol = new TableColumn<Drivingstudent, String>("Straße");
		StreetCol.setCellValueFactory(new PropertyValueFactory<Drivingstudent, String>("street"));
		StreetCol.setMinWidth(150);
		StreetCol.setCellFactory(TextFieldTableCell.forTableColumn());
		/*StreetCol.setOnEditCommit(new EventHandler<CellEditEvent<Drivingstudent, String>>() {
			@Override
			public void handle(CellEditEvent<Drivingstudent, String> t) {
				((Drivingstudent) t.getTableView().getItems().get(t.getTablePosition().getRow())).getAdress()
						.setStreet(t.getNewValue());

			}
		});*/

		TableColumn<Drivingstudent, Integer> HouseNrCol = new TableColumn<Drivingstudent, Integer>("Hausnummer");
		HouseNrCol.setCellValueFactory(new PropertyValueFactory<Drivingstudent, Integer>("housenr"));
		HouseNrCol.setMinWidth(150);
		HouseNrCol.setCellFactory(
				TextFieldTableCell.<Drivingstudent, Integer>forTableColumn(new IntegerStringConverter()));
		/*HouseNrCol.setOnEditCommit(new EventHandler<CellEditEvent<Drivingstudent, Integer>>() {
			@Override
			public void handle(CellEditEvent<Drivingstudent, Integer> evt) {
				Integer newVal = evt.getNewValue();
				evt.getTableView().getItems().get(evt.getTablePosition().getRow()).getAdress().setHousenr(newVal);
			}
		});*/

		TableColumn<Drivingstudent, Integer> numThLeCol = new TableColumn<Drivingstudent, Integer>("anzTheorieStunden");
		numThLeCol.setCellValueFactory(new PropertyValueFactory<Drivingstudent, Integer>("numTheLes"));
		numThLeCol.setMinWidth(150);
		numThLeCol.setCellFactory(
				TextFieldTableCell.<Drivingstudent, Integer>forTableColumn(new IntegerStringConverter()));
		/*numThLeCol.setOnEditCommit(new EventHandler<CellEditEvent<Drivingstudent, Integer>>() {
			@Override
			public void handle(CellEditEvent<Drivingstudent, Integer> evt) {
				Integer newVal = evt.getNewValue();
				evt.getTableView().getItems().get(evt.getTablePosition().getRow()).setNumTheLes(newVal);
			}
		});*/

		TableColumn<Drivingstudent, String> ThPassedCol = new TableColumn<Drivingstudent, String>("theorieBestanden");
		ThPassedCol.setCellValueFactory(new PropertyValueFactory<Drivingstudent, String>("theoryPassed"));
		ThPassedCol.setMinWidth(150);
		ThPassedCol.setCellFactory(TextFieldTableCell.forTableColumn());
		/*ThPassedCol.setOnEditCommit(new EventHandler<CellEditEvent<Drivingstudent, String>>() {
			@Override
			public void handle(CellEditEvent<Drivingstudent, String> t) {
				((Drivingstudent) t.getTableView().getItems().get(t.getTablePosition().getRow())).getAdress()
						.setStreet(t.getNewValue());

			}
		});*/

		TableColumn<Drivingstudent, Integer> numPrLeCol = new TableColumn<Drivingstudent, Integer>("anzPraxisStunden");
		numPrLeCol.setCellValueFactory(new PropertyValueFactory<Drivingstudent, Integer>("numPraLes"));
		numPrLeCol.setMinWidth(150);
		numPrLeCol.setCellFactory(
				TextFieldTableCell.<Drivingstudent, Integer>forTableColumn(new IntegerStringConverter()));
		/*numPrLeCol.setOnEditCommit(new EventHandler<CellEditEvent<Drivingstudent, Integer>>() {
			@Override
			public void handle(CellEditEvent<Drivingstudent, Integer> evt) {
				Integer newVal = evt.getNewValue();
				evt.getTableView().getItems().get(evt.getTablePosition().getRow()).setNumPraLes(newVal);
			}
		});*/

		TableColumn<Drivingstudent, String> praPassedCol = new TableColumn<Drivingstudent, String>("praxisBestanden");
		praPassedCol.setCellValueFactory(new PropertyValueFactory<Drivingstudent, String>("praxisPassed"));
		praPassedCol.setMinWidth(150);
		praPassedCol.setCellFactory(TextFieldTableCell.forTableColumn());
		/*praPassedCol.setOnEditCommit(new EventHandler<CellEditEvent<Drivingstudent, String>>() {
			@Override
			public void handle(CellEditEvent<Drivingstudent, String> t) {
				((Drivingstudent) t.getTableView().getItems().get(t.getTablePosition().getRow())).getAdress()
						.setStreet(t.getNewValue());

			}
		});*/

		TableColumn<Drivingstudent, Drivinginstructor> drivinginstructor = new TableColumn<Drivingstudent, Drivinginstructor>(
				"Fahrlehrer");
		drivinginstructor
				.setCellValueFactory(new PropertyValueFactory<Drivingstudent, Drivinginstructor>("nameOfDrivinginstr"));
		drivinginstructor.setMinWidth(150);

		TableColumn<Drivingstudent, Integer> openAmountsCol = new TableColumn<Drivingstudent, Integer>(
				"Offene Beträge");
		openAmountsCol.setCellValueFactory(new PropertyValueFactory<Drivingstudent, Integer>("openAmounts"));
		openAmountsCol.setMinWidth(150);

		tableS.getColumns().setAll(NameCol, firstNameCol, PLZCol, CityCol, StreetCol, HouseNrCol, numThLeCol,
				ThPassedCol, numPrLeCol, praPassedCol, drivinginstructor, openAmountsCol);

		
		tableS.setEditable(true);
		bpS.setCenter(tableS);

		// Sonstiges
		addS = new Button("Neu");
		addS.setPrefSize(50, 50);
		bpS.setRight(addS);

		return bpS;
	}

	public BorderPane createHomeGUI() {

		// Menüleiste
		mbH.getMenus().add(dataH);
		mbH.getMenus().add(drivingstudentListmH);
		mbH.getMenus().add(dtListmH);
		mbH.getMenus().add(vehiclesmH);
		
		dataH.getItems().add(saveH);
		dataH.getItems().add(loadH);
		drivingstudentListmH.getItems().add(drivingstudentListeH);
		dtListmH.getItems().add(dtListH);
		vehiclesmH.getItems().add(vehiclesH);
		bpH.setTop(mbH);

		addVehicleH = new Button("Fahrzeug");

		addVehicleH.setPrefSize(100, 100);
		adddrivingstudentH = new Button("Fahrschüler");
		adddrivingstudentH.setPrefSize(100, 100);
		adddrivingInstructorH = new Button("Fahrlehrer");
		adddrivingInstructorH.setPrefSize(100, 100);

		VBox vb = new VBox();
		vb.setSpacing(50);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(addVehicleH, adddrivingstudentH, adddrivingInstructorH);

		BorderPane bp2 = new BorderPane();
		bp2.setCenter(vb);
		bpH.setRight(bp2);

		return bpH;
	}

	public BorderPane createDIGUI(ObservableList<Drivinginstructor> drivinginstructorlist) {

		mbI = new MenuBar();
		home1I = new Menu("Home");
		drivingstudent1I = new Menu("Fahrschüler");
		vehicle1I = new Menu("Fahrzeug");
		homeI = new MenuItem("Home");
		drivingstudentI = new MenuItem("Fahrschüler");
		vehicleI = new MenuItem("Fahrzeug");
		mbI.getMenus().add(dataI);
		mbI.getMenus().add(home1I);
		mbI.getMenus().add(drivingstudent1I);
		mbI.getMenus().add(vehicle1I);
		home1I.getItems().add(homeI);
		
		dataI.getItems().add(saveI);
		dataI.getItems().add(loadI);
		drivingstudent1I.getItems().add(drivingstudentI);
		vehicle1I.getItems().add(vehicleI);
		bpI.setTop(mbI);
		tableI = new TableView<Drivinginstructor>();
		// dataI = getInitialTableData();

		tableI.setPrefWidth(450);
		tableI.setPrefHeight(300);
		TableColumn<Drivinginstructor, String> nameColI = new TableColumn<Drivinginstructor, String>("Name");
		TableColumn<Drivinginstructor, String> firstnameColI = new TableColumn<Drivinginstructor, String>("Vorname");

		nameColI.setCellValueFactory(new PropertyValueFactory<Drivinginstructor, String>("name"));
		nameColI.setCellFactory(TextFieldTableCell.<Drivinginstructor>forTableColumn());
		nameColI.setMinWidth(150);
		nameColI.setCellFactory(TextFieldTableCell.forTableColumn());
	/*	nameColI.setOnEditCommit(new EventHandler<CellEditEvent<Drivinginstructor, String>>() {
			@Override
			public void handle(CellEditEvent<Drivinginstructor, String> t) {
				((Drivinginstructor) t.getTableView().getItems().get(t.getTablePosition().getRow()))
						.setName(t.getNewValue());
			}
		});*/

		firstnameColI.setCellValueFactory(new PropertyValueFactory<Drivinginstructor, String>("firstname"));
		firstnameColI.setMinWidth(150);

		TableColumn<Drivinginstructor, Integer> PLZCol = new TableColumn<Drivinginstructor, Integer>("PLZ");
		PLZCol.setCellValueFactory(new PropertyValueFactory<Drivinginstructor, Integer>("pLZ"));
		PLZCol.setCellFactory(
				TextFieldTableCell.<Drivinginstructor, Integer>forTableColumn(new IntegerStringConverter()));
		/*PLZCol.setOnEditCommit(new EventHandler<CellEditEvent<Drivinginstructor, Integer>>() {
			@Override
			public void handle(CellEditEvent<Drivinginstructor, Integer> evt) {
				Integer newVal = evt.getNewValue();
				evt.getTableView().getItems().get(evt.getTablePosition().getRow()).getAdress().setPLZ(newVal);
			}
		});*/

		TableColumn<Drivinginstructor, String> CityCol = new TableColumn<Drivinginstructor, String>("Stadt");
		CityCol.setCellValueFactory(new PropertyValueFactory<Drivinginstructor, String>("city"));
		CityCol.setCellFactory(TextFieldTableCell.forTableColumn());
		CityCol.setMinWidth(150);
		/*CityCol.setOnEditCommit(new EventHandler<CellEditEvent<Drivinginstructor, String>>() {
			@Override
			public void handle(CellEditEvent<Drivinginstructor, String> t) {
				((Drivinginstructor) t.getTableView().getItems().get(t.getTablePosition().getRow())).getAdress()
						.setCity(t.getNewValue());
			}
		});*/

		TableColumn<Drivinginstructor, String> StreetCol = new TableColumn<Drivinginstructor, String>("Straße");
		StreetCol.setCellValueFactory(new PropertyValueFactory<Drivinginstructor, String>("street"));
		StreetCol.setMinWidth(150);
		StreetCol.setCellFactory(TextFieldTableCell.forTableColumn());
		/*StreetCol.setOnEditCommit(new EventHandler<CellEditEvent<Drivinginstructor, String>>() {
			@Override
			public void handle(CellEditEvent<Drivinginstructor, String> t) {
				((Drivinginstructor) t.getTableView().getItems().get(t.getTablePosition().getRow())).getAdress()
						.setStreet(t.getNewValue());
			}
		});*/

		TableColumn<Drivinginstructor, Integer> HouseNrCol = new TableColumn<Drivinginstructor, Integer>("Hausnummer");
		HouseNrCol.setCellValueFactory(new PropertyValueFactory<Drivinginstructor, Integer>("housenr"));
		HouseNrCol.setMinWidth(150);
		HouseNrCol.setCellFactory(
				TextFieldTableCell.<Drivinginstructor, Integer>forTableColumn(new IntegerStringConverter()));
		/*HouseNrCol.setOnEditCommit(new EventHandler<CellEditEvent<Drivinginstructor, Integer>>() {
			@Override
			public void handle(CellEditEvent<Drivinginstructor, Integer> evt) {
				Integer newVal = evt.getNewValue();
				evt.getTableView().getItems().get(evt.getTablePosition().getRow()).getAdress().setPLZ(newVal);
			}
		});*/

		TableColumn<Drivinginstructor, String> vehicleColI = new TableColumn<Drivinginstructor, String>(
				"Zugelassene Fahrzeuge");
		vehicleColI.setCellValueFactory(new PropertyValueFactory<Drivinginstructor, String>("VehiclesAsString"));
		vehicleColI.setMinWidth(150);
		tableI.setItems(drivinginstructorlist);
		tableI.getColumns().addAll(nameColI, firstnameColI, PLZCol, CityCol, StreetCol, HouseNrCol, vehicleColI);
		tableI.setEditable(true);

		bpI.setCenter(tableI);
		addI.setPrefSize(50, 50);
		bpI.setRight(addI);
		return bpI;
	}
	
	
}
