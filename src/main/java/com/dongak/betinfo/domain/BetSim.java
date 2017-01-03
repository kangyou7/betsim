package com.dongak.betinfo.domain;

public class BetSim extends CommonVO {
	
	private String avgOdd;	//평균 배당율
	private String refdOdd;	//당첨 확율
	private String deposit;	//예치금
	private String rollNum; //예치금을 나눈 수
	
	public String getAvgOdd() {
		return avgOdd;
	}
	public void setAvgOdd(String avgOdd) {
		this.avgOdd = avgOdd;
	}
	public String getRefdOdd() {
		return refdOdd;
	}
	public void setRefdOdd(String refdOdd) {
		this.refdOdd = refdOdd;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getRollNum() {
		return rollNum;
	}
	public void setRollNum(String rollNum) {
		this.rollNum = rollNum;
	}

}
