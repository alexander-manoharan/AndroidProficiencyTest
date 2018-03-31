package com.lxndr.android.androidproficiencytest.utils

import com.lxndr.android.androidproficiencytest.model.MyModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Alexander Manoharan on 3/29/2018.
 */

// JSON REST API wrapper that uses Retrofit library.

class JSONRestAPI(jsonUrl: String) {
    private var jsonFileDownloader: JSONFileDownloader
    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(jsonUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        jsonFileDownloader = retrofit.create(JSONFileDownloader::class.java)
    }

    fun downloadJSONFile() : Call<MyModel.JSONRows> {
        return jsonFileDownloader.downloadFile()
    }
}