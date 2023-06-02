/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.Society;

/**
 *
 * @author farouk
 */
public interface iSocietyServices {
    public int ajouterSociety(Society p);
    public int modifierSociety(Society p); 
    public int supprimerSociety(Society p);
    public ArrayList<Society> afficherSociety();
    
}
