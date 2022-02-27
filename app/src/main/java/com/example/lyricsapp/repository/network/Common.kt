package com.example.lyricsapp.repository.network

object Common {
    private const val BASE_URL = "https://cat-fact.herokuapp.com"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}