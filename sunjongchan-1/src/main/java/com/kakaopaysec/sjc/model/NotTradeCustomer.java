package com.kakaopaysec.sjc.model;

public class NotTradeCustomer {
	private Integer year;
	private String name;
	private Integer acctNo;
	
	public NotTradeCustomer(Integer year, String name, Integer acctNo) {
		super();
		this.year = year;
		this.name = name;
		this.acctNo = acctNo;
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
	@Override
	public String toString() {
		return "NotTradeCustomer [year=" + year + ", name=" + name + ", acctNo=" + acctNo + "]";
	}
	
}
