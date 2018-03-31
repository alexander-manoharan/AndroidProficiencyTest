package com.lxndr.android.androidproficiencytest.utils

import com.lxndr.android.androidproficiencytest.model.MyModel
import com.squareup.moshi.Json
import retrofit2.Call
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Alexander Manoharan on 3/29/2018.
 */

interface JSONFileDownloader {
    // REST APIs to download file
    @GET("facts.json")
    fun downloadFile(): Call<MyModel.JSONRows>
}