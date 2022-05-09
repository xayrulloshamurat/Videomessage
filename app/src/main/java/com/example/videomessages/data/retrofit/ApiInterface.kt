package com.example.videomessages.data.retrofit

import com.example.videomessages.data.models.Customer
import com.example.videomessages.data.models.GenericResponse
import com.example.videomessages.data.models.Report
import com.example.videomessages.data.models.editTime
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT

interface ApiInterface {
    @PUT("bot/editTime")
    fun addAnimal(@Body editTime: editTime): Observable<List<editTime>>

    //    @GET("bot/getRule")
//    fun getRule(): Observable<GenericResponse<LastAnimals>>
//
    @GET("bot/getAllSupervisor")
    fun getAllSupervisor(): Observable<GenericResponse<List<Customer>>>

    @GET("bot/getAllReport")
    fun getAllReport() : Observable<GenericResponse<List<Report>>>
//
//    @GET("bot/byDate")
//    fun  fun byDate(): Observable<GenericResponse<LastAnimals>>
//
//    @GET("bot/byDateSupervisor/{id}")
//    fun  fun byDateSupervisor(): Observable<GenericResponse<LastAnimals>>
}