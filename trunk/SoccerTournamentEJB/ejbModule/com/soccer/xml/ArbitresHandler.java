package com.soccer.xml;

import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.soccer.model.Arbitre;

/**
 * DefaultHandler for the Arbitre Class.
 */
public class ArbitresHandler extends DefaultHandler {

	/**
	 * The referees.
	 */
	private List<Arbitre> arbitres;
	/**
	 * The current referee.
	 */
	private Arbitre arbitre;

	/**
	 * Initializes the ArbitresHandler.
	 */
	public ArbitresHandler() {
		super();
	}

	/**
	 * Called when an element has been opened.
	 */
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (qName.equals(Arbitre.XML_ARBITRES)) {
			arbitres = new LinkedList<Arbitre>();
		} else if (qName.equals(Arbitre.XML_ARBITRE)) {
			arbitre = new Arbitre();
			arbitre.setNom(attributes.getValue(Arbitre.XML_ARBITRE_NOM));
			arbitre.setPrenom(attributes.getValue(Arbitre.XML_ARBITRE_PRENOM));
		} else {
			// erreur, on peut lever une exception
			throw new SAXException("Balise " + qName + " inconnue.");
		}
	}

	/**
	 * Called when an element has been closed.
	 */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equals(Arbitre.XML_ARBITRES)) {
		} else if (qName.equals(Arbitre.XML_ARBITRE)) {
			arbitres.add(arbitre);
			arbitre = null;
		} else {
			// erreur, on peut lever une exception
			throw new SAXException("Balise " + qName + " inconnue.");
		}
	}

	/**
	 * Gets the list of referees.
	 * 
	 * @return List&lt;Arbitre&gt; of referees.
	 */
	public List<Arbitre> getArbitres() {
		return arbitres;
	}
}
