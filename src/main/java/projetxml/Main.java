package projetxml;

import java.util.Scanner;

import org.jdom2.JDOMException;

public class Main {

	public static void main(String[] args) throws JDOMException {
		String fileName = "compteBancaire.xml";
		int choix = 0;
		Scanner sc = new Scanner(System.in);
		do {
		System.out.println("---------------------MENU-------------------------");
		System.out.println("Bienvenue dans le programme de gestion de compte bancaire !");
		System.out.println("Que voulez-vous faire ?");
		System.out.println("1. Afficher les comptes");
		System.out.println("2. Ajouter un compte");
		System.out.println("3. Supprimer un compte");
		System.out.println("4. Ajouter un attribut");
		System.out.println("5. Quitter");
		choix = Integer.parseInt(sc.nextLine());
		switch (choix) {
		case 1:
			System.out.println("------------AFFICHAGE DES COMPTES----------------");
			AfficherCompte.printAccount(fileName);
			break;
		case 2:
			System.out.println("------------AJOUT D'UN COMPTE----------------");
			try {
                AjoutCompte.addAccount(sc,fileName);
            } catch (ErrTypeCompteException e) {
                System.out.println(e.getMessage());
            }
            break;
        case 3:
        	System.out.println("------------SUPPRESSION D'UN COMPTE----------------");
        	System.out.println("Veuillez saisir le numero de compte du client a supprimer");
        	int numCompte = Integer.parseInt(sc.nextLine());
        	boolean deleted = SuppressionCompte.deleteAttribut(fileName, numCompte);
        	if (deleted) {
        		System.out.println("Le compte a bien ete supprime");
        	}else {
        		System.out.println("Le compte n'a pas ete supprime");
        	}
            break;
        case 4:
        	System.out.println("------------AJOUT D'UN ATTRIBUT----------------");
        	System.out.println("Veuillez saisir le nom de l'attribut a ajouter");
        	String attributType = sc.nextLine();
        	System.out.println("Veuillez saisir la valeur de l'attribut a ajouter");
        	String attribut = sc.nextLine();
        	AjoutAttribut.addAttribut(fileName, attributType, attribut);
            break;
        case 5:
        	System.out.println("Au revoir !");
        	sc.close();
        	System.exit(0);
		}
		System.out.println("Appuyez sur une touche pour revenir au menu");
		sc.nextLine();
		}while(true);

	}
}
