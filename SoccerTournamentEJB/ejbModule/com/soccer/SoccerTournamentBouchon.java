package com.soccer;

import java.util.ArrayList;
import java.util.List;

import com.soccer.model.Arbitre;
import com.soccer.model.Equipe;
import com.soccer.model.Rencontre;
import com.soccer.model.Tournoi;

public class SoccerTournamentBouchon {
	
	public static List<Arbitre> creerArbitres(){
		Arbitre ar1=new Arbitre();
		ar1.setNom("Robert");
		ar1.setPrenom("Wurtz");
		
		Arbitre ar2=new Arbitre();
		ar2.setNom("Héliès");
		ar2.setPrenom("Robert");
		
		Arbitre ar3=new Arbitre();
		ar3.setNom("Kitabdjian");
		ar3.setPrenom("Michel");
		
		List<Arbitre> arbitres=new ArrayList<Arbitre>();
		arbitres.add(ar1);
		arbitres.add(ar2);
		arbitres.add(ar3);
		return arbitres;		
	}
	
	public static List<Tournoi> creerTouroi(){
		Tournoi tour=new Tournoi();
		tour.setNom("Tournoi2013");		
		Rencontre rc=new Rencontre();
		List<Rencontre> lrc=new ArrayList<Rencontre>();
		lrc.add(rc);
		tour.setRencontres(lrc);
		
		
		Tournoi tour2=new Tournoi();
		tour.setNom("Tournoi2014");	
		Rencontre rc2=new Rencontre();
		List<Rencontre> lrc2=new ArrayList<Rencontre>();
		lrc2.add(rc2);
		tour2.setRencontres(lrc2);
		
		List<Tournoi> lesTours=new ArrayList<Tournoi>();
		lesTours.add(tour);
		lesTours.add(tour2);
		
		return lesTours;
		
	}
	
}
