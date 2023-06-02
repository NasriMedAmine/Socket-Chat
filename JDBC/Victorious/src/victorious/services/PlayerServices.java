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
import victorious.entite.Player;
import victorious.entite.User;
import victorious.utils.MyConnexion;

/**
 *
 * @author farouk
 */
public class PlayerServices implements iPlayerServices{

     Connection connx ;
     Statement ste;
    public PlayerServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }
    @Override
    public int ajouterPlayer(Player p) {
        int x = 0;
        try {
            String sql ="INSERT INTO `player` (`Id_Player`, `Id_User`, `Level`, `Pseudo`, `Password`, `Mail`) VALUES (NULL, '1', '1', 'farouk', 'farouk', 'farouk@esprit.tn');";
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
                Logger.getLogger(PlayerServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
    }

    @Override
    public int modifierPlayer(Player p) {
          int x=0;
        try {
            String sq13="UPDATE 'player' SET 'Pseudo' = 'Achraf' Where 'user'.'Id_Player'=1";
            x=ste.executeUpdate(sq13);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public int supprimerPlayer(Player p) {
         try {
            String sql2 = "Delete from player where Id_Player= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1, 2);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PlayerServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Player> afficherPlayer() {
          ArrayList<Player> players = new ArrayList<>();
        try {
            String sql1="select * from player";
            ResultSet res = ste.executeQuery(sql1);
            
            Player p;
        while (res.next()) {
            p = new Player( res.getInt("Id_Player"),res.getInt("Id_User"),res.getInt("Level"),res.getString("Pseudo"),res.getString("Password"),res.getString("Mail"));
    players.add(p);
    //
    
    
}
        } catch (SQLException ex) {
            Logger.getLogger(PlayerServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Player p : players){
               System.out.println(p);
        }
return players;
    }
    
    
    
}
