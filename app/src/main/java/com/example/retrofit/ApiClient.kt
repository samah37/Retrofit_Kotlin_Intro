package com.example.retrofit
/**
* In this object I will put the configuration of the server URL, and the converter
* which will convert requests from JSON to an object.
* The use of the LAZY keyword is very important.
* NB: Lazy indicates that the object will not be created until it is called, and at that time
* we will use the same object when called.
*/
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL: String = "https://jsonplaceholder.typicode.com/"
    private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val apiService : ApiService by lazy {
        retrofit.create(ApiService::class.java)

    }

}