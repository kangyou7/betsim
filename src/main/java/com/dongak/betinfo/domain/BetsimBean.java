package com.dongak.betinfo.domain;

@SuppressWarnings("serial")
public class BetsimBean extends CommonVO {
	
	private float averageOdds;	//평균 배당율
	private int probability;	//당첨 확율
	private int deposit;	//예치금
	private int rollNumber; //예치금을 나눈 수
	
	public float getAverageOdds() {
		return averageOdds;
	}
	public void setAverageOdds(float averageOdds) {
		this.averageOdds = averageOdds;
	}
	public int getProbability() {
		return probability;
	}
	public void setProbability(int probability) {
		this.probability = probability;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	

}
