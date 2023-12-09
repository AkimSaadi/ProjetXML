package projetxml;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class AfficherCompte {
	
	public static void printAccount(String fileName) {
		List<CompteBancaire> comptes = readXMLFile(fileName);
		System.out.println("Liste des comptes : ");
		for (CompteBancaire compte : comptes) {
			System.out.println(compte);
		}

		System.out.println("Liste des comptes courants : ");
		for (CompteBancaire compte : comptes) {
			if (compte.getTypeCompte().equals("courant")) {
				System.out.println(compte);
			}
		}
	}

	private static List<CompteBancaire> readXMLFile(String fileName) {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(fileName);
		Document jdomDoc;
		List<CompteBancaire> comptes = new ArrayList<CompteBancaire>();
		try {
			jdomDoc = (Document) builder.build(xmlFile);
			Element root = jdomDoc.getRootElement();
			comptes = new ArrayList<CompteBancaire>();
			List<Element> compteList = root.getChildren("CompteBancaire");
			for (Element compte : compteList) {
				CompteBancaire c = new CompteBancaire();
				c.setNumCompte(Integer.parseInt(compte.getChildText("numCompte")));
				c.setNomProprietaire(compte.getChildText("nomProprietaire"));
				c.setSolde(Double.parseDouble(compte.getChildText("solde")));
				c.setDateCreation(LocalDate.parse(compte.getChildText("dateCreation")));
				c.setTypeCompte(compte.getChildText("typeCompte"));
				comptes.add(c);
			}
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
		return comptes;
	}

	
}
