package com.duncanrua.duncanfinal.dataStore

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey

class AnimePreferences(val context: Context){
    companion object{
        val NAME = stringPreferencesKey("NAME")
    }
}