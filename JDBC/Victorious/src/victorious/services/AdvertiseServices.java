/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import victorious.entite.Advertise;
import victorious.entite.User;
import victorious.utils.MyConnexion;

/**
 *
 * @author farouk
 */
public class AdvertiseServices implements iAdvertiseServices{

    Connection connx ;
     Statement ste;
    public AdvertiseServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }
    
    @Override
    public int ajouterAdvertise(Advertise p) {
       int x = 0;
        try {
            String sql ="INSERT INTO `advertise` (`name_society`, `Date_Debut`, `Date_Fin`) VALUES ('farouk', '2022/02/17', '2022/07/17');";
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AdvertiseServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
      
    }

    @Override
    public int modifierAdvertise(Advertise p) {
        int x=0;
        try {
            String sq13="UPDATE 'advertise' SET 'name_society' = 'Achraf' Where 'advertise'.'Id'=1";
            x=ste.executeUpdate(sq13);
        } catch (SQLException ex) {
            Logger.getLogger(AdvertiseServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public int supprimerAdvertise(Advertise p) {
        try {
            String sql2 = "Delete from advertise where Id= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1, 2);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdvertiseServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Advertise> afficherAdvertise() {
       ArrayList<Advertise> advertises = new ArrayList<>();
        try {
            String sql1="select * from advertise";
            ResultSet res = ste.executeQuery(sql1);
            
            Advertise p;
        while (res.next()) {
            p = new Advertise( res.getInt("Id_Advertise"),res.getString("name_society"),res.getDate("Date_Debut"),res.getDate("Date_Fin"));
    advertises.add(p);
    //
    
    
}
        } catch (SQLException ex) {
            Logger.getLogger(AdvertiseServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Advertise p : advertises){
               System.out.println(p);
        }
return advertises;
    }
    
}
