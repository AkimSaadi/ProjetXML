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
		if (typeCompte.equals("courant") || typeCompte.equals("epargne")) {
			this.typeCompte = typeCompte;
		} else {
			throw new ErrTypeCompteException(typeCompte);
		}
		this.typeCompte = typeCompte;
	}
	
	public CompteBancaire() {
		super();
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
	
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	
	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}
	
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	@Override
	public String toString() {
		return "CompteBancaire [numCompte=" + numCompte + ", nomProprietaire=" + nomProprietaire + ", solde=" + solde
				+ ", dateCreation=" + dateCreation + ", typeCompte=" + typeCompte + "]";
	}
	
	
	
}
