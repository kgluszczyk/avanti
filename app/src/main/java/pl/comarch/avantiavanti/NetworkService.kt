package pl.comarch.avantiavanti

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object NetworkService {
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl("https://my-json-server.typicode.com/kgluszczyk/")
        .build()
    val avantiService = retrofit.create(AvantiService::class.java)
}

interface AvantiService {

    @GET("fake-server-avanti/matches")
    fun getMatches(): Call<List<Match>>

    @GET("fake-server-avanti/matches")
    suspend fun getMatches2(): List<Match>
}