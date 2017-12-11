package app.joey.cryptotracker

import android.arch.paging.DataSource
import android.arch.paging.TiledDataSource

class CoinDataSource(private val dataProvider: CoinMarketCapService): TiledDataSource<Coin>() {
    override fun loadRange(startPosition: Int, count: Int): MutableList<Coin> {
        val response = dataProvider.getCoins(startPosition, count).execute()

        return response.body()?.toMutableList() ?: emptyList<Coin>().toMutableList()
    }

    override fun countItems() = DataSource.COUNT_UNDEFINED
}