/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pi.services;

import java.util.ArrayList;
import tn.esprit.pi.entite.Personne;

/**
 *
 * @author chams
 */

public interface iPersonneServices {
    
    public int ajouterPersonne(Personne p);
    public int modifierPersonne(Personne p); 
    public int supprimerPersonne(Personne p);
    public ArrayList<Personne> afficherPersonne();
}
