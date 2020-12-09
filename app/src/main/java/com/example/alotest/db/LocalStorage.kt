package com.example.alotest.db

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalStorage(context: Context) {
    private val appContext = context.applicationContext
    private val dataStore: DataStore<Preferences>

    companion object{
        val USER_EMAIL = preferencesKey<String>("user_email")
    }

    init {
        dataStore = appContext.createDataStore(
            name = "app_preferences"
        )
    }

    val getSavedEmail : Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[USER_EMAIL]
        }

    suspend fun saveEmail(email : String) {
        dataStore.edit { preferences ->
            preferences[USER_EMAIL] = email
        }
    }

}