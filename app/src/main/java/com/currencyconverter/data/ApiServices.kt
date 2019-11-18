package com.currencyconverter.data

import com.currencyconverter.data.model.BaseCurrency
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


interface ApiServices {

    companion object {
        private const val BASEAPI = "http://apilayer.net/"
        private const val timeoutTime = 30

        private val defaultHttpClient = OkHttpClient.Builder()
            .connectTimeout(timeoutTime.toLong(), TimeUnit.SECONDS)
            .writeTimeout(timeoutTime.toLong(), TimeUnit.SECONDS)
            .readTimeout(timeoutTime.toLong(), TimeUnit.SECONDS).build()


        private val sessionRetrofit = Retrofit.Builder()
            .baseUrl(BASEAPI)
            .addConverterFactory(GsonConverterFactory.create())
            .client(defaultHttpClient)
            .build()


        val service = sessionRetrofit.create(ApiServices::class.java)
    }

    @GET("/api/list")
    fun getCurrencies(@Query("access_key") access: String?): Call<BaseCurrency?>

    @GET("api/live")
    fun getCurrencyLive(@Query("access_key") access: String?): Call<BaseCurrency?>

    @GET("/api/convert")
    fun getConvertValue(
        @Query("access_key") access: String?, @Query("from") from: String?, @Query("to") to: String?, @Query(
            "amount"
        ) amount: String?
    ): Call<String>
}