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
import victorious.entite.Tournament;
import victorious.entite.User;
import victorious.utils.MyConnexion;

/**
 *
 * @author farouk
 */
public class TournamentServices implements iTournamentServices{
       
      Connection connx ;
     Statement ste;
    public TournamentServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }
    

    @Override
    public int ajouterTournament(Tournament p) {
          int x = 0;
        try {
            String sql ="INSERT INTO `user` (`Id`, `Pseudo`,'Password','Mail') VALUES ('1', 'Farouk','farouk','farouk.mansour@esprit.tn');";
           
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TournamentServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
    }

    @Override
    public int modifierTournament(Tournament p) {
        int x=0;
        try {
            String sq13="UPDATE 'user' SET 'Pseudo' = 'Achraf' Where 'user'.'Id'=1";
            x=ste.executeUpdate(sq13);
        } catch (SQLException ex) {
            Logger.getLogger(TournamentServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public int supprimerTournament(Tournament p) {
         try {
            String sql2 = "Delete from personne where id= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1, 5);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TournamentServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
   public ArrayList<Tournament> afficherTournament() {
        ArrayList<Tournament> tournaments = new ArrayList<>();
        try {
            String sql1="select * from user";
            ResultSet res = ste.executeQuery(sql1);
            
            Tournament p;
        while (res.next()) {
            p = new Tournament( res.getInt("Id_Res"),res.getString("tournament_name"),res.getString("Res_Tournaments"),res.getString("Brackets"),res.getString("Team"));
    tournaments.add(p);
    //
    
    
}
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
             return tournaments;
    }
}

