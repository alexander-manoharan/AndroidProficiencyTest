package com.lxndr.android.androidproficiencytest.utils

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.picasso.OkHttp3Downloader
import com.lxndr.android.androidproficiencytest.R
import com.lxndr.android.androidproficiencytest.model.MyModel
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_view_row_item.view.*
import okhttp3.OkHttpClient
import okhttp3.Protocol
import java.util.*

/**
 * Created by Alexander Manoharan on 3/30/2018.
 */

// Adapter to RecyclerView.
class RecyclerAdapter(private var rowItem: MutableList<MyModel.RowItem>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    // Override methods for RecyclerView
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(rowItem[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_view_row_item, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return rowItem.count()
    }

    // Custom Adapter for Recycler view to hold each row items.
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems (rowItem: MyModel.RowItem) {
            itemView.title.text = rowItem.title
            itemView.description.text = rowItem.description

            Picasso.with(itemView.context).load(rowItem.image)
                    .resize(300, 300)
                    .centerInside()
                    .into(itemView.image)
        }
    }
}