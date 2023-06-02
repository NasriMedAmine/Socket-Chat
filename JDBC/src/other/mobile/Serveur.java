package other.mobile;

import other.mobile.Chat;
import other.mobile.User;
import other.mobile.ServiceChat;
import other.mobile.ServiceUser;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
 * www.codeurjava.com
 */
public class Serveur {
    private static User user;
    static ServerSocket serveurSocket  ;
    static Socket clientSocket ;
    static BufferedReader in;
    static PrintWriter out;
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] test) {

        try {
            serveurSocket = new ServerSocket(5000);
            System.out.println("------------------------------------");
            while (true) {

                clientSocket = serveurSocket.accept();

                out = new PrintWriter(clientSocket.getOutputStream());
                OutputStream outputStream = clientSocket.getOutputStream();
                ObjectOutputStream outObject = new ObjectOutputStream(outputStream);



                // get the input stream from the connected socket
                InputStream inputStream = clientSocket.getInputStream();
                // create a DataInputStream so we can read data from it.
                ObjectInputStream inObject = new ObjectInputStream(inputStream);

//                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));




//                Thread envoi = new Thread(new Runnable() {
//                    String msg;
//                    String msg2;
//
//                    @Override
//                    public void run() {
//                        while (true) {
//
//
////                            msg = sc.nextLine();
////                            out.println(msg);
////                            out.flush();
//                        }
//                    }
//                });
//                envoi.start();
                Thread recevoir = new Thread(new Runnable() {
                    String msg;

                    @Override
                    public void run() {
                        try
                        {
                            System.out.println("bech nakrah awel mara msg object");
                            Map<String,Serializable> messageObject = (Map<String, Serializable>)inObject. readObject();
                            System.out.println(messageObject);
//                            msg = in.readLine();
                            //tant que le client est connecté
                            while (messageObject != null) {
                                System.out.println("list client conencte");
                                System.out.println(ServiceServeur.getInstanceServiceServeur().getListeClient());

//                                msg = in.readLine();
                                System.out.println("kbal if instance of");
                                //if(messageObject instanceof Map<String, Serializable>)
                                {
                                    System.out.println("baaed if instance of ");
                                    switch ((String) messageObject.get("Function")) {
                                        case "header" : {
                                            System.out.println("feket eli heya header f switch");
                                            ServiceServeur serviceServeur = ServiceServeur.getInstanceServiceServeur();
                                            System.out.println(messageObject);
                                            System.out.println(messageObject.get("IdClient").getClass().getSimpleName());
                                            int idUser = (int)messageObject.get("IdClient");
                                            int idGroupe = (int)messageObject.get("IdGroup");
                                            serviceServeur.registClient(idUser, outObject, idGroupe);
                                            ServiceUser serviceUser = new ServiceUser();
                                             user = serviceUser.findByid((int)messageObject.get("IdClient"));


//                                            if(serviceServeur.AncChat(id_group) instanceof ArrayList<Chat>){
//                                                Map<String,Serializable> protocolAncChat = new HashMap<String,Serializable>();
//                                                protocolAncChat.put("Function","AncChat");
//                                                protocolAncChat.put("List<Chat>",serviceServeur.AncChat(id_group));
//                                                outObject.writeObject(protocolAncChat);
//                                            }

                                            Map<String, Serializable> mapMessageChat = new HashMap<String, Serializable>();


                                            mapMessageChat.put("Function", "Connexion Valide");

                                            ServiceServeur serviceServeur1 = ServiceServeur.getInstanceServiceServeur();
                                            serviceServeur1.getListeClient().forEach(
                                                    map -> {

                                                        try {
                                                            ObjectOutputStream toClient = (ObjectOutputStream) map.get("SendToThisClient");
                                                            toClient.writeObject(mapMessageChat);
                                                            toClient.flush();
                                                            System.out.println("tao rajaaet saye l user kol ");
                                                            System.out.println("rajaaet l mobil");
                                                        } catch (IOException e) {
                                                            e.printStackTrace();
                                                        }


                                                    });




                                            System.out.println("khrajt m case 1 header");
                                            break;
                                        }
                                        case "MessageChat" : {
                                            boolean messageClear = true;
                                            System.out.println(messageObject);
                                            System.out.println("ena tao f case messageChat");
                                            if (messageClear == true) {

                                                ServiceChat serviceChat = new ServiceChat();
                                                int id_user1 = (Integer) messageObject.get("id_user");
                                                int id_tournoi1 = (Integer) messageObject.get("id_tournoi");
                                                String message1 = (String) messageObject.get("message");
                                                Chat chat = new Chat(id_user1, id_tournoi1, message1);
                                                System.out.println("hedha chat eli jetni meen aaned clien");
                                                System.out.println(chat);
                                                if (serviceChat.ajoutChatMobile(message1,id_user1) == 1) {
                                                    System.out.println("aamalt chat f DB jawha behi");
                                                    ServiceServeur serviceServeur1 = ServiceServeur.getInstanceServiceServeur();
                                                    serviceServeur1.getListeClient().forEach(
                                                            map -> {
                                                                ObjectOutputStream toClient = (ObjectOutputStream) map.get("SendToThisClient");
                                                                try {
                                                                    System.out.println("tao bech naawed nrajaa l user kol connecte");

                                                                    Map<String, Serializable> mapMessageChat = new HashMap<String, Serializable>();
                                                                    mapMessageChat.put("Function", "MessageChatNow");
                                                                    ServiceChat serviceChat1 = new ServiceChat();
                                                                    int id_groupe11 = (Integer) map.get("groupChat");
                                                                    System.out.println("id_group");
                                                                    System.out.println(id_groupe11);
                                                                    mapMessageChat.put("Message", message1);
                                                                    mapMessageChat.put("idUser", id_user1);

                                                                    ArrayList<Map<String, Serializable>> listToClient = new ArrayList<>();
//                                                                    serviceChat1.findChatMobile().forEach(
//                                                                            chat1 -> {
//                                                                                Map<String, Serializable> mapToClient = new HashMap<String, Serializable>();
//                                                                                mapToClient.put("id_user", chat1.getIdUser());
//                                                                                mapToClient.put("message", chat1.getMessage());
//                                                                                listToClient.add(mapToClient);
//
//                                                                            }
//                                                                    );


                                                                    //mapMessageChat.put("ListChat", listToClient);

                                                                    System.out.println(mapMessageChat);
                                                                    toClient.writeObject(mapMessageChat);
                                                                    toClient.flush();
                                                                    System.out.println("tao rajaaet saye l user kol ");

                                                                } catch (IOException e) {
                                                                    e.printStackTrace();
                                                                } catch (SQLException e) {
                                                                    e.printStackTrace();
                                                                }
                                                            }
                                                    );


                                                }


                                            }
                                            break;
                                        }
                                        case "addWinnerBracet" : {
                                            String winnerName = (String) messageObject.get("Winner");
                                            String looserName = (String) messageObject.get("Looser");
                                            ServiceUser serviceUser6 = new ServiceUser();
                                            User userWinner = serviceUser6.findByid(serviceUser6.findId(winnerName));
                                            User userLooser = serviceUser6.findByid(serviceUser6.findId(looserName));
                                            ServiceServeur serviceServeur3 = ServiceServeur.getInstanceServiceServeur();
                                            serviceServeur3.getListeClient().forEach(
                                                    map -> {
                                                        ObjectOutputStream toClient = (ObjectOutputStream) map.get("SendToThisClient");
                                                        if (map.get("Entity-User").equals(userWinner)) {
                                                            System.out.println("$$$$$$$$$$$$$$$$ \n");
                                                            System.out.println("feket eli user hedha houwa rebah ");
                                                            Map<String, Serializable> mapToClientBrac1 = new HashMap<>();
                                                            mapToClientBrac1.put("Function", "YouAreWinner");
                                                            try {
                                                                toClient.writeObject(mapToClientBrac1);
                                                                toClient.flush();

                                                                System.out.println("baaaed l user eli rbah bracet");
                                                            } catch (IOException e) {
                                                                e.printStackTrace();
                                                            }


                                                        }
                                                        if (map.get("Entity-User").equals(userLooser)) {
                                                            System.out.println("$$$$$$$$$$$$$$$$ \n");
                                                            System.out.println("feket eli user hedha houwa khaser");
                                                            Map<String, Serializable> mapToClientBrac = new HashMap<>();
                                                            mapToClientBrac.put("Function", "YouAreLooser");
                                                            try {
                                                                toClient.writeObject(mapToClientBrac);
                                                                toClient.flush();

                                                                System.out.println("baaed l user l khser bracet");
                                                            } catch (IOException e) {
                                                                e.printStackTrace();
                                                            }

                                                        }


                                                    }
                                            );
                                        }
                                        break;
                                    }
                                }
                                System.out.println(ServiceServeur.getInstanceServiceServeur().getListeClient());
//                                System.out.println(messageObject);
                                System.out.println("bech nestana msg men aaned client");
                                messageObject = (Map<String, Serializable>)inObject.readObject();
                            }
//                            //sortir de la boucle si le client a déconecté
                            System.out.println("Client déconecté");
//                            //fermer le flux et la session socket
//                            out.close();
//                            clientSocket.close();
//                            serveurSocket.close();

                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
                recevoir.start();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

