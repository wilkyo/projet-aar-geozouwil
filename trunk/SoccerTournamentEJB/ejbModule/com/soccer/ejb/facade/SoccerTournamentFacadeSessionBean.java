package com.soccer.ejb.facade;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import com.soccer.valueobjects.*;

/**
 * Session Bean implementation class SoccerTournamentFacadeSessionBean
 */
@Stateless
public class SoccerTournamentFacadeSessionBean implements
		SoccerTournamentFacadeRemote, SoccerTournamentFacadeLocal {

	/**
	 * Default constructor.
	 */
	public SoccerTournamentFacadeSessionBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creerEquipe(String nomEquipe, String nomRepresentant,
			String prenomRepresentant, String[] nomJoueurs,
			String[] prenomJoueurs) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getTournois() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<VOEquipe> getEquipes(String nomTournoi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VOJoueur> getJoueurs(String nomEquipe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VORencontreLight> getRencontres(String nomTournoi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VORencontre> getRencontre(int idRencontre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VOEquipe> getEquipes(int idRencontre) {
		// TODO Auto-generated method stub
		return null;
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
	public void validerRencontre(Date heureFin) {
		// TODO Auto-generated method stub

	}

}
