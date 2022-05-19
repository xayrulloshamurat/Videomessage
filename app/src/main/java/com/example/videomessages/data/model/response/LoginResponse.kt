package com.example.videomessages.data.model.response

import com.google.gson.annotations.SerializedName

class LoginResponse(
    val message: String,
    val success: Boolean,
    @SerializedName("data") val token: String
)