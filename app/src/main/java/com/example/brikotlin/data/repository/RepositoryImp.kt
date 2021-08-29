package com.example.brikotlin.data.repository

import androidx.room.withTransaction
import com.example.brikotlin.data.source.remote.Api
import com.example.brikotlin.data.source.local.datastore.DataStoreImp
import com.example.brikotlin.data.source.local.room.DataBase
import com.example.brikotlin.domain.model.category.Categories
import com.example.brikotlin.domain.model.loginresponse.LoginResponse
import com.example.brikotlin.domain.model.loginresponse.UserData
import com.example.brikotlin.domain.model.main.HomePage
import com.example.brikotlin.domain.model.paging.PassengerResponse
import com.example.brikotlin.domain.model.products.Products
import com.example.brikotlin.domain.repository.Repository
import com.example.brikotlin.utils.networkBoundResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    val sharedHelperImp: DataStoreImp,
    val api:Api,
) : Repository {
    override suspend fun loginApi(email: String, pass: String):LoginResponse {
        return api.loginApi(email, pass)
    }

    override suspend fun homeApi(header: String):HomePage {
        return api.homeApi(header)
    }

    override suspend fun categoriesApi(header: String): Categories {
        return api.categoriesApi(header)
    }

    override suspend fun subCategoryApi(header: String, id: Int): Categories {
        return api.subCategoriesApi(header, id)
    }

/*
    fun products(header: String, id: Int) =
         networkBoundResource(
            query = {
                dao.getMainCategory()},
            fetch = {
                delay(2000)
                api.productsApi(header,id)
            },
            saveFetchData = {
                dataBase.withTransaction {
                    dao.deleteMainCategory()
                    val dynamicSectionDetails = it.data
                    for(data in dynamicSectionDetails!!){
                        for (variant in data!!.variants) {
                            dao.saveMainCategory(variant)
                        }
                    }
                }
            }
        )

 */



    override suspend fun ProductsApi(header: String, id: Int): Products {
        return api.productsApi(header,id)
    }

    override suspend fun saveUserToken(token: String) {
        sharedHelperImp.saveUserToken(token)
    }

    override suspend fun getUserToken(): Flow<String?> {
        return sharedHelperImp.token
    }


    override suspend fun saveUSerEmail(email: String) {
        sharedHelperImp.saveEmail(email)
    }

    override suspend fun getUserEmail(): String? {
        return sharedHelperImp.getEmail()
    }


    override suspend fun saveUserPassword(password: String) {
        sharedHelperImp.savePassword(password)
    }


    override suspend fun getUserPassword(): String? {
        return sharedHelperImp.getPassword()
    }

    override suspend fun saveUser(userData: UserData) {
        sharedHelperImp.saveUser(userData)
    }

    override suspend fun getUserData(): Flow<String?> {
       return sharedHelperImp.data
    }

    override suspend fun getPagingApi(page: Int, size: Int): PassengerResponse {
        return api.pagingApi(page,size)
    }


}