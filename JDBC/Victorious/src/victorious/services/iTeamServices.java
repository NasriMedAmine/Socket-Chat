/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.Team;

/**
 *
 * @author farouk
 */
public interface iTeamServices {
    public int ajouterTeam(Team p);
    public int modifierTeam(Team p); 
    public int supprimerTeam(Team p);
    public ArrayList<Team> afficherTeams();
}
