package com.smartnet.projet.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSpringSecurity {

	@RequestMapping("/hello")
	public String index() {
		return "hello!!!!!!!!!!!!!!!";
	}

}
