package com.lxndr.android.androidproficiencytest.view

import com.lxndr.android.androidproficiencytest.model.MyModel

/**
 * Created by Alexander Manoharan on 3/29/2018.
 */

// View module of our application. API definition that will be implemented in MainActivity

interface MyView {
    fun refreshView()
    fun onRefreshSuccess()
    fun onRefreshFailure()
    fun updateTitle(title: String)
    fun setRowItems(rowItems: MutableList<MyModel.RowItem>)
}