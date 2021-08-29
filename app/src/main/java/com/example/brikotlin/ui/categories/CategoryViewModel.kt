package com.example.brikotlin.ui.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brikotlin.domain.model.category.Categories
import com.example.brikotlin.domain.usecase.CategoriesUseCase
import com.example.brikotlin.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.brikotlin.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.lang.Exception

@HiltViewModel
class CategoryViewModel @Inject constructor(
    val categoriesUseCase: CategoriesUseCase,
    val userUseCase: UserUseCase

) : ViewModel() {
     var  categoriesApi:Categories?=null
    val mutableStateFlow:MutableStateFlow<Resource<Categories>> = MutableStateFlow<Resource<Categories>>(Resource.loading(null))
    fun categoriesApi(header: String){
        viewModelScope.launch {
            try {
                categoriesApi = categoriesUseCase.categoriesApi("Bearer "+header)
                mutableStateFlow.value = Resource.success(categoriesApi)
            }catch (e:Throwable){
                val code = e as HttpException
                mutableStateFlow.value = Resource.error(code.code(),categoriesApi)
               }
        }
    }

    suspend fun getUserToken(): Flow<String?> {
        return userUseCase.getToken()
    }

}