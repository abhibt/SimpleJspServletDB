package com.rate.cycle;

import java.util.Date;


public class Rate {
	private int rateid;
	private int customerid;
	private float rate;
	private String Destination;
	private String Source;

	public enum LOADTYPE {
		local,
		upcountry;
	}
	public enum RATETYPE {
		boxes,
		fixed
	}
	private LOADTYPE loadtype;
	private RATETYPE ratetype;
	
	public int getRateid() {
		return rateid;
	}

	public void setRateid(int rateid) {
		this.rateid = rateid;
	}
	public float getRate() {
		return rate;
	}

	public void setRate(String rates) {
		float ratesf= Float.parseFloat(rates);
		this.rate = ratesf;
	}
	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String rateid) {
		int result = Integer.parseInt(rateid);
		this.customerid = result;
	}
	public String getDestination() {
		return Destination;
	}

	public void setDestination(String Destination) {
		this.Destination = Destination;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String Source) {
		this.Source = Source;
	}

	public String getLoadType() {
		return (String) loadtype.name();
	}

	public void setLoadType(String loadtype) {
		this.loadtype = LOADTYPE.valueOf(loadtype);
	}
	public String getRateType() {
		return (String) ratetype.name();
	}

	public void setRateType(String ratetype) {
		this.ratetype = RATETYPE.valueOf(ratetype);
	}
	@Override
	public String toString() {
		return "rateentry [rateid=" + rateid + ", Destination=" + Destination
				+ ", Source=" + Source 
				 + ", loadtype=" + loadtype.toString() + "]";
	}

}
