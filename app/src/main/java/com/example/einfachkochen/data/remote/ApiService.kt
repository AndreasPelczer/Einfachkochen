package de.syntaxinstitut.android_ww_template.data.remote

import com.example.einfachkochen.FactsData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://catfact.ninja/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit: Retrofit = Retrofit.Builder()

    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface FactApiService {
    @GET("/fact")
    suspend fun getFact(): FactsData
}
object FactApi {
    val retrofitservice: FactApiService by lazy { retrofit.create(FactApiService::class.java) }
}


