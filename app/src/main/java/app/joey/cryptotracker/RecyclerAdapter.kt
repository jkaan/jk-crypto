package app.joey.cryptotracker

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.coin_row.view.*

class RecyclerAdapter(var coins: List<Coin>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder?, position: Int) {
        val coin = coins[position]
        holder?.bindCoin(coin)
    }

    override fun getItemCount() = coins.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerAdapter.ViewHolder {
        val inflatedView = parent!!.inflate(R.layout.coin_row, false)
        return ViewHolder(inflatedView)
    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var coin: Coin? = null

        init {
            v.setOnClickListener(this)
        }

        fun bindCoin(coin: Coin) {
            this.coin = coin
            view.name.text = coin.name
            view.price.text = "€ ${coin.price}"
            view.percentChangeDay.text = coin.percentChangeDay

            if (coin.percentChangeDay.startsWith("-")) {
                view.percentChangeDay.setTextColor(Color.RED)
            } else {
                view.percentChangeDay.setTextColor(Color.GREEN)
            }

            view.percentChangeWeek.text = coin.percentChangeWeek

            if (coin.percentChangeWeek.startsWith("-")) {
                view.percentChangeWeek.setTextColor(Color.RED)
            } else {
                view.percentChangeWeek.setTextColor(Color.GREEN)
            }
        }

        override fun onClick(v: View?) {
            Log.d("RecyclerView", "CLICK!")
        }

        companion object {
            private val COIN_KEY = "COIN"
        }
    }

}
