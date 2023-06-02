package services;

import model.Pres_res;
import model.User;
import utils.ConnexionMysql;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceDemandeRes implements iServiceDemandeRes {
    private Connection connection;
    private Statement statement;

    public ServiceDemandeRes() throws SQLException {
//        System.out.println("1");
        this.connection = ConnexionMysql.getInstanceConnexion().getConnection();
//        System.out.println("2");
        this.statement = this.connection.createStatement();
    }


    public int AjoutDemandeRes(User user){
        Pres_res pres_res = new Pres_res();
        pres_res.setId_user(user.getId_user());
        pres_res.setDate(new java.util.Date());

        int signeResultat=0;



        try {

            String requeteSQL = "INSERT INTO `pres_res`(`id_user`, `date`) VALUES (?,?)";

            PreparedStatement preparedStatement = this.connection.prepareStatement(requeteSQL);
            preparedStatement.setInt(1,pres_res.getId_user());
            System.out.println(user);
            System.out.println(pres_res);

            String pattern = "yyyy-MM-dd";
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            String dateNow = formatter.format(pres_res.getDate());

            preparedStatement.setString(2,dateNow );
            signeResultat = preparedStatement.executeUpdate();


//            ServicePlayer servicePlayer = new ServicePlayer();
//            servicePlayer.ajouterPlayer(this.findId(pseudo) ,user_code);

        }catch (SQLException e){
            System.out.println(e);
        }

        return signeResultat;




    }


    public ArrayList<Pres_res> afficherDemandeRes(){

        ArrayList<Pres_res> mesDemandes = new ArrayList<Pres_res>();
        try {
            String requeteSQL = "SELECT * FROM `pres_res`";
            ResultSet resultSet = this.statement.executeQuery(requeteSQL);

            while (resultSet.next()){

                Pres_res pres_res = new Pres_res(resultSet.getInt("id_pres_res") ,resultSet.getInt("id_user"),new Date());
                mesDemandes.add(pres_res);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mesDemandes;
    }

}
