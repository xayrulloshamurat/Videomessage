package com.example.videomessages.di

import com.example.videomessages.BuildConfig.BASE_URL
import com.example.videomessages.data.local.SharePref
import com.example.videomessages.data.remote.ApiInterface
import com.example.videomessages.domain.repository.MainRepository
import com.example.videomessages.domain.repository.MainRepositoryImpl
import com.example.videomessages.presenter.login.LoginViewModel
import com.example.videomessages.utils.addLoggingInterceptor
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val timeOut = 50L

val networkModule = module {

    single {
        GsonBuilder().setLenient().create()
    }

    single {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addLoggingInterceptor(androidApplication().applicationContext)
            .connectTimeout(timeout = timeOut, TimeUnit.SECONDS)
            .readTimeout(timeout = timeOut, TimeUnit.SECONDS)
            .writeTimeout(timeout = timeOut, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(get())
            .build()

    }

    single {
        get<Retrofit>().create(ApiInterface::class.java)
    }
}

val helperModule = module {
    single { SharePref(androidApplication().applicationContext) }
}

val repositoryModule = module {
    single<MainRepository> { MainRepositoryImpl(api = get(), pref = get(), gson = get()) }
}

val useCase = module {
    //single { GetBaskets(get()) }
}

val viewModelModule = module {
    viewModel { LoginViewModel(mainRepository = get()) }
}

val adapterModule = module {

}