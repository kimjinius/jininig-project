package com.example.jin_ing

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ShopAPIS{

    @GET("/jining/shop/")
    @Headers("accept: application/json", "content-type: application/json")
    fun getShop() : Call<List<Shop>>


    companion object{
        private const val ipv4 = "172.30.1.60"
        private const val port = "8000"
        fun create(): ShopAPIS{
            val gson: Gson = GsonBuilder().setLenient().create()
            val BASE_URL = "http://$ipv4:$port"
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ShopAPIS::class.java)
        }
    }
}