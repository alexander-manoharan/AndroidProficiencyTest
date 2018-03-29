package com.lxndr.android.androidproficiencytest.utils

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Alexander Manoharan on 3/29/2018.
 */
class JSONRestAPI(jsonUrl: String) {
    private var jsonFileDownloader: JSONFileDownloader
    init {
        var retrofit = Retrofit.Builder()
                .baseUrl(jsonUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        jsonFileDownloader = retrofit.create(JSONFileDownloader::class.java)
    }

    fun downloadJSONFile() : Call<JSONRows> {
        return jsonFileDownloader.downloadFile()
    }
}