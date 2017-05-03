package com.consignment.cycle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsignmentDao {

	private Connection connection;

	public ConsignmentDao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "root");

		//connection = DbUtil.getConnection();
	}

	public void addConsignment(Consignment consignment) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into consignment(" + 
			"consignerid , consigneeid , vehicleid ,	rateid ,transportid ,registrationdate," + 
			"boxcount , boxdescription ,capacity_weight , loadtype ,	paidby ,amount ,"+ 
			"total , addl_charges ,handling_charges ,statistical_charges ,declared_value ,"+ 
			"billed_at , vehicle_type ,articletypedescription ,loading_percentage)" + "values (?, ?, ?,?, ?,?,?,?, ?,?, ?, ?, ?,?,?,?, ?,?,?,?, ? )");
			// Parameters start with 1
			preparedStatement.setLong(1, consignment.getConsignerid());
			preparedStatement.setLong(2, consignment.getConsigneeid());
			preparedStatement.setLong(3, consignment.getvehicleid());
			preparedStatement.setLong(4, consignment.getRateid());
			preparedStatement.setLong(5, consignment.getTransportid());
			preparedStatement.setDate(6, new java.sql.Date(consignment.getRegistrationdate().getTime()));
			preparedStatement.setLong(7, consignment.getBoxcount());
			preparedStatement.setString(8, consignment.getBoxdescription());
			preparedStatement.setString(9, consignment.getCapacity_weight());
			preparedStatement.setString(10, consignment.getLoadtype());
			preparedStatement.setString(11, consignment.getPaidby());
			preparedStatement.setLong(12, (long) consignment.getAmount());
			preparedStatement.setLong(13, (long) consignment.getTotal());
			preparedStatement.setLong(14, (long) consignment.getAddl_charges());
			preparedStatement.setLong(15, (long) consignment.getHandling_charges());
			preparedStatement.setLong(16, (long) consignment.getStatistical_charges());
			preparedStatement.setLong(17, (long) consignment.getDeclared_value());
			preparedStatement.setString(18, consignment.getBilled_at());
			preparedStatement.setString(19, consignment.getVehicle_type());
			preparedStatement.setString(20, consignment.getArticletypedescription());
			preparedStatement.setLong(21, (long) consignment.getLoading_percentage());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteVehicle(int consignmentid) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from consignment where consignmentid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, consignmentid);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatevehicle(Consignment consignment) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update consignment set "
							+ "consignerid , consigneeid , vehicleid ,	rateid ,transportid ,registrationdate," + 
			"boxcount , boxdescription ,capacity_weight , loadtype ,	paidby ,amount ,"+ 
			"total , addl_charges ,handling_charges ,statistical_charges ,declared_value ,"+ 
			"billed_at , vehicle_type ,articletypedescription ,loading_percentage  where consignmentid=?");
			// Parameters start with 1
		
			preparedStatement.setLong(1,consignment.getConsignmentid());
			preparedStatement.setLong(2, consignment.getConsignerid());
			preparedStatement.setLong(3, consignment.getConsigneeid());
			preparedStatement.setLong(4, consignment.getvehicleid());
			preparedStatement.setLong(5, consignment.getRateid());
			preparedStatement.setLong(6, consignment.getTransportid());
			preparedStatement.setDate(7, (Date) consignment.getRegistrationdate());
			preparedStatement.setLong(8, consignment.getBoxcount());
			preparedStatement.setNString(9, consignment.getBoxdescription());
			preparedStatement.setNString(10, consignment.getCapacity_weight());
			preparedStatement.setNString(11, consignment.getLoadtype());
			preparedStatement.setNString(12, consignment.getPaidby());
			preparedStatement.setLong(13, (long) consignment.getAmount());
			preparedStatement.setLong(14, (long) consignment.getTotal());
			preparedStatement.setLong(15, (long) consignment.getAddl_charges());
			preparedStatement.setLong(16, (long) consignment.getHandling_charges());
			preparedStatement.setLong(17, (long) consignment.getStatistical_charges());
			preparedStatement.setLong(18, (long) consignment.getDeclared_value());
			preparedStatement.setNString(19, consignment.getBilled_at());
			preparedStatement.setNString(20, consignment.getVehicle_type());
			preparedStatement.setNString(21, consignment.getArticletypedescription());
			preparedStatement.setLong(22, (long) consignment.getLoading_percentage());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Consignment> getAllConsignments() {
		List<Consignment> Consignments = new ArrayList<Consignment>();
		try {
			if( connection != null)
			{
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from consignment");
				while (rs.next()) {
					Consignment consignment = new Consignment();
		
					consignment.setConsignmentid(rs.getInt("consignmentid"));
					consignment.setConsignerid(rs.getInt("consignerid"));
					consignment.setConsigneeid(rs.getInt("consigneeid"));
					consignment.setvehicleid(rs.getInt("vehicleid"));
					consignment.setRateid(rs.getInt("rateid"));
					consignment.setTransportid(rs.getInt("transportid"));
					consignment.setRegistrationdate(rs.getDate("registrationdate"));
					consignment.setBoxcount(rs.getInt("boxcount"));
					consignment.setBoxdescription(rs.getString("boxdescription"));
					consignment.setCapacity_weight(rs.getString("capacity_weight"));
					consignment.setLoadtype(rs.getString("loadtype"));
					consignment.setPaidby(rs.getString("paidby"));
					consignment.setAmount(rs.getFloat("amount"));
					consignment.setTotal(rs.getFloat("total"));
					consignment.setAddl_charges(rs.getFloat("addl_charges"));
					consignment.setHandling_charges(rs.getFloat("handling_charges"));
					consignment.setStatistical_charges(rs.getFloat("statistical_charges"));
					consignment.setDeclared_value(rs.getFloat("declared_value"));
					consignment.setBilled_at(rs.getString("billed_at"));
					consignment.setVehicle_type(rs.getString("vehicle_type"));
					consignment.setArticletypedescription(rs.getString("articletypedescription"));
					consignment.setLoading_percentage(rs.getFloat("loading_percentage"));
					Consignments.add(consignment);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Consignments;
	}
	
	public Consignment getConsignmentById(int consignmentid) {
		Consignment consignment = new Consignment();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from consignment where consignmentid=?");
			preparedStatement.setInt(1, consignmentid);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				consignment.setConsignmentid(rs.getInt("consignmentid"));
				consignment.setConsignerid(rs.getInt("consignerid"));
				consignment.setConsigneeid(rs.getInt("consigneeid"));
				consignment.setvehicleid(rs.getInt("vehicleid"));
				consignment.setRateid(rs.getInt("rateid"));
				consignment.setTransportid(rs.getInt("transportid"));
				consignment.setRegistrationdate(rs.getDate("registrationdate"));
				consignment.setBoxcount(rs.getInt("boxcount"));
				consignment.setBoxdescription(rs.getString("boxdescription"));
				consignment.setCapacity_weight(rs.getString("capacity_weight"));
				consignment.setLoadtype(rs.getString("loadtype"));
				consignment.setPaidby(rs.getString("paidby"));
				consignment.setAmount(rs.getFloat("amount"));
				consignment.setTotal(rs.getFloat("total"));
				consignment.setAddl_charges(rs.getFloat("addl_charges"));
				consignment.setHandling_charges(rs.getFloat("handling_charges"));
				consignment.setStatistical_charges(rs.getFloat("statistical_charges"));
				consignment.setDeclared_value(rs.getFloat("declared_value"));
				consignment.setBilled_at(rs.getString("billed_at"));
				consignment.setVehicle_type(rs.getString("vehicle_type"));
				consignment.setArticletypedescription(rs.getString("articletypedescription"));
				consignment.setLoading_percentage(rs.getFloat("loading_percentage"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return consignment;
	}

}
