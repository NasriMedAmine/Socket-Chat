/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.Advertise;

/**
 *
 * @author farouk
 */
public interface iAdvertiseServices {
    public int ajouterAdvertise(Advertise p);
    public int modifierAdvertise(Advertise p); 
    public int supprimerAdvertise(Advertise p);
    public ArrayList<Advertise> afficherAdvertise();
    
}
