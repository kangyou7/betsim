package com.dongak.betinfo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimulatorController {
	
	
	@RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
