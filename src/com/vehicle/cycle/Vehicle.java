package com.vehicle.cycle;

import java.util.Date;

public class Vehicle {

	private int vehicleid;
	private String typeormake;
	private String vehicleidnumber;
	private String servicedetails;
	private Date registrationdate;
	private Date insurancedate;
	private Date expirydate;
	private Date fcdate;
	private Date fcexpirydate;
	private Date servicedate;

	@Override
	public String toString() {
		return "Vehicle [vehicleid=" + vehicleid + 
				", vehicleidnumber=" + vehicleidnumber + 
				", typeormake=" + typeormake +
				",registrationdate="+ registrationdate + 
				",insurancedate="+ insurancedate + 
				",expirydate="+ expirydate + 
				",fc_date="+ fcdate + 
				",fc_expirydate="+ fcexpirydate + 
				",service_date="+ servicedate + 
				",servicedetails=" + servicedetails +"]";
	}
	public String setvehicleidnumber(String vehicleidnumber) {
		return this.vehicleidnumber = vehicleidnumber;
	}
	public String getvehicleidnumber() {
		return this.vehicleidnumber;
	}
	public String settypeormake(String typeormake) {
		return this.typeormake = typeormake;
	}
	public String gettypeormake() {
		return this.typeormake;
	}
	
	public String setservicedetails(String servicedetails) {
		return this.servicedetails = servicedetails;
	}
	
	public String getservicedetails() {
		return this.servicedetails;
	}
	public int setvehicleid(int vehicleid) {
		return this.vehicleid = vehicleid;
	}
	public int getvehicleid() {
		return this.vehicleid;
	}
	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}
	public Date getRegistrationdate() {
		return registrationdate;
	}
	public void setInsurancedate(Date insurancedate) {
		this.insurancedate = insurancedate;
	}
	public Date getInsurancedate() {
		return insurancedate;
	}
	public void setexpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	public Date getexpirydate() {
		return expirydate;
	}
	public void setfcdate(Date fcdate) {
		this.fcdate = fcdate;
	}
	public Date getfcdate() {
		return fcdate;
	}
	public void setfcexpirydate(Date fcexpirydate) {
		this.fcexpirydate = fcexpirydate;
	}
	public Date getfcexpirydate() {
		return fcexpirydate;
	}
	public void setservicedate(Date servicedate) {
		this.servicedate = servicedate;
	}
	public Date getservicedate() {
		return servicedate;
	}
}
