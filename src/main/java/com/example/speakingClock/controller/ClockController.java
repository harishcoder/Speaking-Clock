package com.example.speakingClock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.speakingClock.service.ClockService;

@RestController
public class ClockController {
	
	@Autowired
	ClockService clockService;
	
	@GetMapping("/timeConverter/{time}")
	public String getCurrentTime(@PathVariable(value = "time") String time) {
		String message = clockService.timeConversion(time);
		return message;
	}
}
