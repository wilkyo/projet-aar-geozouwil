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
		Tournoi tournoi = new Tournoi();
		tournoi.setNom("Tournoi2013");
		tournoi.setNbEquipes(4);
		tournoi.setTourActuel(1);

		Rencontre rc1 = new Rencontre();
		rc1.setArbitre(arbitres.get(0));
		rc1.setTournoi(tournoi);
		rc1.setHotes(equipes.get(0));
		rc1.setVisiteurs(equipes.get(1));
		rc1.setTour(tournoi.getTourActuel());
		Rencontre rc2 = new Rencontre();
		rc2.setArbitre(arbitres.get(1));
		rc2.setTournoi(tournoi);
		rc2.setHotes(equipes.get(1));
		rc2.setVisiteurs(equipes.get(0));
		rc2.setTour(tournoi.getTourActuel());

		// Tournoi 2
		Tournoi tournoi2 = new Tournoi();
		tournoi2.setNom("Tournoi2014");
		tournoi2.setNbEquipes(8);
		tournoi2.setTourActuel(1);

		Rencontre rc3 = new Rencontre();
		rc3.setArbitre(arbitres.get(1));
		rc3.setTournoi(tournoi2);
		rc3.setHotes(equipes.get(1));
		rc3.setVisiteurs(equipes.get(0));
		rc3.setTour(tournoi2.getTourActuel());
		Rencontre rc4 = new Rencontre();
		rc4.setArbitre(arbitres.get(2));
		rc4.setTournoi(tournoi2);
		rc4.setHotes(equipes.get(0));
		rc4.setVisiteurs(equipes.get(1));
		rc4.setTour(tournoi2.getTourActuel());
		Rencontre rc5 = new Rencontre();
		rc5.setArbitre(arbitres.get(2));
		rc5.setTournoi(tournoi2);
		rc5.setHotes(equipes.get(0));
		rc5.setVisiteurs(equipes.get(1));
		rc5.setTour(tournoi2.getTourActuel());
		Rencontre rc6 = new Rencontre();
		rc6.setArbitre(arbitres.get(2));
		rc6.setTournoi(tournoi2);
		rc6.setHotes(equipes.get(0));
		rc6.setVisiteurs(equipes.get(1));
		rc6.setTour(tournoi2.getTourActuel());

		List<Rencontre> lrc = new ArrayList<Rencontre>();
		lrc.add(rc1);
		lrc.add(rc2);
		tournoi.setRencontres(lrc);
		List<Rencontre> lrc2 = new ArrayList<Rencontre>();
		lrc2.add(rc3);
		lrc2.add(rc4);
		lrc2.add(rc5);
		lrc2.add(rc6);
		tournoi2.setRencontres(lrc2);

		List<Tournoi> lesTours = new ArrayList<Tournoi>();
		lesTours.add(tournoi);
		lesTours.add(tournoi2);

		return lesTours;
	}

}
