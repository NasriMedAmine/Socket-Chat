package services;


import model.Tournament;
import utils.ConnexionMysql;

import java.sql.*;
import java.util.ArrayList;

public class ServiceTournament {

    private Connection connection;
    private Statement statement;

    public ServiceTournament() throws SQLException {
//        System.out.println("1");
        this.connection = ConnexionMysql.getInstanceConnexion().getConnection();
//        System.out.println("2");
        this.statement = this.connection.createStatement();
    }


    public int ajoutTournement(Tournament tournament) {
        int signeResultat=0;



        try {

            String requeteSQL = "INSERT INTO `tournament`(`Tournament_Name`, `id_Managers`, `code`, `id_game`, `type`) VALUES (?,?,?,?,?)";

            PreparedStatement preparedStatement = this.connection.prepareStatement(requeteSQL);
            preparedStatement.setString(1, tournament.getTournament_Name());
            preparedStatement.setInt(2,tournament.getId_managers());
            preparedStatement.setString(3, tournament.getCode());
            preparedStatement.setInt(4,tournament.getId_game());
            preparedStatement.setString(5, tournament.getType());

//            String pattern = "yyyy-MM-dd";
//            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
//            String dateNow = formatter.format(pres_res.getDate());

            signeResultat = preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e);
        }

        return signeResultat;

    }


    public ArrayList<Tournament> afficherTournament() {
        ArrayList<Tournament> mesTournament = new ArrayList<Tournament>();
        try {
            String requeteSQL = "SELECT * FROM `tournament`";
            ResultSet resultSet = this.statement.executeQuery(requeteSQL);

            while (resultSet.next()) {

                Tournament tournament = new Tournament(resultSet.getInt("Id_Tournament"),
                        resultSet.getString("Tournament_Name"),
                        resultSet.getInt("id_Managers"),
                        resultSet.getString("code"),
                        resultSet.getInt("id_game"),
                        resultSet.getString("type")
                );
                mesTournament.add(tournament);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mesTournament;
    }





    public ArrayList<Tournament> showAllByIdUser(int id_user){
        ArrayList<Tournament> mesTournament = new ArrayList<Tournament>();
        try {
            String requeteSQL = "SELECT * FROM `tournament` WHERE id_Managers=?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(requeteSQL);
            preparedStatement.setInt(1,id_user);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Tournament tournament = new Tournament(resultSet.getInt("Id_Tournament"),
                        resultSet.getString("Tournament_Name"),
                        resultSet.getInt("id_Managers"),
                        resultSet.getString("code"),
                        resultSet.getInt("id_game"),
                        resultSet.getString("type")
                );
                mesTournament.add(tournament);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mesTournament;

    }

    public ArrayList<Tournament> showAllByIdNameint (String  name){
        ArrayList<Tournament> mesTournament = new ArrayList<Tournament>();
        try {
            String requeteSQL = "SELECT * FROM `tournament` WHERE Tournament_Name=?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(requeteSQL);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Tournament tournament = new Tournament(resultSet.getInt("Id_Tournament"),
                        resultSet.getString("Tournament_Name"),
                        resultSet.getInt("id_Managers"),
                        resultSet.getString("code"),
                        resultSet.getInt("id_game"),
                        resultSet.getString("type")
                );
                mesTournament.add(tournament);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mesTournament;

    }

    public boolean IsValideCode(String name, String code) {

        try {
            String requeteSQL = "SELECT * FROM `tournament` where `Tournament_Name` = ? and `code` = ? ";
            PreparedStatement preparedStatement = this.connection.prepareStatement(requeteSQL);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, code);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                return true;
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
}
