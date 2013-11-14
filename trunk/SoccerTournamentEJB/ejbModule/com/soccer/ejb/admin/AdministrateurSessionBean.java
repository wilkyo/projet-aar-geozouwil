package com.soccer.ejb.admin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.soccer.model.Arbitre;
import com.soccer.model.But;
import com.soccer.model.Equipe;
import com.soccer.model.Joueur;
import com.soccer.model.Rencontre;
import com.soccer.model.Tournoi;

/**
 * Session Bean implementation class AdministrateurSessionBean
 */
@Stateless
public class AdministrateurSessionBean implements AdministrateurLocal {

	private static final String login = "admin";
	private static final String password = "root";

	@PersistenceContext(unitName = "soccerTournament")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public AdministrateurSessionBean() {
		System.out.println("Je suis l'administrateur");
	}

	@Override
	public boolean connexion(String login, String password) {
		if (login.equals(AdministrateurSessionBean.login)
				&& password.equals(AdministrateurSessionBean.password)) {
			System.out.println("Connexion de l'administrateur ...");
			return true;
		} else
			return false;
	}

	@Override
	public void creerTournoi(String nomTournoi) {
		if (em.find(Tournoi.class, nomTournoi) != null) {
			System.out.println("Tournoi existe déjà (en cours ou terminé....)");
		} else {
			Tournoi newTournoi = new Tournoi();
			newTournoi.setNom(nomTournoi);
			newTournoi.setTourActuel(1);
			List<Equipe> equipes = new ArrayList<Equipe>();
			for (Object e : em.createQuery("FROM Equipe e").getResultList())
				equipes.add((Equipe) e);
			// Attribution d'un numéro aléatoire aux équipes
			Equipe[] ordre = melangerEquipes(equipes.toArray(new Equipe[0]));
			List<Rencontre> rencontres = new ArrayList<Rencontre>();
			for (int i = 0; i < ordre.length; i += 2) {
				Rencontre r = new Rencontre();
				r.setHotes(ordre[i]);
				r.setVisiteurs(ordre[i + 1]);
				r.setTour(1);
				r.setTournoi(newTournoi);
				rencontres.add(r);
			}
			newTournoi.setNbEquipes(ordre.length);
			newTournoi.setRencontres(rencontres);
			em.persist(newTournoi);
		}

	}

	/**
	 * Mix the teams in the Array.
	 * 
	 * @param equipes
	 *            Array of teams to mix.
	 * @return Mixed Array.
	 */
	private Equipe[] melangerEquipes(Equipe[] equipes) {
		// TODO
		return equipes;
	}

	@Override
	public void setDebutRencontre(int idRencontre, Calendar debut) {
		Rencontre r = new Rencontre();
		r = em.find(Rencontre.class, idRencontre);
		r.setDebut(debut);
		em.persist(r);
	}

	@Override
	public void ajouterArbitre(String nom, String prenom) {
		Arbitre a = new Arbitre();
		a.setNom(nom);
		a.setPrenom(prenom);
		em.persist(a);
	}

	@Override
	public void affecterArbitre(int idArbitre, int idRencontre) {
		Rencontre r = new Rencontre();
		Arbitre a = new Arbitre();
		r = em.find(Rencontre.class, idRencontre);
		a = em.find(Arbitre.class, idArbitre);
		r.setArbitre(a);
		em.persist(r);
	}

	@Override
	public void ajouterBut(int idRencontre, int idAuteur, Calendar heure) {
		But b = new But();
		b.setHeure(heure);
		Rencontre r = new Rencontre();
		r = em.find(Rencontre.class, idRencontre);
		b.setRencontre(r);
		Joueur j = new Joueur();
		j = em.find(Joueur.class, idAuteur);
		b.setAuteur(j);
		em.persist(b);
	}

	@Override
	public void validerRencontre(Calendar fin, int idRencontre) {
		Rencontre rencontre = new Rencontre();
		rencontre = em.find(Rencontre.class, idRencontre);
		boolean dejaFait = rencontre.getFin() != null;
		rencontre.setFin(fin);
		em.persist(rencontre);
		if (!dejaFait) {
			// Checking the others
			List<Rencontre> rencontres = new ArrayList<Rencontre>();
			int cpt = 0;
			// Récupère les rencontres du même tour
			Query query = em
					.createQuery("FROM Rencontre e WHERE e.tournoi = ? AND e.tour = ?");
			query.setParameter(1, rencontre.getTournoi());
			query.setParameter(2, rencontre.getTour());
			for (Object r : query.getResultList()) {
				Rencontre tmp = (Rencontre) r;
				if (tmp.getFin() != null)
					cpt++;
				rencontres.add(tmp);
			}
			// Si toutes les rencontres de ce tour ont étés validées
			if (cpt == rencontres.size() && rencontres.size() > 1) {
				// Parcours deux à deux des rencontres pour créer les nouvelles
				// (dans l'ordre)
				for (int i = 0; i < rencontres.size(); i += 2) {
					Rencontre hotes = rencontres.get(i);
					Rencontre visiteurs = rencontres.get(i + 1);
					if (hotes.getTour() < rencontre.getTour())
						break;
					Rencontre newRencontre = new Rencontre();
					newRencontre.setHotes(hotes.getGagnant());
					newRencontre.setVisiteurs(visiteurs.getGagnant());
					newRencontre.setTour(rencontre.getTour() + 1);
					newRencontre.setTournoi(rencontre.getTournoi());
					em.persist(newRencontre);
				}
			}
		}
	}
}
