package com.example.test.controller;

import android.content.Context;

public final class SettingController {
    private static SettingController instance = null;

    private SettingController(){}

    public static final SettingController getInstance(){
        if(SettingController.instance == null){
            SettingController.instance = new SettingController();
        }
        return SettingController.instance;
    }

}
