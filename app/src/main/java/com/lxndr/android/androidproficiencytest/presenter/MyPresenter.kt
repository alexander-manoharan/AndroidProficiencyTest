package com.lxndr.android.androidproficiencytest.presenter

import android.content.Context
import com.lxndr.android.androidproficiencytest.R
import com.lxndr.android.androidproficiencytest.model.MyModel
import com.lxndr.android.androidproficiencytest.utils.JSONData
import com.lxndr.android.androidproficiencytest.utils.JSONFileDownloader
import com.lxndr.android.androidproficiencytest.utils.JSONRestAPI
import com.lxndr.android.androidproficiencytest.utils.JSONRows
import com.lxndr.android.androidproficiencytest.view.MyView
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException

/**
 * Created by Alexander Manoharan on 3/29/2018.
 */
class MyPresenter(private val view: MyView, private val context: Context) {
    private var myView = view
    private var myModel: MyModel? = null
    private var myContext = context

    init {
        myModel = MyModel()
    }

    fun start() {
        downloadFile(context.resources.getString(R.string.json_baseurl))
    }

    private fun downloadFile(jsonUrl: String) {

        var jsonApi = JSONRestAPI(jsonUrl)
        var request = jsonApi.downloadJSONFile()

        request.enqueue(object : Callback<JSONRows> {
            override fun onResponse(call: Call<JSONRows>?, response: Response<JSONRows>?) {
                val body = response?.body()
                if (body != null) {
                    println(body.title)
                    for (i in body.rows) {
                        println("Row Item is ${i}")
                    }
                }
            }

            override fun onFailure(call: Call<JSONRows>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}