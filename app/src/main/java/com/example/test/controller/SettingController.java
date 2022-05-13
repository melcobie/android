package com.example.test.controller;

import android.content.Context;

import com.example.test.view.Setting;

public final class SettingController {
    private static SettingController instance = null;

    private SettingController(){}

    public static final SettingController getInstance(Context context){
        if(SettingController.instance == null){
            SettingController.instance = new SettingController();
        }
        return SettingController.instance;
    }

}
