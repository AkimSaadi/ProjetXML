package projetxml;

import java.time.LocalDate;
import java.util.Scanner;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileWriter;
import java.io.IOException;

public class ReadInfo {
	public static void main(String[] args) throws ErrTypeCompteException {
		try {
			Document doc = new Document();
			doc.setRootElement(new Element("CompteBancaire"));
			Scanner sc = new Scanner(System.in);
			for (int i=0; i<2; i++) {
				System.out.printf("Veuillez saisir le numero de compte du client %d:\n",i);
				int numCompte = Integer.parseInt(sc.nextLine());
				System.out.printf("Veuillez saisir le nom du proprietaire du client %d:\n",i);
				String nomProprietaire = sc.nextLine();
				System.out.printf("Veuillez saisir le solde du client %d:\n",i);
				Double solde = Double.parseDouble(sc.nextLine());
				System.out.printf("Veuillez saisir lannee de creation du compte du client %d:\n",i);
				int annee =Integer.parseInt(sc.nextLine());
				System.out.printf("Veuillez saisir le mois de creation du compte du client %d:\n",i);
				int mois = Integer.parseInt(sc.nextLine());
				System.out.printf("Veuillez saisir le jour de creation du compte du client %d:\n",i);
				int jour = Integer.parseInt(sc.nextLine());
				System.out.printf("Veuillez saisir le type de compte du client %d:\n",i);
				String typeCompte = sc.nextLine();
				if (i==0) {
		            CompteBancaire c1 = new CompteBancaire(numCompte, nomProprietaire, solde, LocalDate.of(annee, mois, jour), typeCompte);
		            doc.getRootElement().addContent(createCompteBancaireElement(c1));
		        }
		        else {
		            CompteBancaire c2 = new CompteBancaire(numCompte, nomProprietaire, solde, LocalDate.of(annee, mois, jour), typeCompte);
		            doc.getRootElement().addContent(createCompteBancaireElement(c2));
		        }
			}
			sc.close();
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter("compteBancaire.xml"));
			System.out.println("File Saved!");
			
		}catch(IOException e) {
            System.out.println(e.getMessage());
	}
	finally {
	}
}

private static Element createCompteBancaireElement(CompteBancaire compteBancaire) {
	Element compteBancaireElement = new Element("CompteBancaire");
	compteBancaireElement.addContent(new Element("numCompte").setText("" + compteBancaire.getNumCompte()));
	compteBancaireElement.addContent(new Element("nomProprietaire").setText(compteBancaire.getNomProprietaire()));
	compteBancaireElement.addContent(new Element("solde").setText("" + compteBancaire.getSolde()));
	compteBancaireElement.addContent(new Element("dateCreation").setText("" + compteBancaire.getDateCreation()));
	compteBancaireElement.addContent(new Element("typeCompte").setText(compteBancaire.getTypeCompte()));

	return compteBancaireElement;
}

}
