package com.lxndr.android.androidproficiencytest.model

import com.squareup.moshi.Json

/**
 * Created by Alexander Manoharan on 3/29/2018.
 */

/* Model to hold data store for our application.
   Holds mutable list of row items.
   Moshi library converts JSON text into data class objects.
*/

class MyModel {
    private var rowItems: MutableList<RowItem>

    init {
        rowItems = mutableListOf<RowItem>()
    }

    // JSON Rows containing title and rows.
    data class JSONRows(
            @Json(name = "title") val title: String,
            @Json(name = "rows") val rows: List<JSONRow>
    )

    // JSON Row containing title, description, image link
    data class JSONRow(
            @Json(name = "title") val title: String,
            @Json(name = "description") val description: String,
            @Json(name = "imageHref") val image: String
    )

    data class RowItem(val title: String, val description: String, val image: String) {
        constructor(row : JSONRow) : this(row.title, row.description, row.image)
    }

    fun addRow(rowItem: RowItem) {
        rowItems.add(rowItem)
    }

    fun getRowItems() : MutableList<RowItem> {
        return rowItems
    }

    fun clearRows() {
        rowItems.clear()
    }
}