package com.example.videomessages.data.model

class GenericResponse<T>(
    var success: Boolean,
    var message: String? = null,
    var data: T
)
