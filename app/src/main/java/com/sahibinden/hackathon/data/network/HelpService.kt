package com.sahibinden.hackathon.data.network

import com.sahibinden.hackathon.data.model.DemandModel
import com.sahibinden.hackathon.data.model.ResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

interface HelpService {

    @POST("hackathon/bad.php")
    suspend fun sendDemandRequest(
        @Body demandModel: DemandModel
    ): ResponseModel
}
