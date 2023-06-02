package model;

import java.io.Serializable;
import java.util.Objects;

public class Chat implements Serializable {
    private int id_chat;
    private int id_user;
    private int id_tounroi;
    private String message;






    public Chat(int id_user, int id_tounroi, String message) {
        this.id_user = id_user;
        this.id_tounroi = id_tounroi;
        this.message = message;
    }

    public Chat() {
    }

    public Chat(int id_chat, int id_user, int id_tounroi, String message) {
        this.id_chat = id_chat;
        this.id_user = id_user;
        this.id_tounroi = id_tounroi;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id_chat=" + id_chat +
                ", id_user=" + id_user +
                ", id_tounroi=" + id_tounroi +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return getId_chat() == chat.getId_chat() && getId_user() == chat.getId_user() && getId_tounroi() == chat.getId_tounroi() && Objects.equals(getMessage(), chat.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_chat(), getId_user(), getId_tounroi(), getMessage());
    }

    public void setId_chat(int id_chat) {
        this.id_chat = id_chat;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_tounroi(int id_tounroi) {
        this.id_tounroi = id_tounroi;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId_chat() {
        return id_chat;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_tounroi() {
        return id_tounroi;
    }

    public String getMessage() {
        return message;
    }
}
