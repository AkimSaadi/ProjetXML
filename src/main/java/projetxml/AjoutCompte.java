package projetxml;

import java.io.File;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class AjoutCompte {
	
	
	public static void main(String[] args) throws ErrTypeCompteException, JDOMException {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Veuillez saisir le numero de compte du client");
		int numCompte = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez saisir le nom du proprietaire du client ");
		String nomProprietaire = sc.nextLine();
		System.out.println("Veuillez saisir le solde du client ");
		Double solde = Double.parseDouble(sc.nextLine());
		System.out.println("Veuillez saisir lannee de creation du compte du client");
		int annee =Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez saisir le mois de creation du compte du client");
		int mois = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez saisir le jour de creation du compte du client");
		int jour = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez saisir le type de compte du client:");
		String typeCompte = sc.nextLine();
		sc.close();
        CompteBancaire c1 = new CompteBancaire(numCompte, nomProprietaire, solde, LocalDate.of(annee, mois, jour), typeCompte);
        addAccount("compteBancaire.xml", c1);

	}
private static void addAccount(String fileName, CompteBancaire compteBancaire) throws JDOMException {
	try {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(fileName);
		Document jdomDoc = (Document) builder.build(xmlFile);
		Element root = jdomDoc.getRootElement();
        root.addContent(createCompteBancaireElement(compteBancaire));
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(jdomDoc, new FileWriter(fileName));
        System.out.println("File Saved!");
	} catch (IOException e) {
		System.out.println(e.getMessage());
	} finally {
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
