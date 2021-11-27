package com.sahibinden.hackathon.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahibinden.hackathon.data.ResultWrapper
import com.sahibinden.hackathon.data.model.DemandModel
import com.sahibinden.hackathon.data.repository.HelpRepository
import com.sahibinden.hackathon.util.LiveEvent
import kotlinx.coroutines.launch

class HelpViewModel(private val helpRepository: HelpRepository): ViewModel() {

    private val _responseState = LiveEvent<Boolean>()
    val responseState: LiveData<Boolean> = _responseState

    fun sendDemand(demandModel: DemandModel){
        viewModelScope.launch {
            when(val response = helpRepository.sendDemand(demandModel)){
                is ResultWrapper.Success -> _responseState.value = true
                is ResultWrapper.Error -> _responseState.value = false
            }
        }
    }

}