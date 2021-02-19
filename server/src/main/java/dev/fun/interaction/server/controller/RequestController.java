package dev.fun.interaction.server.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name ="/", produces = MediaType.TEXT_PLAIN_VALUE)
public class RequestController {

	@GetMapping
	public String getResponse() {
		return "Hello, friend!";
	}
	
}
