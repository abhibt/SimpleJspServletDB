package com.transporter.cycle;

import java.util.Date;


public class User {
	private int userid;
	private String firstName;
	private String lastName;
	private Date dob;
	private String email;


	public enum USERTYPE {
		operator,
		admin
	}
	private USERTYPE usertype;
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOperatorType() {
		return (String) usertype.name();
	}

	public void setOperatorType(String usertype) {
		this.usertype = USERTYPE.valueOf(usertype);
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", dlnumber="
				+ email + "]";
	}

}
