package com.soccer.ejb.user;

import java.util.List;
import com.soccer.valueobjects.*;

public interface Utilisateur {

	public List<VOTournoi> getTournois();

	public List<VOEquipe> getEquipes(String nomTournoi);

	public List<VOJoueur> getJoueurs(String nomEquipe);

	public List<VORencontreLight> getRencontres(String nomTournoi);

	public VORencontre getRencontre(int idRencontre);

	public List<VOEquipe> getEquipes(int idRencontre);

}
