/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.User;

/**
 *
 * @author farouk
 */
public interface iUserServices {
    public int ajouterUser(User p);
    public int modifierUser(User p); 
    public int supprimerUser(User p);
    public ArrayList<User> afficherUser();
}
