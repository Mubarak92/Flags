package com.example.flags

import java.util.*


data class FlagResponse<T>(var error : Boolean, val msg:String, val data: List<FlagsData>)
