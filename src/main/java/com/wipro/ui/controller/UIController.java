package com.wipro.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {
	@RequestMapping(value="/home")
	public String load() {
		return "index";
	}
}
