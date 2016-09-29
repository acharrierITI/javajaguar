package fr.intech.s5.banque.persistence.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.intech.s5.banque.persistence.model.Client;
import fr.intech.s5.banque.util.exception.BanqueException;

public interface ClientDao {
	/**
	 * Ajoute un client
	 * @param client
	 * @return
	 * @throws BanqueException
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BanqueException.class)
	public Long ajouterClient(Client client) throws BanqueException;
	
	/**
	 * Recherche un client par ID
	 * @param idClient
	 * @return
	 * @throws BanqueException
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public Client rechercherClientParId(long idClient) throws BanqueException;
	
	/**
	 * Recherche tous les clients
	 * @return
	 * @throws BanqueException
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public List<Client> rechercherTousLesClients() throws BanqueException;
	
}
