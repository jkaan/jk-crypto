package app.joey.cryptotracker

import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.DiffCallback
import android.view.ViewGroup
import android.view.LayoutInflater

class CoinAdapter: PagedListAdapter<Coin, CoinViewHolder>(CoinAdapter.diffCallback()) {
    override fun onBindViewHolder(holder: CoinViewHolder?, position: Int) {
        val coin = getItem(position)
        if (coin != null) {
            holder?.bindCoin(coin)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CoinViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val view = layoutInflater.inflate(R.layout.coin_row, parent, false)
        return CoinViewHolder(view)
    }

    companion object {
        fun diffCallback(): DiffCallback<Coin> = object: DiffCallback<Coin>() {
            override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean {
                return oldItem.symbol == newItem.symbol
            }

            override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
                return oldItem == newItem
            }

        }
    }
}