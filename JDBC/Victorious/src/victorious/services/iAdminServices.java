/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.Admin;


/**
 *
 * @author farouk
 */
public interface iAdminServices {
    public int ajouterAdmin(Admin p);
    public int modifierAdmin(Admin p); 
    public int supprimerAdmin(Admin p);
    public ArrayList<Admin> afficherAdmin();
    
}
