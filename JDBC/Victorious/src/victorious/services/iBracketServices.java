/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.Bracket;

/**
 *
 * @author farouk
 */
public interface iBracketServices {
    public int ajouterBracket(Bracket p);
    public int modifierBracket(Bracket p); 
    public int supprimerBracket(Bracket p);
    public ArrayList<Bracket> afficherBracket();
    
}
