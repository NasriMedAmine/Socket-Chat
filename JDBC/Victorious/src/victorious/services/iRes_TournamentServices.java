/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.Res_Tournament;
import victorious.entite.User;

/**
 *
 * @author farouk
 */
public interface iRes_TournamentServices {
    public int ajouterRes_Tournament(Res_Tournament p);
    public int modifierRes_Tournament(Res_Tournament p); 
    public int supprimerRes_Tournament(Res_Tournament p);
    public ArrayList<Res_Tournament> afficherRes_Tournament();
    
}
