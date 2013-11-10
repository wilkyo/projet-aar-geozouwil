package com.soccer.ejb.representative;

public interface Representant {

	public boolean creerEquipe(String nomEquipe, String nomRepresentant,
			String prenomRepresentant, String[] nomJoueurs,
			String[] prenomJoueurs, int[] numeroJoueurs);
}
