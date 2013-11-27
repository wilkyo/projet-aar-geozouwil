package com.soccer.ejb.user;

import java.util.List;
import com.soccer.valueobjects.*;

/**
 * The interface of Utilisateur.
 */
public interface Utilisateur {

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

}
