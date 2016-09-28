package fr.intech.s5.impl;

import fr.intech.s5.service.HelloIntech;

public class HelloIntechImpl implements HelloIntech {

	@Override
	public String sayHello(String pName) {
		return "Hello " + pName;
	}

}
