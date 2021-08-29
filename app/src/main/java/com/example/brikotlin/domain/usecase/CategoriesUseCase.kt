package com.example.brikotlin.domain.usecase

import com.example.brikotlin.data.repository.RepositoryImp
import com.example.brikotlin.domain.model.category.Categories
import javax.inject.Inject

class CategoriesUseCase @Inject constructor(val repositoryImp: RepositoryImp) {

    suspend fun categoriesApi(header: String): Categories {
        return repositoryImp.categoriesApi(header)
    }

}