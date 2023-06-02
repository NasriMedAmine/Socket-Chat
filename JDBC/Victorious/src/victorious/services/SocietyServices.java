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
import victorious.entite.Society;
import victorious.entite.User;
import victorious.utils.MyConnexion;

/**
 *
 * @author farouk
 */
public class SocietyServices implements iSocietyServices{

       Connection connx ;
     Statement ste;
    public SocietyServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }
    
   
    public int ajouterSociety(Society p) {
          int x = 0;
        try {
            String sql ="INSERT INTO `society` (`Id_Society`, `Name`, `Registration_Number`) VALUES (NULL, 'Red bull', '1111111');";
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SocietyServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
    }

    @Override
    public int modifierSociety(Society p) {
           int x=0;
        try {
            String sq13="UPDATE 'society' SET 'Pseudo' = 'Achraf' Where 'society'.'Id_Society'=1";
            x=ste.executeUpdate(sq13);
        } catch (SQLException ex) {
            Logger.getLogger(SocietyServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public int supprimerSociety(Society p) {
        try {
            String sql2 = "Delete from society where id= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1, 2);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SocietyServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    
    
    }

    @Override
    public ArrayList<Society> afficherSociety() {
         ArrayList<Society> societys = new ArrayList<>();
        try {
            String sql1="select * from society";
            ResultSet res = ste.executeQuery(sql1);
            
            Society p;
        while (res.next()) {
            p = new Society( res.getInt("Id_Society"),res.getString("Name"),res.getInt("registration_number"));
    societys.add(p);
   
}
        } catch (SQLException ex) {
            Logger.getLogger(SocietyServices.class.getName()).log(Level.SEVERE, null, ex);
        }
         for (Society p : societys){
               System.out.println(p);
        }
return societys;
    }
    
}
