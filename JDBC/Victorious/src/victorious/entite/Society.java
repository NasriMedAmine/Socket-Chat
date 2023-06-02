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
public class Society {
    private int id_society ;
    private String name ;
    private int registration_number ;

    public Society() {
    }

    public Society(int id_society, String name, int registration_number) {
        this.id_society = id_society;
        this.name = name;
        this.registration_number = registration_number;
    }

    public int getId_society() {
        return id_society;
    }

    public void setId_society(int id_society) {
        this.id_society = id_society;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(int registration_number) {
        this.registration_number = registration_number;
    }

    @Override
    public String toString() {
        return "Society{" + "id_society=" + id_society + ", name=" + name + ", registration_number=" + registration_number + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Society other = (Society) obj;
        if (this.id_society != other.id_society) {
            return false;
        }
        if (this.registration_number != other.registration_number) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    

    
}
