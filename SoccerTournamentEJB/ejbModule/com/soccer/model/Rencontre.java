package com.soccer.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Class of Rencontre.
 */
@Entity
public class Rencontre implements Serializable {

	/**
	 * The serial version id.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constants.
	 */
	public static final int TEMPS_RENCONTRE = 90;
	public static final int TEMPS_PROLONGATIONS = 30;
	public static final int TEMPS_TIRS_AUX_BUTS = 15;
	/**
	 * The id of the match.
	 */
	private int id;
	/**
	 * The tournament affected to the match.
	 */
	private Tournoi tournoi;
	/**
	 * The host team of the match.
	 */
	private Equipe hotes;
	/**
	 * The visitor team of the match.
	 */
	private Equipe visiteurs;
	/**
	 * The referee of the match.
	 */
	private Arbitre arbitre;
	/**
	 * The round of the match.
	 */
	private int tour;
	/**
	 * The date of beginning of the match.
	 */
	private Calendar debut;
	/**
	 * The date of end of the match.
	 */
	private Calendar fin;
	/**
	 * List of goals of the match.
	 */
	private List<But> buts;

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
	 * @return the tournoi
	 */
	@ManyToOne
	public Tournoi getTournoi() {
		return tournoi;
	}

	/**
	 * @param tournoi
	 *            the tournoi to set
	 */
	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}

	/**
	 * @return the hotes
	 */
	@ManyToOne
	public Equipe getHotes() {
		return hotes;
	}

	/**
	 * @param hotes
	 *            the hotes to set
	 */
	public void setHotes(Equipe hotes) {
		this.hotes = hotes;
	}

	/**
	 * @return the visiteurs
	 */
	@ManyToOne
	public Equipe getVisiteurs() {
		return visiteurs;
	}

	/**
	 * @param visiteurs
	 *            the visiteurs to set
	 */
	public void setVisiteurs(Equipe visiteurs) {
		this.visiteurs = visiteurs;
	}

	/**
	 * @return the arbitre
	 */
	@ManyToOne
	public Arbitre getArbitre() {
		return arbitre;
	}

	/**
	 * @param arbitre
	 *            the arbitre to set
	 */
	public void setArbitre(Arbitre arbitre) {
		this.arbitre = arbitre;
	}

	/**
	 * @return the tour
	 */
	public int getTour() {
		return tour;
	}

	/**
	 * @param tour
	 *            the tour to set
	 */
	public void setTour(int tour) {
		this.tour = tour;
	}

	/**
	 * @return the debut
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getDebut() {
		return debut;
	}

	/**
	 * @param debut
	 *            the debut to set
	 */
	public void setDebut(Calendar debut) {
		this.debut = debut;
	}

	/**
	 * @return the fin
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFin() {
		return fin;
	}

	/**
	 * @param fin
	 *            the fin to set
	 */
	public void setFin(Calendar fin) {
		this.fin = fin;
	}

	/**
	 * @return the buts
	 */
	@OneToMany(mappedBy = "rencontre", cascade = CascadeType.ALL)
	public List<But> getButs() {
		return buts;
	}

	/**
	 * @param buts
	 *            the buts to set
	 */
	public void setButs(List<But> buts) {
		this.buts = buts;
	}

	/**
	 * Gets the hosts score.
	 * 
	 * @return the hosts score.
	 */
	@Transient
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
	@Transient
	public int getScoreVisiteurs() {
		int score = 0;
		for (But b : buts) {
			if (b.getAuteur().getEquipe() == visiteurs)
				score++;
		}
		return score;
	}

	/**
	 * Gets the winner team.
	 * 
	 * @return the winner team.
	 */
	@Transient
	public Equipe getGagnant() {
		if (getScoreHotes() > getScoreVisiteurs())
			return hotes;
		else
			return visiteurs;
	}

}
