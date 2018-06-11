package data_management;

import fold_logic.Drivinginstructor;
import fold_logic.DrivinginstructorTO;
import fold_logic.Drivingstudent;
import fold_logic.DrivingstudentTO;
import fold_logic.InstructorhasVehicleTO;
import fold_logic.Vehicle;
import fold_logic.VehicleTO;
import java.util.LinkedList;
import javafx.collections.ObservableList;

/**
 *
 * @author Fabian
 */

public interface IDAO {
  //  public void save(ObservableList<Vehicle> v, ObservableList<Drivinginstructor> g, ObservableList<Drivingstudent> s);
  //  public void load(ObservableList<Vehicle> v, ObservableList<Drivinginstructor> i, ObservableList<Drivingstudent> s);
    public void save(LinkedList<VehicleTO> v, LinkedList<DrivinginstructorTO> g, LinkedList<DrivingstudentTO> s);
    public void load(LinkedList<VehicleTO> v, LinkedList<DrivinginstructorTO> i, LinkedList<DrivingstudentTO> s,LinkedList<InstructorhasVehicleTO> f);
    
}
