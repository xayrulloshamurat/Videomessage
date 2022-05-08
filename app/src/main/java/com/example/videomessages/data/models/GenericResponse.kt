package com.example.videomessages.data.models

class GenericResponse <T>(
    var success: Boolean,
    var message: String,
    var data:T
)
