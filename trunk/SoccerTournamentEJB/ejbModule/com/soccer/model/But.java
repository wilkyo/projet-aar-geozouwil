package com.soccer.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Class of But.
 */
@Entity
public class But implements Serializable {

	/**
	 * The serial version id.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The id of the goal.
	 */
	private int id;
	/**
	 * Match affected to the goal.
	 */
	private Rencontre rencontre;
	/**
	 * Author of the goal.
	 */
	private Joueur auteur;
	/**
	 * Hour of the goal.
	 */
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
	@ManyToOne
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
	@ManyToOne
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
