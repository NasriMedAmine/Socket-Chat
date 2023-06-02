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
import victorious.entite.News;
import victorious.entite.User;
import victorious.utils.MyConnexion;

/**
 *
 * @author farouk
 */
public class NewsServices implements iNewsServices{
    
     Connection connx ;
     Statement ste;
    public NewsServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }
    

    @Override
    public int ajouterLeader(News p) {
       int x = 0;
        try {
            String sql ="INSERT INTO `news` (`Date_Debut`, `Date_Fin`) VALUES ('2022/02/17', '2022/07/01');";
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(NewsServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
      
    }
    

    @Override
    public int modifierLeader(News p) {
         int x=0;
        try {
            String sq13="UPDATE 'news' SET 'Pseudo' = 'Achraf' Where 'news'.'Id_News'=1";
            x=ste.executeUpdate(sq13);
        } catch (SQLException ex) {
            Logger.getLogger(NewsServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public int supprimerLeader(News p) {
        try {
            String sql2 = "Delete from news where Id_News= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1, 2);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NewsServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<News> afficherLeader() {
         ArrayList<News> newses = new ArrayList<>();
        try {
            String sql1="select * from news";
            ResultSet res = ste.executeQuery(sql1);
            
            News p;
        while (res.next()) {
            p = new News( res.getInt("Id_News"),res.getDate("Date_Debut"),res.getDate("Date_Fin"));
    newses.add(p);
    //
    
    
}
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (News p : newses){
               System.out.println(p);
        }
return newses;
    }
    
}
