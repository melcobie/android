package com.example.test.services;

import com.example.test.model.Profils;
import com.example.test.model.ProfilsResponses;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserServices {
    @POST("api/signin")
    public Call<ProfilsResponses> login(@Body Profils user);
    @POST("api/signup")
    public Call<ProfilsResponses> Signin(@Body Profils user);
}
