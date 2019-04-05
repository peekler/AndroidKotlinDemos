package com.example.peter.kotlinweather.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

import android.R.attr.data
import com.example.peter.kotlinweather.data.Base

interface WeatherAPI {
    @GET("data/2.5/weather")
    fun getWeatherDetails(@Query("q") city: String,
                          @Query("units") units: String,
                          @Query("appid") appid: String): Call<Base>
}

