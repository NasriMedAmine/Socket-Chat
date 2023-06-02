/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public class Responsable extends User{
    private int id_res ;
    private ArrayList<Tournament> mesTournoi ;


    public Responsable() {
    }

    public Responsable(int id_user, String pseudo, String password, String mail,int age) {
        super(id_user, pseudo, password, mail,age);

    }
    public Responsable(User user) {
        super(user.getId_user() , user.getPseudo(), user.getPwd(), user.getEmail(), user.getAge());
    }
   

   

    public int getId_res() {
        return id_res;
    }
   
    public void setId_res(int id_res) {
        this.id_res = id_res;
    }
   
    public String toString() {
        return "Res_Tournament{" + "id=" + id_res + ", pseudo=" + getPseudo() + ", password=" + getPwd() + ", mail=" + getEmail() + '}';
    }

    public void setMesTournoiElement(Tournament mesTournoiElement) {
        this.mesTournoi.add(mesTournoiElement);
    }
    public void setMesTournoi(ArrayList mesTournoi) {
        this.mesTournoi = mesTournoi;
    }

    public ArrayList getMesTournoi() {
        return mesTournoi;
    }
}
