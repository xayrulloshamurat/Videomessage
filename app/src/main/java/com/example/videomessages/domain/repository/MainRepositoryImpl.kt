package com.example.videomessages.domain.repository

import com.example.videomessages.data.local.SharePref
import com.example.videomessages.data.model.ErrorMessage
import com.example.videomessages.data.model.request.LoginRequest
import com.example.videomessages.data.remote.ApiInterface
import com.google.gson.Gson

class MainRepositoryImpl constructor(
    private val api: ApiInterface,
    private val pref: SharePref,
    private val gson: Gson
) : MainRepository {

    private val bearer = "Bearer "

    // login
    override suspend fun userLogin(request: LoginRequest): String {
        var res = ""
        val response = api.login(request)
        if (response.isSuccessful) {
            res = "Успешно вошел!"
            response.body()!!.apply {
                pref.token = response.body()!!.data
            }
        } else {
            res = "Произошла ошибка"
            response.errorBody()?.let {
                res = gson.fromJson(it.toString(), ErrorMessage::class.java).message
            }
        }
        return res
    }
}
