package com.sahibinden.hackathon.data.repository

import com.sahibinden.hackathon.R
import com.sahibinden.hackathon.data.ResultWrapper
import com.sahibinden.hackathon.data.model.DemandModel
import com.sahibinden.hackathon.data.model.ResponseModel
import com.sahibinden.hackathon.data.network.HelpService
import com.sahibinden.hackathon.util.safeApiCall

class HelpRepository(private val helpService: HelpService) {

    suspend fun sendDemand(demandModel: DemandModel) : ResultWrapper<ResponseModel> {
        return safeApiCall({
                val response = helpService.sendDemandRequest(demandModel)
                ResultWrapper.Success<ResponseModel>(response)
            },
            R.string.RequestUnexpectedError.toString()
        )
    }

}

