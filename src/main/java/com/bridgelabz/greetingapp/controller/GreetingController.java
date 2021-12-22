package com.bridgelabz.greetingapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.greetingapp.dto.UserDto;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.service.IGreetingService;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	/*
	 * localhost:8080/greeting
	 * 
	 * @return={id =1 , content="hello world!}
	 * 
	 * localhost:8080/greeting?name=Aditya
	 * 
	 * @return= { id=2, content="hello Aditya
	 */
	@GetMapping(value = { "/greeting", "/greeting/", "/greeting/home" })
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	/*
	 * localhost:8080/greeting/Aditya
	 * 
	 * @return={id =1 , content="hello Aditya!}
	 */
	@GetMapping("greeting/{name}")
	public Greeting greetings(@PathVariable String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@Autowired
	private IGreetingService greetingService;

	/*
	 * localhost:8080/greeting/service
	 * 
	 * @return={id =1 , content="hello world!}
	 */
	@GetMapping("greeting/service")
	public Greeting greeting() {
		return greetingService.greetingMessage();

	}

	@PostMapping("/greeting")
	public String greetingMessage(@RequestBody UserDto userDto) {
		return greetingService.gettingMessageByName(userDto);

	}
	
	/**
	 * finding the data by using messageId
	 * @param messageId
	 * @return
	 */

	@GetMapping("/service/{messageId}")
	public Greeting findById(@PathVariable String messageId) {
		return this.greetingService.findById(Long.parseLong(messageId));
	}
	
	/**
	 * using findAll method to list all the messages
	 */
	@GetMapping("/findall")
	public List<Greeting>getMessages(){
		return this.greetingService.getMessages();
	}
}