package fr.intech.s5.impl;

import org.springframework.beans.factory.annotation.Autowired;

import fr.intech.s5.service.Greetings;
import fr.intech.s5.service.HelloIntech;

public class GreetingImpl implements Greetings {
	@Autowired
	private HelloIntech hello;
	
	//CONSTRUCTOR
	public GreetingImpl() {
	}

	public GreetingImpl(HelloIntech hello) {			
		this.hello = hello;
	}
	
	@Override
	public String meetSomeOne(String pName) {
		return hello.sayHello(pName);
	}
	
	public void setHello(HelloIntech pHello) {
        hello = pHello;
 }
	
	


}
