package pl.comarch.avantiavanti

import retrofit2.Retrofit
import retrofit2.http.GET

object NetworkService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/kgluszczyk/")
        .build()
    val avantiService = retrofit.create(AvantiService::class.java)
}

interface AvantiService {

    @GET("fake-server-avanti/matches")
    fun getMatches(): List<Match>
}