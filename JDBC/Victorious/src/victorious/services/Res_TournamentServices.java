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
import victorious.entite.Res_Tournament;
import victorious.entite.User;
import victorious.utils.MyConnexion;

/**
 *
 * @author farouk
 */
public class Res_TournamentServices implements iRes_TournamentServices{

     
      Connection connx ;
     Statement ste;
    public Res_TournamentServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }
    

    @Override
    public int ajouterRes_Tournament(Res_Tournament p) {
        int x = 0;
        try {
            String sql ="INSERT INTO `res_tournament` (`Id_Res`, `Id_User`, `Pseudo`, `Password`, `Mail`) VALUES (NULL, '1', 'farouk', 'farouk', 'farouk@esprit.tn');";    
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Res_TournamentServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
          }

    @Override
    public int modifierRes_Tournament(Res_Tournament p) {
 int x=0;
        try {
            String sq13="UPDATE 'res_responsible' SET 'Pseudo' = 'Achraf' Where 'user'.'Id_Res'=1";
            x=ste.executeUpdate(sq13);
        } catch (Exception ex) {
            Logger.getLogger(Res_TournamentServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;    }

    @Override
    public int supprimerRes_Tournament(Res_Tournament p) {
 try {
            String sql2 = "Delete from res_tournament where id= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1, 2);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TournamentServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        }

    @Override
    public ArrayList<Res_Tournament> afficherRes_Tournament() {
         ArrayList<Res_Tournament> res_Tournaments = new ArrayList<>();
        try {
            String sql1="select * from res_tournament";
            ResultSet res = ste.executeQuery(sql1);
            
            Res_Tournament p;
        while (res.next()) {
            p = new Res_Tournament(res.getInt("Id_Res"),res.getInt("Id_User"),res.getString("Pseudo"),res.getString("Password"),res.getString("Mail"));
    res_Tournaments.add(p);
    //
}
        } catch (SQLException ex) {
            Logger.getLogger(Res_TournamentServices.class.getName()).log(Level.SEVERE, null, ex);
        }
         for (Res_Tournament p : res_Tournaments){
               System.out.println(p);
        }
        
           return res_Tournaments;    }
    
}

