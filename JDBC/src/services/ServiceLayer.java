package services;

import model.User;
import model.layerTournament;
import utils.ConnexionMysql;


import java.sql.*;
import java.util.ArrayList;

public class ServiceLayer {

    private Connection connection;
    private Statement statement;
//    private PreparedStatement preparedStatement;

    public ServiceLayer() throws SQLException {
//        System.out.println("1");
        this.connection = ConnexionMysql.getInstanceConnexion().getConnection();
//        System.out.println("2");
        this.statement = this.connection.createStatement();
//       System.out.println("3");
//        System.out.println();

    }


    public boolean isfull(int id_tournoi , String type) throws SQLException {
        System.out.println("123456");
//        int finalcompteur = getInteger(type);
        int finalcompteur = 0;

        switch (type){
            case "2" :
                finalcompteur = 2;
                break;

            case "4" :
                finalcompteur = 4;
                break;
        }
        System.out.println(this.ShowByIdTournament(id_tournoi).size());
        if(this.ShowByIdTournament(id_tournoi).size() < finalcompteur)
            return false;
        return true;
    }

    public ArrayList<layerTournament> ShowByIdTournament(int id_tournoi) throws SQLException {
        ArrayList<layerTournament> mesLayer = new ArrayList<layerTournament>() ;
        String requete = "SELECT * FROM `layerTournament` WHERE `id_tournoi` = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(requete);
        preparedStatement.setInt(1,id_tournoi);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            layerTournament layerTournament1 = new layerTournament(resultSet.getInt("id"),
                    resultSet.getInt("id_tournoi"),
                    resultSet.getInt("id_user")
                    );
            mesLayer.add(layerTournament1);

        }
        return mesLayer;
    }

    public int AjoutLayer(layerTournament layerTournament1) throws SQLException {
        String requete = "INSERT INTO `layerTournament`(`id_tournoi`, `id_user`) VALUES (?,?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(requete);
        preparedStatement.setInt(1,layerTournament1.getId_tournoi());
        preparedStatement.setInt(2,layerTournament1.getId_user());
        return preparedStatement.executeUpdate();

    }




    public ArrayList<User> getUserInTournamentByIdTour(int id_tournoi) throws SQLException {
        ArrayList<User> mesUser = new ArrayList<User>();
        ServiceUser serviceUser = new ServiceUser();
        for (layerTournament layerTournament : this.ShowByIdTournament(id_tournoi)) {
            mesUser.add(serviceUser.findByid(layerTournament.getId_user()));
        }
        return mesUser;
    }
}
