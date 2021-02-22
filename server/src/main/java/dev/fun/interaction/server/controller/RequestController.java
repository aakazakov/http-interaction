package dev.fun.interaction.server.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name ="/", produces = MediaType.TEXT_PLAIN_VALUE)
public class RequestController {

	@GetMapping("/{var}")
	public String getResponse(@PathVariable(name = "var") String var) {
		System.out.println("I've got it");
		return "echo: " + var + "\n";
	}
	
}
