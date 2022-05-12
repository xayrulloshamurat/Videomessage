package com.example.videomessages.di

import com.example.videomessages.CustomerViewModel
import com.example.videomessages.LoginViewModel
import com.example.videomessages.data.models.Customer
import com.example.videomessages.data.retrofit.ApiInterface
import com.google.gson.GsonBuilder
import io.reactivex.rxjava3.schedulers.Schedulers.single
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val baseUrl = "http://smartshop24.uz"

val dataModule = module {
    single {
        GsonBuilder()
            .setLenient()
            .create()
    }
    single {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    single {
        get<Retrofit>().create(ApiInterface::class.java)
    }
}
val viewModelModule = module {
    viewModel { CustomerViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}