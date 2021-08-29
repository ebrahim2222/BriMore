package com.example.brikotlin.ui.productdetails

import androidx.lifecycle.ViewModel
import com.example.brikotlin.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    val userUseCase: UserUseCase
    ): ViewModel() {


        suspend fun saveDefaultUserEmail(email:String){
            userUseCase.saveEmail(email)
        }
        suspend fun saveDefaultUserPass(pass:String){
            userUseCase.savePassword(pass)
        }



}