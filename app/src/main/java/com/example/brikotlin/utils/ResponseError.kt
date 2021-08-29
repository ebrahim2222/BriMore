package com.example.brikotlin.utils

import android.app.Application
import android.content.Context
import android.widget.Toast

class ResponseError {
    companion object{
        fun errorCode(context: Context ,code: Int){
            when (code)
            {
                400 -> Toast.makeText(context,"Bad Request",Toast.LENGTH_LONG).show()
                401 -> Toast.makeText(context,"Unauthorized",Toast.LENGTH_LONG).show()
                404 -> Toast.makeText(context,"user not found",Toast.LENGTH_LONG).show()
                408 -> Toast.makeText(context,"Request time out",Toast.LENGTH_LONG).show()
                500 -> Toast.makeText(context,"server broken",Toast.LENGTH_LONG).show()

            }
        }
    }

}