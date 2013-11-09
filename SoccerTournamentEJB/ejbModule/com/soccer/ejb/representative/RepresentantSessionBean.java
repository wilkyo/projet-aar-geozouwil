package com.soccer.ejb.representative;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class RepresentantSessionBean
 */
@Stateless
public class RepresentantSessionBean implements RepresentantRemote,
		RepresentantLocal {

	@PersistenceContext(unitName = "soccerTournament")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public RepresentantSessionBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creerEquipe(String nomEquipe, String nomRepresentant,
			String prenomRepresentant, String[] nomJoueurs,
			String[] prenomJoueurs) {
		// TODO Auto-generated method stub

	}

}
