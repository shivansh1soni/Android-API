package com.example.apitutorial

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")
    fun getApiData(): Call<MyData>
}