package com.example.brikotlin.ui.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brikotlin.domain.model.main.HomePage
import com.example.brikotlin.domain.usecase.HomeUseCase
import com.example.brikotlin.domain.usecase.UserUseCase
import com.example.brikotlin.utils.Resource
import com.example.brikotlin.utils.ResponseError
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    val mainUseCase: HomeUseCase,
    val userUseCase: UserUseCase,
    @ApplicationContext val context:Context
    ) : ViewModel() {
    var homeApi:HomePage? = null
    val mutableStateFlow = MutableStateFlow<Resource<HomePage>>(Resource.loading(null))
    fun homeApi(header:String){
        viewModelScope.launch {
            try {
                homeApi = mainUseCase.homeApi("Bearer "+header)
                mutableStateFlow.value = Resource.success(homeApi)
            }catch (e:Throwable){
                val code = e as HttpException
                mutableStateFlow.value = Resource.error(code.code() , homeApi )
            }
        }
    }

    suspend fun getToken():Flow<String?>{
        return userUseCase.getToken()
    }


}