package com.example.videomessages.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.videomessages.utils.StringPreference

class SharePref(context: Context) {

    companion object{
        const val BEARER = "bearer"
    }

    private val pref : SharedPreferences = context.getSharedPreferences("sharePref", Context.MODE_PRIVATE)

    var token : String by StringPreference(pref, "")
}