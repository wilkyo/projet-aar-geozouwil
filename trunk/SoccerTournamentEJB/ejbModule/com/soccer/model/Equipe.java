package com.soccer.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Class of Equipe.
 */
@Entity
public class Equipe implements Serializable {

	/**
	 * The serial version id.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constants.
	 */
	public static final String XML_EQUIPES = "Equipes";
	public static final String XML_EQUIPE = "Equipe";
	public static final String XML_EQUIPE_NOM = "nom";
	public static final String XML_EQUIPE_NOM_REPRESENTANT = "nomRepresentant";
	public static final String XML_EQUIPE_PRENOM_REPRESENTANT = "prenomRepresentant";
	public static final String XML_EQUIPE_JOUEURS = "Joueurs";
	/**
	 * Name of the team.
	 */
	private String nom;
	/**
	 * List of the players.
	 */
	private List<Joueur> joueurs;
	/**
	 * Name of the representative.
	 */
	private String nomRepresentant;
	/**
	 * Nickname of the representative.
	 */
	private String prenomRepresentant;

	/**
	 * @return the nom
	 */
	@Id
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the nomRepresentant
	 */
	public String getNomRepresentant() {
		return nomRepresentant;
	}

	/**
	 * @param nomRepresentant
	 *            the nomRepresentant to set
	 */
	public void setNomRepresentant(String nomRepresentant) {
		this.nomRepresentant = nomRepresentant;
	}

	/**
	 * @return the prenomRepresentant
	 */
	public String getPrenomRepresentant() {
		return prenomRepresentant;
	}

	/**
	 * @param prenomRepresentant
	 *            the prenomRepresentant to set
	 */
	public void setPrenomRepresentant(String prenomRepresentant) {
		this.prenomRepresentant = prenomRepresentant;
	}

	/**
	 * Get Players.
	 * 
	 * @return the joueurs
	 */
	@OneToMany(mappedBy = "equipe", cascade = { CascadeType.ALL })
	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	/**
	 * @param joueurs
	 *            the joueurs to set
	 */
	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	/**
	 * Returns the XML representation of a team.
	 * 
	 * @return String of the XML representation of a team.
	 */
	public String toXML() {
		StringBuffer res = new StringBuffer("<" + XML_EQUIPE + " "
				+ XML_EQUIPE_NOM + "=\"" + nom + "\" "
				+ XML_EQUIPE_NOM_REPRESENTANT + "=\"" + nomRepresentant + "\" "
				+ XML_EQUIPE_PRENOM_REPRESENTANT + "=\"" + prenomRepresentant
				+ "\">\n");
		for (Joueur j : joueurs)
			res.append("\t" + j.toXML() + "\n");
		res.append("</" + XML_EQUIPE + ">");
		return res.toString();
	}

}
