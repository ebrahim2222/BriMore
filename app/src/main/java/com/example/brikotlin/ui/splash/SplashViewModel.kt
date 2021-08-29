package com.example.brikotlin.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brikotlin.domain.model.loginresponse.LoginResponse
import com.example.brikotlin.domain.usecase.LoginUseCase
import com.example.brikotlin.domain.usecase.UserUseCase
import com.example.brikotlin.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    val userUseCase: UserUseCase,
    val loginUseCase: LoginUseCase
    ) : ViewModel() {
    var loginApi: LoginResponse?=null

    val mutableStateFlow = MutableStateFlow<Resource<LoginResponse>>(Resource.loading(null))

    fun login(email: String, pass: String) {
        viewModelScope.launch {
            try {
                loginApi = loginUseCase.loginApi(email, pass)
                mutableStateFlow.value = Resource.success(loginApi)

            } catch (e: Throwable) {

                val code = e as HttpException
                mutableStateFlow.value = Resource.error(code.code(), loginApi)

            }

        }
    }

    suspend fun getUserEmail():String?{
        return userUseCase.getEmail()
    }
    suspend fun saveToken(token:String){
         userUseCase.saveToken(token)
    }
    suspend fun getUserPassword():String?{
        return userUseCase.getPassword()
    }

}