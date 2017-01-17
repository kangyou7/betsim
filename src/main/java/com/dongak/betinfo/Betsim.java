package com.dongak.betinfo;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.LoggerFactory;

import com.dongak.betinfo.domain.BetsimBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.classic.Logger;

public class Betsim {

	private static final Logger log = (Logger) LoggerFactory.getLogger(Betsim.class);

	private static final int MINIUM_STAKE = 5;

	/**
	 * 베팅시뮬
	 * 
	 * @param in
	 * @return
	 * @throws JsonProcessingException
	 */
	public String getSimulResult(BetsimBean in) throws JsonProcessingException {

		StringBuilder str = new StringBuilder();

		int simulTimes, netCount;
		simulTimes = 100;
		netCount = 0;

		ObjectMapper objectMapper = new ObjectMapper();
		List<Object> objList = new LinkedList<Object>();
		Map<String, Object> out = new LinkedHashMap<String, Object>();

		for (int n = 1; n <= simulTimes; n++) {

			Map<String, Object> obj = new LinkedHashMap<String, Object>();
			float profit, loss, stake;
			profit = 0;
			loss = 0;
			stake = 0;
			float balance = in.getDeposit();
			float bankroll = balance / in.getRollNumber();

			for (int i = 1; balance > bankroll; i++) {

				str = new StringBuilder();
				stake = 0;

				if (profit > MINIUM_STAKE) {
					stake = profit;
				} else {
					stake = bankroll;
				}

				profit = 0;
				loss = 0;

				if (isSuccess(in)) {
					profit = in.getAverageOdds() * stake - stake;
					balance = balance + profit;
				} else {
					loss = stake;
					balance = balance - loss;
				}

				if (balance >= in.getDeposit() * in.getMultiNumber()) {
					obj.put("try", n);
					obj.put("th", i);
//					obj.put("stake", stake);
//					obj.put("profit", profit);
//					obj.put("loss", loss);
					obj.put("balance", balance);
					str.append(n).append(" try").append(",").append(i).append(" th").append(",").append("stake=")
							.append(stake).append(",").append("profit=").append(profit).append(",").append("loss=")
							.append(loss).append(",").append("balance=").append(balance);
					// System.out.println(str.toString());
					netCount++;
					break;
				}
				obj.put("try", n);
				obj.put("th", i);
//				obj.put("stake", stake);
//				obj.put("profit", profit);
//				obj.put("loss", loss);
				obj.put("balance", balance);
				str.append(n).append(" try").append(",").append(i).append(" th").append(",").append("stake=")
						.append(stake).append(",").append("profit=").append(profit).append(",").append("loss=")
						.append(loss).append(",").append("balance=").append(balance);
				// System.out.println(str.toString());
			}
			objList.add(obj);
		}

		out.put("percent", netCount);
		out.put("list", objList);

		System.out.println("netCount=" + netCount);
		System.out.println(objectMapper.writeValueAsString(objList));
		System.out.println("======================================================");
		System.out.println(objectMapper.writeValueAsString(out));
		System.out.println("======================================================");

		return objectMapper.writeValueAsString(out);
	}

	/**
	 * 당첨성공여부
	 * 
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

		return result;
	}

}
