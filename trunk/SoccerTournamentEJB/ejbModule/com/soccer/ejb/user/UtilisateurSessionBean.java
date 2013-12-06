package com.soccer.ejb.user;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.soccer.model.Equipe;
import com.soccer.model.Joueur;
import com.soccer.model.Rencontre;
import com.soccer.model.Tournoi;
import com.soccer.valueobjects.VOEquipe;
import com.soccer.valueobjects.VOJoueur;
import com.soccer.valueobjects.VORencontre;
import com.soccer.valueobjects.VORencontreLight;
import com.soccer.valueobjects.VOTournoi;

/**
 * Session Bean implementation class UtilisateurSessionBean.
 */
@Stateless
public class UtilisateurSessionBean implements UtilisateurLocal {

	/**
	 * The entity manager.
	 */
	@PersistenceContext(unitName = "soccerTournament")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public UtilisateurSessionBean() {
	}

	@Override
	public VOTournoi getTournoi(String nomTournoi) {
		Tournoi t = em.find(Tournoi.class, nomTournoi);
		return new VOTournoi(t);
	}

	@Override
	public List<VOTournoi> getTournois() {
		List<VOTournoi> listVOTournoi = new ArrayList<VOTournoi>();
		List<Tournoi> tournois = new ArrayList<Tournoi>();
		for (Object o : em.createQuery("From Tournoi t").getResultList())
			tournois.add((Tournoi) o);
		for (Tournoi tr : tournois) {
			VOTournoi voTour = new VOTournoi(tr);
			listVOTournoi.add(voTour);
		}
		return listVOTournoi;
	}

	@Override
	public List<VOEquipe> getEquipes(String nomTournoi) {
		List<VOEquipe> listVOEquipe = new ArrayList<VOEquipe>();
		Tournoi tournoi = (Tournoi) em.find(Tournoi.class, nomTournoi);
		List<Rencontre> rencontres = tournoi.getRencontres();
		for (Rencontre r : rencontres) {
			VOEquipe voEquipeHote = new VOEquipe(r.getHotes());
			VOEquipe voEquipeVisiteur = new VOEquipe(r.getVisiteurs());
			listVOEquipe.add(voEquipeHote);
			listVOEquipe.add(voEquipeVisiteur);
		}
		return listVOEquipe;
	}

	@Override
	public List<VOJoueur> getJoueurs(String nomEquipe) {
		List<VOJoueur> listVOJoueur = new ArrayList<VOJoueur>();
		Equipe equipe = (Equipe) em.find(Equipe.class, nomEquipe);
		List<Joueur> joueurs = equipe.getJoueurs();
		for (Joueur j : joueurs) {
			VOJoueur voJoueur = new VOJoueur(j);
			listVOJoueur.add(voJoueur);
		}
		return listVOJoueur;
	}

	@Override
	public List<VORencontreLight> getRencontres(String nomTournoi) {
		List<VORencontreLight> listVORencontreLight = new ArrayList<VORencontreLight>();
		Tournoi tournoi = (Tournoi) em.find(Tournoi.class, nomTournoi);
		List<Rencontre> rencontres = tournoi.getRencontres();
		for (Rencontre r : rencontres) {
			VORencontreLight voRencontreLight = new VORencontreLight(r);
			listVORencontreLight.add(voRencontreLight);
		}
		return listVORencontreLight;
	}

	@Override
	public VORencontre getRencontre(int idRencontre) {
		Rencontre r = (Rencontre) em.find(Rencontre.class, idRencontre);
		VORencontre voRencontre = new VORencontre(r);
		return voRencontre;
	}

	@Override
	public List<VOEquipe> getEquipes(int idRencontre) {
		List<VOEquipe> listVOEquipe = new ArrayList<VOEquipe>();
		Rencontre r = (Rencontre) em.find(Rencontre.class, idRencontre);
		VOEquipe voEquipeHote = new VOEquipe(r.getHotes());
		VOEquipe voEquipeVisiteur = new VOEquipe(r.getVisiteurs());
		listVOEquipe.add(voEquipeHote);
		listVOEquipe.add(voEquipeVisiteur);
		return listVOEquipe;
	}

	@Override
	public VOEquipe getEquipe(String nomEquipe) {
		Equipe e = (Equipe) em.find(Equipe.class, nomEquipe);
		return new VOEquipe(e);
	}

	@Override
	public List<VOEquipe> getEquipes() {
		List<VOEquipe> equipes = new ArrayList<VOEquipe>();
		for (Object e : em.createQuery("FROM Equipe e").getResultList())
			equipes.add(new VOEquipe((Equipe) e));
		return equipes;
	}
}
