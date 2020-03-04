package com.kakaopaysec.sjc.model;

public class Customer {
	private Integer year;
	private String name;
	private Integer acctNo;
	private Integer sumAmt;
	
	public Customer(Integer year, String name, Integer acctNo, Integer sumAmt) {
		super();
		this.year = year;
		this.name = name;
		this.acctNo = acctNo;
		this.sumAmt = sumAmt;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(Integer acctNo) {
		this.acctNo = acctNo;
	}
	public Integer getSumAmt() {
		return sumAmt;
	}
	public void setSumAmt(Integer sumAmt) {
		this.sumAmt = sumAmt;
	}
	@Override
	public String toString() {
		return "Customer [year=" + year + ", name=" + name + ", acctNo=" + acctNo + ", sumAmt=" + sumAmt + "]";
	}
}
