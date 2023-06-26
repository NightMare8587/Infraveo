package com.example.infraveotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.infraveotest.Adapter.InfraveoAdapter
import com.example.infraveotest.Constants.Constants
import com.example.infraveotest.Model.InfraveoItem
import com.example.infraveotest.Model.InfraveoModel
import com.example.infraveotest.Retrofit.RetrofitInstance
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var retrofit: Retrofit
    private lateinit var progressBar : ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialise()

        val apiRequest = retrofit.create(RetrofitInstance::class.java)


            val data = apiRequest.getUserList()


            data.enqueue(object : Callback<ArrayList<InfraveoItem>>{
                override fun onResponse(
                    call: Call<ArrayList<InfraveoItem>>,
                    response: Response<ArrayList<InfraveoItem>>
                 ) {
                    if(response.isSuccessful){
                        Log.d("get","help")
                    }

                    val result = response.body()
                    progressBar.visibility = View.GONE
                    recyclerView.adapter = result?.let { InfraveoAdapter(it) }
                }

                override fun onFailure(call: Call<ArrayList<InfraveoItem>>, t: Throwable) {
                    Log.d("infoNull",t.message.toString())
                }

            })



    }

    private fun initialise() {

        retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        progressBar = findViewById(R.id.progressBar)
        recyclerView = findViewById(R.id.mainActivityRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}