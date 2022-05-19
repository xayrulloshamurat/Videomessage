package com.example.videomessages.data.remote

import com.example.videomessages.data.model.Customer
import com.example.videomessages.data.model.EditTime
import com.example.videomessages.data.model.GenericResponse
import com.example.videomessages.data.model.Report
import com.example.videomessages.data.model.request.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @POST("auth/login")
    fun login(@Body loginRequest: LoginRequest): Response<GenericResponse<String>>

    @GET("bot/getAllSupervisor")
    fun getAllSupervisor(): Response<GenericResponse<List<Customer>>>

    @GET("bot/getAllReport")
    fun getAllReport(): Response<GenericResponse<List<Report>>>

    @POST("bot/editTime")
    fun addAnimal(@Body EditTime: EditTime): Response<List<EditTime>>
}