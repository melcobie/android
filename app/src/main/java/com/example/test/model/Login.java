package com.example.test.model;

public class Login {
    private  String pseudo;
    private String password;

    public Login(String pseudo, String password) {
        this.pseudo = pseudo;
        this.password = password;
    }

    public Login() {
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
