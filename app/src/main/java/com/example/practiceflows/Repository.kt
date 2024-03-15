package com.example.practiceflows

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: PostService) {

    fun getPosts() : Flow<Posts> = flow {
        val response = apiService.getPosts().execute()
        if(response.isSuccessful){
            emit(response.body()!!)
        }
    }.flowOn(Dispatchers.Default)

    fun getPostQuery(userId : Int) : Flow<Posts>  = flow{
        val response = apiService.getPosts(userId).execute()
        if(response.isSuccessful){
            emit(response.body()!!)
        }
    }.flowOn(Dispatchers.Default)

    fun getPostQueryMap(queryMap: Map<String, String>) : Flow<Posts>  = flow{
        val response = apiService.getPosts(queryMap).execute()
        if(response.isSuccessful){
            emit(response.body()!!)
        }
    }.flowOn(Dispatchers.Default)
}