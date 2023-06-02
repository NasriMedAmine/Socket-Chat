package services;

import model.Chat;
import utils.*;

import java.sql.*;
import java.util.ArrayList;

public class ServiceChat {
    private Connection connection;
    private Statement statement;
//    private PreparedStatement preparedStatement;

    public ServiceChat() throws SQLException {
//        System.out.println("1");
        this.connection = ConnexionMysql.getInstanceConnexion().getConnection();
//        System.out.println("2");
        this.statement = this.connection.createStatement();
//       System.out.println("3");
//        System.out.println();

    }

    public ArrayList<Chat> findChatByIdGroup(int id_group) throws SQLException {
        ArrayList<Chat> mesChat = new ArrayList<Chat>();
        String request = "SELECT * FROM `chat` WHERE `id_tournoi`= ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(request);
        preparedStatement.setInt(1,id_group);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Chat chat = new Chat(resultSet.getInt("Id_Chat"),
                    resultSet.getInt("id_user"),
                    resultSet.getInt("id_tournoi"),
                    resultSet.getString("Message")
            );
            mesChat.add(chat);
        }
        return mesChat;

    }


    public int ajoutChat(Chat chat) throws SQLException {


        String request = "INSERT INTO `chat`(`Message`, `id_user`, `id_tournoi`) VALUES (?,?,?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(request);
        preparedStatement.setString(1,chat.getMessage());
        preparedStatement.setInt(2,chat.getId_user());
        preparedStatement.setInt(3,chat.getId_tounroi());
        return preparedStatement.executeUpdate();

    }




}
