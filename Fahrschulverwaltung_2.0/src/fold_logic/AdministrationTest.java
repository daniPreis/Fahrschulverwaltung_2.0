package fold_logic;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class AdministrationTest {


    public LinkedList<Drivinginstructor> drivinginstructorlistLL = new LinkedList<Drivinginstructor>();
    public LinkedList<Drivingstudent> studentListLL = new LinkedList<Drivingstudent>();
    public LinkedList<Vehicle> vehiclesLL = new LinkedList<Vehicle>();




    @Test
    public void addvehicle() {

        vehiclesLL.add(new Vehicle("TestAuto","Dodge Cobra","B","Dra",2016));
        Assert.assertEquals(vehiclesLL.getFirst().getId() + vehiclesLL.getFirst().getModel() + vehiclesLL.getFirst().getAdmissionClass() + vehiclesLL.getFirst().getManufacturer() + vehiclesLL.getFirst().getConstructionYear(), "TestAuto" + "Dodge Cobra" + "B" + "Dra" + 2016);
    }

    @org.junit.Test
    public void adddrivinginstructor() {
        drivinginstructorlistLL.add(new Drivinginstructor("Ratert","Fabian",new Adress(12345,"Dortmund","Weg",51)));
        Assert.assertEquals( drivinginstructorlistLL.getFirst().getFirstname()+drivinginstructorlistLL.getFirst().getName()+drivinginstructorlistLL.getFirst().getAdressAsString(),"FabianRatert12345 Dortmund Weg 51");

    }
    @Test
    public void adddrivingsstudent() {
        studentListLL.add(new Drivingstudent("Tst","Tstvor",new Adress(1,"","",5),12,"ja",new Drivinginstructor("Ratert","Fabian",new Adress(12345,"Dortmund","Weg",51)),5,"nein"));
        Assert.assertEquals(studentListLL.getFirst().getFirstname()+studentListLL.getFirst().getName()+studentListLL.getFirst().isTheoryPassed()+studentListLL.getFirst().isPraxisPassed(),"TstvorTstjanein");
    }



}