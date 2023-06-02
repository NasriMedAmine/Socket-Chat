/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.Ticket;

/**
 *
 * @author farouk
 */
public interface iTicketServices {
     public int ajouterTicket(Ticket p);
    public int modifierTicket(Ticket p); 
    public int supprimerTicket(Ticket p);
    public ArrayList<Ticket> afficherTicket();
}
