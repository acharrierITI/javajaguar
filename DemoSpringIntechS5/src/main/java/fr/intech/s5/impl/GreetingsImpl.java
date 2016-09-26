package fr.intech.s5.impl;

import org.springframework.beans.factory.annotation.Autowired;

import fr.intech.s5.service.Greetings;
import fr.intech.s5.service.HelloIntech;

public class GreetingsImpl implements Greetings {
	
	@Autowired
	private HelloIntech hello;
	
	@Override
	public String meetSomeOne(String pName) {
		return hello.sayHello(pName);
	}
	
	public void setHello(HelloIntech pHello) {
        hello = pHello;
	}
	
	/**
	 * Constructeur
	 */
	public GreetingsImpl(){
		
	}
	
	/**
	 * Constructeur
	 * @param hello
	 */
	public GreetingsImpl(HelloIntech hello){
		this.hello = hello;
	}

}
