package app.joey.cryptotracker

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync

class MainActivity: AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        adapter = RecyclerAdapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this))

        val viewModel = ViewModelProviders.of(this).get(CryptoViewModel::class.java)
        viewModel.getCoins().observe(this, Observer<List<Coin>> { coins ->
            if (coins != null) {
                adapter.coins = coins
                adapter.notifyDataSetChanged()
            }
        })
    }
}
