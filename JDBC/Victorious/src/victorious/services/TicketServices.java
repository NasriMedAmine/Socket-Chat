/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import victorious.entite.Ticket;
import victorious.utils.MyConnexion;

/**
 *
 * @author farouk
 */
public class TicketServices implements iTicketServices{
    
     Connection connx ;
     Statement ste;
    public TicketServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }

    @Override
    public int ajouterTicket(Ticket p) {
        int x = 0;
        try {
            String sql ="INSERT INTO `ticket` (`Pseudo`, `Password`, `Mail`) VALUES ('farouk', 'farouk', 'faroku.mansour@esprit.tn');";
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
    }

    @Override
    public int modifierTicket(Ticket p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int supprimerTicket(Ticket p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Ticket> afficherTicket() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
