package com.example.brikotlin.domain.usecase

import com.example.brikotlin.data.repository.RepositoryImp
import com.example.brikotlin.domain.model.category.Categories
import javax.inject.Inject

class SubCategoryUseCase @Inject constructor(val repositoryImp: RepositoryImp) {

    suspend fun subCategoryApi(header:String,id:Int):Categories{
        return repositoryImp.subCategoryApi(header, id)
    }

}