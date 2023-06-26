package com.example.infraveotest.Retrofit


import com.example.infraveotest.Model.InfraveoItem
import com.example.infraveotest.Model.InfraveoModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInstance {
    @GET("userlist.php")
     fun getUserList() : Call<ArrayList<InfraveoItem>>
}