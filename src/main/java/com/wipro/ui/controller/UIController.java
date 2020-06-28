package com.wipro.ui.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class UIController {

	@Autowired
	RestTemplate rest;

	@RequestMapping(value = "/")
	public String load() {
		return "index";
	}

	@RequestMapping(value = "/getData")
	public void getData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ResponseEntity<String> resp = rest.getForEntity(
				"https://b7m9hsi226.execute-api.ap-south-1.amazonaws.com/default/callJavaAPI", String.class);
		PrintWriter print = response.getWriter();
		print.write(resp.getBody());
	}
}
