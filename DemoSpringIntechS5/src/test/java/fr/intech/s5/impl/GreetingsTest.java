package fr.intech.s5.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.intech.s5.service.Greetings;

public class GreetingsTest {
	
ApplicationContext context;
	
	@Autowired
	Greetings greeting;
	
	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("app-context.xml");
		
	}
	
	@Test
	public void testGreetings() {
		String sHello = greeting.meetSomeOne("Martin");
		assertEquals("Hello Martin", sHello);
	}
}
