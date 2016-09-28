package fr.intech.s5.banque.persistence.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.intech.s5.banque.persistence.dao.ClientDao;
import fr.intech.s5.banque.persistence.model.Client;
import fr.intech.s5.banque.util.exception.BanqueException;

public class ClientDaoImpl implements ClientDao {
	
	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public Long ajouterClient(Client pClient) throws BanqueException {
		Long idClient = null;
		try{
			idClient= (Long) sessionFactory.getCurrentSession().save(pClient);
		}catch(Exception e){
			throw new BanqueException("Erreur lors de l'enregistrement du client", e);
		}
		return idClient;
	}

	@Override
	public Client rechercherClientParId(long pIdClient) throws BanqueException {
		Client client = null;
		try{
			client = (Client) sessionFactory.getCurrentSession().get(Client.class, new Long(pIdClient));
		}catch(Exception e){
			throw new BanqueException("Erreur lors de la récupération du client", e);
		}
		return client;
	}

	@Override
	public List<Client> rechercherTousLesClients() throws BanqueException {
		List<Client> listClient = null;
		try{
			String query = "from Client as c";
			listClient = sessionFactory.getCurrentSession().createQuery(query).getResultList();
		}catch(Exception e){
			throw new BanqueException("Erreur lors de l'obtention de la liste des clients", e);
		}
		return listClient;
	}
	
	

}
