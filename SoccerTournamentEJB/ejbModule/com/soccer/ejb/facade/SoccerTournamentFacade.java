package com.soccer.ejb.facade;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.soccer.valueobjects.*;

public interface SoccerTournamentFacade {

	/**
	 * Initializes the Database.
	 */
	public void initDB();

	public void creerEquipe(String nomEquipe, String nomRepresentant,
			String prenomRepresentant, String[] nomJoueurs,
			String[] prenomJoueurs, int[] numeroJoueurs);

	public List<VOTournoi> getTournois();

	public List<VOEquipe> getEquipes(String nomTournoi);

	public List<VOJoueur> getJoueurs(String nomEquipe);

	public List<VORencontreLight> getRencontres(String nomTournoi);

	public List<VORencontre> getRencontre(int idRencontre);

	public List<VOEquipe> getEquipes(int idRencontre);

	public boolean connexion(String login, String password);

	public void creerTournoi();

	public void setDebutRencontre(int idRencontre, Calendar debut);

	public void ajouterArbitre(String nom, String prenom);

	public void affecterArbitre(int idArbitre, int idRencontre);

	public void ajouterBut(int idRencontre, int idAuteur, Calendar heure);

	public void validerRencontre(Date heureFin);

}
