package com.example.test.controller;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.test.Utils.RetrofitClient;
import com.example.test.model.Categorie;
import com.example.test.model.CategorieResponses;
import com.example.test.model.Item;
import com.example.test.view.fragment.lesson.LessonsFragment;
import com.example.test.services.LeconsServices;
import com.example.test.view.MainActivity;
import com.example.test.view.fragment.LessonsFragment;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class ListController {
    private static ListController instance = null;

    private ListController(){}

    public static final ListController getInstance(Context context){
        if(ListController.instance == null){
            ListController.instance = new ListController();
        }
        return ListController.instance;
    }
public BlockingQueue<ArrayList<Item>> reqest (){
    LeconsServices apiService = RetrofitClient.getRetrofitInstance().create(LeconsServices.class);
    final BlockingQueue<ArrayList<Item>> BQ = new ArrayBlockingQueue<ArrayList<Item>>(1);
    apiService.GetItems().enqueue(new Callback<CategorieResponses>() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onResponse(Call<CategorieResponses> call, Response<CategorieResponses> response) {

//                Optional<Categorie> Animal =  response.body().getCategorie().stream().filter((x) -> x.getNom() == "ANIMAL") .findFirst();
//                System.out.println(Animal);

            ArrayList<Item> result = response.body().getCategorie().get(0).getItem();
            BQ.add(result);

        }

        @Override
        public void onFailure(Call<CategorieResponses> call, Throwable t) {
            System.out.println(t);
        }

    });
    return BQ;
}
    public ArrayList<Item> getItems(String type){
        ArrayList<Item> list = new ArrayList<>();
        try {
            BlockingQueue<ArrayList<Item>> reqestss = reqest();
            list = reqestss.take();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
