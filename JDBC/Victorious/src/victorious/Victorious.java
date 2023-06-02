/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious;



import victorious.entite.Advertise;
import victorious.entite.Chat;
import victorious.entite.Leader;
import victorious.entite.News;
import victorious.entite.Player;
import victorious.entite.Res_Tournament;
import victorious.entite.Society;
import victorious.entite.User;
import victorious.services.AdvertiseServices;
import victorious.services.ChatServices;
import victorious.services.LeaderServices;
import victorious.services.NewsServices;
import victorious.services.PlayerServices;
import victorious.services.Res_TournamentServices;
import victorious.services.SocietyServices;
import victorious.services.UserServices;
import victorious.utils.MyConnexion;

/**
 *
 * @author farouk
 */
public class Victorious {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyConnexion.getInstanceConnex();
        User s = new User();
        UserServices a=new UserServices();
//        a.afficherUser();
        //a.afficherUser();
        Society s1 = new Society();
        SocietyServices a1=new SocietyServices();
       // a1.afficherSociety();
        Res_Tournament s2 = new Res_Tournament();
        Res_TournamentServices a2=new Res_TournamentServices();
        //a2.ajouterRes_Tournament(s2);
        Leader s3 = new Leader();
        LeaderServices a3=new LeaderServices();
        //a3.afficherLeader();
        News s4 = new News();
        NewsServices a4=new NewsServices();
       // a4.supprimerLeader(s4);
        Chat s5 = new Chat();
        ChatServices a5=new ChatServices();
        //a5.afficherChat();
         Player s6 = new Player();
        PlayerServices a6=new PlayerServices();
       // a6.supprimerPlayer(s6);
        Advertise s7 = new Advertise();
        AdvertiseServices a7=new AdvertiseServices();
        a7.afficherAdvertise();
        
    }
    
}
