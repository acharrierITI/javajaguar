package fr.intech.s5.tp.banque.business.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.intech.s5.banque.persistence.dao.ClientDao;
import fr.intech.s5.banque.persistence.dao.CompteDao;
import fr.intech.s5.banque.persistence.model.Client;
import fr.intech.s5.banque.util.exception.BanqueException;
import fr.intech.s5.tp.banque.business.service.BanqueService;

public class BanqueServiceImplTest {

	@InjectMocks
	private BanqueService banqueService = new BanqueServiceImpl();
	
	@Mock
	public ClientDao clientDao;
	
	@Mock
	public CompteDao compteDao;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAuthentifier() throws BanqueException {
		Client client = new Client();
		client.setNom("Martin");
		client.setPrenom("Mickael");
		client.setAdresse("11 rue La Fayette Paris");
		client.setCodePostal(75002);
		client.setPassword("password");
		client.setVille("Paris");
		client.setEmail("m.martin@gmail.com");
		
		Mockito.when(clientDao.rechercherClientParEmail(Mockito.anyString())).thenReturn(client);
		
		Client clientAuth = banqueService.authentifier("m.martin@gmail.com", "password");
		assertNotNull(clientAuth);
		
		Mockito.verify(clientDao).rechercherClientParEmail("m.martin@gmail.com");
		
	}
	
}
