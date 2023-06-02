/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pi.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.pi.entite.Personne;
import tn.esprit.pi.utils.MyConnexion;

/**
 *
 * @author chams
 */
public class PersonneServices implements iPersonneServices{

    Connection connx ;
    Statement ste;


    public PersonneServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            this.ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
     
    
    }
    

    @Override
    public int ajouterPersonne(Personne p) {
        int x = 0;
        try {
            String sql ="INSERT INTO `personne` (`Nom`, `Age`) VALUES ('zzzz', '1');";
           
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
    }

    @Override
    public int modifierPersonne(Personne p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int supprimerPersonne(Personne p) {
        
        try {
            String sql2 = "Delete from personne where id= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1, 5);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Personne> afficherPersonne() {
       ArrayList<Personne> personnes = new ArrayList<>();
        try {
            String sql1="select * from personne";
            ResultSet res = ste.executeQuery(sql1);
            
            Personne p;
        while (res.next()) {
            p = new Personne( res.getInt("ID"),res.getString("Nom"),res.getInt("Age"));
    personnes.add(p);
    //
    
    
}
        } catch (SQLException ex) {
            Logger.getLogger(PersonneServices.class.getName()).log(Level.SEVERE, null, ex);
        }
return personnes;
    }
    
    
    
}
