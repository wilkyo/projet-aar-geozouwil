package com.soccer.ejb.admin;

import java.util.Calendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class AdministrateurSessionBean
 */
@Stateless
public class AdministrateurSessionBean implements AdministrateurRemote,
		AdministrateurLocal {

	/*
	 * @PersistenceContext(unitName = "soccerTournament") EntityManager em;
	 */

	/**
	 * Default constructor.
	 */
	public AdministrateurSessionBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean connexion(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void creerTournoi() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDebutRencontre(int idRencontre, Calendar debut) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ajouterArbitre(String nom, String prenom) {
		// TODO Auto-generated method stub

	}

	@Override
	public void affecterArbitre(int idArbitre, int idRencontre) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ajouterBut(int idRencontre, int idAuteur, Calendar heure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validerRencontre(Calendar fin) {
		// TODO Auto-generated method stub

	}

}
