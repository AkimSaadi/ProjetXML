package projetxml;

public class ErrTypeCompteException extends Exception{
	public ErrTypeCompteException(String typeCompte) {
		super(typeCompte+" est différent de compte courant ou compte épargne");
	}

}
