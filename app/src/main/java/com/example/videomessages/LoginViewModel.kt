package com.example.videomessages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.videomessages.data.Resource
import com.example.videomessages.data.retrofit.ApiInterface
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class LoginViewModel(private val api: ApiInterface) : ViewModel()
//    private val compositeDisposable = CompositeDisposable()
//    private var _login: MutableLiveData<Resource<UserToken>> = MutableLiveData()
//    val login: MutableLiveData<Resource<UserToken>>
//        get() = _login
//
//    fun loginUser(phone: Int, password: String) {
//        _login.value = Resource.loading()
//        compositeDisposable.add(
//            api.loginUser(user = LoginUser(phone = phone, password))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                    {
//                        _login.value = Resource.success(it.data)
//                    },
//                    {
//                        _login.value = Resource.error(it.message)
//                    }
//                )
//        )
//    }
//}