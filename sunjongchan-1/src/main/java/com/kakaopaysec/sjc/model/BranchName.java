package com.kakaopaysec.sjc.model;

public class BranchName {
	private String brName;
	private String brCode;
	private Integer sumAmt;
	
	public BranchName(String brName, String brCode, Integer sumAmt) {
		super();
		this.brName = brName;
		this.brCode = brCode;
		this.sumAmt = sumAmt;
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
		return "BranchName [brName=" + brName + ", brCode=" + brCode + ", sumAmt=" + sumAmt + "]";
	}
}
