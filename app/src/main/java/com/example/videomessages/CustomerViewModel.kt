package com.example.videomessages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.videomessages.data.Resource
import com.example.videomessages.data.models.Customer
import com.example.videomessages.data.models.GenericResponse
import com.example.videomessages.data.retrofit.ApiInterface
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CustomerViewModel (private val api: ApiInterface) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private var _customers: MutableLiveData<Resource<List<Customer>>> = MutableLiveData()
    val customers: MutableLiveData<Resource<List<Customer>>>
        get() = _customers

    fun customersFunc() {
        _customers.value = Resource.loading()
        compositeDisposable.add(
            api.getAllSupervisor()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        _customers.value = Resource.success(it.data)
                    }, {
                        _customers.value = Resource.error(it.message)
                    }
                )
        )
    }

}