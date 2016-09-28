package fr.intech.s5.banque.persistence.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.intech.s5.banque.persistence.dao.CompteDao;
import fr.intech.s5.banque.persistence.model.Client;
import fr.intech.s5.banque.persistence.model.Compte;
import fr.intech.s5.banque.util.exception.BanqueException;

public class CompteDaoImpl implements CompteDao {

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public boolean ajouterCompte(Compte pCompte) throws BanqueException {
		boolean ajout = false;
		try{
			ajout = (Boolean) sessionFactory.getCurrentSession().save(pCompte);
		}catch(Exception e){
			throw new BanqueException("Erreur lors de l'enregistrement d'un compte", e);
		}
		return ajout;
	}

	@Override
	public Compte rechercherCompteParNumero(long pNumeroCompte) throws BanqueException {
		Compte compte = null;
		try{
			compte = (Compte) sessionFactory.getCurrentSession().get(Compte.class, pNumeroCompte);
		}catch(Exception e){
			throw new BanqueException("Erreur lors de la récupération du compte", e);
		}
		return compte;
	}

	@Override
	public List<Compte> rechercherCompteClient(Client pClient) throws BanqueException {
		List<Compte> listCompte = null;
		try{
			String query = "from Compte as c where c.client.idClient=:idclient";
			Query req = sessionFactory.getCurrentSession().createQuery(query);
			req.setParameter("idclient", pClient.getIdClient());
			listCompte = req.getResultList();
		}catch(Exception e){
			throw new BanqueException("Erreur lors de la récupération des comptes", e);
		}
		return listCompte;
	}

	@Override
	public Compte modifierCompte(Compte pCompte) throws BanqueException {
		// TODO Auto-generated method stub
		return null;
	}

}
