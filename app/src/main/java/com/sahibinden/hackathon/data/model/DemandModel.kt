package com.sahibinden.hackathon.data.model

data class DemandModel(
    val nameSurname: String = "",
    val phoneNumber: String = "",
    val identityNo: String = "",
    val requirement: String,
    val quantity: String = "",
    val city: String = "",
    val district: String = "",
    val neighbourhood: String = "",
    val note: String = "",
    val type: String = ""
)
