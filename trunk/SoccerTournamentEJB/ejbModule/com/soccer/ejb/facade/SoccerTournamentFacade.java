package com.soccer.ejb.facade;

import java.util.Calendar;
import java.util.List;
import com.soccer.model.Arbitre;
import com.soccer.valueobjects.*;

/**
 * The interface of SoccerTournamentFacade.
 */
public interface SoccerTournamentFacade {

	/**
	 * Initializes the Database.
	 */
	public void initDB();

	/**
	 * Create a team.
	 * 
	 * @param nomEquipe
	 *            Name of the team.
	 * @param nomRepresentant
	 *            Name of the representative.
	 * @param prenomRepresentant
	 *            Nickname of the representative.
	 * @param nomJoueurs
	 *            Array of players's names.
	 * @param prenomJoueurs
	 *            Array of players's nicknames.
	 * @param numeroJoueurs
	 *            Array of players's numbers.
	 * @return True : creation successful / False : creation failed.
	 */
	public boolean creerEquipe(String nomEquipe, String nomRepresentant,
			String prenomRepresentant, String[] nomJoueurs,
			String[] prenomJoueurs, int[] numeroJoueurs);

	/**
	 * Returns a tournament.
	 * 
	 * @param nomTournoi
	 *            Name of the tournament.
	 * @return Value object of Tournoi.
	 */
	public VOTournoi getTournoi(String nomTournoi);

	/**
	 * Returns all the tournaments.
	 * 
	 * @return List of value object of Tournoi.
	 */
	public List<VOTournoi> getTournois();

	/**
	 * Returns all the teams of a tournament.
	 * 
	 * @param nomTournoi
	 *            Name of the tournament.
	 * @return List of value object of Equipe.
	 */
	public List<VOEquipe> getEquipes(String nomTournoi);

	/**
	 * Returns all the players of a team.
	 * 
	 * @param nomEquipe
	 *            Name of the team.
	 * @return List of value object of Joueur.
	 */
	public List<VOJoueur> getJoueurs(String nomEquipe);

	/**
	 * Returns all the matchs of a tournament.
	 * 
	 * @param nomTournoi
	 *            Name of the tournament.
	 * @return List of value object of RencontreLight.
	 */
	public List<VORencontreLight> getRencontres(String nomTournoi);

	/**
	 * Returns a match.
	 * 
	 * @param idRencontre
	 *            The id of the match.
	 * @return Value object of Rencontre.
	 */
	public VORencontre getRencontre(int idRencontre);

	/**
	 * Returns the teams of a match.
	 * 
	 * @param idRencontre
	 *            The id of the match.
	 * @return List of value object of Equipe.
	 */
	public List<VOEquipe> getEquipes(int idRencontre);

	/**
	 * Returns a team.
	 * 
	 * @param nomEquipe
	 *            Name of the team.
	 * @return Value object of Equipe.
	 */
	public VOEquipe getEquipe(String nomEquipe);

	/**
	 * Returns all the teams.
	 * 
	 * @return List of value object of Equipe.
	 */
	public List<VOEquipe> getEquipes();

	/**
	 * Connect the admin.
	 * 
	 * @param login
	 *            The admin's login.
	 * @param password
	 *            The admin's password.
	 * @return True : connection successful / False : connection failed.
	 */
	public boolean connexion(String login, String password);

	/**
	 * Create a tournament.
	 * 
	 * @param nomTournoi
	 *            Name of the tournament.
	 */
	public void creerTournoi(String nomTournoi);

	/**
	 * Set the beginning of the match.
	 * 
	 * @param idRencontre
	 *            The id of the match.
	 * @param debut
	 *            The date of beginning of the match.
	 */
	public void setDebutRencontre(int idRencontre, Calendar debut);

	/**
	 * Returns all the referees.
	 * 
	 * @return List of referees.
	 */
	public List<Arbitre> getArbitres();

	/**
	 * Add a referee.
	 * 
	 * @param nom
	 *            Name of the referee.
	 * @param prenom
	 *            Nickname of the referee.
	 */
	public void ajouterArbitre(String nom, String prenom);

	/**
	 * Affect a referee to a match.
	 * 
	 * @param idArbitre
	 *            The id of the referee.
	 * @param idRencontre
	 *            The id of the match.
	 */
	public void affecterArbitre(int idArbitre, int idRencontre);

	/**
	 * Add a goal.
	 * 
	 * @param idRencontre
	 *            The id of the match.
	 * @param idAuteur
	 *            The id of the goal's author.
	 * @param heure
	 *            The Date (hour) of the goal.
	 */
	public void ajouterBut(int idRencontre, int idAuteur, Calendar heure);

	/**
	 * Validate a match.
	 * 
	 * @param idRencontre
	 *            The id of the match.
	 * @param heureFin
	 *            The Date of the end of the match.
	 */
	public void validerRencontre(int idRencontre, Calendar heureFin);

}
