package app.joey.cryptotracker

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import org.jetbrains.anko.doAsync


class CryptoViewModel: ViewModel() {
    private var coins: MutableLiveData<List<Coin>> = MutableLiveData()
    private val service = CoinMarketCapService()

    fun getCoins(): LiveData<List<Coin>> {
        loadCoins()
        return coins
    }

    private fun loadCoins() {
        doAsync {
            val response = service.getCoins().execute()

            if (response.isSuccessful) {
                coins.postValue(response.body())
            }
        }
    }
}