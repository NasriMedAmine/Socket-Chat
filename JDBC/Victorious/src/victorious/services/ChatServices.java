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
import victorious.entite.Chat;
import victorious.entite.User;
import victorious.utils.MyConnexion;

/**
 *
 * @author farouk
 */
public class ChatServices implements iChatServices{

     Connection connx ;
     Statement ste;
    public ChatServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }
    @Override
    public int ajouterChat(Chat p) {
        int x = 0;
        try {
            String sql ="INSERT INTO `chat` ( `Message`) VALUES ( 'farouk');";
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ChatServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
    }

    @Override
    public int modifierChat(Chat p) {
           int x=0;
        try {
            String sq13="UPDATE 'chat' SET 'Message' = 'Achraf' Where 'chat'.'Id'=1";
            x=ste.executeUpdate(sq13);
        } catch (SQLException ex) {
            Logger.getLogger(ChatServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public int supprimerChat(Chat p) {
       try {
            String sql2 = "Delete from chat where Id= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1, 2);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChatServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Chat> afficherChat() {
         ArrayList<Chat> chats = new ArrayList<>();
        try {
            String sql1="select * from chat";
            ResultSet res = ste.executeQuery(sql1);
            
            Chat p;
        while (res.next()) {
            p = new Chat( res.getInt("Id_Chat"),res.getString("Message"));
    chats.add(p);
    //
    
    
}
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Chat p : chats){
               System.out.println(p);
        }
return chats;
    }
    
}
