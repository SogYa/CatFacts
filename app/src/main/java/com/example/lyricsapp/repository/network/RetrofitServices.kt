package com.example.lyricsapp.repository.network

import com.example.lyricsapp.repository.model.Fact
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitServices {
    @GET("/facts/random")
    fun getRandomFact(): Call<Fact>

    @GET("/facts")
    fun getAllFacts(): Call<List<Fact>>

    @GET("/facts/{ID}")
    fun getFactById(@Path("ID") factId : String): Call<Fact>

}