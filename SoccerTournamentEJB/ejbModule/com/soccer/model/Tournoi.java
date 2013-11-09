package com.soccer.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tournoi  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String nom;
	private int tourActuel;
	private List<Rencontre> rencontres;
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the tourActuel
	 */
	public int getTourActuel() {
		return tourActuel;
	}
	/**
	 * @param tourActuel the tourActuel to set
	 */
	public void setTourActuel(int tourActuel) {
		this.tourActuel = tourActuel;
	}
	/**
	 * Got all Match
	 * 
	 * @return the rencontres
	 */
	@OneToMany(mappedBy="tournoi",cascade={CascadeType.ALL})
	public List<Rencontre> getRencontres() {
		return rencontres;
	}
	/**
	 * @param rencontres the rencontres to set
	 */
	public void setRencontres(List<Rencontre> rencontres) {
		this.rencontres = rencontres;
	}
	
	

}
