/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.Tournament;

/**
 *
 * @author farouk
 */
public interface iTournamentServices {
    public int ajouterTournament(Tournament p);
    public int modifierTournament(Tournament p); 
    public int supprimerTournament(Tournament p);
    public ArrayList<Tournament> afficherTournament();
}
