/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.Player;

/**
 *
 * @author farouk
 */
public interface iPlayerServices {
    public int ajouterPlayer(Player p);
    public int modifierPlayer(Player p); 
    public int supprimerPlayer(Player p);
    public ArrayList<Player> afficherPlayer();
    
}
