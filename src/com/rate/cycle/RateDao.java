package com.rate.cycle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;



public class RateDao {

	private Connection connection;
	private ArrayList<String> cust;

	public RateDao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "root");

		//connection = DbUtil.getConnection();
	}

	public void addRate(Rate rate) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into rateentry(loadtype,custid,rate,destination,source,ratetype) values (?, ?, ?, ?,?,? )");
			// Parameters start with 1
			preparedStatement.setString(1, rate.getLoadType());
			preparedStatement.setInt(2, rate.getCustomerid());
			preparedStatement.setLong(3, (long) rate.getRate());
			preparedStatement.setString(4, rate.getDestination());
			preparedStatement.setString(5, rate.getSource());
			preparedStatement.setString(6, rate.getRateType());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRate(int userId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from rateentry where rateid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateRate(Rate rate) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update rateentry set loadtype=?, custid=?, rate=?, destination=? , source=?, ratetype=?" +
							"where rateid=?");
			// Parameters start with 1
			preparedStatement.setString(1, rate.getLoadType());
			preparedStatement.setInt(2, rate.getCustomerid());
			preparedStatement.setLong(3, (long) rate.getRate());
			preparedStatement.setString(4, rate.getDestination());
			preparedStatement.setString(5, rate.getSource());
			preparedStatement.setString(6, rate.getRateType());
			preparedStatement.setInt(7, rate.getRateid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Rate> getAllRates() {
		List<Rate> rates = new ArrayList<Rate>();

		try {
			if( connection != null)
			{
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from rateentry");
				while (rs.next()) {
					Rate rate = new Rate();
					rate.setRateid(rs.getInt("rateid"));
					rate.setSource(rs.getString("source"));
					rate.setDestination(rs.getString("destination"));
					rate.setCustomerid(rs.getString("custid"));
					rate.setRate(rs.getString("rate"));
					rate.setLoadType(rs.getString("loadtype"));
					rate.setRateType(rs.getString("ratetype"));
					rates.add(rate);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rates;
	}
	
	public Rate getRateById(int rateid) {
		Rate rate = new Rate();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from rateentry where rateid=?");
			preparedStatement.setInt(1, rateid);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				rate.setRateid(rs.getInt("rateid"));
				rate.setSource(rs.getString("source"));
				rate.setDestination(rs.getString("destination"));
				rate.setCustomerid(rs.getString("custid"));
				rate.setRate(rs.getString("rate"));
				rate.setLoadType(rs.getString("loadtype"));
				rate.setRateType(rs.getString("ratetype"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rate;
	}

	public List<String> findcustomers() throws SQLException {
		List<String> cust = new ArrayList();
		PreparedStatement preparedStatement = connection.
				prepareStatement("select name from customer");
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			String custname = rs.getString("name");
			if(custname.isEmpty() == false)
			cust.add(custname);
		}
		return (ArrayList)cust;
	}
}
