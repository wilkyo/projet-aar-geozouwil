package com.soccer.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class But  implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private Rencontre recontre;
	private Joueur auteur;
	private Calendar heure;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the recontre
	 */
	@ManyToOne
	public Rencontre getRecontre() {
		return recontre;
	}
	/**
	 * @param recontre the recontre to set
	 */
	public void setRecontre(Rencontre recontre) {
		this.recontre = recontre;
	}
	/**
	 * @return the auteur
	 */
	@ManyToOne
	public Joueur getAuteur() {
		return auteur;
	}
	/**
	 * @param auteur the auteur to set
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
	 * @param heure the heure to set
	 */
	public void setHeure(Calendar heure) {
		this.heure = heure;
	}

	

}
