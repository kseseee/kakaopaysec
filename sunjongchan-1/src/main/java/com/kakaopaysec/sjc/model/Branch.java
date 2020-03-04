package com.kakaopaysec.sjc.model;

public class Branch {
	private Integer year;
	private String brName;
	private String brCode;
	private Integer sumAmt;

	public Branch(Integer year, String brName, String brCode, Integer sumAmt) {
		super();
		this.year = year;
		this.brName = brName;
		this.brCode = brCode;
		this.sumAmt = sumAmt;
	}
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
	}

	public String getBrCode() {
		return brCode;
	}

	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}

	public Integer getSumAmt() {
		return sumAmt;
	}

	public void setSumAmt(Integer sumAmt) {
		this.sumAmt = sumAmt;
	}
	
	@Override
	public String toString() {
		return "Branch [year=" + year + ", brName=" + brName + ", brCode=" + brCode + ", sumAmt=" + sumAmt + "]";
	}
}