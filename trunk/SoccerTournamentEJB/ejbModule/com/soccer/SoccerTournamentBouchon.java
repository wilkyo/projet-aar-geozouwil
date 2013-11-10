package com.soccer;

import java.util.ArrayList;
import java.util.List;

import com.soccer.model.Equipe;
import com.soccer.model.Joueur;

public class SoccerTournamentBouchon {

	public static List<Equipe> creerEquipes() {
		Equipe a = new Equipe();
		a.setNom("Paris Saint-Germain");
		a.setNomRepresentant("Blanc");
		a.setPrenomRepresentant("Laurent");

		Joueur j1 = new Joueur();
		j1.setNom("Douchez");
		j1.setPrenom("Nicolas");
		j1.setNumero(1);
		j1.setEquipe(a);

		Joueur j2 = new Joueur();
		j2.setNom("Silva");
		j2.setPrenom("Thiago");
		j2.setNumero(2);
		j2.setEquipe(a);

		Joueur j3 = new Joueur();
		j3.setNom("");
		j3.setPrenom("Marquinhos");
		j3.setNumero(5);
		j3.setEquipe(a);

		List<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.add(j1);
		joueurs.add(j2);
		joueurs.add(j3);
		a.setJoueurs(joueurs);

		Equipe b = new Equipe();
		b.setNom("Olympique de Marseille");
		b.setNomRepresentant("Baup");
		b.setPrenomRepresentant("Élie");

		Joueur j4 = new Joueur();
		j4.setNom("Gennaro");
		j4.setPrenom("Bracigliano");
		j4.setNumero(1);
		j4.setEquipe(b);

		Joueur j5 = new Joueur();
		j5.setNom("André");
		j5.setPrenom("Ayew");
		j5.setNumero(10);
		j5.setEquipe(b);

		Joueur j6 = new Joueur();
		j6.setNom("Jordan");
		j6.setPrenom("Ayew");
		j6.setNumero(11);
		j6.setEquipe(b);

		joueurs = new ArrayList<Joueur>();
		joueurs.add(j4);
		joueurs.add(j5);
		joueurs.add(j6);
		b.setJoueurs(joueurs);

		List<Equipe> equipes = new ArrayList<Equipe>();
		equipes.add(a);
		equipes.add(b);

		return equipes;
	}
}
