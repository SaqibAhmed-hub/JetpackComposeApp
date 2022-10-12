package com.example.composeactivity.repository

import com.example.composeactivity.data.ReceipeCount
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    suspend fun receipe(
        @Query("q") query: String
    ) : Response<ReceipeCount>

    companion object {

        private val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        private val okHttpClient = OkHttpClient.Builder().addNetworkInterceptor(interceptor).build()

        fun getInstance():ApiService{
            val service = Retrofit.Builder()
                .baseUrl("https://forkify-api.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(ApiService::class.java)
            return service
        }

    }
}