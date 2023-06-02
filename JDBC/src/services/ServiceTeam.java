package services;

import model.Team;
import model.User;
import utils.ConnexionMysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ServiceTeam implements iServiceTeam {
    private Connection connection;
    private Statement statement;

    public ServiceTeam() throws SQLException {
        this.connection = ConnexionMysql.getInstanceConnexion().getConnection();
        System.out.println("2");
        this.statement = this.connection.createStatement();
    }

    @Override
    public int ajouterTeam(User user,String nom_equipe , int nbr) {


        int resultat = 0;

        try {
            String requeteSQL = "INSERT INTO `team`(`nom`, `id_chef`, `nbr`) VALUES (?,?,?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(requeteSQL);
            preparedStatement.setString(1, nom_equipe);
            preparedStatement.setInt(2, user.getId_user());
            preparedStatement.setInt(3, nbr);
            resultat = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultat;
    }

    @Override
    public Team modifierTeam() throws SQLException {
        return null;
    }

    @Override
    public int supprimerTeam() {
        int signeResultat=0;

//        Team team_cible = this.chercher();
//        System.out.println(team_cible);
//        System.out.println(team_cible.hashCode());
//        System.out.println(team_cible.hashCode());
//        if(user_cible != null){
//            try {
//                String requeteSQL = "DELETE FROM `team` WHERE pseudo_id=?";
//                PreparedStatement preparedStatement = this.connection.prepareStatement(requeteSQL);
//                preparedStatement.setInt(1,team_cible.hashCode());
//                preparedStatement.executeUpdate();
//                System.out.println("on a supprimé user \n");
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//

        return signeResultat;
    }

    @Override
    public ArrayList<Team> afficherTeam() {
        ArrayList<Team> mesTeams = new ArrayList<Team>();
        try {
            String requeteSQL = "SELECT * FROM `team`";
            ResultSet resultSet = this.statement.executeQuery(requeteSQL);

            while (resultSet.next()) {
                Team team = new Team(resultSet.getInt("id_team"),resultSet.getString("nom"), resultSet.getInt("id_chef"), resultSet.getInt("nbr"));
                mesTeams.add(team);
                System.out.println(team);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mesTeams;
    }

    @Override
    public Team chercher() {
        while (true) {
            Scanner myObj1 = new Scanner(System.in);
            System.out.println(" taper le nom d Team \n");


            String equipe_cible1 = myObj1.nextLine();
//            myObj1.close();
            ArrayList<Team> mesTeam = this.afficherTeam();
            int compteur = 0;
//            myObj1.close();

            while (compteur < mesTeam.size()) {
                System.out.println(compteur);
                System.out.println(mesTeam.get(compteur).getNom());

                if (mesTeam.get(compteur).getNom().equals(equipe_cible1)) {
                    System.out.println("saye lkitou user");
                    return mesTeam.get(compteur);
                }
                compteur++;


//            myObj1.close();

            }
            return null;
        }


    }

}




