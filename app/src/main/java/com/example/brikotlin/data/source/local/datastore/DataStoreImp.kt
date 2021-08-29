package com.example.brikotlin.data.source.local.datastore

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import com.example.brikotlin.domain.model.loginresponse.UserData
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreImp  : com.example.brikotlin.data.source.local.datastore.DataStore {
    val dataStore:DataStore<Preferences>
    var gson:Gson
    @Inject constructor(@ApplicationContext context:Context, fileName:String, gson: Gson){
        dataStore = context.createDataStore(name = fileName)
        this.gson = gson
    }


    val token : Flow<String?>
    get() = dataStore.data.map { preferences ->
        preferences[tokenKey]
    }


    override suspend fun saveUserToken(token: String) {
        dataStore.edit { preferences ->
            preferences[tokenKey] = token
        }
    }


    override suspend fun saveEmail(email: String) {
        dataStore.edit { preferences ->
            preferences[userEmail] = email
        }
    }

    override suspend fun savePassword(password: String) {
        dataStore.edit { preferences ->
            preferences[userPassword] = password
        }
    }


    override suspend fun saveUser(userData: UserData) {
        val userrData:String = gson.toJson(userData)
        dataStore.edit { preferences ->
            preferences[userDataa] = userrData
        }
    }

    val data : Flow<String?>
    get() = dataStore.data.map { preferences ->
        preferences[userDataa]
    }

    override suspend fun getEmail():String?{
        val preferences = dataStore.data.first()
        return preferences[userEmail]
    }
    override suspend fun getPassword():String?{
        val preferences = dataStore.data.first()
        return preferences[userPassword]
    }



    companion object{
        val tokenKey = preferencesKey<String>("token")
        val userDataa = preferencesKey<String>("userData")
        val userEmail = preferencesKey<String>("email")
        val userPassword= preferencesKey<String>("password")
    }
}


