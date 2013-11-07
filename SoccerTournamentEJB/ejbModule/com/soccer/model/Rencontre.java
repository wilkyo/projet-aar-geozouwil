package com.soccer.model;

import java.util.Calendar;
import java.util.List;

public class Rencontre {

	private int id;
	private Tournoi tournoi;
	private Equipe hotes;
	private Equipe visiteurs;
	private Arbitre arbitre;
	private int tour;
	private Calendar debut;
	private Calendar fin;
	private List<But> buts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tournoi getTournoi() {
		return tournoi;
	}

	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}

	public Equipe getHotes() {
		return hotes;
	}

	public void setHotes(Equipe hotes) {
		this.hotes = hotes;
	}

	public Equipe getVisiteurs() {
		return visiteurs;
	}

	public void setVisiteurs(Equipe visiteurs) {
		this.visiteurs = visiteurs;
	}

	public Arbitre getArbitre() {
		return arbitre;
	}

	public void setArbitre(Arbitre arbitre) {
		this.arbitre = arbitre;
	}

	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

	public Calendar getDebut() {
		return debut;
	}

	public void setDebut(Calendar debut) {
		this.debut = debut;
	}

	public Calendar getFin() {
		return fin;
	}

	public void setFin(Calendar fin) {
		this.fin = fin;
	}

	public List<But> getButs() {
		return buts;
	}

	public void setButs(List<But> buts) {
		this.buts = buts;
	}

}
