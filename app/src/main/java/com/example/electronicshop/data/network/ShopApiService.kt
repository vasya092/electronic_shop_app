package com.example.electronicshop.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://run.mocky.io/v3/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface ShopApiService {
    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getProducts(): ProductsListResponse
}

object ShopApi {
    val retrofitService : ShopApiService by lazy {
        retrofit.create(ShopApiService::class.java)
    }
}