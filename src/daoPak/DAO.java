package daoPak;

//vazni importi 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import devPak.Car;
import devPak.Gear;
import devPak.GearList;

import java.util.ArrayList;

public class DAO {
	private DataSource ds;

	// DEFINICIJA KONEKCIONIH STRINGOVA
	private static String GetAllCars = "select * from car";
	private static String GetAllGear = "SELECT * FROM gear ";
	
	private static String GetCarById = "select * from car where id = (?)";
	private static String getGearListByCarId = "SELECT * FROM `gear_list` WHERE id_car = (?);";
	
	private static String InsertCar = "insert into car (make, type) values (?, ?)";
	private static String InsertGear = "INSERT INTO gear (name) VALUES ( ? )";
	private static String InsertGearList = "insert into gear_list (id_car, id_gear) values (?, ?)";
	private static String InsertImg = "";
	
	private static String DeleteGearListByCarId = "DELETE FROM `gear_list` WHERE id_car = (?)";
	
	// DEFINICIJA KONSTRUKTORA ZA PODESAVNJE KONEKCIJE – UVEK ISTO
	@SuppressWarnings("unused")
	public DAO(){
		try {
			InitialContext cxt = new InitialContext();
			if ( cxt == null ) { 
			} 
			ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/mysql" ); 
			if ( ds == null ) { 
			} 		
		} catch (NamingException e) {
		}
	}
	// DEFINICIJA METODE 
	public ArrayList<Car> getAllCars(){
		ArrayList<Car> alCar = new ArrayList<Car>();
		Car c = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GetAllCars);
			pstm.execute();
			rs = pstm.getResultSet();
			while (rs.next()) {
				c = new Car();
				c.setId(rs.getInt("id"));
				c.setMake(rs.getString("make"));
				c.setType(rs.getString("type"));
				c.setImg(rs.getString("img"));
				alCar.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return alCar;
	}
	public void insertCar(Car c) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = ds.getConnection();
			pstm = con.prepareStatement(InsertCar);
			pstm.setString(1, c.getMake());
			pstm.setString(2, c.getType());
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	// getAllGear
	public ArrayList<Gear> getAllGear(){
		ArrayList<Gear> alGear = new ArrayList<Gear>();
		Gear g = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GetAllGear);
			pstm.execute();
			rs = pstm.getResultSet();
			while (rs.next()) {
				g = new Gear();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				alGear.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return alGear;
	}
	
	// insertGear
	public void insertGear(Gear g) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = ds.getConnection();
			pstm = con.prepareStatement(InsertGear);
			pstm.setString(1, g.getName());
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	// getCarById
	public Car getCarById(int id){
		Car c = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GetCarById);
			pstm.setInt(1, id);
			pstm.execute();
			rs = pstm.getResultSet();
			rs.next();
			c = new Car();
			c.setId(rs.getInt("id"));
			c.setMake(rs.getString("make"));
			c.setType(rs.getString("type"));
			c.setImg(rs.getString("img"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return c;
	}
	
	// setup gear for a car
	public void setupGear(ArrayList<GearList> alGearList) {
		// TODO Auto-generated method stub
		
	}
	
	// get arrayList of gearLists
	// getGearListByCarId(c.getId())
	public ArrayList<GearList> getGearListByCarId(int carId){
		ArrayList<GearList> alGearList = new ArrayList<GearList>();
		GearList gl = null;
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstm = con.prepareStatement(getGearListByCarId);
			pstm.setInt(1, carId);
			pstm.execute();
			
			rs = pstm.getResultSet();
			while (rs.next()) {
				gl = new GearList();
				gl.setId_car(rs.getInt("id_car"));
				gl.setId_gear(rs.getInt("id_gear"));
				alGearList.add(gl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return alGearList;
	}
	
	//  dao.setupGear(alGearList, idCar);
	public void setupGear(ArrayList<GearList> alGearList, int idCar){
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = ds.getConnection();
			pstm = con.prepareStatement(DeleteGearListByCarId);
			pstm.setInt(1, idCar);
			pstm.execute();
			if (alGearList != null && alGearList.size() > 0) {
				for (GearList gl : alGearList) {
					pstm = con.prepareStatement(InsertGearList);
					pstm.setInt(1, idCar);
					pstm.setInt(2, gl.getId_gear());
					pstm.execute();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
