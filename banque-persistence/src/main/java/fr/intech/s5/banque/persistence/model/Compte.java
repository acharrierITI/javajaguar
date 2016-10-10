package fr.intech.s5.banque.persistence.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;

@Entity
@Table
public class Compte {

	@Id
	@Column(name="numero_compte")
	private long numeroCompte;
	
	@Column(name="solde")
	private double solde;
	
	public long getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(long numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_client")
	private Client client;
	
}
