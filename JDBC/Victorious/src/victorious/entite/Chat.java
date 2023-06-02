/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.entite;

import java.util.Objects;

/**
 *
 * @author farouk
 */
public class Chat {
    private int id_chat ;
    private String message ;

    public Chat() {
    }

    public Chat(int chat, String message) {
        this.id_chat = chat;
        this.message = message;
    }

    public int getChat() {
        return id_chat;
    }

    public void setChat(int chat) {
        this.id_chat = id_chat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Chat{" + "chat=" + id_chat + ", message=" + message + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chat other = (Chat) obj;
        if (this.id_chat != other.id_chat) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        return true;
    }
    
    
}
