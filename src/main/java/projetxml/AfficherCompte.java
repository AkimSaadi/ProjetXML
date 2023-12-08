package projetxml;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class AfficherCompte {

	public static void main(String[] args) {
		final String fileName = "compteBancaire.xml";
		try {
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File(fileName);
			Document jdomDoc = (Document) builder.build(xmlFile);

			Element root = jdomDoc.getRootElement();
			List<CompteBancaire> comptes = new ArrayList<CompteBancaire>();
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
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
		}
	}

}
