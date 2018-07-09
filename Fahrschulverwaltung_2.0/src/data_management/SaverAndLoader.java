package data_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import fold_logic.Adress;
import fold_logic.Drivinginstructor;
import fold_logic.DrivinginstructorTO;
import fold_logic.Drivingstudent;
import fold_logic.DrivingstudentTO;
import fold_logic.InstructorhasVehicleTO;
import fold_logic.Vehicle;
import fold_logic.VehicleTO;
import java.util.LinkedList;

import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

public class SaverAndLoader implements IDAO {

	Connection conn;
	static final Logger debugLog = Logger.getLogger("debugLogger");
	static final Logger infoLog = Logger.getLogger("infoLogger");

	public void save(ObservableList<Vehicle> v, ObservableList<Drivinginstructor> g, ObservableList<Drivingstudent> s) {
		try {
			
			Connection conn = getConnection();
			
			String clear = "SET FOREIGN_KEY_CHECKS = 0;";
			PreparedStatement create = conn.prepareStatement(clear);
			create.executeUpdate();
			
			clear = "TRUNCATE mydb.Vehicle";
			 create = conn.prepareStatement(clear);
			create.executeUpdate();
			
			clear = "TRUNCATE mydb.Drivingstudent";
			create = conn.prepareStatement(clear);
			create.executeUpdate();
			
			clear = "TRUNCATE mydb.Drivinginstructor";
			create = conn.prepareStatement(clear);
			create.executeUpdate();
			
			clear = "TRUNCATE mydb.Vehicle_has_Drivinginstructor";
			create = conn.prepareStatement(clear);
			create.executeUpdate();
			
			clear = "SET FOREIGN_KEY_CHECKS = 1;";
			create = conn.prepareStatement(clear);
			create.executeUpdate();
			
			
			for (Vehicle i : v) {

				String a = "";
				a = "INSERT INTO mydb.Vehicle VALUES ('" + i.getId() + "','" + i.getModel() + "','" + i.getAdmissionClass()
						+ "','" + i.getManufacturer() + "'," + i.getConstructionYear() + ");";
				 create = conn.prepareStatement(a);
				create.executeUpdate();
			}
			for (Drivingstudent j : s) {
				String b = "";
				b = "INSERT INTO mydb.Drivingstudent VALUES (0,'" + j.getName() + "','" + j.getFirstname() + "'," + j.getPLZ() + ",'" + j.getCity() + "','" + j.getStreet() + "'," + j.getHousenr() + ",'"
						+ j.isTheoryPassed() + "','" + j.isPraxisPassed() + "'," + j.getNumTheLes() + ","
						+ j.getNumPraLes() + "," + j.getOpenAmounts() + ",'" + j.getDrivinginstructor().getName()
						+ "','" + j.getDrivinginstructor().getName() + "','" +j.isTheoryPassed() + "','" + j.isPraxisPassed()  + "');";
				
				 create = conn.prepareStatement(b);
				create.executeUpdate();
			}
			for (Drivinginstructor k : g) {

				String c = "";
				c = "INSERT INTO mydb.Drivinginstructor VALUES (" + k.getId() + ",'" + k.getName() + "','" + k.getFirstname()
						+ "'," + k.getPLZ() + ",'" + k.getCity() + "','" + k.getStreet() + "',"
						+ k.getHousenr() + "," + 0 + ");";
				System.out.println(c);
				create = conn.prepareStatement(c);
				create.executeUpdate();
				for (Vehicle h : k.getlicensedVehicles()) {
					String bc = "";
					bc = "INSERT INTO mydb.Vehicle_has_Drivinginstructor VALUES ('" + h.getId() + "'," + k.getId() + ");";
					System.out.println(bc);
					PreparedStatement create2 = conn.prepareStatement(bc);
					create2.executeUpdate();
				}
				infoLog.info("Saving successfull");
			}
		} catch (Exception e) {

			debugLog.error("Saving failed",e);
		} finally {
			System.out.println("Function complete.");
		}

	}
        
        
        
        
        public void save(LinkedList<VehicleTO> v, LinkedList<DrivinginstructorTO> g, LinkedList<DrivingstudentTO> s) {
		try {
			
			Connection conn = getConnection();
			
			String clear = "SET FOREIGN_KEY_CHECKS = 0;";
			PreparedStatement create = conn.prepareStatement(clear);
			create.executeUpdate();
			
			clear = "TRUNCATE mydb.Vehicle";
			 create = conn.prepareStatement(clear);
			create.executeUpdate();
			
			clear = "TRUNCATE mydb.Drivingstudent";
			create = conn.prepareStatement(clear);
			create.executeUpdate();
			
			clear = "TRUNCATE mydb.Drivinginstructor";
			create = conn.prepareStatement(clear);
			create.executeUpdate();
			
			clear = "TRUNCATE mydb.Vehicle_has_Drivinginstructor";
			create = conn.prepareStatement(clear);
			create.executeUpdate();
			
			clear = "SET FOREIGN_KEY_CHECKS = 1;";
			create = conn.prepareStatement(clear);
			create.executeUpdate();
			
			
			for (VehicleTO i : v) {

				String a = "";
				a = "INSERT INTO mydb.Vehicle VALUES ('" + i.getId() + "','" + i.getModel() + "','" + i.getAdmissionClass()
						+ "','" + i.getManufacturer() + "'," + i.getConstructionYear() + ");";
				 create = conn.prepareStatement(a);
				create.executeUpdate();
			}
			for (DrivingstudentTO j : s) {
				String b = "";
				b = "INSERT INTO mydb.Drivingstudent VALUES (0,'" + j.getName() + "','" + j.getFirstname() + "'," + j.getPLZ() + ",'" + j.getCity() + "','" + j.getStreet() + "'," + j.getHousenr() + ",'"
						+ j.isTheoryPassed() + "','" + j.isPraxisPassed() + "'," + j.getNumTheLes() + ","
						+ j.getNumPraLes() + "," + j.getOpenAmounts() + ",'" + j.getDrivinginstructor().getName()
						+ "','" + j.getDrivinginstructor().getName() + "','" +j.isTheoryPassed() + "','" + j.isPraxisPassed()  + "');";
				
				 create = conn.prepareStatement(b);
				create.executeUpdate();
			}
			for (DrivinginstructorTO k : g) {

				String c = "";
				c = "INSERT INTO mydb.Drivinginstructor VALUES (" + k.getId() + ",'" + k.getName() + "','" + k.getFirstname()
						+ "'," + k.getPLZ() + ",'" + k.getCity() + "','" + k.getStreet() + "',"
						+ k.getHousenr() + "," + 0 + ");";
				System.out.println(c);
				create = conn.prepareStatement(c);
				create.executeUpdate();
				for (VehicleTO h : k.getlicensedVehicles()) {
					String bc = "";
					bc = "INSERT INTO mydb.Vehicle_has_Drivinginstructor VALUES ('" + h.getId() + "'," + k.getId() + ");";
					System.out.println(bc);
					PreparedStatement create2 = conn.prepareStatement(bc);
					create2.executeUpdate();
					infoLog.info("Saving succeeded");
				}
			}
		} catch (Exception e) {
			debugLog.error("Saving failed",e);
		} finally {
		}

	}
        

	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/mydb";
			String username = "root";
			String password = "";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			infoLog.info("Connection succeeded");
			return conn;
		} catch (Exception e) {
			debugLog.error("No Connection available",e);
		}

		return null;
	}

	public void load(ObservableList<Vehicle> v, ObservableList<Drivinginstructor> i, ObservableList<Drivingstudent> s) {
		try {
			Statement stmt = null;
			String query = "select * from mydb.Vehicle;";
			Connection conn = getConnection();

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				v.add(new Vehicle(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));

			}

			rs = stmt.executeQuery("select * from mydb.Drivinginstructor;");
			while (rs.next()) {
				i.add(new Drivinginstructor(rs.getString(2), rs.getString(3),
						new Adress(rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7)),rs.getInt(1)));

			}

			rs = stmt.executeQuery("select * from mydb.Drivingstudent;");
			while (rs.next()) {
				Drivinginstructor a = new Drivinginstructor("", "", new Adress(0, "", "", 0),0);

				for (Drivinginstructor b : i) {
					if (rs.getString(14).equals(b.getName()))
						a = b;

					s.add(new Drivingstudent(rs.getString(2), rs.getString(3),
							new Adress(rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7)), rs.getInt(10),
							rs.getString(8), a, rs.getInt(11), rs.getString(9)));
                        }
			}
                        
                        rs = stmt.executeQuery("select * from mydb.Vehicle_has_Drivinginstructor;");
			
                        while (rs.next())
                        {
                            Drivinginstructor a = new Drivinginstructor("", "", new Adress(0, "", "", 0),0);
                            
                            for (Drivinginstructor b : i) {
					if (rs.getInt(2) == (b.getId()))
                                        {
                                            a = b;
                                        }
                            }
                          
                            
                            Vehicle  c = new Vehicle("","","","",0);
                            
                            for (Vehicle b : v) {
                                
					if (rs.getString(1).equals(b.getId()))
						c = b;
                            }
                            
                            a.addZugelasseneKlasse(c);
                            a.vehiclesAsString = a.vehicleIdsAsString();
                            
                        }
                        
                    infoLog.info("Loading succeeded");
		} catch (Exception e) {
			debugLog.error("Loading failed",e);

		}
	}
        
        
        
        
        
        
        
        public void load(LinkedList<VehicleTO> v, LinkedList<DrivinginstructorTO> i, LinkedList<DrivingstudentTO> s,LinkedList<InstructorhasVehicleTO> f) {
		try {
			Statement stmt = null;
			String query = "select * from mydb.Vehicle;";
			Connection conn = getConnection();

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				v.add(new VehicleTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));

			}

			rs = stmt.executeQuery("select * from mydb.Drivinginstructor;");
			while (rs.next()) {
				i.add(new DrivinginstructorTO(rs.getString(2), rs.getString(3),
						new Adress(rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7)),rs.getInt(1)));

			}

			rs = stmt.executeQuery("select * from mydb.Drivingstudent;");
			while (rs.next()) {
				DrivinginstructorTO a = new DrivinginstructorTO("", "", new Adress(0, "", "", 0),0);

				for (DrivinginstructorTO b : i) {
					if (rs.getString(14).equals(b.getName()))
						a = b;

					s.add(new DrivingstudentTO(rs.getString(2), rs.getString(3),
							new Adress(rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7)), rs.getInt(10),
							rs.getString(8), a, rs.getInt(11), rs.getString(9)));
                        }
			}
                        
                        rs = stmt.executeQuery("select * from mydb.Vehicle_has_Drivinginstructor;");
			
                        while (rs.next())
                        {
                            f.add(new InstructorhasVehicleTO(rs.getString(1),rs.getInt(2)));
                            
                            DrivinginstructorTO a = new DrivinginstructorTO("", "", new Adress(0, "", "", 0),0);
                            
                            for (DrivinginstructorTO b : i) {
					if (rs.getInt(2) == (b.getId()))
                                        {
                                            a = b;
                                        }
                            }
                          
                            
                            VehicleTO  c = new VehicleTO("","","","",0);
                            
                            for (VehicleTO b : v) {
                                
					if (rs.getString(1).equals(b.getId()))
						c = b;
                            }
                            
                            a.addZugelasseneKlasse(c);
                            a.vehiclesAsString = a.vehicleIdsAsString();
                            
                        }
                        
                        infoLog.info("Loading succeeded");
		} catch (Exception e) {
			debugLog.error("Loading failed",e);
		}
	}


}
