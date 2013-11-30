package com.soccer.ejb.facade;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Semaphore;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import com.soccer.ejb.admin.AdministrateurLocal;
import com.soccer.ejb.representative.RepresentantLocal;
import com.soccer.ejb.user.UtilisateurLocal;
import com.soccer.model.Arbitre;
import com.soccer.model.Equipe;
import com.soccer.model.Joueur;
import com.soccer.valueobjects.VOEquipe;
import com.soccer.valueobjects.VOJoueur;
import com.soccer.valueobjects.VORencontre;
import com.soccer.valueobjects.VORencontreLight;
import com.soccer.valueobjects.VOTournoi;
import com.soccer.xml.ArbitresHandler;
import com.soccer.xml.EquipeHandler;

/**
 * Session Bean implementation class SoccerTournamentFacadeSessionBean.
 */
@Stateless
public class SoccerTournamentFacadeSessionBean implements
		SoccerTournamentFacadeRemote, SoccerTournamentFacadeLocal {

	/**
	 * Database initialized or not.
	 */
	private boolean dbInitialized = false;
	/**
	 * Mutex used in the initialization of database.
	 */
	private Semaphore mutex = new Semaphore(1);
	/**
	 * The entity manager.
	 */
	@PersistenceContext(unitName = "soccerTournament")
	private EntityManager em;
	/**
	 * EJB of RepresentantLocal.
	 */
	@EJB
	private RepresentantLocal representant;
	/**
	 * EJB of AdministrateurLocal.
	 */
	@EJB
	private AdministrateurLocal administrateur;
	/**
	 * EJB of UtilisateurLocal.
	 */
	@EJB
	private UtilisateurLocal utilisateur;

	/**
	 * Initializes the Database.
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void initDB() {
		try {
			mutex.acquire();
			if (!dbInitialized) {
				try {
					SAXParserFactory parserFactory = SAXParserFactory
							.newInstance();
					SAXParser parser = parserFactory.newSAXParser();
					File fichier;
					String path = "../standalone/deployments/SoccerTournament.ear/SoccerTournamentEJB.jar/META-INF/data/";

					fichier = new File(path + "equipes.xml");
					EquipeHandler equipeManager = new EquipeHandler();
					parser.parse(fichier, equipeManager);
					for (Equipe e : equipeManager.getEquipes()) {
						for (Joueur j : e.getJoueurs())
							em.persist(j);
						em.persist(e);
					}
					System.out.println("Equipes chargées.");
					fichier = new File(path + "arbitres.xml");
					ArbitresHandler arbitresManager = new ArbitresHandler();
					parser.parse(fichier, arbitresManager);
					for (Arbitre a : arbitresManager.getArbitres()) {
						em.persist(a);
					}
					System.out.println("Arbitres chargés.");
				} catch (ParserConfigurationException pce) {
					System.out
							.println("Erreur de configuration du parseur Lors de l'appel à SAXParser()");
				} catch (SAXException se) {
					System.out.println(se.getMessage());
				} catch (IOException ioe) {
					System.out
							.println("Erreur d'entrée/sortie Lors de l'appel à parse()");
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
		return representant.creerEquipe(nomEquipe, nomRepresentant,
				prenomRepresentant, nomJoueurs, prenomJoueurs, numeroJoueurs);
	}

	/**
	 * Returns a tournament.
	 * 
	 * @param nomTournoi
	 *            Name of the tournament.
	 * @return Value object of Tournoi.
	 */
	@Override
	public VOTournoi getTournoi(String nomTournoi) {
		return utilisateur.getTournoi(nomTournoi);
	}

	/**
	 * Returns all the tournaments.
	 * 
	 * @return List of value object of Tournoi.
	 */
	@Override
	public List<VOTournoi> getTournois() {
		return utilisateur.getTournois();
	}

	/**
	 * Returns all the teams of a tournament.
	 * 
	 * @param nomTournoi
	 *            Name of the tournament.
	 * @return List of value object of Equipe.
	 */
	@Override
	public List<VOEquipe> getEquipes(String nomTournoi) {
		return utilisateur.getEquipes(nomTournoi);
	}

	/**
	 * Returns all the players of a team.
	 * 
	 * @param nomEquipe
	 *            Name of the team.
	 * @return List of value object of Joueur.
	 */
	@Override
	public List<VOJoueur> getJoueurs(String nomEquipe) {
		return utilisateur.getJoueurs(nomEquipe);
	}

	/**
	 * Returns all the matchs of a tournament.
	 * 
	 * @param nomTournoi
	 *            Name of the tournament.
	 * @return List of value object of RencontreLight.
	 */
	@Override
	public List<VORencontreLight> getRencontres(String nomTournoi) {
		return utilisateur.getRencontres(nomTournoi);
	}

	/**
	 * Returns a match.
	 * 
	 * @param idRencontre
	 *            The id of the match.
	 * @return Value object of Rencontre.
	 */
	@Override
	public VORencontre getRencontre(int idRencontre) {
		return utilisateur.getRencontre(idRencontre);
	}

	/**
	 * Returns the teams of a match.
	 * 
	 * @param idRencontre
	 *            The id of the match.
	 * @return List of value object of Equipe.
	 */
	@Override
	public List<VOEquipe> getEquipes(int idRencontre) {
		return utilisateur.getEquipes(idRencontre);
	}

	/**
	 * Returns a team.
	 * 
	 * @param nomEquipe
	 *            Name of the team.
	 * @return Value object of Equipe.
	 */
	@Override
	public VOEquipe getEquipe(String nomEquipe) {
		return utilisateur.getEquipe(nomEquipe);
	}

	/**
	 * Returns all the teams.
	 * 
	 * @return List of value object of Equipe.
	 */
	@Override
	public List<VOEquipe> getEquipes() {
		return utilisateur.getEquipes();
	}

	/**
	 * Connect the admin.
	 * 
	 * @param login
	 *            The admin's login.
	 * @param password
	 *            The admin's password.
	 * @return True : connection successful / False : connection failed.
	 */
	@Override
	public boolean connexion(String login, String password) {
		return administrateur.connexion(login, password);
	}

	/**
	 * Create a tournament.
	 * 
	 * @param nomTournoi
	 *            Name of the tournament.
	 */
	@Override
	public void creerTournoi(String nomTournoi) {
		administrateur.creerTournoi(nomTournoi);
	}

	/**
	 * Set the beginning of the match.
	 * 
	 * @param idRencontre
	 *            The id of the match.
	 * @param debut
	 *            The date of beginning of the match.
	 */
	@Override
	public void setDebutRencontre(int idRencontre, Calendar debut) {
		administrateur.setDebutRencontre(idRencontre, debut);
	}

	/**
	 * Returns all the referees.
	 * 
	 * @return List of referees.
	 */
	@Override
	public List<Arbitre> getArbitres() {
		return administrateur.getArbitres();
	}

	/**
	 * Add a referee.
	 * 
	 * @param nom
	 *            Name of the referee.
	 * @param prenom
	 *            Nickname of the referee.
	 */
	@Override
	public void ajouterArbitre(String nom, String prenom) {
		administrateur.ajouterArbitre(nom, prenom);
	}

	/**
	 * Affect a referee to a match.
	 * 
	 * @param idArbitre
	 *            The id of the referee.
	 * @param idRencontre
	 *            The id of the match.
	 */
	@Override
	public void affecterArbitre(int idArbitre, int idRencontre) {
		administrateur.affecterArbitre(idArbitre, idRencontre);
	}

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
	@Override
	public void ajouterBut(int idRencontre, int idAuteur, Calendar heure) {
		administrateur.ajouterBut(idRencontre, idAuteur, heure);
	}

	/**
	 * Validate a match.
	 * 
	 * @param idRencontre
	 *            The id of the match.
	 * @param heureFin
	 *            The Date of the end of the match.
	 */
	@Override
	public void validerRencontre(int idRencontre, Calendar heureFin) {
		administrateur.validerRencontre(idRencontre, heureFin);
	}

}
