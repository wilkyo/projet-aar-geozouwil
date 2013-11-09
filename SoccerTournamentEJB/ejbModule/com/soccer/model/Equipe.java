package com.soccer.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Equipe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private List<Joueur> joueurs;
	private String nomRepresentant;
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

}
