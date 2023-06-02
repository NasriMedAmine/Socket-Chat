/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.TicketEnum;

/**
 *
 * @author farouk
 */
public interface iTicketEnumServices {
     public int ajouterTicketEnum(TicketEnum p);
    public int modifierTicketEnum(TicketEnum p); 
    public int supprimerTicketEnum(TicketEnum p);
    public ArrayList<TicketEnum> afficherTicketEnum();
    
    
}
