package com.soccer.model;

import java.util.List;

public class Tournoi {

	private String nom;
	private List<Rencontre> rencontres;
	private int tourActuel;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Rencontre> getRencontres() {
		return rencontres;
	}

	public void setRencontres(List<Rencontre> rencontres) {
		this.rencontres = rencontres;
	}

	public int getTourActuel() {
		return tourActuel;
	}

	public void setTourActuel(int tourActuel) {
		this.tourActuel = tourActuel;
	}

}
