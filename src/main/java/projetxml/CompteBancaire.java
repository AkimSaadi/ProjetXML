package projetxml;

import java.time.LocalDate;

public class CompteBancaire {
	private int numCompte;
	private String nomProprietaire;
	private double solde;
	private LocalDate dateCreation;
	private String typeCompte;
	
	public CompteBancaire(int numCompte, String nomProprietaire, double solde, LocalDate dateCreation,
			String typeCompte) throws ErrTypeCompteException {
		this.numCompte = numCompte;
		this.nomProprietaire = nomProprietaire;
		this.solde = solde;
		this.dateCreation = dateCreation;
		if (typeCompte.equals("compte courant") || typeCompte.equals("compte épargne")) {
			this.typeCompte = typeCompte;
		} else {
			throw new ErrTypeCompteException(typeCompte);
		}
		this.typeCompte = typeCompte;
	}

	public int getNumCompte() {
		return numCompte;
	}


	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public double getSolde() {
		return solde;
	}


	public LocalDate getDateCreation() {
		return dateCreation;
	}
	public String getTypeCompte() {
		return typeCompte;
	}
	
}
