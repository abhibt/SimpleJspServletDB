package com.customer.cycle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.daniel.util.DbUtil;
import com.user.cycle.User;

public class CustomerDao {

	private Connection connection;

	public CustomerDao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "root");

		//connection = DbUtil.getConnection();
	}

	public void addCustomer(Customer cust) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into customer(custcode,name,address) values (?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, cust.getcustcode());
			preparedStatement.setString(2, cust.getname());
			preparedStatement.setString(3, cust.getaddress());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCustomer(int custid) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from customer where custid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, custid);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatecust(Customer cust) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update customer set custcode=?, name=?, address=?" +
							"where custid=?");
			// Parameters start with 1
			preparedStatement.setString(1, cust.getcustcode());
			preparedStatement.setString(2, cust.getname());
			preparedStatement.setString(3, cust.getaddress());
			preparedStatement.setInt(4, cust.getcustid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Customer> getAllCustomers() {
		List<Customer> Customers = new ArrayList<Customer>();
		try {
			if( connection != null)
			{
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from customer");
				while (rs.next()) {
					Customer cust = new Customer();
					cust.setcustid(rs.getInt("custid"));
					cust.setcustcode(rs.getString("custcode"));
					cust.setname(rs.getString("name"));
					cust.setaddress(rs.getString("address"));
					Customers.add(cust);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Customers;
	}
	
	public Customer getCustomerById(int custId) {
		Customer customer = new Customer();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from customer where custid=?");
			preparedStatement.setInt(1, custId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				customer.setcustid(rs.getInt("custid"));
				customer.setname(rs.getString("name"));
				customer.setcustcode(rs.getString("custcode"));
				customer.setaddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}
}
