package com.bridgelabz.greetingapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.greetingapp.dto.UserDto;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.repository.IGreetingRepository;

import java.util.concurrent.atomic.AtomicLong;




@Service
public class GreetingService implements IGreetingService {
	
	 private static final String template = "Hello world";
	 private final AtomicLong counter = new AtomicLong();
	 
	 @Autowired
	 private IGreetingRepository greetingRepository;
	 
	 /**
	  * Call method to save the message in the repository
	  */
	 @Override
	 public Greeting greetingMessage() {
		 return greetingRepository.save(new Greeting(counter.incrementAndGet(), String.format(template)));
	 }
	 
	 @Override
	 public String gettingMessageByName(UserDto userDto) {
		 User user = new User();
		 ModelMapper modelMapper = new ModelMapper();
		 modelMapper.map(userDto, user);
		 return ("Hello" +" "+ user.getFirstName() + " " + user.getLastName()+"...");
	}
	 
	 @Override
		public Greeting findById(long messageId) {
			return greetingRepository.findById(messageId).get();
		}
	 
	
	
}