package com.soccer.ejb.facade;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Semaphore;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.soccer.SoccerTournamentBouchon;
import com.soccer.ejb.admin.AdministrateurLocal;
import com.soccer.ejb.representative.RepresentantLocal;
import com.soccer.ejb.user.UtilisateurLocal;
import com.soccer.model.Equipe;
import com.soccer.model.Joueur;
import com.soccer.valueobjects.VOEquipe;
import com.soccer.valueobjects.VOJoueur;
import com.soccer.valueobjects.VORencontre;
import com.soccer.valueobjects.VORencontreLight;
import com.soccer.valueobjects.VOTournoi;

/**
 * Session Bean implementation class SoccerTournamentFacadeSessionBean
 */
@Stateless
public class SoccerTournamentFacadeSessionBean implements
		SoccerTournamentFacadeRemote, SoccerTournamentFacadeLocal {

	private boolean dbInitialized = false;
	private Semaphore mutex = new Semaphore(1);

	@PersistenceContext(unitName = "soccerTournament")
	private EntityManager em;
	@EJB
	private RepresentantLocal representant;
	@EJB
	private AdministrateurLocal administrateur;
	@EJB
	private UtilisateurLocal utilisateur;

	@Override
	public void initDB() {
		try {
			mutex.acquire();
			if (!dbInitialized) {
				for (Equipe e : SoccerTournamentBouchon.creerEquipes()) {
					for (Joueur j : e.getJoueurs())
						em.persist(j);
					em.persist(e);
				}
				dbInitialized = true;
			}
			mutex.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Default constructor.
	 */
	public SoccerTournamentFacadeSessionBean() {
		// TODO Auto-generated constructor stub
		System.out.println("Hello");
	}

	@Override
	public void creerEquipe(String nomEquipe, String nomRepresentant,
			String prenomRepresentant, String[] nomJoueurs,
			String[] prenomJoueurs, int[] numeroJoueurs) {
		representant.creerEquipe(nomEquipe, nomRepresentant,
				prenomRepresentant, nomJoueurs, prenomJoueurs, numeroJoueurs);
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

	@Override
	public boolean connexion(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void creerTournoi() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDebutRencontre(int idRencontre, Calendar debut) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ajouterArbitre(String nom, String prenom) {
		// TODO Auto-generated method stub

	}

	@Override
	public void affecterArbitre(int idArbitre, int idRencontre) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ajouterBut(int idRencontre, int idAuteur, Calendar heure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validerRencontre(Date heureFin) {
		// TODO Auto-generated method stub

	}

}
