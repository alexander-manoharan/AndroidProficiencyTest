package com.lxndr.android.androidproficiencytest.utils

import com.squareup.moshi.Json
import retrofit2.Call
import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 * Created by Alexander Manoharan on 3/29/2018.
 */

class JSONData(val data: JSONRows)

data class JSONRows(
        @Json(name = "title") val title: String,
        @Json(name = "rows") val rows: List<JSONRow>
)

data class JSONRow(
        @Json(name = "title") val title: String,
        @Json(name = "description") val description: String,
        @Json(name = "imageHref") val image: String
)

interface JSONFileDownloader {
    @GET("facts.json")
    fun downloadFile(): Call<JSONRows>;
}