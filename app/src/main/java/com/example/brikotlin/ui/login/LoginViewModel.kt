package com.example.brikotlin.ui.login

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brikotlin.domain.model.loginresponse.LoginResponse
import com.example.brikotlin.domain.model.loginresponse.UserData
import com.example.brikotlin.domain.usecase.LoginUseCase
import com.example.brikotlin.domain.usecase.UserUseCase
import com.example.brikotlin.utils.Resource
import com.example.brikotlin.utils.ResponseError
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val loginUseCase: LoginUseCase,
    @ApplicationContext val context: Context,
    val userUseCase: UserUseCase
) : ViewModel() {
    var loginApi: LoginResponse?=null


    val mutableStateFlow = MutableStateFlow<Resource<LoginResponse>>(Resource.loading(null))

    @ExperimentalCoroutinesApi
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


    suspend fun saveUserToken(token:String){
        userUseCase.saveToken(token)
    }

    suspend fun getUserToken():Flow<String?>{
        return userUseCase.getToken()
    }

    suspend fun saveUserData(user:UserData){
        userUseCase.saveUser(user)
    }
    suspend fun getUserData():Flow<String?>{
        return userUseCase.getUser()
    }

    suspend fun saveUserEmail(email:String){
        userUseCase.saveEmail(email)
    }
    suspend fun saveUserPass(pass:String){
        userUseCase.savePassword(pass)
    }

    suspend fun getUserEmail():String?{
        return userUseCase.getEmail()
    }
    suspend fun getUserPass():String?{
        return userUseCase.getPassword()
    }

}
