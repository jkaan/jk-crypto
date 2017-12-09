package app.joey.cryptotracker

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoinMarketCapService {
    private val service: CoinMarketCap = Retrofit.Builder()
            .baseUrl("https://api.coinmarketcap.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinMarketCap::class.java)

    fun getCoins(): Call<List<Coin>> {
        return service.getCoins()
    }
}
