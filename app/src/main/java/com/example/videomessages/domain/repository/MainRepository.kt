package com.example.videomessages.domain.repository

import com.example.videomessages.data.model.request.LoginRequest

interface MainRepository {

    // auth
    suspend fun userLogin(request: LoginRequest): String
}