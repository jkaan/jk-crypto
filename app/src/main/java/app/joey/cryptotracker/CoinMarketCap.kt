package app.joey.cryptotracker

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinMarketCap {
    @GET("/v1/ticker/?convert=EUR&limit=40")
    fun getCoins(): Call<List<Coin>>

    @GET("/v1/ticker/?convert=EUR")
    fun getCoins(@Query("start") start: Int, @Query("limit") count: Int): Call<List<Coin>>
}
