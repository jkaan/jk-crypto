package app.joey.cryptotracker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerAdapter
    private lateinit var service: CoinMarketCapService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        adapter = RecyclerAdapter(emptyList())
        recyclerView.adapter = adapter
        service = CoinMarketCapService()
    }

    override fun onStart() {
        super.onStart()
        doAsync {
            val response = service.getCoins().execute()

            if (response.isSuccessful) {
                runOnUiThread {
                    adapter.coins =  response.body() ?: emptyList()
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}
