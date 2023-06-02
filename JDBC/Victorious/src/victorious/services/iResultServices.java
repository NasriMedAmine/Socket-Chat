/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.Result;

/**
 *
 * @author farouk
 */
public interface iResultServices {
    public int ajouterResult(Result p);
    public int modifierResult(Result p); 
    public int supprimerResult(Result p);
    public ArrayList<Result> afficherResult();
    
}
