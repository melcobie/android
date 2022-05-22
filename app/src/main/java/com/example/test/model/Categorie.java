package com.example.test.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;


public class Categorie implements Serializable {
    @SerializedName("_id")
    private String id;
    @SerializedName("nom")
    private String nom;

    public Categorie() {
    }

    public Categorie(String id, String nom, ArrayList<Item> item) {
        this.id = id;
        this.nom = nom;
        this.item = item;
    }

    @SerializedName("items")
    private ArrayList<Item> item;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Item> getItem() {
        return item;
    }

    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }
}
