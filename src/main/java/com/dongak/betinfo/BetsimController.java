package com.dongak.betinfo;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dongak.betinfo.domain.BetsimBean;

import ch.qos.logback.classic.Logger;

@RestController
public class BetsimController {
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(BetsimController.class);
	
	@RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

	@RequestMapping("/betsim")
    public String getBetsimResult(BetsimBean req) {
		
		log.info(req.toString());
		
		Betsim b = new Betsim();
		
        return b.getSimulResult(req);
    }
	
}
