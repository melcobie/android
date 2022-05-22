package com.example.test.model;

import com.google.gson.annotations.SerializedName;

public class Profils {
    @SerializedName("email")
    private String mail;
    @SerializedName("username")
    private  String pseudo;
    @SerializedName("password")
    private String password;

    public Profils(String mail, String pseudo, String password) {
        this.mail = mail;
        this.pseudo = pseudo;
        this.password = password;
    }

    public Profils() {
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
