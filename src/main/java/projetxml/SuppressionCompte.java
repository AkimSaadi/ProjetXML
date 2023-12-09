package projetxml;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.List;

public class SuppressionCompte {
	public static boolean deleteAttribut(String fileName, int numCompte) throws JDOMException {
		boolean deleted = false;
		try {
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File(fileName);
			Document jdomDoc = (Document) builder.build(xmlFile);
			Element root = jdomDoc.getRootElement();
			List<Element> compteList = root.getChildren("CompteBancaire");
			for (Element compte : compteList) {
				if (Integer.parseInt(compte.getChildText("numCompte")) == numCompte) {
					root.removeContent(compte);
					deleted = true;					
				}
			}
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(jdomDoc, new FileWriter(fileName));
			System.out.println("File Saved!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
		}
		return deleted;
		
	}

}
