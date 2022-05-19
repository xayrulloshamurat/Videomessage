package com.example.videomessages.data.model

data class Customer(
    val id : Int,
    var firstName : String,
    var lastName: String,
    var username : String,
    var chatId : Int,
    var groupChatId: Int,
    var name: String
)
