package gUI;

import data_management.SaverAndLoader;
import fold_logic.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import javax.swing.*;

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
    static int language=0;

    Administration admin = Administration.getInstance();
    SaverAndLoader sAL = new SaverAndLoader();


    static final Logger debugLog = Logger.getLogger("debugLogger");
    static final Logger infoLog = Logger.getLogger("infoLogger");

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Verknüpfung der GUIs
        Main_GUIs gui = new Main_GUIs();

        Create_Vehicle_GUI cV = new Create_Vehicle_GUI(language);
        Detail_Vehicle_GUI dV = new Detail_Vehicle_GUI(language);

        Create_Student_GUI cS = new Create_Student_GUI(language);
        Detail_Student_GUI dS = new Detail_Student_GUI(language);

        Create_Instructor_GUI cI = new Create_Instructor_GUI(language);
        Detail_Instructor_GUI dI = new Detail_Instructor_GUI(language);

        dV.label = new Label("Fahrzeug bearbeiten");
        dI.label = new Label("Fahrlehrer bearbeiten:");
        dS.label = new Label("Fahrschüler bearbeiten");
        if(language==1)
        {
            dV.label.setText("edit vehicle");
            dI.label.setText("edit drivinginstructor");
            dS.label.setText("edit drivingstudent");
        }
        detV_GUI = new Scene(dV.showDetails(language), 900, 700);
        addI_GUI = new Scene(cI.showDetails(language), 900, 700);
        detS_GUI = new Scene(dS.showDetails(language), 900, 700);
        Scene detI_GUI = new Scene(dI.showDetails(language), 900, 700);
        addV_GUI = new Scene(cV.showDetails(language), 900, 700);


        addS_GUI = new Scene(cS.showDetails(language), 900, 700);

        Stage addStage = new Stage();

        di_GUI = new Scene(gui.createDIGUI(admin.drivinginstructorlist,language), 900, 700);
        ds_GUI = new Scene(gui.createDSGUI(admin.studentList,language), 900, 700);
        vh_GUI = new Scene(gui.createVhGUI(admin.vehicles,language), 900, 700);
        home = new Scene(gui.createHomeGUI(language), 900, 700);

        gui.drivingstudentListeH.setOnAction(e -> primaryStage.setScene(ds_GUI));
        gui.dtListH.setOnAction(e -> primaryStage.setScene(di_GUI));
        gui.vehiclesH.setOnAction(e -> primaryStage.setScene(vh_GUI));
        gui.adddrivingstudentH.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                addStage.setScene(addS_GUI);
                addStage.setTitle("Fahrschüler hinzufügen");
                if (language==1)
                    addStage.setTitle("add drivingstudent");
                addStage.show();
            }

        });
        gui.adddrivingInstructorH.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                addStage.setScene(addI_GUI);
                addStage.setTitle("Fahrlehrer hinzufügen");
                if (language==1)
                    addStage.setTitle("add drivinginstructor");
                addStage.show();
            }

        });
        gui.addVehicleH.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                addStage.setScene(addV_GUI);
                addStage.setTitle("Fahrzeug hinzufügen");
                if (language==1)
                    addStage.setTitle("add vehicle");
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
                if (language==1)
                    addStage.setTitle("add drivingstudent");
                addStage.show();
            }

        });

        gui.drivingstudentI.setOnAction(e -> primaryStage.setScene(ds_GUI));
        gui.homeI.setOnAction(e -> primaryStage.setScene(home));
        gui.vehicleI.setOnAction(e -> primaryStage.setScene(vh_GUI));
        gui.addI.setOnAction(e -> {
            addStage.setScene(addI_GUI);
            addStage.setTitle("Fahrlehrer hinzufügen");
            if (language==1)
                addStage.setTitle("add drivinginstructor");
            addStage.show();
        });

        gui.drivingInstructorV.setOnAction(e -> primaryStage.setScene(di_GUI));
        gui.homeV.setOnAction(e -> primaryStage.setScene(home));
        gui.drivingstudentV.setOnAction(e -> primaryStage.setScene(ds_GUI));
        gui.addV.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                addStage.setScene(addV_GUI);
                addStage.setTitle("Fahrzeug hinzufügen");
                if (language==1)
                    addStage.setTitle("add vehicle");
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
                    if (language==1){
                        dV.label.setText("edit vehicle");
                    }
                    dV.idT = new TextField(rowData.getId());
                    dV.modelT = new TextField(rowData.getModel());
                    dV.constructionYearT = new TextField(Integer.toString(rowData.getConstructionYear()));
                    dV.admissionClassT = new TextField(rowData.getAdmissionClass());
                    dV.manufacturerT = new TextField(rowData.getManufacturer());

                    dV.updateView();

                    addStage.setScene(detV_GUI);
                    addStage.setTitle("Fahrzeug bearbeiten");
                    if (language==1){
                        addStage.setTitle("edit vehicle");
                    }
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
                try {
                    admin.vehicles.add(new Vehicle(cV.idT.getText(), cV.modelT.getText(), cV.admissionClassT.getText(),
                            cV.manufacturerT.getText(), Integer.parseInt(cV.constructionYearT.getText())));
                    infoLog.info(String.format("Fahrzeug bearbeitet: %s%s%s%s%d", cV.idT.getText(), cV.modelT.getText(), cV.admissionClassT.getText(), cV.manufacturerT.getText(), Integer.parseInt(cV.constructionYearT.getText())));

                    addStage.close();
                } catch (Exception e) {
                    debugLog.error("Vehicle edit failed: ", e);
                }
            }
        });

        dV.print.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dV.rowData.writeInFile();
                    //logger.info(String.format("In File %s", dV.rowData.getId()));
                } catch (Exception e) {
                    //logger.error("Write in File failed", e);
                }
            }
        });

        gui.tableS.setRowFactory(tv -> {
            TableRow<Drivingstudent> row = new TableRow<Drivingstudent>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Drivingstudent rowData = (Drivingstudent) row.getItem();
                    dS.rowData = rowData;
                    dS.label = new Label("Fahrschüler bearbeiten");
                    if (language==1){
                        dS.label.setText("edit drivingstudent");
                    }
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
                    if (language==1){
                        addStage.setTitle("edit drivingstudent");
                    }
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

        dS.print.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dS.rowData.writeInFile();
                    //logger.info(String.format("Drivingstudent in File %s", dS.rowData.getName()));
                } catch (Exception e) {
                    //logger.error("Write in File failed: ", e);
                }
            }
        });

        dS.save.setOnAction(new EventHandler<ActionEvent>() {
            Drivinginstructor a = new Drivinginstructor("", "", new Adress(0, "", "", 0), 0);

            public void handle(ActionEvent e) {

                if (cS.nameT.getText() != null && cS.surnameT.getText() != null &&
                        cS.plZT.getText() != null && cS.cityT.getText() != null && cS.streetT.getText() != null
                        && cS.houseNrT.getText() != null && cS.numTheLesT.getText() != null && cS.numPraLesT.getText() != null && cS.theoryPassedT.getText() != null
                        && cS.praxisPassedT.getText() != null) {
                    for (Drivinginstructor b : admin.drivinginstructorlist) {

                        if (b.getName().equals(cS.drivinginstructorT.getText())) {
                            a = b;
                            admin.studentList.add(new Drivingstudent(cS.nameT.getText(), cS.surnameT.getText(),
                                    new Adress(Integer.parseInt(cS.plZT.getText()), cS.cityT.getText(), cS.streetT.getText(),
                                            Integer.parseInt(cS.houseNrT.getText())),
                                    Integer.parseInt(cS.numTheLesT.getText()), cS.theoryPassedT.getText(), a,
                                    Integer.parseInt(cS.numPraLesT.getText()), cS.praxisPassedT.getText()));
                            if (language==0) {

                                JOptionPane.showMessageDialog(null, "Fahrschüler erfolgreich geändert");
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "student edit success");
                            }
                            infoLog.info("Student changed" + cS.nameT.getText());
                            addStage.close();
                        } else {
                            if (language==0) {
                                JOptionPane.showMessageDialog(null,
                                        "Vorhandener Fahrlehrer nicht vorhanden, bitte vorhandenen Fahrlehrer eintragen");
                            }else
                            {
                                JOptionPane.showMessageDialog(null,
                                        "drivinginstructor not found please insert a valid instructor name");
                            }
                            debugLog.error(String.format("Error: Instructor not found"));
                        }
                    }


                } else {
                    debugLog.error("Cannot add Student, TextView is not filled");
                }

            }
        });
        /*gui.tableI.setRowFactory(tv ->

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
*/

        dI.print.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dI.rowData.writeInFile();
                //logger.info(String.format("Instructor in File: %s", dI.rowData.getId()));
            }
        });

        dI.save.setOnAction(new EventHandler<ActionEvent>() {
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
                infoLog.info(String.format("Instructor Changed: %s", b.getId()));
                if (language==0){
                JOptionPane.showMessageDialog(null, "Fahrlehrer erfolgreich geändert");
                }
                else{
                    JOptionPane.showMessageDialog(null, "instructor edit success");
                }

                addStage.close();
            }
        });

        gui.saveH.setOnAction(e -> {

            sAL.save(admin.vehicles, admin.drivinginstructorlist, admin.studentList);


        });

        gui.saveV.setOnAction(new EventHandler<ActionEvent>()

        {

            public void handle(ActionEvent e) {


                sAL.save(admin.vehicles, admin.drivinginstructorlist, admin.studentList);


            }
        });

        gui.saveI.setOnAction(new EventHandler<ActionEvent>()

        {

            public void handle(ActionEvent e) {

                try {
                    sAL.save(admin.vehicles, admin.drivinginstructorlist, admin.studentList);


                } catch (Exception z) {


                }
            }
        });

        gui.saveS.setOnAction(new EventHandler<ActionEvent>()

        {

            public void handle(ActionEvent e) {

                try {
                    sAL.save(admin.vehicles, admin.drivinginstructorlist, admin.studentList);


                } catch (Exception z) {


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
                        if (language==0){
                            JOptionPane.showMessageDialog(null,
                                    "Vorhandener Fahrlehrer nicht vorhanden, bitte vorhandenen Fahrlehrer eintragen");
                        }else{
                            JOptionPane.showMessageDialog(null,
                                    "drivinginstructor not found please insert a valid instructor name");
                        }

                    }
                }
                admin.studentList.add(new Drivingstudent(cS.nameT.getText(), cS.surnameT.getText(),
                        new Adress(Integer.parseInt(cS.plZT.getText()), cS.cityT.getText(), cS.streetT.getText(),
                                Integer.parseInt(cS.houseNrT.getText())),
                        Integer.parseInt(cS.numTheLesT.getText()), cS.theoryPassedT.getText(), a,
                        Integer.parseInt(cS.numPraLesT.getText()), cS.praxisPassedT.getText()));
                if (language==0) {
                    JOptionPane.showMessageDialog(null, "Student erfolgreich hinzugefügt");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "student successful added");
                }
                infoLog.info(String.format("Student addet: %s", cS.nameT.getText()));
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
                if (language==0){
                    JOptionPane.showMessageDialog(null, "Fahrlehrer erfolgreich hinzugefügt");
                }else{
                    JOptionPane.showMessageDialog(null, "drivinginstructor added successful");
                }

                infoLog.info(String.format("Instructor addet %s"));
                addStage.close();
            }
        });

        cV.create.setOnAction(new EventHandler<ActionEvent>()

        {

            public void handle(ActionEvent e) {
                admin.vehicles.add(new Vehicle(cV.idT.getText(), cV.modelT.getText(), cV.admissionClassT.getText(),
                        cV.manufacturerT.getText(), Integer.parseInt(cV.constructionYearT.getText())));

                if (language==0){
                    JOptionPane.showMessageDialog(null, "Fahrzeug erfolgreich hinzugefügt");
                }else{
                    JOptionPane.showMessageDialog(null, "vehicle add success");
                }
                infoLog.info(String.format("Vehicle addet: %s", cV.idT.getText()));
                addStage.close();
            }

        });


        gui.loadH.setOnAction(new EventHandler<ActionEvent>()

        {
            public void handle(ActionEvent e) {
                try {
                    sAL.load(admin.vehicles, admin.drivinginstructorlist, admin.studentList);

                } catch (Exception u) {

                }
            }
        });

        primaryStage.setScene(home);
        primaryStage.setTitle("Fahrschulverwaltung");
        if (language==1)
            primaryStage.setTitle("drivingscoolmanagement");
        primaryStage.show();
    }

    public static void main(String[] args) {
            infoLog.info("Program started");
        try {
            Object[] lang={"Deutsch","English"};
            language=JOptionPane.showOptionDialog(null,"Sprachauswahl","english",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,lang,lang[0]);

            launch();

        } catch (Exception e) {
            debugLog.error("Start failed", e);
        }
    }

}
