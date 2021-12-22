package com.bridgelabz.greetingapp.service;

import java.util.List;

import com.bridgelabz.greetingapp.dto.UserDto;
import com.bridgelabz.greetingapp.model.Greeting;

public interface IGreetingService {
    Greeting greetingMessage();
    String gettingMessageByName(UserDto userDto);
    Greeting findById(long messageId);
    List<Greeting> getMessages();
    Greeting editMessage(Greeting greeting);
    
}

