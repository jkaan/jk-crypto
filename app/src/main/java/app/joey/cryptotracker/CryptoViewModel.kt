package app.joey.cryptotracker

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.DataSource
import android.arch.paging.LivePagedListProvider
import android.arch.paging.PagedList
import org.jetbrains.anko.doAsync


class CryptoViewModel: ViewModel() {
    var pagedCoins: LiveData<PagedList<Coin>>? = null

    init {
        pagedCoins = object: LivePagedListProvider<Int, Coin>() {
            override fun createDataSource(): DataSource<Int, Coin> {
                return CoinDataSource(CoinMarketCapService())
            }
        }.create(0, PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(25)
            .build()
        )
    }
}