package com.soccer.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Rencontre  implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Tournoi tournoi;
	@OneToMany
	private Equipe hotes;
	@OneToMany
	private Equipe visiteurs;
	private Arbitre arbitre;
	private int tour;
	private Calendar debut;
	private Calendar fin;
	@OneToMany
	private List<But> buts;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the tournoi
	 */
	
	public Tournoi getTournoi() {
		return tournoi;
	}

	/**
	 * @return the hotes
	 */
	
	public Equipe getHotes() {
		return hotes;
	}

	/**
	 * @return the visiteurs
	 */
	
	public Equipe getVisiteurs() {
		return visiteurs;
	}

	/**
	 * @return the arbitre
	 */
	public Arbitre getArbitre() {
		return arbitre;
	}

	/**
	 * @return the tour
	 */
	public int getTour() {
		return tour;
	}

	/**
	 * @return the debut
	 */
	public Calendar getDebut() {
		return debut;
	}

	/**
	 * @return the fin
	 */
	public Calendar getFin() {
		return fin;
	}

	/**
	 * @return the buts
	 */
	
	public List<But> getButs() {
		return buts;
	}

	/**
	 * Gets the hosts score.
	 * 
	 * @return the hosts score.
	 */
	public int getScoreHotes() {
		int score = 0;
		for (But b : buts) {
			if (b.getAuteur().getEquipe() == hotes)
				score++;
		}
		return score;
	}

	/**
	 * Gets the visitors score.
	 * 
	 * @return the visitors score.
	 */
	public int getScoreVisiteurs() {
		int score = 0;
		for (But b : buts) {
			if (b.getAuteur().getEquipe() == visiteurs)
				score++;
		}
		return score;
	}

}
