package com.qintess.clinicaVeterinaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class IndexController {
	
	@RequestMapping("")
	public String home() {
		return "index";
	}

}
