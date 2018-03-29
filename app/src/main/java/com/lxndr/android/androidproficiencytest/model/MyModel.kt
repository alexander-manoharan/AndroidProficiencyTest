package com.lxndr.android.androidproficiencytest.model

/**
 * Created by Alexander Manoharan on 3/29/2018.
 */
class MyModel {
    private var rowItems: MutableList<RowItem>

    init {
        rowItems = mutableListOf<RowItem>()
    }
    data class RowItem(val title: String, val description: String, val image: String) {
        private val rowTitle: String = title
        private val rowDescription: String = description
        private val rowImage: String = image
    }
    fun addRow(title: String, description: String, image: String) {
        val rowItem = RowItem(title, description, image)
        rowItems.add(rowItem)
    }
    fun clearRows() {
        rowItems.clear()
    }
}