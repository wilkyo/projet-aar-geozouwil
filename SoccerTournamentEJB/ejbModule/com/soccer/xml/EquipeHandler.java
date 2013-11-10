package com.soccer.xml;

import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.soccer.model.Equipe;
import com.soccer.model.Joueur;

/**
 * DefaultHandler for the Equipe Class.
 */
public class EquipeHandler extends DefaultHandler {

	/**
	 * The teams.
	 */
	private List<Equipe> equipes;
	/**
	 * The players of a team.
	 */
	private List<Joueur> joueurs;
	/**
	 * The current team.
	 */
	private Equipe equipe;
	/**
	 * The current player.
	 */
	private Joueur joueur;
	// flags nous indiquant la position du parseur
	private boolean inEquipe, inJoueur;

	/**
	 * Initializes the EquipeHandler.
	 */
	public EquipeHandler() {
		super();
		if (inEquipe && inJoueur)
			; // TODO
	}

	/**
	 * Called when an element has been opened.
	 */
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (qName.equals(Equipe.XML_EQUIPES)) {
			equipes = new LinkedList<Equipe>();
		} else if (qName.equals(Equipe.XML_EQUIPE)) {
			equipe = new Equipe();
			equipe.setNom(attributes.getValue(Equipe.XML_EQUIPE_NOM));
			equipe.setNomRepresentant(attributes
					.getValue(Equipe.XML_EQUIPE_NOM_REPRESENTANT));
			equipe.setPrenomRepresentant(attributes
					.getValue(Equipe.XML_EQUIPE_PRENOM_REPRESENTANT));
			joueurs = new LinkedList<Joueur>();
			inEquipe = true;
		} else if (qName.equals(Joueur.XML_JOUEUR)) {
			joueur = new Joueur();
			try {
				// joueur.setId(Integer.parseInt(attributes
				// .getValue(Joueur.XML_JOUEUR_ID)));
				joueur.setNom(attributes.getValue(Joueur.XML_JOUEUR_NOM));
				joueur.setPrenom(attributes.getValue(Joueur.XML_JOUEUR_PRENOM));
				joueur.setNumero(Integer.parseInt(attributes
						.getValue(Joueur.XML_JOUEUR_NUMERO)));
				joueur.setEquipe(this.equipe);
			} catch (java.lang.NumberFormatException e) {
				// erreur, le contenu de id n'est pas un entier
				throw new SAXException(e);
			}
			inJoueur = true;
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
		if (qName.equals(Equipe.XML_EQUIPES)) {
		} else if (qName.equals(Equipe.XML_EQUIPE)) {
			equipe.setJoueurs(joueurs);
			equipes.add(equipe);
			equipe = null;
			inEquipe = false;
		} else if (qName.equals(Joueur.XML_JOUEUR)) {
			joueurs.add(joueur);
			joueur = null;
			inJoueur = false;
		} else {
			// erreur, on peut lever une exception
			throw new SAXException("Balise " + qName + " inconnue.");
		}
	}

	/**
	 * Gets the list of teams.
	 * 
	 * @return List&lt;Equipe&gt; of teams.
	 */
	public List<Equipe> getEquipes() {
		return equipes;
	}
}
