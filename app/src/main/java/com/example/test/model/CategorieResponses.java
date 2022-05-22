package com.example.test.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategorieResponses {


    public List<Categorie> getCategorie() {
        return categorie;
    }

    public CategorieResponses() {
    }

    public CategorieResponses(List<Categorie> categorie) {
        this.categorie = categorie;
    }

    public void setCategorie(List<Categorie> categorie) {
        this.categorie = categorie;
    }

    @SerializedName("categorie")
    private List<Categorie> categorie;
}
