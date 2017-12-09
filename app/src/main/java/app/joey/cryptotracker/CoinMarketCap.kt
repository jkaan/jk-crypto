package app.joey.cryptotracker

import retrofit2.Call
import retrofit2.http.GET

interface CoinMarketCap {
    @GET("/v1/ticker/?convert=EUR&limit=40")
    fun getCoins(): Call<List<Coin>>
}
