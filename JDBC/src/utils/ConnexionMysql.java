package utils;

import java.sql.*;

public class ConnexionMysql {

    private String url = "jdbc:mysql://localhost:3306/victorious?characterEncoding=utf8";
    //private String user = "Pidev";
    //private String pwd = "azertyAZERTY123?";

    private String user = "root";
    private String pwd = "";


    static Connection myConnexionMysql ;
    static  ConnexionMysql myInstanceConnexionMysql;

    private ConnexionMysql() {
//        System.out.println("je suis dans contructeur ConnexionMysql kbal try");
        try {
//            System.out.println("je suis dans contructeur ConnexionMysql");
            myConnexionMysql = DriverManager.getConnection(url, user, pwd);
            System.out.println("connexion Mysql valide");

        } catch (Exception e) {
            System.out.println("il y a problem instance de ConnextionMysql");;
        }
    }

    public static ConnexionMysql getInstanceConnexion(){
        if(myInstanceConnexionMysql == null)
            myInstanceConnexionMysql = new ConnexionMysql();

        return myInstanceConnexionMysql;
    }

    public Connection getConnection(){
        return myConnexionMysql;
    }

}
