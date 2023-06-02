/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.Match;

/**
 *
 * @author farouk
 */
public interface iMatchServices {
    public int ajouterMatch(Match p);
    public int modifierMatch(Match p); 
    public int supprimerMatch(Match p);
    public ArrayList<Match> afficherMatch();
    
}
