package other.SocketService;
import model.*;
import model.Chat;
import model.*;
import services.ServiceChat;
import services.*;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServiceServeur implements Serializable{
    private static ServiceServeur serviceServeur ;
    private static List<Map<String,Object>> listeClient = new ArrayList<Map<String,Object>>() ;

    private ServiceServeur() {}


    public void setListeClient(List listeClient) {
        this.listeClient = listeClient;
    }

    public List<Map<String, Object>> getListeClient() {
        return listeClient;
    }

    public static ServiceServeur getInstanceServiceServeur(){
        if(serviceServeur == null)
            serviceServeur = new ServiceServeur();
        return serviceServeur;
    }


    public void registClient(int id_user , ObjectOutputStream outObject , int id_group) throws SQLException {

        boolean isHere = false;
        if (isHere == false){

            ServiceUser serviceUser = new ServiceUser();
            serviceUser.findByid(id_user);
            if (serviceUser.findByid(id_user) instanceof User){
                Map<String,Object> protocolRegistre = new HashMap<String,Object>();
                protocolRegistre.put("Entity-User" ,serviceUser.findByid(id_user));
                protocolRegistre.put("SendToThisClient" ,outObject);
                protocolRegistre.put("groupChat" , id_group);

                listeClient.add(protocolRegistre);
            }



        }



    }

    public ArrayList<Chat> AncChat(int id_group) throws SQLException {

        if(new ServiceChat().findChatByIdGroup(id_group).size() != 0){
            ArrayList<Chat> mesChat = new ServiceChat().findChatByIdGroup(id_group);
           return mesChat;
        }
        return null;

    }










}
