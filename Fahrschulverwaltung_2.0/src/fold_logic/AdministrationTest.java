package fold_logic;

import data_management.SaverAndLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class AdministrationTest {


    public LinkedList<Drivinginstructor> drivinginstructorlistLL = new LinkedList<Drivinginstructor>();
    public LinkedList<Drivingstudent> studentListLL = new LinkedList<Drivingstudent>();
    public LinkedList<Vehicle> vehiclesLL = new LinkedList<Vehicle>();


    @Test
    public void addvehicle() {

        vehiclesLL.add(new Vehicle("TestAuto", "Dodge Cobra", "B", "Dra", 2016));
        Assert.assertEquals(vehiclesLL.getFirst().getId() + vehiclesLL.getFirst().getModel() + vehiclesLL.getFirst().getAdmissionClass() + vehiclesLL.getFirst().getManufacturer() + vehiclesLL.getFirst().getConstructionYear(), "TestAuto" + "Dodge Cobra" + "B" + "Dra" + 2016);

    }

    @org.junit.Test
    public void adddrivinginstructor() {
        drivinginstructorlistLL.add(new Drivinginstructor("Ratert", "Fabian", new Adress(12345, "Dortmund", "Weg", 51)));
        Assert.assertEquals(drivinginstructorlistLL.getFirst().getFirstname() + drivinginstructorlistLL.getFirst().getName() + drivinginstructorlistLL.getFirst().getAdressAsString(), "FabianRatert12345 Dortmund Weg 51");

    }

    @Test
    public void adddrivingsstudent() {
        studentListLL.add(new Drivingstudent("Toster", "Tester", new Adress(1, "Berlin", "Neubergstraße", 5), 12, "ja", new Drivinginstructor("Ratert", "Fabian", new Adress(12345, "Dortmund", "Weg", 51)), 5, "nein"));
        Assert.assertEquals(studentListLL.getFirst().getFirstname() + studentListLL.getFirst().getName() + studentListLL.getFirst().isTheoryPassed() + studentListLL.getFirst().isPraxisPassed(), "TesterTosterjanein");
    }

    @Test
    public void speichern()
    {
        drivinginstructorlistLL = new LinkedList<Drivinginstructor>();
        studentListLL = new LinkedList<Drivingstudent>();
        vehiclesLL = new LinkedList<Vehicle>();

        vehiclesLL.add(new Vehicle("TestAuto", "Dodge Cobra", "B", "Dra", 2016));
        drivinginstructorlistLL.add(new Drivinginstructor("Ratert", "Fabian", new Adress(12345, "Dortmund", "Weg", 51),vehiclesLL.getFirst()));
        studentListLL.add(new Drivingstudent("Meier", "Michael", new Adress(1, "Berlin", "Neubergstraße", 5), 12, "ja", drivinginstructorlistLL.getFirst(), 5, "nein"));

        System.out.println(studentListLL.getFirst().getDrivinginstructor().vehiclesAsString);

        save();

        drivinginstructorlistLL = new LinkedList<Drivinginstructor>();
        studentListLL = new LinkedList<Drivingstudent>();
        vehiclesLL = new LinkedList<Vehicle>();

        load();

        //


        //Assert.assertEquals(vehiclesLLtst.getFirst().toString(),vehiclesLL.getFirst().toString());


        Assert.assertEquals(vehiclesLL.getFirst().getId() + vehiclesLL.getFirst().getModel() + vehiclesLL.getFirst().getAdmissionClass() + vehiclesLL.getFirst().getManufacturer() + vehiclesLL.getFirst().getConstructionYear(), "TestAuto" + "Dodge Cobra" + "B" + "Dra" + 2016);
        Assert.assertEquals(drivinginstructorlistLL.getFirst().getFirstname() + drivinginstructorlistLL.getFirst().getName() + drivinginstructorlistLL.getFirst().getAdressAsString()+drivinginstructorlistLL.getFirst().vehiclesAsString, "FabianRatert12345 Dortmund Weg 51  TestAuto");


        //


        /*

        System.out.println(studentListLL.getFirst().getDrivinginstructor().vehiclesAsString);
        System.out.println(studentListLL.getFirst().getName());
        System.out.println(studentListLL.getFirst().getDrivinginstructor().getName());
        System.out.println(drivinginstructorlistLL.getFirst().getName());
        System.out.println(drivinginstructorlistLL.getFirst().getlicensedVehicles().size());
        */
    }

    public void save() {

        SaverAndLoader sAL = new SaverAndLoader();

        LinkedList<DrivinginstructorTO> b = new LinkedList<>();
        LinkedList<DrivingstudentTO> c = new LinkedList<>();
        LinkedList<VehicleTO> d = new LinkedList<>();

        vehiclesLL.forEach((m) -> {
            d.add(new VehicleTO(m.getId(), m.getModel(), m.getAdmissionClass(), m.getManufacturer(),
                    m.getConstructionYear()));
        });

        drivinginstructorlistLL.forEach((k) -> {
            LinkedList<VehicleTO> e = new LinkedList<>();

            k.getlicensedVehicles().forEach((m) -> {
                e.add(new VehicleTO(m.getId(), m.getModel(), m.getAdmissionClass(), m.getManufacturer(),
                        m.getConstructionYear()));
            });
            b.add(new DrivinginstructorTO(k.getName(), k.getFirstname(), k.getAdress(), e));
        });

        studentListLL.forEach((u) -> {
            LinkedList<VehicleTO> e = new LinkedList<>();
            u.getDrivinginstructor().getlicensedVehicles().forEach((m) -> {
                e.add(new VehicleTO(m.getId(), m.getModel(), m.getAdmissionClass(), m.getManufacturer(),
                        m.getConstructionYear()));
            });
            c.add(new DrivingstudentTO(u.getName(), u.getFirstname(), u.getAdress(), u.getNumTheLes(),
                    u.isTheoryPassed(), new DrivinginstructorTO(u.getDrivinginstructor().getName(),
                    u.getDrivinginstructor().getFirstname(), u.getDrivinginstructor().getAdress(), e),
                    u.getNumPraLes(), u.isPraxisPassed()));
        });

        sAL.save(d, b, c);
    }



    public void load() {

        SaverAndLoader sAL = new SaverAndLoader();

        LinkedList<DrivinginstructorTO> b = new LinkedList<>();
        LinkedList<DrivingstudentTO> c = new LinkedList<>();
        LinkedList<VehicleTO> d = new LinkedList<>();
        LinkedList<InstructorhasVehicleTO> f = new LinkedList<>();

        sAL.load(d, b, c, f);

        d.forEach((m) -> {
            vehiclesLL.add(new Vehicle(m.getId(), m.getModel(), m.getAdmissionClass(), m.getManufacturer(),
                    m.getConstructionYear()));
        });

        b.forEach((n) -> {

            drivinginstructorlistLL.add(new Drivinginstructor(n.getName(), n.getFirstname(),
                    new Adress(n.getPLZ(), n.getCity(), n.getStreet(), n.getHousenr()),n.getId()));

        });

        f.forEach((z) -> {
            String o = z.getCarID();
            int p = z.getInstructorID();

            Drivinginstructor a = new Drivinginstructor("", "", new Adress(0, "", "", 0), 0);

            for (Drivinginstructor u : drivinginstructorlistLL
                    ) {
                if (p == (u.getId())) {
                    a = u;
                }
            }
            Vehicle v = new Vehicle("", "", "", "", 0);

            for (Vehicle q : vehiclesLL) {

                if (o.equals(q.getId()))
                    v = q;
            }
            a.addZugelasseneKlasse(v);
            a.vehiclesAsString = a.vehicleIdsAsString();
        });

        c.forEach((e) -> {

            Drivinginstructor a = new Drivinginstructor("", "", new Adress(0, "", "", 0), 0);

            for (Drivinginstructor g : drivinginstructorlistLL) {
                if (e.getDrivinginstructor().getName().equals(g.getName()))
                    a = g;

                studentListLL.add(new Drivingstudent(e.getName(), e.getFirstname(),
                        new Adress(e.getPLZ(), e.getCity(), e.getStreet(), e.getHousenr()), e.getNumTheLes(),
                        e.isTheoryPassed(), g, e.getNumPraLes(), e.isPraxisPassed()));
            }

        });

    }



}