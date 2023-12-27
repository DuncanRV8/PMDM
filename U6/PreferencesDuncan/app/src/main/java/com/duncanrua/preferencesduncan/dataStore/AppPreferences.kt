package com.duncanrua.preferencesduncan.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

class AppPreferences(val context: Context) {
    companion object{
        val NAME = stringPreferencesKey("NAME")
        val TELEPHONE = stringPreferencesKey("TELEPHONE")

    }
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences")

    suspend fun saveName(name: String) {
        context.dataStore.edit { preferences ->
            preferences[NAME] = name
        }
    }
    suspend fun saveTelephone(telephone: String) {
        context.dataStore.edit { preferences ->
            preferences[TELEPHONE] = telephone
        }
    }

    fun loadName() = context.dataStore.data.map { preferences ->
        preferences[NAME] ?: ""
    }

    fun loadTelephone() = context.dataStore.data.map { preferences ->
        preferences[TELEPHONE] ?: ""
    }
}
