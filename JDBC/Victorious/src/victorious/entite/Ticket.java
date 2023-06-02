/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.entite;
import java.io.BufferedReader;
import java.io. InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author jasse
 */
public class Ticket {
    private int id_ticket;
    private TicketEnum type;
    private User ticket_owner;

    public Ticket(int id_ticket, TicketEnum type, User ticket_owner) {
        this.id_ticket = id_ticket;
        this.type = type;
        this.ticket_owner = ticket_owner;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public TicketEnum getType() {
        return type;
    }

    public void setType(TicketEnum type) {
        this.type = type;
    }

    public User getTicket_owner() {
        return ticket_owner;
    }

    public void setTicket_owner(User ticket_owner) {
        this.ticket_owner = ticket_owner;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id_ticket=" + id_ticket + ", type=" + type + ", Owner=" + ticket_owner + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Ticket other = (Ticket) obj;
        if (this.id_ticket != other.id_ticket) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (!Objects.equals(this.ticket_owner, other.ticket_owner)) {
            return false;
        }
        return true;
    }
    
}
