package com.example.flags

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.util.*


private const val BASE_URL = "https://countriesnow.space/api/v0.1/countries/flag/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface FlagApiService {
    @GET("images")
    suspend fun getImages(): FlagResponse<FlagsData>
}

object FlagsApi {
    val retrofitService: FlagApiService by lazy { retrofit.create(FlagApiService::class.java) }
}