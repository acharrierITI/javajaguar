package fr.intech.s5.banque.persistence.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.intech.s5.banque.persistence.model.Client;
import fr.intech.s5.banque.persistence.model.Compte;
import fr.intech.s5.banque.util.exception.BanqueException;

public interface CompteDao {
	
	/**
	 * Ajoute un compte
	 * @param compte
	 * @return
	 * @throws BanqueException
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BanqueException.class)
	public boolean ajouterCompte(Compte compte) throws BanqueException;

	/**
	 * Recherche un compte par numéro
	 * @param numeroCompte
	 * @return
	 * @throws BanqueException
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public Compte rechercherCompteParNumero(long numeroCompte) throws BanqueException;
	
	/**
	 * Recherche un compte par client
	 * @param client
	 * @return
	 * @throws BanqueException
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public List<Compte> rechercherCompteClient(Client client) throws BanqueException;
	
	/**
	 * Modifie un compte
	 * @param compte
	 * @return
	 * @throws BanqueException
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BanqueException.class)
	public Compte modifierCompte(Compte compte) throws BanqueException;
}
