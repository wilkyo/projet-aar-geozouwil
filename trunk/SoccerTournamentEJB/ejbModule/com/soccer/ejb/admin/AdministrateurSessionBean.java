package com.soccer.ejb.admin;

import java.util.Calendar;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.soccer.model.Arbitre;
import com.soccer.model.But;
import com.soccer.model.Joueur;
import com.soccer.model.Rencontre;

/**
 * Session Bean implementation class AdministrateurSessionBean
 */
@Stateless
public class AdministrateurSessionBean implements AdministrateurRemote,
		AdministrateurLocal {

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
	public void creerTournoi() {
		// TODO Auto-generated method stub

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
	public void validerRencontre(Calendar fin) {
		// TODO Auto-generated method stub

	}

}
