package com.leniorko.LearnignWebSockets.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class greetingController {
	@GetMapping("/")
	public String greet() {
		System.out.println("Accepted");
		return "Greetings";
	}
}
