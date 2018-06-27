package gUI;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import javax.swing.JOptionPane;

import data_management.SaverAndLoader;
import fold_logic.Administration;
import fold_logic.Adress;
import fold_logic.Drivinginstructor;
import fold_logic.Drivingstudent;
import fold_logic.Vehicle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller extends Application {

    Scene home;
    Scene ds_GUI;
    Scene di_GUI;
    Scene vh_GUI;
    Scene addI_GUI;
    Scene addV_GUI;
    Scene addS_GUI;
    Scene detV_GUI;
    Scene detS_GUI;

    Administration admin = Administration.getInstance();
    SaverAndLoader sAL = new SaverAndLoader();

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Verknüpfung der GUIs
        Main_GUIs gui = new Main_GUIs();

        Create_Vehicle_GUI cV = new Create_Vehicle_GUI();
        Detail_Vehicle_GUI dV = new Detail_Vehicle_GUI();

        Create_Student_GUI cS = new Create_Student_GUI();
        Detail_Student_GUI dS = new Detail_Student_GUI();

        Create_Instructor_GUI cI = new Create_Instructor_GUI();
        Detail_Instructor_GUI dI = new Detail_Instructor_GUI();

        dV.label = new Label("Fahrzeug bearbeiten");
        dI.label = new Label("Fahrlehrer bearbeiten:");
        dS.label = new Label("Fahrschüler bearbeiten");
        detV_GUI = new Scene(dV.showDetails(),900,700);
        addI_GUI = new Scene(cI.showDetails(), 900, 700);
        detS_GUI = new Scene(dS.showDetails(), 900, 700);
        Scene detI_GUI = new Scene(dI.showDetails(), 900, 700);
        addV_GUI = new Scene(cV.showDetails(), 900, 700);


        addS_GUI = new Scene(cS.showDetails(), 900, 700);


        Stage addStage = new Stage();

        di_GUI = new Scene(gui.createDIGUI(admin.drivinginstructorlist), 900, 700);
        ds_GUI = new Scene(gui.createDSGUI(admin.studentList), 900, 700);
        vh_GUI = new Scene(gui.createVhGUI(admin.vehicles), 900, 700);
        home = new Scene(gui.createHomeGUI(), 900, 700);

        gui.drivingstudentListeH.setOnAction(e -> primaryStage.setScene(ds_GUI));
        gui.dtListH.setOnAction(e -> primaryStage.setScene(di_GUI));
        gui.vehiclesH.setOnAction(e -> primaryStage.setScene(vh_GUI));
        gui.adddrivingstudentH.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                addStage.setScene(addS_GUI);
                addStage.setTitle("Fahrschüler hinzufügen");
                addStage.show();
            }

        });
        gui.adddrivingInstructorH.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                addStage.setScene(addI_GUI);
                addStage.setTitle("Fahrlehrer hinzufügen");
                addStage.show();
            }

        });
        gui.addVehicleH.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                addStage.setScene(addV_GUI);
                addStage.setTitle("Fahrzeug hinzufügen");
                addStage.show();
            }

        });

        gui.drivinginstructorS.setOnAction(e -> primaryStage.setScene(di_GUI));
        gui.homeS.setOnAction(e -> primaryStage.setScene(home));
        gui.vehiclesS.setOnAction(e -> primaryStage.setScene(vh_GUI));
        gui.addS.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                addStage.setScene(addS_GUI);
                addStage.setTitle("Fahrschüler hinzufügen");
                addStage.show();
            }

        });

        gui.drivingstudentI.setOnAction(e -> primaryStage.setScene(ds_GUI));
        gui.homeI.setOnAction(e -> primaryStage.setScene(home));
        gui.vehicleI.setOnAction(e -> primaryStage.setScene(vh_GUI));
        gui.addI.setOnAction(e -> {
            addStage.setScene(addI_GUI);
            addStage.setTitle("Fahrlehrer hinzufügen");
            addStage.show();
        });

        gui.drivingInstructorV.setOnAction(e -> primaryStage.setScene(di_GUI));
        gui.homeV.setOnAction(e -> primaryStage.setScene(home));
        gui.drivingstudentV.setOnAction(e -> primaryStage.setScene(ds_GUI));
        gui.addV.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                addStage.setScene(addV_GUI);
                addStage.setTitle("Fahrzeug hinzufügen");
                addStage.show();
            }

        });

        // Verknüpfung GUI und Fachlogik

        gui.tableV.setRowFactory(tv -> {
            TableRow<Vehicle> row = new TableRow<Vehicle>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Vehicle rowData = row.getItem();
                    dV.rowData = rowData;
                    dV.label = new Label("Fahrzeug bearbeiten");
                    dV.idT = new TextField(rowData.getId());
                    dV.modelT = new TextField(rowData.getModel());
                    dV.constructionYearT = new TextField(Integer.toString(rowData.getConstructionYear()));
                    dV.admissionClassT = new TextField(rowData.getAdmissionClass());
                    dV.manufacturerT = new TextField(rowData.getManufacturer());

                    dV.updateView();

                    addStage.setScene(detV_GUI);
                    addStage.setTitle("Fahrzeug bearbeiten");
                    addStage.show();

                    for (Vehicle vehicle : admin.vehicles) {
                        if (vehicle.equals(rowData)) {
                            admin.vehicles.remove(vehicle);
                        }
                    }
                }
            });
            return row;
        });

        dV.save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                admin.vehicles.add(new Vehicle(cV.idT.getText(), cV.modelT.getText(), cV.admissionClassT.getText(),
                        cV.manufacturerT.getText(), Integer.parseInt(cV.constructionYearT.getText())));
                addStage.close();
            }
        });

        dV.print.setOnAction(e -> dV.rowData.writeInFile());

        gui.tableS.setRowFactory(tv -> {
            TableRow<Drivingstudent> row = new TableRow<Drivingstudent>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Drivingstudent rowData = (Drivingstudent) row.getItem();
                    dS.rowData = rowData;
                    dS.label = new Label("Fahrschüler bearbeiten");
                    dS.nameT = new TextField(rowData.getName());
                    dS.surnameT = new TextField(rowData.getFirstname());
                    dS.cityT = new TextField(rowData.getCity());
                    dS.plZT = new TextField(Integer.toString(rowData.getPLZ()));
                    dS.streetT = new TextField(rowData.getStreet());
                    dS.houseNrT = new TextField(Integer.toString(rowData.getHousenr()));
                    dS.numTheLesT = new TextField(Integer.toString(rowData.getNumTheLes()));
                    dS.theoryPassedT = new TextField(rowData.getThPa());
                    dS.numPraLesT = new TextField(rowData.getPrPa());


                    dS.updateView();
                    addStage.setScene(detS_GUI);
                    addStage.setTitle("Fahrschüler bearbeiten");
                    addStage.show();

                    for (Drivingstudent drivingstudent : admin.studentList) {
                        if (drivingstudent.equals(rowData)) {
                            admin.studentList.remove(drivingstudent);
                        }
                    }
                }
            });
            return row;
        });

        dS.print.setOnAction(e -> dS.rowData.writeInFile());

        dS.save.setOnAction(new EventHandler<ActionEvent>() {
            Drivinginstructor a = new Drivinginstructor("", "", new Adress(0, "", "", 0), 0);

            public void handle(ActionEvent e) {

                for (Drivinginstructor b : admin.drivinginstructorlist) {
                    if (b.getName().equals(cS.drivinginstructorT.getText()))
                        a = b;
                    else {
                        JOptionPane.showMessageDialog(null,
                                "Vorhandener Fahrlehrer nicht vorhanden, bitte vorhandenen Fahrlehrer eintragen");
                    }
                }
                admin.studentList.add(new Drivingstudent(cS.nameT.getText(), cS.surnameT.getText(),
                        new Adress(Integer.parseInt(cS.plZT.getText()), cS.cityT.getText(), cS.streetT.getText(),
                                Integer.parseInt(cS.houseNrT.getText())),
                        Integer.parseInt(cS.numTheLesT.getText()), cS.theoryPassedT.getText(), a,
                        Integer.parseInt(cS.numPraLesT.getText()), cS.praxisPassedT.getText()));
                JOptionPane.showMessageDialog(null,"Fahrschüler erfolgreich geändert");
                addStage.close();
            }
        });
        gui.tableI.setRowFactory(tv ->

        {
            TableRow<Drivinginstructor> row = new TableRow<Drivinginstructor>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Drivinginstructor rowData = row.getItem();

                    dI.rowData = rowData;
                    dI.label = new Label("Fahrlehrer bearbeiten");
                    dI.nameTI = new TextField(rowData.getName());
                    dI.surnameTI = new TextField(rowData.getFirstname());
                    dI.cityTI = new TextField(rowData.getCity());
                    dI.plZTI = new TextField(Integer.toString(rowData.getPLZ()));
                    dI.streetTI = new TextField(rowData.getStreet());
                    dI.houseNrTI = new TextField(Integer.toString(rowData.getHousenr()));
                    if (!rowData.getlicensedVehicles().isEmpty()) {
                        dI.vehicleT1 = new TextField(rowData.getlicensedVehicles().get(0).getId());
                    }
                    if (rowData.sizeOflV > 1) {
                        dI.vehicleT2 = new TextField(rowData.getlicensedVehicles().get(1).getId());
                    }
                    if (rowData.sizeOflV > 2) {
                        dI.vehicleT3 = new TextField(rowData.getlicensedVehicles().get(2).getId());
                    }


                    dI.updateView();
                    addStage.setScene(detI_GUI);
                    addStage.setTitle("Fahrlehrer bearbeiten");
                    addStage.show();
                    for (Drivinginstructor d : admin.drivinginstructorlist) {
                        if (d.getId() == rowData.getId()) {
                            admin.drivinginstructorlist.remove(d);
                        }
                    }
                }
            });
            return row;
        });


        dI.print.setOnAction(e -> dI.rowData.writeInFile());

        dI.save.setOnAction(new EventHandler<ActionEvent>()

        {

            Vehicle vh;
            Vehicle vh1;
            Vehicle vh2;

            public void handle(ActionEvent e) {
                for (Vehicle h : admin.vehicles) {
                    if (cI.vehicleT1.getText().equals(h.getId())) {
                        vh = h;
                    } else {
                        // JOptionPane.showMessageDialog(null,
                        // "Fahrzeug nicht vorhanden. Bitte tragen sie ein vorhandenes Fahrzeug ein");
                    }
                }
                Drivinginstructor b = new Drivinginstructor(
                        cI.nameTI.getText(), cI.surnameTI.getText(), new Adress(Integer.parseInt(cI.plZTI.getText()),
                        cI.cityTI.getText(), cI.streetTI.getText(), Integer.parseInt(cI.houseNrTI.getText())),
                        vh);

                for (Vehicle h : admin.vehicles) {
                    if (cI.vehicleT2.getText().equals(h.getId())) {
                        vh1 = h;
                        b.addZugelasseneKlasse(vh1);
                    } else {
                        // JOptionPane.showMessageDialog(null, "Fahrzeug nicht vorhanden. Bitte tragen sie ein vorhandenes Fahrzeug ein");
                    }
                }
                for (Vehicle h : admin.vehicles) {
                    if (cI.vehicleT3.getText().equals(h.getId())) {
                        vh2 = h;
                        b.addZugelasseneKlasse(vh2);
                    } else {
                        // JOptionPane.showMessageDialog(null, "Fahrzeug nicht vorhanden. Bitte tragen sie ein vorhandenes Fahrzeug ein");
                    }
                }
                admin.drivinginstructorlist.add(b);
                JOptionPane.showMessageDialog(null, "Fahrlehrer erfolgreich geändert");
                addStage.close();
            }
        });

        gui.saveH.setOnAction(new EventHandler<ActionEvent>()

        {

            public void handle(ActionEvent e) {

                sAL.save(admin.vehicles, admin.drivinginstructorlist, admin.studentList);
                JOptionPane.showMessageDialog(null,"Speichern erfolgreich");
            }


        });

        gui.saveV.setOnAction(new EventHandler<ActionEvent>()

        {

            public void handle(ActionEvent e) {

               try {
                   sAL.save(admin.vehicles, admin.drivinginstructorlist, admin.studentList);
                   JOptionPane.showMessageDialog(null, "Speichern erfolgreich");
               }catch (Exception z){
                   JOptionPane.showMessageDialog(null, "Speichern fehlgeschlagen");
               }
            }
        });

        gui.saveI.setOnAction(new EventHandler<ActionEvent>()

        {

            public void handle(ActionEvent e) {

              try {
                  sAL.save(admin.vehicles, admin.drivinginstructorlist, admin.studentList);
                  JOptionPane.showMessageDialog(null, "Speichern erfolgreich");
              }catch (Exception z){
                  JOptionPane.showMessageDialog(null, "Speichern fehlgeschlagen");
              }
            }
        });

        gui.saveS.setOnAction(new EventHandler<ActionEvent>()

        {

            public void handle(ActionEvent e) {

                try {
                    sAL.save(admin.vehicles, admin.drivinginstructorlist, admin.studentList);
                    JOptionPane.showMessageDialog(null, "Speichern erfolgreich");
                }catch (Exception z){
                    JOptionPane.showMessageDialog(null, "Speichern fehlgeschlagen");
                }
            }
        });

        cS.create.setOnAction(new EventHandler<ActionEvent>()

        {

            Drivinginstructor a = new Drivinginstructor("", "", new Adress(0, "", "", 0), 0);

            public void handle(ActionEvent e) {

                for (Drivinginstructor b : admin.drivinginstructorlist) {
                    if (b.getName().equals(cS.drivinginstructorT.getText()))
                        a = b;
                    else {
                        JOptionPane.showMessageDialog(null,
                                "Vorhandener Fahrlehrer nicht vorhanden, bitte vorhandenen Fahrlehrer eintragen");
                    }
                }
                admin.studentList.add(new Drivingstudent(cS.nameT.getText(), cS.surnameT.getText(),
                        new Adress(Integer.parseInt(cS.plZT.getText()), cS.cityT.getText(), cS.streetT.getText(),
                                Integer.parseInt(cS.houseNrT.getText())),
                        Integer.parseInt(cS.numTheLesT.getText()), cS.theoryPassedT.getText(), a,
                        Integer.parseInt(cS.numPraLesT.getText()), cS.praxisPassedT.getText()));
                JOptionPane.showMessageDialog(null,"Student erfolgreich hinzugefügt");
                addStage.close();
            }
        });

        cI.create.setOnAction(new EventHandler<ActionEvent>()

        {

            Vehicle vh;
            Vehicle vh1;
            Vehicle vh2;

            public void handle(ActionEvent e) {
                for (Vehicle h : admin.vehicles) {
                    if (cI.vehicleT1.getText().equals(h.getId())) {
                        vh = h;
                    } else {
                        // JOptionPane.showMessageDialog(null,
                        // "Fahrzeug nicht vorhanden. Bitte tragen sie ein vorhandenes Fahrzeug ein");
                    }
                }
                Drivinginstructor b = new Drivinginstructor(
                        cI.nameTI.getText(), cI.surnameTI.getText(), new Adress(Integer.parseInt(cI.plZTI.getText()),
                        cI.cityTI.getText(), cI.streetTI.getText(), Integer.parseInt(cI.houseNrTI.getText())),
                        vh);

                for (Vehicle h : admin.vehicles) {
                    if (cI.vehicleT2.getText().equals(h.getId())) {
                        vh1 = h;
                        b.addZugelasseneKlasse(vh1);
                    } else {
                        // JOptionPane.showMessageDialog(null, "Fahrzeug nicht vorhanden. Bitte tragen sie ein vorhandenes Fahrzeug ein");
                    }
                }
                for (Vehicle h : admin.vehicles) {
                    if (cI.vehicleT3.getText().equals(h.getId())) {
                        vh2 = h;
                        b.addZugelasseneKlasse(vh2);
                    } else {
                        // JOptionPane.showMessageDialog(null, "Fahrzeug nicht vorhanden. Bitte tragen sie ein vorhandenes Fahrzeug ein");
                    }
                }
                admin.drivinginstructorlist.add(b);
                JOptionPane.showMessageDialog(null,"Fahrlehrer erfolgreich hinzugefügt");
                addStage.close();
            }
        });

        cV.create.setOnAction(new EventHandler<ActionEvent>()

        {

            public void handle(ActionEvent e) {
                admin.vehicles.add(new Vehicle(cV.idT.getText(), cV.modelT.getText(), cV.admissionClassT.getText(),
                        cV.manufacturerT.getText(), Integer.parseInt(cV.constructionYearT.getText())));
                JOptionPane.showMessageDialog(null,"Fahrzeug erfolgreich hinzugefügt");
                addStage.close();
            }

        });


        gui.loadH.setOnAction(new EventHandler<ActionEvent>()

        {
            public void handle(ActionEvent e) {
                sAL.load(admin.vehicles, admin.drivinginstructorlist, admin.studentList);
                JOptionPane.showMessageDialog(null, "Laden erfolgreich");
            }
        });

        primaryStage.setScene(home);
        primaryStage.setTitle("Fahrschulverwaltung");
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch();
    }

}
