package com.example.brikotlin.ui.subcategory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brikotlin.domain.model.category.Categories
import com.example.brikotlin.domain.usecase.SubCategoryUseCase
import com.example.brikotlin.domain.usecase.UserUseCase
import com.example.brikotlin.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class SubCategoryViewModel @Inject constructor(
    val subCategoryUseCase: SubCategoryUseCase,
    val userUseCase: UserUseCase
) : ViewModel() {
    var subCategoryApi:Categories?=null
    val mutableStateFlow = MutableStateFlow<Resource<Categories>>(Resource.loading(null))
    fun getSubCategoryApi(header:String , id:Int){
        viewModelScope.launch {
            try {
                subCategoryApi = subCategoryUseCase.subCategoryApi("Bearer "+header, id)
                mutableStateFlow.value = Resource.success(subCategoryApi)

            }catch (e:Throwable){
                val code = e as HttpException
                mutableStateFlow.value = Resource.error(code.code(),subCategoryApi)
            }
        }


    }

    suspend fun getUserToken():Flow<String?>{
        return userUseCase.getToken()
    }

}