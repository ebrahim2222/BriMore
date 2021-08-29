package com.example.brikotlin.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext

data class Resource<T>(val status:Status ,val data:T? , val code: Int?) {


    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(code: Int, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, code)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }






}

