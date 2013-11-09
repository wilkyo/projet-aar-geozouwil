package com.soccer.ejb.representative;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class RepresentantSessionBean
 */
@Stateless
public class RepresentantSessionBean implements RepresentantRemote,
		RepresentantLocal {

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
