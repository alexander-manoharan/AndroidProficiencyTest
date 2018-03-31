package com.lxndr.android.androidproficiencytest.presenter

import android.content.Context
import android.widget.Toast
import com.lxndr.android.androidproficiencytest.R
import com.lxndr.android.androidproficiencytest.model.MyModel
import com.lxndr.android.androidproficiencytest.utils.JSONRestAPI
import com.lxndr.android.androidproficiencytest.view.MyView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Alexander Manoharan on 3/29/2018.
 */

/*  Presenter class. Core logic of the application resides here.
    1. Initializes the Model.
    2. Downloads the JSON file using Retrofit library.
    3. Moshi library converts the JSON data into data class.
 */
class MyPresenter(private val view: MyView, private val context: Context) {
    private var myView = view
    private var myModel: MyModel
    private var myContext = context

    init {
        // Initialize Model. The data store.
        myModel = MyModel()
    }

    // Function to start the Presenter in our application.
    fun start() {
        downloadFile(context.resources.getString(R.string.json_baseurl))
    }

    // Download the JSON file using Retrofit library
    private fun downloadFile(jsonUrl: String) {

        // JSON REST API to download the file
        val jsonApi = JSONRestAPI(jsonUrl)
        val request = jsonApi.downloadJSONFile()

        // Asynchronous request to handle JSON file download
        request.enqueue(object : Callback<MyModel.JSONRows> {

            // Success response from server. Now, we have the JSON data
            override fun onResponse(call: Call<MyModel.JSONRows>?, response: Response<MyModel.JSONRows>?) {
                val body = response?.body()
                if (body != null) {
                    // Update Title from JSON data
                    myView.updateTitle(body.title)
                    for (i in body.rows) {
                        if (i.title != null && i.description != null && i.image != null) {
                            // Row item in JSON
                            val rowItem: MyModel.RowItem = MyModel.RowItem(i)
                            // Add the row entry in model store
                            myModel.addRow(rowItem)
                        }
                    }
                }
                // Set the row items to our View
                myView.setRowItems(myModel.getRowItems())
                // Now, we have JSON data, reset refresh status in View
                myView.onRefreshSuccess()
            }

            override fun onFailure(call: Call<MyModel.JSONRows>?, t: Throwable?) {
                println("JSON data download failure")
                Toast.makeText(context, "Connectivity to server lost", Toast.LENGTH_SHORT).show()
            }
        })
    }

    public fun onRefresh() {
        // Swipe down to refresh JSON query
        // Clear the rows
        myModel.clearRows()
        // Download the JSON file
        downloadFile(context.resources.getString(R.string.json_baseurl))
    }
}