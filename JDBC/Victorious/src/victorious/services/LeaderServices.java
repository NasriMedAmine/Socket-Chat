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
import victorious.entite.Leader;
import victorious.utils.MyConnexion;

/**
 *
 * @author farouk
 */
public class LeaderServices implements iLeaderServices{
        
      Connection connx ;
     Statement ste;
    public LeaderServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }
    

    @Override
    public int ajouterLeader(Leader p) {
        int x = 0;
        try {
            String sql ="INSERT INTO `leader` (`Id_Leader`, `Id_Player`, `Id_User`, `Level`, `Pseudo`, `Password`, `Mail`) VALUES (NULL, '1', '1', '1', 'farouk', 'farouk', 'farouk@esprit.com');";    
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(LeaderServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
    }

    @Override
    public int modifierLeader(Leader p) {
     int x=0;
        try {
            String sq13="UPDATE 'leader' SET 'Pseudo' = 'Achraf' Where 'user'.'Id_Leader'=1";
            x=ste.executeUpdate(sq13);
        } catch (SQLException ex) {
            Logger.getLogger(LeaderServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public int supprimerLeader(Leader p) {
        try {
            String sql2 = "Delete from leader where Id= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1, 2);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LeaderServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    
    }

    @Override
    public ArrayList<Leader> afficherLeader() {
           ArrayList<Leader> leaders = new ArrayList<>();
        try {
            String sql1="select * from leader";
            ResultSet res = ste.executeQuery(sql1);
            
            Leader p;
        while (res.next()) {
            p = new Leader( res.getInt("Id_Leader"),res.getInt("Id_Player"),res.getInt("Id_User"),res.getInt("Level"),res.getString("Pseudo"),res.getString("Password"),res.getString("Mail"));
    leaders.add(p);
    
}
        } catch (SQLException ex) {
            Logger.getLogger(LeaderServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Leader p : leaders){
               System.out.println(p);
        }
return leaders;
    }
    
}
