package com.example.test.controller;

import android.content.Context;

import com.example.test.model.Item;
import com.example.test.view.fragment.lesson.LessonsFragment;

import java.util.ArrayList;

public final class ListController {
    private static ListController instance = null;

    private ListController(){}

    public static final ListController getInstance(Context context){
        if(ListController.instance == null){
            ListController.instance = new ListController();
        }
        return ListController.instance;
    }

    public ArrayList<Item> getItems(String type){
        if(type == LessonsFragment.ANIMAL){
            // initialisation liste animaux
        }else if(type == LessonsFragment.THING){
            // initialisation liste objets
        }

        // Exemple à supprimer
        ArrayList<Item> list = new ArrayList<>();
        list.add(0, new Item("", "item 1"));
        list.add(1, new Item("", "item 2"));
        list.add(2, new Item("", "item 3"));
        list.add(3, new Item("", "item dfsdfsfsfescsgb4"));
        // Exemple à supprimer
        return list;
    }
}
