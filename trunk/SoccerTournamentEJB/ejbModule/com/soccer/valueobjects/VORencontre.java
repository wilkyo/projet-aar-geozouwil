package com.soccer.valueobjects;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.soccer.model.Arbitre;
import com.soccer.model.But;
import com.soccer.model.Rencontre;

/**
 * ValueObject of Rencontre.
 */
public class VORencontre {
	
	/**
	 * name of the Tournement
	 */
	private String nomTournoi;

	/**
	 * ValueObject of Host Teams.
	 */
	private VOEquipe hotes;
	/**
	 * ValueObject of Visitor Teams.
	 */
	private VOEquipe visiteurs;
	/**
	 * The referee.
	 */
	private Arbitre arbitre;
	/**
	 * Number of the round.
	 */
	private int tour;
	/**
	 * Date of the beginning.
	 */
	private Calendar debut;
	/**
	 * Date of the end.
	 */
	private Calendar fin;
	/**
	 * List of ValueObjects of Host Goals.
	 */
	private List<VOBut> butsHotes;
	/**
	 * List of ValueObjects of Visitor Goals.
	 */
	private List<VOBut> butsVisiteurs;

	/**
	 * Initializes the ValueObject.
	 * 
	 * @param rencontre
	 *            The match.
	 */
	public VORencontre(Rencontre rencontre) {
		this.hotes = new VOEquipe(rencontre.getHotes());
		this.visiteurs = new VOEquipe(rencontre.getVisiteurs());
		this.arbitre = rencontre.getArbitre();
		this.debut = rencontre.getDebut();
		this.fin = rencontre.getFin();
		this.nomTournoi=rencontre.getTournoi().getNom();
		this.butsHotes = new ArrayList<VOBut>();
		for (But b : rencontre.getButs()) {
			this.butsHotes.add(new VOBut(b));
		}
		this.butsVisiteurs = new ArrayList<VOBut>();
		for (But b : rencontre.getButs()) {
			this.butsVisiteurs.add(new VOBut(b));
		}
	}

	/**
	 * @return the hotes
	 */
	public VOEquipe getHotes() {
		return hotes;
	}

	/**
	 * @return the visiteurs
	 */
	public VOEquipe getVisiteurs() {
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
	 * @return the nomTournoi
	 */
	public String getNomTournoi() {
		return nomTournoi;
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
	 * @return the butsHotes
	 */
	public List<VOBut> getButsHotes() {
		return butsHotes;
	}

	/**
	 * @return the butsVisiteurs
	 */
	public List<VOBut> getButsVisiteurs() {
		return butsVisiteurs;
	}

}
