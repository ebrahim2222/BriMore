package com.example.brikotlin.utils

import com.example.brikotlin.domain.model.products.Products
import kotlinx.coroutines.flow.*
import retrofit2.HttpException

inline fun <ResultType , RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,

    crossinline fetch: suspend () -> RequestType,

    crossinline saveFetchData: suspend (RequestType) -> Unit ,

    crossinline shouldFetch : (ResultType) -> Boolean = {true}

)= flow {
        val data = query().first()
        val flow = if(shouldFetch(data)){
            emit(Resource.loading(data))
            try {
                saveFetchData(fetch())
                query().map {
                    Resource.success(it)
                }
            }catch (t:Throwable){
                query().map {
                    val code = t as HttpException
                    Resource.error(code.code(),it)
                }
            }
        }else{
            query().map {
                Resource.success(it)
            }
        }
        emitAll(flow)
    }

