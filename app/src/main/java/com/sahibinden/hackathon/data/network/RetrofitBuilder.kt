package com.sahibinden.hackathon.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://www.kornis.net.tr/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.
        Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /*fun provideHelpService(): HelpService {
        return getRetrofit().create(HelpService::class.java)
    }*/

    val helpService: HelpService = getRetrofit().create(HelpService::class.java)


}