/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.Historique;

/**
 *
 * @author farouk
 */
public interface iHistoriqueServices {
    public int ajouterHistorique(Historique p);
    public int modifierHistorique(Historique p); 
    public int supprimerHistorique(Historique p);
    public ArrayList<Historique> afficherHistorique();
    
}
