package com.dongak.betinfo;

import java.util.Random;

import org.slf4j.LoggerFactory;

import com.dongak.betinfo.domain.BetsimBean;

import ch.qos.logback.classic.Logger;

public class Betsim {
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(Betsim.class);
	
	private static final int MINIUM_STAKE = 5;
	
	/**
	 * 베팅시뮬
	 * @param in
	 * @return
	 */
	public String getSimulResult(BetsimBean in ) {
		
		log.info(in.toString());
		
		StringBuilder str = new StringBuilder();
		
		float profit = 0;
		float loss = 0;
		float balance = in.getDeposit();
		float bankroll = balance/in.getRollNumber();
		float stake = 0;
		
		str.append("==============");
		str.append("initial state");
		str.append("==============");
		str.append("balance		="+balance);
		str.append("bankroll	="+bankroll);
		str.append("average odds="+in.getAverageOdds());
		str.append("probability	="+in.getProbability());
		str.append("==============");
		
		for(int i = 1;balance > bankroll ;i++) {
			
			
			if (profit > MINIUM_STAKE) {
				stake = profit;
			} else {
				stake = bankroll;
			}
			
			if (isSuccess(in)) {
				profit = in.getAverageOdds()*stake;
				balance = balance + profit;
			} else {
				loss = bankroll;
				balance = balance - loss;
			}
			
			if (balance >=  in.getDeposit()*in.getMultiNumber()) {
				break;
			}
						
		}
		
		return str.toString();
	}
	
	
	/**
	 * 당첨성공여부
	 * @param in
	 * @return
	 */
	public boolean isSuccess(BetsimBean in) {
		
		boolean result;

		Random r = new Random();
		int p = r.nextInt(100);
		
		if (p < in.getProbability()) {
			result = true;
		} else {
			result = false;
		}
		
		log.info(String.valueOf(result));
		
		return result;
	}
	
}
