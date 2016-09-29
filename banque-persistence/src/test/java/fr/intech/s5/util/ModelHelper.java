package fr.intech.s5.util;

import fr.intech.s5.banque.persistence.model.Client;

public class ModelHelper {

	public static Client getClient(){
		Client client = new Client();
		
		client.setNom("Martin");
		client.setPrenom("Mickael");
		client.setAdresse("11 rue La Fayette");
		client.setCodePostal(75002);
		client.setPassword("password");
		client.setVille("Paris");
		client.setEmail("m.martin@gmail.com");
		
		return client;
	}
	
}
