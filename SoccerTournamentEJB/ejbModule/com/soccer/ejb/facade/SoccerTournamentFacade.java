package com.soccer.ejb.facade;

import java.util.Calendar;
import java.util.List;

import com.soccer.model.Arbitre;
import com.soccer.valueobjects.*;

public interface SoccerTournamentFacade {

	/**
	 * Initializes the Database.
	 */
	public void initDB();

	public void initDBBouchon();

	public boolean creerEquipe(String nomEquipe, String nomRepresentant,
			String prenomRepresentant, String[] nomJoueurs,
			String[] prenomJoueurs, int[] numeroJoueurs);

	public VOTournoi getTournoi(String nomTournoi);

	public List<VOTournoi> getTournois();

	public List<VOEquipe> getEquipes(String nomTournoi);

	public List<VOJoueur> getJoueurs(String nomEquipe);

	public List<VORencontreLight> getRencontres(String nomTournoi);

	public VORencontre getRencontre(int idRencontre);

	public List<VOEquipe> getEquipes(int idRencontre);

	public VOEquipe getEquipe(String nomEquipe);

	public List<VOEquipe> getEquipes();

	public boolean connexion(String login, String password);

	public void creerTournoi(String nomTournoi);

	public void setDebutRencontre(int idRencontre, Calendar debut);

	public List<Arbitre> getArbitres();

	public void ajouterArbitre(String nom, String prenom);

	public void affecterArbitre(int idArbitre, int idRencontre);

	public void ajouterBut(int idRencontre, int idAuteur, Calendar heure);

	public void validerRencontre(int idRencontre, Calendar heureFin);

}
