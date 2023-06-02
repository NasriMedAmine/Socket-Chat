package services;

import model.*;
import model.*;
import model.*;
import utils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ServicePlayer implements iServicePlayer {
    private Connection connection;
    private Statement statement;

    public ServicePlayer() throws SQLException {
        this.connection = ConnexionMysql.getInstanceConnexion().getConnection();
        this.statement = this.connection.createStatement();
    }

    @Override
    public int ajouterPlayer(User user, Team team)  {
        int signeResultat=0;

        try {
            String requeteSQL = "INSERT INTO `player`(`Id_User`, `id_team`) VALUES (?,?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(requeteSQL);
            preparedStatement.setInt(1,user.getId_user());
            preparedStatement.setInt(2,team.getId_team());
            signeResultat = preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e);
        }

        return signeResultat;
    }

    @Override
    public int modifierPlayer() throws SQLException {
        return 0;
    }

    @Override
    public int supprimerPlayer() {
        return 0;
    }

    @Override
    public ArrayList<User> afficherPlayer() {
        return null;
    }

    @Override
    public User chercher() {
        return null;
    }
}
