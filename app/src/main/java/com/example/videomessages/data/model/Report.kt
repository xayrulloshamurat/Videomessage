package com.example.videomessages.data.model

data class Report(
    val id: Int,
    var url: String,
    var date: String,
    var supervisor: Customer
)