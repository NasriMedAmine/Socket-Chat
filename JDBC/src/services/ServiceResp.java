package services;

import model.Pres_res;
import model.Responsable;
import model.User;
import utils.ConnexionMysql;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ServiceResp implements iServiceResp{
    private Connection connection;
    private Statement statement;

    public ServiceResp() throws SQLException {
//        System.out.println("1");
        this.connection = ConnexionMysql.getInstanceConnexion().getConnection();
//        System.out.println("2");
        this.statement = this.connection.createStatement();
    }

    @Override
    public int ajoutResp(User user) throws SQLException {
        int signeResultat = 0;
        String requeteSql = "INSERT INTO `res_tournament`(`Id_User`,`date`) VALUES (?,?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(requeteSql);
        preparedStatement.setInt(1,user.getId_user());
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String dateNow = formatter.format(new Date());

        preparedStatement.setString(2,dateNow );
        signeResultat = preparedStatement.executeUpdate();


        return signeResultat;
    }

    @Override
    public ArrayList<Responsable> afficherResponsable() {
        ArrayList<Responsable> mesResponsables = new ArrayList<Responsable>();
        try {

            String requeteSQL = "SELECT * FROM `res_tournament`";
            ResultSet resultSet = this.statement.executeQuery(requeteSQL);

            while (resultSet.next()){
                Responsable responsable = new Responsable(new ServiceUser().findByid(resultSet.getInt("Id_User")));
                mesResponsables.add(responsable);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mesResponsables;

    }

    @Override
    public boolean isResponsable(User user1) {

        for(Responsable responsable : this.afficherResponsable()){
            if(responsable.getId_user() == user1.getId_user())
                return true;
        }
        return false;

    }

    public int deleteDemande(User user) throws SQLException {
        int res = 0;
        String requeteSQL = "DELETE FROM `pres_res` WHERE `pres_res`.`id_pres_res` = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(requeteSQL);
        ServiceUser serviceUser = new ServiceUser();
        System.out.println("dekhel deleteDemande");
//        System.out.println(serviceUser.findId(user.getPseudo()));
        preparedStatement.setInt(1,serviceUser.findId(user.getPseudo()));
        res = preparedStatement.executeUpdate();
        return res;

    }


}
