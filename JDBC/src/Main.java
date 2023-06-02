//import services.ServiceJoueur;
//import services.ServiceTeam;
import model.*;
import services.ServiceDemandeRes;
import services.ServiceUser;
import services.*;
import model.*;

import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;


class Main {



    static Scanner myScanner1 = new Scanner(System.in);
    static transient Socket clientSocket;
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        System.out.println(new Date());


        while (true){

            System.out.println("Taper :  \n");
            System.out.println("    1- log in \n");
            System.out.println("    2- sign in \n");
            System.out.println("    3- Admin \n");


//            int inMyScanner1 = myScanner1.nextInt();
            System.out.println(myScanner1.nextLine().isEmpty());
            System.out.println("******");
            int inMyScanner1 = Integer.parseInt(myScanner1.nextLine());


            ServiceUser serviceUser = new ServiceUser();

            if( inMyScanner1 == 1 ){

                System.out.println("---------------------------------------------------------");

                System.out.println("pseudo : \n");

                String pseudo = myScanner1.nextLine();
                System.out.println("mot de passe : ");
                String  pwd = myScanner1.nextLine();
                System.out.println("login" + pseudo);
                System.out.println("pwd  " + pwd);
                if (serviceUser.logIn(pseudo,pwd) instanceof User){
                    System.out.println("login mawjoud w ahawa ");
                    User user1 = serviceUser.logIn(pseudo,pwd);
                    if(new ServiceResp().isResponsable(user1)){
                        fenetreTemplateAccForResp(new Responsable(user1));
                    }else {
                        fenetreTemplateAccForUser(user1);
                    }
                }
                else{
                    System.out.println(" (pseudo / mot de passe) est faux");
                }
            }
            else if (inMyScanner1 == 2){
                User user = serviceUser.MainAjoutUser(myScanner1);
                int signe = serviceUser.ajouterUser(user);
                if (signe == 1){
                    System.out.println("ajout succes\n");
                }else {
                    System.out.println("ajout echec\n");
                }



            }else if(inMyScanner1 == 3){
                fenetreTemplateAccForAdmin();


            }




        }













//            System.out.println("awel etape f main");
//            Scanner myObjmain1 = new Scanner(System.in);
//            System.out.println("taper 1 pour create user in BD \n");
//            System.out.println("taper 2 pour faire modification pour un user \n");
//            System.out.println("taper 3 pour supprimer un user \n");
//            System.out.println("taper 4 pour afficher user \n");
////            System.out.println("taper 5 pour creer equipe");
//            int choix = myObjmain1.nextInt();
////            myObjmain1.close();
//            ServiceUser serviceUser = new ServiceUser();
////            ServiceTeam serviceTeam = new ServiceTeam();
//
//            switch (choix){
//                case 1 :
////                    System.out.println("tao dkhalet f west case 1 w bech nodkhol l service.ajoutUser");
//                    int res = serviceUser.ajouterUser();
//
//                    if(res == 1){
//                        System.out.println("creation user est terminé avec succes");
//                        System.out.println("tao user saye f BD");
//                        System.out.println("tao Joueur");
////                        ServiceJoueur serviceJoueur = new ServiceJoueur();
//
//
//
//                    }else {
//                        System.out.println("il y a probleme dans creation ueser");
//                    }
////                    System.out.println("hedha serviceUser.ajoutUser");
//
////                    System.out.println(res);
////                    System.out.println("--------");
//                    break;
//
//                case 2 :
//
//                    int ress = serviceUser.modifierUser();
//                    if(ress == 1){
//                        System.out.println("modification est terminé acec succes ");
//
//                    }else {
//                        System.out.println("probleme dans modification");
//                    }
//
//                    break;
//
//                case 3 :
//
//                    int signe = serviceUser.supprimerUser();
//                    if(signe == 1){
//                        System.out.println("user saye tfasakh");
//                    }else {
//                        System.out.println("fama mochkla f suppression");
//                    }
//                    break;
//
//                case 4 :
//                    System.out.println(serviceUser.afficherUser());
//                    break;
//
//
//                case 5 :
//                    System.out.println("pour creer equipe il faut indiquer chef equipe");
//                    System.out.println(serviceUser.afficherUser());
//                    Scanner chefequipeobject = new Scanner(System.in);
//                    String chefequipe = chefequipeobject.nextLine();
//
////                    serviceTeam.ajouterTeam(serviceUser.findId(chefequipe));
//
//
//
//
//
//
//            }
//
//        }
//
//
//
//
//



    }

    public static void fenetreTemplateAccForUser(User user) throws SQLException, IOException {

        boolean isConnected = true;
        while (isConnected == true){
            System.out.println("----------------------------------------------------");
            System.out.println("bienvenue   " + user.getPseudo());
            System.out.println("taper  :");
            System.out.println("     1 - pour faire une demande <<Responsable Tournoi>>");
            System.out.println("     2 - pour creer equipe");
            System.out.println("     3 - pour rejoindre œequipe");
            System.out.println("     4 - pour rejoindre tournoi-");

            System.out.println("     0 - deconnexion");

            int response = myScanner1.nextInt();
            switch (response){
                case 0 :
                    isConnected = false;
                    break;
                case 1 :
                    ServiceDemandeRes serviceDemandeRes = new ServiceDemandeRes();
                    if(serviceDemandeRes.AjoutDemandeRes(user) == 1)
                        System.out.println("demande Res succes");
                    else
                        System.out.println("demande Res echec");


                    break;

                case 2 :
                    fenetreTemplateAddTeamForUser(user);
                    break;

                case 3 :
                    fenetreTemplateInTeamForUser(user);
                    break;
                case 4 :
                    fenetreTemplateInTournamentorUser(user);
                    break;

                default:
                    break;

            }

        }
    }

    public static void fenetreTemplateAccForAdmin() throws SQLException {

        boolean isConnected = true;
        while (isConnected == true){
            System.out.println("vous etes Admin \n");
            System.out.println("Taper \n");
            System.out.println("      1 = consulter liste de damande pour responsable");
            System.out.println("      0 = pour deconnecter");

            int response1 = myScanner1.nextInt();
            System.out.println(response1);
            switch (response1){
                case 0 :
                    isConnected = false;
                    break;
                case  1 :
//                    System.out.println("dkhalet l case 1 admin");
                    ServiceDemandeRes serviceDemandeRes = new ServiceDemandeRes();
                    if (serviceDemandeRes.afficherDemandeRes().size() == 0)
                        System.out.println("il n y a pas demandes pour responsable");

                    else {
                        ServiceUser serviceUser1 = new ServiceUser();
//                        System.out.println("kbal for");
//                        System.out.println(serviceDemandeRes.afficherDemandeRes().size());
                        serviceDemandeRes.afficherDemandeRes().forEach(
                                pres_res -> {
                                    System.out.println("demande  : \n");
                                    System.out.println(pres_res);
                                    System.out.println("User : \n");
                                    try {
                                        System.out.println(serviceUser1.findByid(pres_res.getId_user()));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }

                                }
                        );
                        fenetreTemplateUpdateDemandeResForAdmin(serviceDemandeRes.afficherDemandeRes());
//
                    }
                    break;

                default:
                    break;

            }

        }



    }


    public static void fenetreTemplateUpdateDemandeResForAdmin(ArrayList<Pres_res> pres_res) throws SQLException {
        boolean again = true;
        while (again) {
            System.out.println("        -----------   ");
            System.out.println("                1 = pour accept une demande");
            System.out.println("                2 = pour supprimer une demande");
            System.out.println("                3 = pour annuler");
            int response2 = myScanner1.nextInt();

            switch (response2) {
                case 3:
                    again = false;
                    break;

                case 1 :
                    Map<Integer,Pres_res> jsonData = new HashMap<Integer,Pres_res>();

                    pres_res.forEach(
                            pres_res1 -> {
                                int compteurBox = jsonData.size();
                                compteurBox++;

                                jsonData.put(compteurBox,pres_res1);
                                System.out.println("                taper  "+ Integer.toString(compteurBox)+  "  :  pour accepter cette demande  :\n");
                                System.out.println("                        "+ pres_res1);
                                try {
                                    System.out.println("                    pour User : "+ new ServiceUser().findByid(pres_res1.getId_user()));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }



                            }
                    );
//                    System.out.println(jsonData);
                    int choix = myScanner1.nextInt();
                    if(new ServiceResp().ajoutResp(new ServiceUser().findByid(jsonData.get(choix).getId_user())) == 1)
                        System.out.println("ajout Responsable succes");
                    else
                        System.out.println("ajout Responsable echec");



                case 2 :
                    Map<Integer,Pres_res> jsonData1 = new HashMap<Integer,Pres_res>();

                    pres_res.forEach(
                            pres_res1 -> {
                                int compteurBox = jsonData1.size();
                                compteurBox++;

                                jsonData1.put(compteurBox,pres_res1);
                                System.out.println("                taper  "+ Integer.toString(compteurBox)+  "  :  pour supprimer cette demande  :\n");
                                System.out.println("                        "+ pres_res1);
                                try {
                                    System.out.println("                    pour User : "+ new ServiceUser().findByid(pres_res1.getId_user()));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }



                            }
                    );
//                    System.out.println(jsonData);
                    int choix1 = myScanner1.nextInt();
                    System.out.println("**-*****");
                    System.out.println(new ServiceUser().findByid(jsonData1.get(choix1).getId_user()));
                    if(new ServiceResp().deleteDemande(new ServiceUser().findByid(jsonData1.get(choix1).getId_user())) == 1)
                        System.out.println("demande annulee");
                    else
                        System.out.println("problem demande annulee");


                default:
                    break;

            }
        }




    }



    public static void fenetreTemplateAccForResp(Responsable responsable) throws SQLException {

        boolean isConnected = true;
        while (isConnected == true){
            System.out.println("----------------------------------------------------");
            System.out.println("bienvenue   " + responsable.getPseudo());
            System.out.println("vous etes <<Responsable Tournoi>>");
            System.out.println("taper  :");
            System.out.println("     1 - pour creer un tournoi");

            System.out.println("     0 - deconnexion");

            int response = myScanner1.nextInt();
            switch (response){
                case 0 :
                    isConnected = false;
                    break;
                case 1 :


                    System.out.println("            ----------------------------------------------------");
                    System.out.println("              le nom de Tournoi : ");
                    Scanner scanner = new Scanner(System.in);
                    String nomTournoi = scanner.nextLine();
                    System.out.println("hedha esem tournoi" + nomTournoi);
                    Tournament tournament = new Tournament(nomTournoi,responsable.getId_user(),"code",3,"2");
//                    Tournament tournament = new Tournament(nomTournoi ,responsable);
                    System.out.println(tournament);
                    ServiceTournament serviceTournament = new ServiceTournament();
                    if( serviceTournament.ajoutTournement(tournament) == 1)
                        System.out.println("ajout tournoi succes");
                    else
                        System.out.println("ajout Tournoi echec");

                    break;


                default:
                    break;


            }

        }

    }

    public static void fenetreTemplateAddTeamForUser(User user) throws SQLException {

        System.out.println("    --------Nom de l'equipe  : ");

        String teamname = myScanner1.next();
        System.out.println("    --------Nbr  :  ");
        int nbr = myScanner1.nextInt();
        ServiceTeam serviceTeam = new ServiceTeam();
        if(serviceTeam.ajouterTeam(user, teamname, nbr) == 1)
            System.out.println(" ajout equipe succes    ");
        else
            System.out.println("ajout equipe succes");




    }

    public static void fenetreTemplateInTeamForUser(User user) throws SQLException {
        ServiceTeam serviceTeam = new ServiceTeam();
        System.out.println("    -----voici tous le equipes");
        if(serviceTeam.afficherTeam().size() != 0){
            Map<Integer,Team> mesChoix = new HashMap<Integer,Team>();
            serviceTeam.afficherTeam().forEach(
                    team -> {
                        int compteurBox = mesChoix.size();
                        compteurBox++;
                        mesChoix.put(compteurBox,team);
                        System.out.println("  -------- taper  "+ Integer.toString(compteurBox)+  "  pour equipe suivant  :\n");
                        System.out.println("                        "+ team);
                    }
            );
            System.out.println("  -------- taper 0 pour  annuler  :\n");
            int choixinput = myScanner1.nextInt();
            if(choixinput == 0)
                return;
            if(new ServicePlayer().ajouterPlayer(user,mesChoix.get(choixinput)) == 1) {
                System.out.println(" -------------vous etes dans team :");
                System.out.println("---------------"+mesChoix.get(choixinput).toString());
            }

        }else {
            System.out.println("il n y a pas des equipes dispo");
        }


    }

    public static void fenetreTemplateInTournamentorUser(User user) throws SQLException, IOException {
        ServiceTournament serviceTournament = new ServiceTournament();
        System.out.println(" ---------voici  tournoi dispo :");
        if( serviceTournament.afficherTournament().size() !=0 ){
            Map<Integer,Tournament> meschoix = new HashMap<Integer,Tournament>();
            serviceTournament.afficherTournament().forEach(
                    tournament -> {
                        int compteurBox = meschoix.size();
                        compteurBox++;
                        meschoix.put(compteurBox,tournament);
                        System.out.println("  -------- taper  "+ Integer.toString(compteurBox)+  "  pour tournoi suivant  :\n");
                        System.out.println("                        "+ tournament);

                    }
            );

            int choix2 = myScanner1.nextInt();
            fenetreTemplateAccTournamentorUser(user , meschoix.get(choix2));


        }else {
            System.out.println("il n y a pas tournoi dispo");
        }


    }

    private static void fenetreTemplateAccTournamentorUser(User user, Tournament tournament) throws IOException {

        boolean again = true;
        while (again) {
            System.out.println("                ------ vous etes dans tournoi  :" + tournament.getTournament_Name()  );

            System.out.println("                --------------taper 1 : pour ouvrir chat");
            System.out.println("                --------------taper 2 : pour lancer jeu");
            System.out.println("                 -------------taper 3 : pour annuler");
            int choix5 = myScanner1.nextInt();
            switch (choix5) {

                case 1:
                    fenetreTemplateChatTournamentorUser(user, tournament);


                case 3:
                    again = false;

                default:
                    break;
            }
        }
    }

    private static void fenetreTemplateChatTournamentorUser(User user, Tournament tournament) throws IOException {
        boolean end = false;

        System.out.println("vous etes dans chat de Tournoi : " + tournament.getTournament_Name());


        clientSocket = new Socket("127.0.0.1",5000);
        System.out.println("connexion Socket valide");
        OutputStream outputStream = clientSocket.getOutputStream();
        ObjectOutputStream outObject = new ObjectOutputStream(outputStream);

        InputStream inputStream = clientSocket.getInputStream();
        ObjectInputStream inObject = new ObjectInputStream(inputStream);
        Thread envoyer = new Thread(new Runnable() {
            String msg2;
            @Override
            public void run() {
                Map<String,Serializable> messageMapHeader = new HashMap<>();
                messageMapHeader.put("Function","header");

                messageMapHeader.put("IdClient",Integer.toString(user.getId_user()));
                messageMapHeader.put("IdGroup" ,Integer.toString(tournament.getId_Tournament()));
                try {
                    outObject.writeObject(messageMapHeader);
                    outObject.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                while(true){
                    try {
                        System.out.println("----------------------------------------");
                        System.out.println("------------ ecrire votre message------------\n");
                        String messageChat = myScanner1.next();
                        Map<String,Serializable> protocolChatMessage = new HashMap<>();
                        protocolChatMessage.put("Function","MessageChat");
                        Chat chat = new Chat(user.getId_user(), tournament.getId_Tournament() ,messageChat);
                        protocolChatMessage.put("Chat",chat);
                        System.out.println("message chat");
                        System.out.println(protocolChatMessage);
                        outObject.writeObject(protocolChatMessage);
                        outObject.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        envoyer.start();


        Thread recevoir = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    Map<String,Serializable> messageObject = (Map<String,Serializable>)inObject.readObject();


                    while (messageObject != null) {
                        if ("AncChat".equals(messageObject.get("Function"))) {
                            System.out.println("------------------------------------------------------------------------------");
                            System.out.println("--------------------------Chat-------------------------------------------------");
                            System.out.println("-----AncChat--------------------------------------------------------------------");
                           ArrayList<Chat> mesAncChat = (ArrayList<Chat>)messageObject.get("List<Chat>");
                           mesAncChat.forEach(
                                   chat -> {
                                       System.out.println("--------   ($" + Integer.toString(chat.getId_user()) + " :\n");
                                       System.out.println("----------------->   " + chat.getMessage());
                                   }

                           );

                            System.out.println("----------------------------------------------------------");
                        }
                        else if ("MessageChatNow".equals(messageObject.get("Function"))){
//                            System.out.println("tao dkhalet l MessageNow");
                            ArrayList<Chat> listchatnow = (ArrayList<Chat>) messageObject.get("ListChat");

                            List<Chat> listchatnowtree = listchatnow.stream()
                                    .sorted(Comparator.comparing(Chat::getId_chat))
                                            .collect(Collectors.toList());


//                                    stream()
//                                    .sorted(Comparator.comparingInt(User::getAge))
//                                    .collect(Collectors.toList());


//                            System.out.println(listchatnow);
//                            System.out.println("tao dabelthom b list");
                            listchatnowtree.forEach(
                                    chatNow -> {
                                        System.out.println("***");
                                        System.out.println("--" + chatNow.getId_chat());
                                        System.out.println("message From   $"+Integer.toString(chatNow.getId_user() )+"\n");
                                        System.out.println("            ----->  " + chatNow.getMessage());
                                    }
                            );
//                            System.out.println("tao dkhalt m foreach");


                        }


                        messageObject = (Map<String,Serializable>)inObject.readObject();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }
        });
        recevoir.start();

        while (end == false){

        };





    }


}














//        Connection conn = null;
//        try {
//
//            System.out.println("step1");
//            String url = "jdbc:mysql://localhost:3306/Esprit_Pidev?characterEncoding=utf8";
//            String user = "Pidev";
//            String pwd = "azertyAZERTY123?";
//            conn = DriverManager.getConnection(url,user,pwd);
//
//            System.out.println("saayeee!");
//            Statement statement = conn.createStatement();
//            String query = "SELECT * FROM user";
//            ResultSet result = statement.executeQuery(query);
//            System.out.println(result);
////            System.out.println(result.getInt(1));
//            while (result.next()){
//                System.out.println(result.getString("nom"));
//                /*System.out.println(result.last());*/
//            }
//
//
//        } catch (SQLException e) {
//            throw new Error("Problem", e);
//        }
//        finally {
//            try {
//                System.out.println("finaly");
//                if (conn != null) {
//                    System.out.println("besh nsaker saye");
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//    }
//}












































//
//Uml     40 CC   60 examen   10.8
//python  20 test   80 Examen    12.2
//math   40 CC   60 examen  11.8
//analyse fina  40 CC   60 examen  6.85
//ang  40 CC   60 examen  9.25
//entrep  40CC  60 examen  8.05
//java 20 cc 30 ds 50 examen     8.85
//
//ip et switched  40cc 60 examen
//
//ip  6.2
//
//sn  16.12
