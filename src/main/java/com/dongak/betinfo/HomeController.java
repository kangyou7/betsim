package com.dongak.betinfo;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;

public class HomeController {
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
    public String index() {
        return "index";
    }


}
