package com.example.brikotlin.data.source.local.datastore

import com.example.brikotlin.domain.model.loginresponse.UserData

interface DataStore {

    suspend fun saveUserToken(token:String)

    suspend fun saveEmail(token:String)

    suspend fun savePassword(token:String)

    suspend fun saveUser(userData:UserData)

    suspend fun getEmail():String?

    suspend fun getPassword():String?


}