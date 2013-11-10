package com.soccer.ejb.facade;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Semaphore;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import com.soccer.SoccerTournamentBouchon;
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
		// initDBBouchon();
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

	public void initDBBouchon() {
		try {
			mutex.acquire();
			if (!dbInitialized) {
				for (Arbitre ar : SoccerTournamentBouchon.creerArbitres()) {
					em.persist(ar);
					System.out.println(ar.toXML());
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
		System.out.println("SoccerTournamentFacadeSessionBean()");
	}

	@Override
	public boolean creerEquipe(String nomEquipe, String nomRepresentant,
			String prenomRepresentant, String[] nomJoueurs,
			String[] prenomJoueurs, int[] numeroJoueurs) {
		return representant.creerEquipe(nomEquipe, nomRepresentant,
				prenomRepresentant, nomJoueurs, prenomJoueurs, numeroJoueurs);
	}

	@Override
	public List<VOTournoi> getTournois() {
		return utilisateur.getTournois();
	}

	@Override
	public List<VOEquipe> getEquipes(String nomTournoi) {
		return utilisateur.getEquipes(nomTournoi);
	}

	@Override
	public List<VOJoueur> getJoueurs(String nomEquipe) {
		return utilisateur.getJoueurs(nomEquipe);
	}

	@Override
	public List<VORencontreLight> getRencontres(String nomTournoi) {
		return utilisateur.getRencontres(nomTournoi);
	}

	@Override
	public List<VORencontre> getRencontre(int idRencontre) {
		return utilisateur.getRencontre(idRencontre);
	}

	@Override
	public List<VOEquipe> getEquipes(int idRencontre) {
		return utilisateur.getEquipes(idRencontre);
	}

	@Override
	public boolean connexion(String login, String password) {
		return administrateur.connexion(login, password);
	}

	@Override
	public void creerTournoi() {
		administrateur.creerTournoi();
	}

	@Override
	public void setDebutRencontre(int idRencontre, Calendar debut) {
		administrateur.setDebutRencontre(idRencontre, debut);
	}

	@Override
	public void ajouterArbitre(String nom, String prenom) {
		administrateur.ajouterArbitre(nom, prenom);
	}

	@Override
	public void affecterArbitre(int idArbitre, int idRencontre) {
		administrateur.affecterArbitre(idArbitre, idRencontre);
	}

	@Override
	public void ajouterBut(int idRencontre, int idAuteur, Calendar heure) {
		administrateur.ajouterBut(idRencontre, idAuteur, heure);
	}

	@Override
	public void validerRencontre(Calendar heureFin) {
		administrateur.validerRencontre(heureFin);
	}

}
