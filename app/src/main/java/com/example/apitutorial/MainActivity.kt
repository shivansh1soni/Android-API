package com.example.apitutorial

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val retrofitBuilder = Retrofit.Builder().baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getApiData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val responseBody = response.body()

                val productList = responseBody?.products!!


                val recyclerView = findViewById<RecyclerView>(R.id.rv)
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                recyclerView.adapter = CustomAdapter(productList)

            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("MainActivity", "on failure: " + t.message)
            }
        })

    }
}