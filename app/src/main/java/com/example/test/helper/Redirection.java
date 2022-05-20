package com.example.test.helper;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.test.R;

public class Redirection {
    public static void goToFragment(FragmentManager fragmentManager, Fragment direction){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, direction);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public static void goToPreviousFragment(FragmentManager fragmentManager, Fragment previous){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, previous);
        fragmentTransaction.commit();
    }
}
