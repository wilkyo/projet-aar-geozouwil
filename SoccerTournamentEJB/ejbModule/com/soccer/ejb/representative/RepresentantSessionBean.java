package com.soccer.ejb.representative;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.soccer.model.Equipe;
import com.soccer.model.Joueur;

/**
 * Session Bean implementation class RepresentantSessionBean.
 */
@Stateless
public class RepresentantSessionBean implements RepresentantLocal {

	/**
	 * The entity manager.
	 */
	@PersistenceContext(unitName = "soccerTournament")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public RepresentantSessionBean() {
	}

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
	@Override
	public boolean creerEquipe(String nomEquipe, String nomRepresentant,
			String prenomRepresentant, String[] nomJoueurs,
			String[] prenomJoueurs, int[] numeroJoueurs) {
		// si le nom de l'équipe existe déja
		if (em.find(Equipe.class, nomEquipe) != null) {
			System.out.println("L'équipe existe déja !!!!");
			return false;
		}
		// sinon on crée une nouvelle équipe
		else {
			Equipe newTeam = new Equipe();
			newTeam.setNom(nomEquipe);
			newTeam.setNomRepresentant(nomRepresentant);
			newTeam.setPrenomRepresentant(prenomRepresentant);
			List<Joueur> lesjoueurs = new ArrayList<Joueur>();
			for (int i = 0; i < prenomJoueurs.length; i++) {
				if (prenomJoueurs[i].equals(""))
					break;
				Joueur j = new Joueur();
				j.setNom(nomJoueurs[i]);
				j.setPrenom(prenomJoueurs[i]);
				j.setNumero(numeroJoueurs[i]);
				j.setEquipe(newTeam);
				em.persist(j);
				lesjoueurs.add(j);
			}
			newTeam.setJoueurs(lesjoueurs);
			em.persist(newTeam);
			return true;
		}
	}
}
