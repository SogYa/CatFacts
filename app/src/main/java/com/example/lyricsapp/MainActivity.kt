package com.example.lyricsapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lyricsapp.repository.model.Fact
import com.example.lyricsapp.repository.network.Common
import com.example.lyricsapp.repository.network.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var mServ: RetrofitServices
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mServ = Common.retrofitService
        recyclerView = findViewById(R.id.factRecyclerView)
        mServ.getRandomFact().enqueue(object : Callback<Fact> {
            override fun onFailure(call: Call<Fact>, t: Throwable) {
                println(t.message)
            }

            override fun onResponse(call: Call<Fact>, response: Response<Fact>) {
                println(response.body()?.updateAt)
            }
        })
        mServ.getAllFacts().enqueue(object: Callback<List<Fact>>{
            override fun onResponse(call: Call<List<Fact>>, response: Response<List<Fact>>) {
                val adapter = FactAdapter(response.body()!!)
                recyclerView.adapter =adapter
            }

            override fun onFailure(call: Call<List<Fact>>, t: Throwable) {
                Toast.makeText(applicationContext,t.message,Toast.LENGTH_SHORT).show()

            }
        })
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = linearLayoutManager

    }
}
