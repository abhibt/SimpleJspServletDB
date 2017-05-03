package com.vehicle.cycle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.daniel.util.DbUtil;
import com.user.cycle.User;

public class VehicleDao {

	private Connection connection;

	public VehicleDao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "root");

		//connection = DbUtil.getConnection();
	}

	public void addVehicle(Vehicle vehicle) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into vehicle(vehicleidnumber,typeormake,registrationdate,insurancedate,expirydate,fc_date,fc_expirydate,service_date,servicedetails) values (?, ?, ?,?,?,?,?,?,? )");
			// Parameters start with 1
			preparedStatement.setString(1, vehicle.getvehicleidnumber());
			preparedStatement.setString(2, vehicle.gettypeormake());
			preparedStatement.setDate(3, new java.sql.Date(vehicle.getRegistrationdate().getTime()));
			preparedStatement.setDate(4, new java.sql.Date(vehicle.getInsurancedate().getTime()));
			preparedStatement.setDate(5, new java.sql.Date(vehicle.getexpirydate().getTime()));
			preparedStatement.setDate(6, new java.sql.Date(vehicle.getfcdate().getTime()));
			preparedStatement.setDate(7, new java.sql.Date(vehicle.getfcexpirydate().getTime()));
			preparedStatement.setDate(8, new java.sql.Date(vehicle.getservicedate().getTime()));
			preparedStatement.setString(9, vehicle.getservicedetails());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteVehicle(int vehicleid) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from vehicle where vehicleid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, vehicleid);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatevehicle(Vehicle vehicle) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update vehicle set vehicleidnumber=?, typeormake=?, servicedetails=?" +
							"registrationdate=? ,insurancedate=? ,expirydate=?, fc_date=?, fc_expirydate=?, service_date=? "+
							" where vehicleid=?");
			// Parameters start with 1
			preparedStatement.setString(1, vehicle.getvehicleidnumber());
			preparedStatement.setString(2, vehicle.gettypeormake());
			preparedStatement.setString(3, vehicle.getservicedetails());
			preparedStatement.setDate(4, (Date) vehicle.getRegistrationdate());
			preparedStatement.setDate(5, (Date) vehicle.getInsurancedate());
			preparedStatement.setDate(6, (Date) vehicle.getexpirydate());
			preparedStatement.setDate(7, (Date) vehicle.getfcdate());
			preparedStatement.setDate(8, (Date) vehicle.getfcexpirydate());
			preparedStatement.setDate(9, (Date) vehicle.getservicedate());
			preparedStatement.setInt(10, vehicle.getvehicleid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Vehicle> getAllVehicles() {
		List<Vehicle> Vehicles = new ArrayList<Vehicle>();
		try {
			if( connection != null)
			{
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from vehicle");
				while (rs.next()) {
					Vehicle vehicle = new Vehicle();
					vehicle.setvehicleid(rs.getInt("vehicleid"));
					vehicle.setvehicleidnumber(rs.getString("vehicleidnumber"));
					vehicle.settypeormake(rs.getString("typeormake"));
					vehicle.setRegistrationdate(rs.getDate("registrationdate"));
					vehicle.setInsurancedate(rs.getDate("insurancedate"));
					vehicle.setexpirydate(rs.getDate("expirydate"));
					vehicle.setfcdate(rs.getDate("fcdate"));
					vehicle.setfcexpirydate(rs.getDate("fcexpirydate"));
					vehicle.setservicedate(rs.getDate("servicedate"));
					vehicle.setservicedetails(rs.getString("servicedetails"));
					Vehicles.add(vehicle);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Vehicles;
	}
	
	public Vehicle getVehicleById(int vehicleId) {
		Vehicle vehicle = new Vehicle();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from vehicle where vehicleid=?");
			preparedStatement.setInt(1, vehicleId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				vehicle.setvehicleid(rs.getInt("vehicleid"));
				vehicle.settypeormake(rs.getString("typeormake"));
				vehicle.setvehicleidnumber(rs.getString("vehicleidnumber"));
				vehicle.setRegistrationdate(rs.getDate("registrationdate"));
				vehicle.setInsurancedate(rs.getDate("insurancedate"));
				vehicle.setexpirydate(rs.getDate("expirydate"));
				vehicle.setfcdate(rs.getDate("fcdate"));
				vehicle.setfcexpirydate(rs.getDate("fcexpirydate"));
				vehicle.setservicedate(rs.getDate("servicedate"));
				vehicle.setservicedetails(rs.getString("servicedetails"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vehicle;
	}
}
