/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.Leader;

/**
 *
 * @author farouk
 */
public interface iLeaderServices {
    public int ajouterLeader(Leader p);
    public int modifierLeader(Leader p); 
    public int supprimerLeader(Leader p);
    public ArrayList<Leader> afficherLeader();
    
}
