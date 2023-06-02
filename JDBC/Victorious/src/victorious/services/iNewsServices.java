/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.News;

/**
 *
 * @author farouk
 */
public interface iNewsServices {
    public int ajouterLeader(News p);
    public int modifierLeader(News p); 
    public int supprimerLeader(News p);
    public ArrayList<News> afficherLeader();
    
}
