package com.sahibinden.hackathon.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sahibinden.hackathon.HelpApplication
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(HelpViewModel::class.java)){
            return HelpViewModel((application as HelpApplication).helpRepository) as T
        }else{
            throw IllegalArgumentException("There is no view model such that.")
        }
    }
}