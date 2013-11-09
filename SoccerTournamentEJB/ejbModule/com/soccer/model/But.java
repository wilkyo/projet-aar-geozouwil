package com.soccer.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class But implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	@ManyToOne
	private Rencontre rencontre;
	@ManyToOne
	private Joueur auteur;
	private Calendar heure;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the rencontre
	 */

	public Rencontre getRencontre() {
		return rencontre;
	}

	/**
	 * @param rencontre
	 *            the rencontre to set
	 */
	public void setRencontre(Rencontre rencontre) {
		this.rencontre = rencontre;
	}

	/**
	 * @return the auteur
	 */

	public Joueur getAuteur() {
		return auteur;
	}

	/**
	 * @param auteur
	 *            the auteur to set
	 */
	public void setAuteur(Joueur auteur) {
		this.auteur = auteur;
	}

	/**
	 * @return the heure
	 */
	public Calendar getHeure() {
		return heure;
	}

	/**
	 * @param heure
	 *            the heure to set
	 */
	public void setHeure(Calendar heure) {
		this.heure = heure;
	}

}
