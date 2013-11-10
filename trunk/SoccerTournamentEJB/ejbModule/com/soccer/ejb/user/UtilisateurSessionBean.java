package com.soccer.ejb.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.soccer.valueobjects.*;

/**
 * Session Bean implementation class UtilisateurSessionBean
 */
@Stateless
public class UtilisateurSessionBean implements UtilisateurRemote,
		UtilisateurLocal {

	@PersistenceContext(unitName = "soccerTournament")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public UtilisateurSessionBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<VOTournoi> getTournois() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VOEquipe> getEquipes(String nomTournoi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VOJoueur> getJoueurs(String nomEquipe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VORencontreLight> getRencontres(String nomTournoi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VORencontre> getRencontre(int idRencontre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VOEquipe> getEquipes(int idRencontre) {
		// TODO Auto-generated method stub
		return null;
	}

}
