package com.customer.cycle;

import java.util.Date;

public class Customer {

	private int custid;
	private String name;
	private String custcode;
	private String address;

	@Override
	public String toString() {
		return "User [custid=" + custid + ", name=" + name
				+ ", custcode=" + custcode + ", address=" + address + "]";
	}
	public String setcustcode(String custcode) {
		return this.custcode = custcode;
	}
	public String getcustcode() {
		return this.custcode;
	}
	public String setname(String name) {
		return this.name = name;
	}
	public String getname() {
		return this.name;
	}
	
	public String setaddress(String address) {
		return this.address = address;
	}
	
	public String getaddress() {
		return this.address;
	}
	public int setcustid(int custid) {
		return this.custid = custid;
	}
	public int getcustid() {
		return this.custid;
	}
	public void add(Customer cust) {
		// TODO Auto-generated method stub
		
	}
}
