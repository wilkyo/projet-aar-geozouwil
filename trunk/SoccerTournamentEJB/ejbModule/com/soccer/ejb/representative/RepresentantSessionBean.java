package com.soccer.ejb.representative;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class RepresentantSessionBean
 */
@Stateless
public class RepresentantSessionBean implements RepresentantRemote,
		RepresentantLocal {

	/*
	 * @PersistenceContext(unitName = "soccerTournament") EntityManager em;
	 */

	/**
	 * Default constructor.
	 */
	public RepresentantSessionBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creerEquipe(String nomEquipe, String nomRepresentant,
			String prenomRepresentant, String[] nomJoueurs,
			String[] prenomJoueurs, int[] numeroJoueurs) {
		// TODO Auto-generated method stub
		System.out.println(nomEquipe + "; " + nomRepresentant + " "
				+ prenomRepresentant);
	}

}
