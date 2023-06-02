package other.mobile;

import utils.*;
import other.mobile.ConnexionMysqlMobil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class ServiceUser implements iServiceUser {


    private Connection connection;
    private Statement statement;
//    private PreparedStatement preparedStatement;

    public ServiceUser() throws SQLException {
//        System.out.println("1");
        this.connection = ConnexionMysql.getInstanceConnexion().getConnection();
//        System.out.println("2");
        this.statement = this.connection.createStatement();
//       System.out.println("3");
//        System.out.println();

    }

    @Override
    public int ajouterUser(User user) {
        int signeResultat=0;



        try {
            String requeteSQL = "INSERT INTO `user`(`Pseudo`, `Password`, `Mail`, `age`, `pseudo_id`) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(requeteSQL);
            preparedStatement.setString(1,user.getPseudo());
            preparedStatement.setString(2,user.getPwd());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setInt(4,user.getAge());
            preparedStatement.setInt(5, user.hashCode());
            signeResultat = preparedStatement.executeUpdate();


//            ServicePlayer servicePlayer = new ServicePlayer();
//            servicePlayer.ajouterPlayer(this.findId(pseudo) ,user_code);

        }catch (SQLException e){
            System.out.println(e);
        }

        return signeResultat;
    }

    @Override
    public int modifierUser() throws SQLException {
        int signeResultat=0;
        User user_cible = this.chercher();
        Scanner myObjajout13 = new Scanner(System.in);
        System.out.println("pour ce user on va changer :  taper \n");
        System.out.println(" 1 = pour changer pseudo \n");
        System.out.println(" 2 = pour changer pwd \n");
        System.out.println(" 3 = pour changer email \n");
        System.out.println(" 4 = pour changer age \n");

        int choix;
        choix = myObjajout13.nextInt();
        System.out.println("kbak if instanceof");


        if(user_cible instanceof User && user_cible != null){
            switch (choix){
                case 1 :
                    Scanner myObjajout5 = new Scanner(System.in);
                    System.out.println("taper nouveau pseudo");
                    String nouveaupseudo = myObjajout5.nextLine();
                    String requetesql = "UPDATE `user` SET `Pseudo`=? WHERE pseudo_id=?";
                    PreparedStatement preparedStatement = this.connection.prepareStatement(requetesql);
                    preparedStatement.setString(1,nouveaupseudo);
                    preparedStatement.setInt(2,user_cible.hashCode());
                    return preparedStatement.executeUpdate();
                case 2 :
                    Scanner myObjajout6 = new Scanner(System.in);
                    System.out.println("taper nouveau mot de passe \n");
                    String nouveaupseudo1 = myObjajout6.nextLine();
                    String requetesql1 = "UPDATE `user` SET `Password`=? WHERE pseudo_id=?";
                    PreparedStatement preparedStatement1 = this.connection.prepareStatement(requetesql1);
                    preparedStatement1.setString(1,nouveaupseudo1);
                    preparedStatement1.setInt(2,user_cible.hashCode());
                    return preparedStatement1.executeUpdate();

                case 3 :
                    Scanner myObjajout7 = new Scanner(System.in);
                    System.out.println("taper nouveau email \n");
                    String nouveaupseudo2 = myObjajout7.nextLine();
                    String requetesql2 = "UPDATE `user` SET `Mail`=? WHERE pseudo_id=?";
                    PreparedStatement preparedStatement2 = this.connection.prepareStatement(requetesql2);
                    preparedStatement2.setString(1,nouveaupseudo2);
                    preparedStatement2.setInt(2,user_cible.hashCode());
                    return preparedStatement2.executeUpdate();
                case 4:
                    Scanner myObjajout8 = new Scanner(System.in);
                    System.out.println("taper nouvelle age \n");
                    int nouveaupseudo3 = myObjajout8.nextInt();
                    String requetesql3 = "UPDATE `user` SET `age`=? WHERE pseudo_id=?";
                    PreparedStatement preparedStatement3 = this.connection.prepareStatement(requetesql3);
                    preparedStatement3.setInt(1,nouveaupseudo3);
                    preparedStatement3.setInt(2,user_cible.hashCode());
                    return preparedStatement3.executeUpdate();



            }



        }




        /*try {
            String requeteSQL = "DELETE FROM `user` WHERE pseudo_id=?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(requeteSQL);
            preparedStatement.setInt(1,user_cible.hashCode());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }*/


        return signeResultat;
    }

    @Override
    public int supprimerUser() {
        int signeResultat=0;

        User user_cible = this.chercher();
        System.out.println(user_cible);
        System.out.println(user_cible.hashCode());
        System.out.println(user_cible.hashCode());
        if(user_cible != null){
            try {
                String requeteSQL = "DELETE FROM `user` WHERE pseudo_id=?";
                PreparedStatement preparedStatement = this.connection.prepareStatement(requeteSQL);
                preparedStatement.setInt(1,user_cible.hashCode());
                preparedStatement.executeUpdate();
                System.out.println("on a supprimé user \n");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return signeResultat;
    }

    @Override
    public ArrayList<User> afficherUser() {
        ArrayList<User> mesUser = new ArrayList<User>();
        try {
            String requeteSQL = "SELECT * FROM `user`";
            ResultSet resultSet = this.statement.executeQuery(requeteSQL);

            while (resultSet.next()){
                User user = new User(resultSet.getString("Pseudo") ,resultSet.getString("Password"), resultSet.getString("Mail"),resultSet.getInt("age"));
                mesUser.add(user);
                System.out.println(user);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mesUser;
    }

    @Override
    public User chercher() {

        while (true){
            Scanner myObj1 = new Scanner(System.in);
            System.out.println("on va chercher un user selon : taper \n");
            System.out.println(" 1 = chercher selon nom \n");
            System.out.println(" 2 = chercher selon email \n");
            System.out.println(" 3 = chercher selon age \n");
            System.out.println(" 3 = quitter \n");

            int user_cible = myObj1.nextInt();
//            myObj1.close();
            ArrayList<User> mesUser = this.afficherUser();
            int compteur = 0;
//            myObj1.close();
            switch (user_cible){
                case 1 :
                            Scanner myObj11 = new Scanner(System.in);
                            System.out.println("ecrire le nom \n");
                            String nom_cible = myObj11.nextLine();
                    System.out.println("nom eli hatiout == " + nom_cible );
//                            myObj11.close();
                    System.out.println("-----");
                    System.out.println("compteur =="+compteur);
                            while (compteur < mesUser.size()){
                                System.out.println(compteur);
                                System.out.println(mesUser.get(compteur).getPseudo());

                                if(mesUser.get(compteur).getPseudo().equals(nom_cible) ){
                                    System.out.println("saye lkitou user");
                                    return mesUser.get(compteur);
                                }
                                compteur++;

                            }
                    System.out.println("malkitouch user w bech nrajaa null f   USer chercher() ");
                            return null;
                case 2 :


                            Scanner myObj111 = new Scanner(System.in);
                            System.out.println("ecrire email \n" );
                            String email_cible = myObj111.nextLine();
//                            myObj111.close();
                            while (compteur < mesUser.size()){
                                if(mesUser.get(compteur).getEmail().equals(email_cible) ){
                                    System.out.println("cbon lkitou user");
                                    return mesUser.get(compteur);
                                }
                                compteur++;
                            }
                    System.out.println("malkit shay");
                            return null;


                case 3 :
                    System.out.println("not yet \n");
                    break;


                case 4 : return null;


            }
//            myObj1.close();

        }


    }



    @Override
    public User logIn(String login , String pwd) {
//        System.out.println("f serviceuser   USER logIN");
//        System.out.println(this.afficherUserLogIn(login,pwd));
        if( this.afficherUserLogIn(login,pwd).size() != 0 ){
            return this.afficherUserLogIn(login,pwd).get(0);
        }
        return null;
    }

    @Override
    public ArrayList<User> afficherUserLogIn(String login, String pwd) {
        ArrayList<User> mesUser = new ArrayList<User>();
        try {
//            login = "'" + login + "'";
//            pwd = "'" + login + "'";
            String requeteSQL = "SELECT * FROM `user` WHERE `Pseudo`=? AND `Password`= ?" ;
//            ResultSet resultSet = this.statement.executeQuery(requeteSQL);
            PreparedStatement preparedStatement = this.connection.prepareStatement(requeteSQL);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,pwd);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                User user = new User(resultSet.getInt("Id"),resultSet.getString("Pseudo") ,resultSet.getString("Password"), resultSet.getString("Mail"),resultSet.getInt("age"));
                mesUser.add(user);
//                System.out.println(user);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mesUser;

    }


    public int findId(String pseudo) throws SQLException {
        System.out.println("ena tao f findID");
        System.out.println(pseudo);
        String requeteSQL = "SELECT * FROM `user`";
        ResultSet resultSet = this.statement.executeQuery(requeteSQL);
        while (resultSet.next()){
            if( resultSet.getString("Pseudo").equals(pseudo) ){
                System.out.println("cbon lkit id mtaa pseudo f findId");
                System.out.println(resultSet.getInt("Id"));

                return resultSet.getInt("Id");
            }


        }
        System.out.println("rajaaet 0");
        return 0;

    }


    public User findByid(int id) throws SQLException {

        String requeteSQL = "SELECT * FROM `user` WHERE `Id`=? " ;
        PreparedStatement preparedStatement = this.connection.prepareStatement(requeteSQL);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            User user = new User(resultSet.getInt("Id"),resultSet.getString("Pseudo") ,resultSet.getString("Password"), resultSet.getString("Mail"));
            return user;

        }
        return null;
    }


    public static Predicate<User> Age(int minAge, int maxAge) {
        return p -> p.getAge() >= minAge && p.getAge() <= maxAge ;
    }

    public void refreshHashCode(User usercode){

    }


    public User MainAjoutUser(Scanner myScanner){
        String NOTHING = myScanner.nextLine();
        System.out.println("entrer votre pseudo \n");
        String pseudo = myScanner.nextLine();
//        myObjajout1.close();


        System.out.println("entrer votre mot de passe \n");
        String pwd = myScanner.nextLine();
//        myObjajout2.close();


        System.out.println("entrer votre email \n");
        String email = myScanner.nextLine();
//        myObjajout3.close();


        System.out.println("entrer votre age \n");
        int age = myScanner.nextInt();
        User user = new User(pseudo,pwd,email,age);
        return user;


    }
}
