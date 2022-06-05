package com.geektech.lovecalculator.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Prefs {

    private SharedPreferences preferences;

    public Prefs(){
    }

    public void save (Context context){
        preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }

    public void saveState(){
        preferences.edit().putBoolean("isShown",true).apply();
    }

    public boolean isShown(){
        return preferences.getBoolean("isShown",false);
    }
}

