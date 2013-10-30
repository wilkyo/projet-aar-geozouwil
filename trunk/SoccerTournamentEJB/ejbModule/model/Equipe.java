package model;

import java.util.List;

public class Equipe {

	private String nom;
	private List<Joueur> joueurs;
	private Representant representant;
	private int numero;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public Representant getRepresentant() {
		return representant;
	}

	public void setRepresentant(Representant representant) {
		this.representant = representant;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
