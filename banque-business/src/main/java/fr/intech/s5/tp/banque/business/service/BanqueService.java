package fr.intech.s5.tp.banque.business.service;

import java.util.List;

import fr.intech.s5.banque.persistence.model.Client;
import fr.intech.s5.banque.persistence.model.Compte;
import fr.intech.s5.banque.util.exception.BanqueException;

public interface BanqueService {
	public Client authentifier(String pEmail, String pPassword) throws BanqueException;
	public List<Compte> mesComptes(long pIdClient) throws BanqueException;
	public void faireUnVirement(long pNumeroADebiter, long pNumeroACrediter, double pMontant) throws BanqueException;
}
