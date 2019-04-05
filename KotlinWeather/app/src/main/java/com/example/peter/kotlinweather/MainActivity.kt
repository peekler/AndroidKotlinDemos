package com.example.peter.kotlinweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.peter.kotlinweather.network.WeatherAPI
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import android.R.attr.name
import com.bumptech.glide.Glide
import com.example.peter.kotlinweather.data.Base
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URLEncoder
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var retrofit: Retrofit
    lateinit var weatherAPI: WeatherAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit = Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        weatherAPI = retrofit.create(WeatherAPI::class.java)

        btnGetRate.setOnClickListener {
            queryWeather()
        }
    }

    private fun queryWeather() {
        val call = weatherAPI.getWeatherDetails(etCity.text.toString(),
                "metric",
                "f3d694bc3e1d44c1ed5a97bd1120e8fe"
        )

        call.enqueue(object : Callback<Base> {
            override fun onResponse(call: Call<Base>, response: Response<Base>) {
                tvResult.text = response.body()?.name + "\n" +
                        response.body()?.main?.temp


                //val sunRiseText = SimpleDateFormat("hh:mm a").format(response.body()?.sys?.sunrise)
                //tvResult.text = sunRiseText
                val c = Calendar.getInstance()
                    val sunRise = response.body()?.sys?.sunrise!!.toLong()
                c.setTimeInMillis(sunRise * 1000)
                //tvResult.text = SimpleDateFormat("HH:mm").format(c.time)

                Glide.with(this@MainActivity)
                        .load(
                                ("https://openweathermap.org/img/w/" +
                                        response.body()?.weather?.get(0)?.icon
                                        + ".png"))
                        .into(ivWeather)
            }

            override fun onFailure(call: Call<Base>, t: Throwable) {
                tvResult.text = t.message
            }
        })
    }
}
