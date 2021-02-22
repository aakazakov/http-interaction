package dev.fun.interaction.server.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fun.interaction.server.dto.SimpleDto;

@RestController
@RequestMapping(name ="/", produces = MediaType.APPLICATION_JSON_VALUE)
public class RequestController {

	@GetMapping("/get/{var}")
	public Map<String, String> getResponse(@PathVariable(name = "var") String var) {
		System.out.println("I've got it");
		Map<String, String> payload = new HashMap<>();
		payload.put("echo", var);
		return payload;
	}
	
	@PostMapping(path = "/post", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SimpleDto postResponse(@RequestBody SimpleDto dto) {
		System.out.println("I've got it");
		dto.setValue(dto.getValue() + " ))");
		return dto;
	}
	
}
