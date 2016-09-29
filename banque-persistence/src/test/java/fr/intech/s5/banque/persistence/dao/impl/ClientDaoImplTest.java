package fr.intech.s5.banque.persistence.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.intech.s5.banque.persistence.dao.ClientDao;
import fr.intech.s5.banque.persistence.model.Client;
import fr.intech.s5.util.AbstractDefaultRollbackTestCase;
import fr.intech.s5.util.ModelHelper;
import fr.intech.s5.banque.util.exception.BanqueException;

public class ClientDaoImplTest extends AbstractDefaultRollbackTestCase {
	
	@Autowired
	private ClientDao clientDao;

	/**
	 * Test ajouterClient()
	 * @throws BanqueException
	 */
	@Test
	public void testAjouterClient() throws BanqueException{
		Client client = ModelHelper.getClient();
		
		Long idClient = clientDao.ajouterClient(client);
		getCurrentSession().flush();
		getCurrentSession().clear();
		
		assertNotNull(idClient);
	}
	
	/**
	 * Test rechercherClientParId()
	 * @throws BanqueException
	 */
	@Test
	public void testRechercherClientParId() throws BanqueException{
		Client client = ModelHelper.getClient();
		
		Long idClient = clientDao.ajouterClient(client);
		getCurrentSession().flush();
		getCurrentSession().clear();
		
		Client client1 = clientDao.rechercherClientParId(idClient);
		
		assertNotNull(client1);
		assertEquals(idClient.longValue(), client1.getIdClient());
		
		Client client2 = clientDao.rechercherClientParId(222);
		assertNull(client2);
	}
	
	/**
	 * Test rechercherTousLesClients()
	 * @throws BanqueException
	 */
	@Test
	public void testRechercherTousLesClients() throws BanqueException{
		Client client = ModelHelper.getClient();
		
		clientDao.ajouterClient(client);
		getCurrentSession().flush();
		getCurrentSession().clear();
		
		List<Client> clients = clientDao.rechercherTousLesClients();
		assertFalse(clients.isEmpty());
		assertEquals(1, clients.size());
	}
	
}
