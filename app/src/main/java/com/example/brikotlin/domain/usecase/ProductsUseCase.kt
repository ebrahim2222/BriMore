package com.example.brikotlin.domain.usecase

import com.example.brikotlin.data.repository.RepositoryImp
import com.example.brikotlin.domain.model.products.Products
import javax.inject.Inject

class ProductsUseCase @Inject constructor(val repositoryImp: RepositoryImp) {

    suspend fun productsApi(header:String,id:Int):Products{
        return repositoryImp.ProductsApi(header,id)
    }

}