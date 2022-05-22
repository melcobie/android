package com.example.test.services;

import com.example.test.model.Categorie;
import com.example.test.model.CategorieResponses;
import com.example.test.model.Profils;
import com.example.test.model.ProfilsResponses;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LeconsServices {
    @GET("lecons/Items")
    public Call<CategorieResponses> GetItems();

}
