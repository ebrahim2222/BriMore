package com.example.brikotlin.di

import android.content.Context
import androidx.room.Room
import com.example.brikotlin.data.repository.RepositoryImp
import com.example.brikotlin.data.source.remote.Api
import com.example.brikotlin.data.source.local.datastore.DataStoreImp
import com.example.brikotlin.data.source.local.room.DataBase
import com.example.brikotlin.utils.Constants
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Modules {
    //val baseUrl:String = "https://test.hercules.brimore.com/"

    @Singleton
    @Provides
    fun  provideRetrofit():Retrofit{

        val logingInterceptor:HttpLoggingInterceptor = HttpLoggingInterceptor();
        logingInterceptor.level  = HttpLoggingInterceptor.Level.BODY

        val httpClient:OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logingInterceptor)
            .build()

        val builder:Retrofit.Builder = Retrofit.Builder()
        val retrofit:Retrofit = builder.baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()

        return retrofit
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit):Api{
        val api:Api = retrofit.create(Api::class.java)
        return api
    }


    @Singleton
    @Provides
    fun provideRepository(sharedHelperImp: DataStoreImp, api :Api):RepositoryImp{
        return RepositoryImp(sharedHelperImp,api)
    }

    @Singleton
    @Provides
    fun provideDataStoreImp(@ApplicationContext context: Context,gson: Gson):DataStoreImp{
        return DataStoreImp(context,"UserData",gson)
    }

    @Provides
    @Singleton
    fun provideGson():Gson{
        return Gson()
    }

}