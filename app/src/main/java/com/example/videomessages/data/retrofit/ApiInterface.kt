package com.example.videomessages.data.retrofit

import com.example.videomessages.data.models.*
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiInterface {
    @POST("bot/editTime")
    fun addAnimal(@Body editTime: editTime): Observable<List<editTime>>

    @POST("auth/login")
    fun loginUser(@Body loginUser: LoginUser ): Observable<GenericResponse<UserToken>>

    @GET("bot/getAllSupervisor")
    fun getAllSupervisor(): Observable<GenericResponse<List<Customer>>>

    @GET("bot/getAllReport")
    fun getAllReport() : Observable<GenericResponse<List<Report>>>


}