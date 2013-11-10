package com.soccer;

import java.util.ArrayList;
import java.util.List;

import com.soccer.model.Arbitre;

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
}
