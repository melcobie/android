package com.example.test.model;

public class ProfilsResponses {
    private  Profils user;
    private  String accessToken;

    public ProfilsResponses() {
    }

    public ProfilsResponses(Profils users, String accessToken) {
        this.user = users;
        this.accessToken = accessToken;
    }



    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Profils getUser() {
        return user;
    }

    public void setUser(Profils user) {
        this.user = user;
    }
}
