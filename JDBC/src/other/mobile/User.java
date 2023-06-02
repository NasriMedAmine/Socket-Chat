package other.mobile;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private int id_user;

    public User(int id_user, String pseudo, String pwd, String email, int age) {
        this.id_user = id_user;
        this.pseudo = pseudo;
        this.pwd = pwd;
        this.email = email;
        this.age = age;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_user() {
        return id_user;
    }

    private String pseudo;
    private String pwd;
    private String email;
    private int pseudo_id ;
    private int age;


    public User(String pseudo, String pwd, String email, int age) {
        this.pseudo = pseudo;
        this.pwd = pwd;
        this.email = email;
        this.age = age;
        this.setPseudo_id(this.hashCode());
    }


    public User(int id,String pseudo, String pwd, String email) {
        this.id_user = id;
        this.pseudo = pseudo;
        this.pwd = pwd;
        this.email = email;

        this.setPseudo_id(this.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(pseudo, user.pseudo) && Objects.equals(pwd, user.pwd) && Objects.equals(email, user.email) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
//        this.pseudo_id = Objects.hash(pseudo, pwd, email, age);
//        return Objects.hash(pseudo, pwd, email, age);

        int hash = 37;
        hash += hash * this.pseudo.hashCode();
        hash += hash * this.pwd.hashCode();
        hash += hash * this.email.hashCode();
        hash += hash * this.age;
        return hash;

    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "pseudo='" + pseudo + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", pseudo_id=" + pseudo_id +
                ", age='" + age + '\'' +
                '}';
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPseudo_id() {
        return pseudo_id;
    }

    public void setPseudo_id(int pseudo_id) {
        this.pseudo_id = pseudo_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

