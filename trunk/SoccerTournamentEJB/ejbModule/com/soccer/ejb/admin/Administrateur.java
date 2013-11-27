package com.soccer.ejb.admin;

import java.util.Calendar;
import java.util.List;
import com.soccer.model.Arbitre;

/**
 * The interface of Administrateur.
 */
public interface Administrateur {

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
