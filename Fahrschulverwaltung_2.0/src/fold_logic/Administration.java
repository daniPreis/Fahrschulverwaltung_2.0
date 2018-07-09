package fold_logic;

import data_management.SaverAndLoader;
import java.util.LinkedList;
import java.util.List;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;


public class Administration {

	SaverAndLoader sAL = new SaverAndLoader();

	public LinkedList<Drivinginstructor> drivinginstructorlistLL = new LinkedList<Drivinginstructor>();
	public LinkedList<Drivingstudent> studentListLL = new LinkedList<Drivingstudent>();
	public LinkedList<Vehicle> vehiclesLL = new LinkedList<Vehicle>();

	public ObservableList<Drivinginstructor> drivinginstructorlist = FXCollections.observableList(drivinginstructorlistLL);
	public ObservableList<Drivingstudent> studentList = FXCollections.observableList(studentListLL);
	public ObservableList<Vehicle> vehicles = FXCollections.observableList(vehiclesLL);

	private static Administration onlyAdmin = null;

    static final Logger debugLog = Logger.getLogger("debugLogger");
    static final Logger infoLog = Logger.getLogger("infoLogger");

	private Administration() {

	}

	public static Administration getInstance() {
		if(onlyAdmin == null) {
			onlyAdmin = new Administration();
		}
		return onlyAdmin;
	}
	
	
	public List<Drivingstudent> getstudentList() {
		return studentList;
	}

	public void adddrivinginstructor(Drivinginstructor drivinginstructor) {

	    try {
            drivinginstructorlist.add(drivinginstructor);
            infoLog.info("Drivinginstructor addet" + drivinginstructor.getId());
        }catch (Exception e){
	        debugLog.error("Drivinginstructor cannot be addet", e);
        }

	}

	public void adddrivingsstudent(Drivingstudent drivingstudent) {
	    try{
		studentList.add(drivingstudent);
		infoLog.info("Student addet" + drivingstudent.getName());
	}catch (Exception e){
	    debugLog.error("Student cannot be addet", e);
	    }
    }

	public void addvehicle(Vehicle vehicle) {
	    try{
            vehicles.add(vehicle);
            infoLog.info("Vehicle addet" + vehicle.getId());
        }catch (Exception e){
	        debugLog.error("Vehicle cannot be addet", e);
        }
	}

	public void removedrivinginstructor(Drivinginstructor drivinginstructor) {
		drivinginstructorlist.remove(drivinginstructor);
	}

	public void removevehicle(Vehicle vehicle) {
		vehicles.remove(vehicle);
	}

	public void save() {
		// sAL.save(vehicles, drivinginstructorlist, studentList);

		LinkedList<DrivinginstructorTO> b = new LinkedList<>();
		LinkedList<DrivingstudentTO> c = new LinkedList<>();
		LinkedList<VehicleTO> d = new LinkedList<>();

		vehicles.forEach((m) -> {
			d.add(new VehicleTO(m.getId(), m.getModel(), m.getAdmissionClass(), m.getManufacturer(),
					m.getConstructionYear()));
		});

		drivinginstructorlist.forEach((k) -> {
			LinkedList<VehicleTO> e = new LinkedList<>();

			k.getlicensedVehicles().forEach((m) -> {
				e.add(new VehicleTO(m.getId(), m.getModel(), m.getAdmissionClass(), m.getManufacturer(),
						m.getConstructionYear()));
			});
			b.add(new DrivinginstructorTO(k.getName(), k.getFirstname(), k.getAdress(), e));
		});

		studentList.forEach((u) -> {
			System.out.println("TST in wandlung " + u.isPraxisPassed());
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
		// public DrivingstudentTO(String name, String firstname, Adress adress, int
		// numTheLes, String theoryPassed,DrivinginstructorTO drivinginstructorTO, int
		// numPraLes, String praxisPassed)
		c.forEach((e) -> {
			System.out.println(e.isPraxisPassed());
		});
		sAL.save(d, b, c);
	}

	public void load() {
		LinkedList<DrivinginstructorTO> b = new LinkedList<>();
		LinkedList<DrivingstudentTO> c = new LinkedList<>();
		LinkedList<VehicleTO> d = new LinkedList<>();
		LinkedList<InstructorhasVehicleTO> f = new LinkedList<>();

		sAL.load(d, b, c, f);

		d.forEach((m) -> {
			vehicles.add(new Vehicle(m.getId(), m.getModel(), m.getAdmissionClass(), m.getManufacturer(),
					m.getConstructionYear()));
		});

		b.forEach((n) -> {

			drivinginstructorlist.add(new Drivinginstructor(n.getName(), n.getFirstname(),
					new Adress(n.getPLZ(), n.getCity(), n.getStreet(), n.getHousenr()),n.getId()));

		});

		f.forEach((z) -> {
			String o = z.getCarID();
			int p = z.getInstructorID();
			Drivinginstructor a = new Drivinginstructor("", "", new Adress(0, "", "", 0), 0);

			for (Drivinginstructor u : drivinginstructorlist) {
				if (p == (u.getId())) {
					a = u;
				}
			}
			Vehicle v = new Vehicle("dummy", "", "", "", 0);

			for (Vehicle q : vehicles) {

				if (o.equals(q.getId()))
					v = q;
			}
			a.addZugelasseneKlasse(v);
			a.vehiclesAsString = a.vehicleIdsAsString();
		});

		c.forEach((e) -> {

			Drivinginstructor a = new Drivinginstructor("", "", new Adress(0, "", "", 0), 0);

			for (Drivinginstructor g : drivinginstructorlist) {
				if (e.getDrivinginstructor().getName().equals(g.getName()))
					a = g;

				studentList.add(new Drivingstudent(e.getName(), e.getFirstname(),
						new Adress(e.getPLZ(), e.getCity(), e.getStreet(), e.getHousenr()), e.getNumTheLes(),
						e.isTheoryPassed(), a, e.getNumPraLes(), e.isPraxisPassed()));
			}

		});

	}

}
