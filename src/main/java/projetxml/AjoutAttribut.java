package projetxml;

import java.io.File;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import java.io.FileWriter;
import java.io.IOException;

public class AjoutAttribut {

	public static void main(String[] args) throws JDOMException {
		addAttribut("compteBancaire.xml", "typePersonne", "physique");

	}

	private static void addAttribut(String filename, String attributType, String Attribut) throws JDOMException {
		try {
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File(filename);
			Document jdomDoc = (Document) builder.build(xmlFile);
			Element root = jdomDoc.getRootElement();
			List<Element> compteList = root.getChildren("CompteBancaire");
			for (Element compte : compteList) {
				compte.setAttribute(attributType, Attribut);
			}
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(jdomDoc, new FileWriter(filename));
			System.out.println("File Saved!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
		}
		
	}

}
