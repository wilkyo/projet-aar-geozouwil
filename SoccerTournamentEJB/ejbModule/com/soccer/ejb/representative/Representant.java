package com.soccer.ejb.representative;

/**
 * The interface of Representant.
 */
public interface Representant {

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
}
