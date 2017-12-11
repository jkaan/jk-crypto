package app.joey.cryptotracker

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync

class MainActivity: AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: CoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        adapter = CoinAdapter()
        recyclerView.addItemDecoration(DividerItemDecoration(this))

        val viewModel = ViewModelProviders.of(this).get(CryptoViewModel::class.java)
        viewModel.pagedCoins?.observe(this, Observer<PagedList<Coin>> { coins ->
            adapter.setList(coins)
        })
        recyclerView.adapter = adapter
    }
}
