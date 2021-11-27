package com.sahibinden.hackathon

import android.app.Application
import com.sahibinden.hackathon.data.network.RetrofitBuilder
import com.sahibinden.hackathon.data.repository.HelpRepository

class HelpApplication: Application() {

    val helpRepository: HelpRepository by lazy {
        HelpRepository(RetrofitBuilder.helpService)
    }

}