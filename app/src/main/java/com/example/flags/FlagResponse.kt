package com.example.flags

import com.squareup.moshi.Json
import java.util.*


data class FlagResponse (var error : Boolean,
                         val msg:String,
                         val data: List<FlagsData>)
