package com.example.brikotlin.ui.products

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.brikotlin.data.repository.RepositoryImp
import com.example.brikotlin.domain.model.products.Products
import com.example.brikotlin.domain.usecase.ProductsUseCase
import com.example.brikotlin.domain.usecase.UserUseCase
import com.example.brikotlin.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    val productsUseCase: ProductsUseCase,
    val userUseCase: UserUseCase,
    val repositoryImp: RepositoryImp
) : ViewModel() {
    private  val TAG = "ProductsViewModel"
    var productsReponse:Products?=null
    val mutableStateFlow = MutableStateFlow<Resource<Products>>(Resource.loading(null))

    fun productsApi(header:String,id:Int){
        viewModelScope.launch {
            try {
                productsReponse = productsUseCase.productsApi("Bearer "+header,id)
                Log.d(TAG, "productsApi: "+productsReponse)
                mutableStateFlow.value = Resource.success(productsReponse)
            }catch (t:Throwable){
                val code = t as HttpException
                mutableStateFlow.value = Resource.error(code.code(),productsReponse)

            }
        }
    }
    suspend fun getUserToken(): Flow<String?>{
        return userUseCase.getToken()
    }

}