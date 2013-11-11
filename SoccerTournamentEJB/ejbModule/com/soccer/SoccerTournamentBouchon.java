package com.soccer;

import java.util.ArrayList;
import java.util.List;

import com.soccer.model.Arbitre;
import com.soccer.model.Equipe;
import com.soccer.model.Rencontre;
import com.soccer.model.Tournoi;

public class SoccerTournamentBouchon {

	public static List<Tournoi> creerTouroi(List<Arbitre> arbitres,
			List<Equipe> equipes) {
		// Tournoi 1
		Tournoi tour = new Tournoi();
		tour.setNom("Tournoi2013");
		tour.setNbEquipes(4);

		Rencontre rc1 = new Rencontre();
		rc1.setArbitre(arbitres.get(0));
		rc1.setTournoi(tour);
		rc1.setHotes(equipes.get(0));
		rc1.setVisiteurs(equipes.get(1));
		Rencontre rc2 = new Rencontre();
		rc2.setArbitre(arbitres.get(1));
		rc2.setTournoi(tour);
		rc2.setHotes(equipes.get(1));
		rc2.setVisiteurs(equipes.get(0));

		// Tournoi 2
		Tournoi tour2 = new Tournoi();
		tour2.setNom("Tournoi2014");
		tour2.setNbEquipes(8);
		
		Rencontre rc3 = new Rencontre();
		rc3.setArbitre(arbitres.get(1));
		rc3.setTournoi(tour2);
		rc3.setHotes(equipes.get(1));
		rc3.setVisiteurs(equipes.get(0));
		Rencontre rc4 = new Rencontre();
		rc4.setArbitre(arbitres.get(2));
		rc4.setTournoi(tour2);
		rc4.setHotes(equipes.get(0));
		rc4.setVisiteurs(equipes.get(1));
		Rencontre rc5 = new Rencontre();
		rc5.setArbitre(arbitres.get(2));
		rc5.setTournoi(tour2);
		rc5.setHotes(equipes.get(0));
		rc5.setVisiteurs(equipes.get(1));
		Rencontre rc6 = new Rencontre();
		rc6.setArbitre(arbitres.get(2));
		rc6.setTournoi(tour2);
		rc6.setHotes(equipes.get(0));
		rc6.setVisiteurs(equipes.get(1));

		List<Rencontre> lrc = new ArrayList<Rencontre>();
		lrc.add(rc1);
		lrc.add(rc2);
		tour.setRencontres(lrc);
		List<Rencontre> lrc2 = new ArrayList<Rencontre>();
		lrc2.add(rc3);
		lrc2.add(rc4);
		lrc2.add(rc5);
		lrc2.add(rc6);
		tour2.setRencontres(lrc2);

		List<Tournoi> lesTours = new ArrayList<Tournoi>();
		lesTours.add(tour);
		lesTours.add(tour2);

		return lesTours;
	}

}
