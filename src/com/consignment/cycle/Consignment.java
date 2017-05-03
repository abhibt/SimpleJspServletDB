package com.consignment.cycle;

import java.util.Date;

public class Consignment {

	private int consignmentid;
	private int consignerid;
	private int consigneeid;
	private int vehicleid;
	private int rateid;
	private int transportid;
	private Date registrationdate;
	private int boxcount;
	private String boxdescription;
	private WEIGHTTYPE capacity_weight;
	private LOADINGTYPE loadtype;
	private PAIDBY paidby;
	private float amount;
	private float total;
	private float addl_charges;
	private float handling_charges;
	private float statistical_charges;
	private float declared_value;
	private BILLEDAT billed_at;
	private VEHICLETYPE vehicle_type;
	private String articletypedescription;
	private float loading_percentage;
	
	
	public int setvehicleid(int vehicleid) {
		return this.vehicleid = vehicleid;
	}
	public int setvehicleid(String vehicleid) {
		return this.vehicleid = Integer.parseInt(vehicleid);
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
	public int getConsignmentid() {
		return consignmentid;
	}
	public void setConsignmentid(String consignmentid) {
		this.consignmentid = Integer.parseInt(consignmentid);
	}
	public void setConsignmentid(int consignmentid) {
		this.consignmentid = consignmentid;
	}
	
	public int getConsignerid() {
		return consignerid;
	}
	public void setConsignerid(int consignerid) {
		this.consignerid = consignerid;
	}
	public void setConsignerid(String consignerid) {
		this.consignerid = Integer.parseInt(consignerid);;
	}
	
	public int getConsigneeid() {
		return consigneeid;
	}
	public void setConsigneeid(int consigneeid) {
		this.consigneeid = consigneeid;
	}
	public void setConsigneeid(String consigneeid) {
		this.consigneeid = Integer.parseInt(consigneeid);
	}
	
	public int getRateid() {
		return rateid;
	}
	public void setRateid(int rateid) {
		this.rateid = rateid;
	}
	public void setRateid(String rateid) {
		this.rateid = Integer.parseInt(rateid);
	}
	
	public int getTransportid() {
		return transportid;
	}
	public void setTransportid(int transportid) {
		this.transportid = transportid;
	}
	public void setTransportid(String transportid) {
		this.transportid = Integer.parseInt(transportid);
	}
		
	public int getBoxcount() {
		return boxcount;
	}
	public void setBoxcount(int boxcount) {
		this.boxcount = boxcount;
	}
	public void setBoxcount(String boxcount) {
		this.boxcount = Integer.parseInt(boxcount);
	}	
	public String getBoxdescription() {
		return boxdescription;
	}
	public void setBoxdescription(String boxdescription) {
		this.boxdescription = boxdescription;
	}
	public String getCapacity_weight() {
		return capacity_weight.toString();
	}
	public void setCapacity_weight(String cw) {
		this.capacity_weight = WEIGHTTYPE.valueOf(cw);
	}
	public String getLoadtype() {
		return loadtype.toString();
	}
	public void setLoadtype(String loadtype) {
		this.loadtype = LOADINGTYPE.valueOf(loadtype);
	}
	public String getPaidby() {
		return paidby.toString();
	}
	public void setPaidby(String paidby) {
		this.paidby = PAIDBY.valueOf(paidby);
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public void setAmount(String amount) {
		this.amount = Float.parseFloat(amount);
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public void setTotal(String total) {
		this.total = Float.parseFloat(total);
	}	
	public float getAddl_charges() {
		return addl_charges;
	}
	public void setAddl_charges(float addl_charges) {
		this.addl_charges = addl_charges;
	}
	public void setAddl_charges(String addl_charges) {
		this.addl_charges = Float.parseFloat(addl_charges);
	}
	public float getHandling_charges() {
		return handling_charges;
	}
	public void setHandling_charges(float handling_charges) {
		this.handling_charges = handling_charges;
	}
	public void setHandling_charges(String handling_charges) {
		this.handling_charges = Float.parseFloat(handling_charges);
	}
	public float getStatistical_charges() {
		return statistical_charges;
	}
	public void setStatistical_charges(float statistical_charges) {
		this.statistical_charges = statistical_charges;
	}
	public void setStatistical_charges(String statistical_charges) {
		this.statistical_charges = Float.parseFloat(statistical_charges);
	}
	public float getDeclared_value() {
		return declared_value;
	}
	public void setDeclared_value(float declared_value) {
		this.declared_value = declared_value;
	}
	public void setDeclared_value(String declared_value) {
		this.declared_value = Float.parseFloat(declared_value);
	}
	public String getBilled_at() {
		return billed_at.toString();
	}
	public void setBilled_at(String billed_at) {
		this.billed_at = BILLEDAT.valueOf(billed_at);
	}
	public String getVehicle_type() {
		return vehicle_type.toString();
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = VEHICLETYPE.valueOf(vehicle_type);
	}
	public String getArticletypedescription() {
		return articletypedescription;
	}
	public void setArticletypedescription(String articletypedescription) {
		this.articletypedescription = articletypedescription;
	}
	public float getLoading_percentage() {
		return loading_percentage;
	}
	public void setLoading_percentage(float loading_percentage) {
		this.loading_percentage = loading_percentage;
	}
	
	public void setLoading_percentage(String loading_percentage) {
		this.loading_percentage = Float.parseFloat(loading_percentage);
	}
}
