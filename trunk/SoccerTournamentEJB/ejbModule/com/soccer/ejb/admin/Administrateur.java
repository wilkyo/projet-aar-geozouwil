package com.soccer.ejb.admin;

import java.util.Calendar;
import java.util.List;

import com.soccer.model.Arbitre;

public interface Administrateur {

	public boolean connexion(String login, String password);

	public void creerTournoi(String nomTournoi);

	public void setDebutRencontre(int idRencontre, Calendar debut);

	public List<Arbitre> getArbitres();

	public void ajouterArbitre(String nom, String prenom);

	public void affecterArbitre(int idArbitre, int idRencontre);

	public void ajouterBut(int idRencontre, int idAuteur, Calendar heure);

	public void validerRencontre(Calendar fin, int idRencontre);
}
