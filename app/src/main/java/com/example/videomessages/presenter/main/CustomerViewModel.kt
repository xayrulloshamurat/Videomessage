package com.example.videomessages.presenter.main

import androidx.lifecycle.ViewModel
import com.example.videomessages.data.remote.ApiInterface

class CustomerViewModel(private val api: ApiInterface) : ViewModel() {
//    private val compositeDisposable = CompositeDisposable()
//    private var _customers: MutableLiveData<Resource<List<Customer>>> = MutableLiveData()
//    val customers: MutableLiveData<Resource<List<Customer>>>
//        get() = _customers
//
//    fun customersFunc() {
//        _customers.value = Resource.loading()
//        compositeDisposable.add(
//            api.getAllSupervisor()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                    {
//                        _customers.value = Resource.success(it.data)
//                    }, {
//                        _customers.value = Resource.error(it.message)
//                    }
//                )
//        )
//    }

}