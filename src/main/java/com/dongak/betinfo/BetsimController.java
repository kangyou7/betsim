package com.dongak.betinfo;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dongak.betinfo.domain.BetsimBean;
import com.fasterxml.jackson.core.JsonProcessingException;

import ch.qos.logback.classic.Logger;

@RestController
public class BetsimController {
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(BetsimController.class);


	@RequestMapping("/betsim")
    public String getBetsimResult(BetsimBean req) throws JsonProcessingException {
		
		log.info("\n"+req.toString());
		
		Betsim b = new Betsim();
		
        return b.getSimulResult(req);
    }
	
}
