package com.lxndr.android.androidproficiencytest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.jakewharton.picasso.OkHttp3Downloader
import com.lxndr.android.androidproficiencytest.model.MyModel
import com.lxndr.android.androidproficiencytest.presenter.MyPresenter
import com.lxndr.android.androidproficiencytest.utils.RecyclerAdapter
import com.lxndr.android.androidproficiencytest.view.MyView
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import okhttp3.Protocol
import java.util.*

class MainActivity : AppCompatActivity(), MyView {
    private lateinit var linearLayoutManager : LinearLayoutManager
    private lateinit var recyclerView : RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var myPresenter: MyPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.row_item_list)

        // Initialize Presenter part of our application.
        myPresenter = MyPresenter(this@MainActivity, this)
        myPresenter.start()
        // Swipe Refresh to download JSON file
        swipeRefreshLayout = findViewById(R.id.swipe_layout)
        swipeRefreshLayout.setOnRefreshListener {
            refreshView()
        }

        try {
            val client = OkHttpClient.Builder()
                    .protocols(Collections.singletonList(Protocol.HTTP_1_1))
                    .build()

            var picasso = Picasso.Builder(this)
                    .downloader(OkHttp3Downloader(client))
                    .build()

            Picasso.setSingletonInstance(picasso)
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }

    // Update Title bar after receiving JSON file
    override fun updateTitle(title: String) {
        val ab : ActionBar? = supportActionBar
        ab?.setTitle(title)
    }

    // Set Row Items from Presenter to RecyclerView adapter
    override fun setRowItems(rowItems: MutableList<MyModel.RowItem>) {
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = RecyclerAdapter(rowItems)
    }

    override fun onRefreshSuccess() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun onRefreshFailure() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun refreshView() {
        myPresenter.onRefresh()
    }
}
