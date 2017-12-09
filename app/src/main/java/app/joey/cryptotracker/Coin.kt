package app.joey.cryptotracker

import com.google.gson.annotations.SerializedName

data class Coin(
    val name: String,
    val symbol: String,
    @SerializedName("price_eur") val price: String,
    @SerializedName("percent_change_24h") val percentChangeDay: String,
    @SerializedName("percent_change_7d") val percentChangeWeek: String
)
