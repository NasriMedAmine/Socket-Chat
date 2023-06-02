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
import victorious.entite.User;
import victorious.utils.MyConnexion;

/**
 *
 * @author farouk
 */
public class UserServices implements iUserServices{
    
      Connection connx ;
     Statement ste;
    public UserServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }
    

  
    public int ajouterUser(User p) {
        int x = 0;
        try {
            String sql ="INSERT INTO `user` (`Pseudo`, `Password`, `Mail`) VALUES ('farouk', 'farouk', 'faroku.mansour@esprit.tn');";
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
      
    }

    
    public int modifierUser(User p) {
        int x=0;
        try {
            String sq13="UPDATE 'user' SET 'Pseudo' = 'Achraf' Where 'user'.'Id'=1";
            x=ste.executeUpdate(sq13);
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    
    public int supprimerUser(User p) {
        try {
            String sql2 = "Delete from user where Id= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1, 2);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    
    }

   
    public ArrayList<User> afficherUser() {
         ArrayList<User> users = new ArrayList<>();
        try {
            String sql1="select * from user";
            ResultSet res = ste.executeQuery(sql1);
            
            User p;
            while (res.next()) {
                p = new User( res.getInt("Id"),res.getString("Pseudo"),res.getString("Password"),res.getString("Mail"));
                users.add(p);
    //
             }
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (User p : users){
               System.out.println(p);
        }
return users;
    }
    
}
