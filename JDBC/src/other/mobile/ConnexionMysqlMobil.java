package other.mobile;

import java.sql.*;

public class ConnexionMysqlMobil {

    private String url = "jdbc:mysql://localhost:3306/victorious?characterEncoding=utf8";
    private String user = "root";
    private String pwd = "";
    static Connection myConnexionMysql ;
    static  ConnexionMysqlMobil myInstanceConnexionMysql;

    private ConnexionMysqlMobil() {
//        System.out.println("je suis dans contructeur ConnexionMysql kbal try");
        try {
//            System.out.println("je suis dans contructeur ConnexionMysql");
            myConnexionMysql = DriverManager.getConnection(url, user, pwd);
            System.out.println("connexion Mysql valide");

        } catch (Exception e) {
            System.out.println("il y a problem instance de ConnextionMysql");;
        }
    }

    public static ConnexionMysqlMobil getInstanceConnexion(){
        if(myInstanceConnexionMysql == null)
            myInstanceConnexionMysql = new ConnexionMysqlMobil();

        return myInstanceConnexionMysql;
    }

    public Connection getConnection(){
        return myConnexionMysql;
    }

}
