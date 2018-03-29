package com.lxndr.android.androidproficiencytest.view

import com.lxndr.android.androidproficiencytest.model.MyModel

/**
 * Created by Alexander Manoharan on 3/29/2018.
 */
public interface MyView {
    fun refreshView()
    fun updateTitle()
    fun setRowItems(rowItems: MutableList<MyModel.RowItem>)
}