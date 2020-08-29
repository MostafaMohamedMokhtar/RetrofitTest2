package com.example.retrofittest2

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @GET("posts")
    fun getPost(@Query("userId") userID:String): Call<List<Post?>>?

//    @POST("posts")
//    fun storePost(@Body post: Post) :Call<Post>
    @POST("posts")
    fun storePost(@Body map: HashMap<Any, Any>) :Call<Post>
}