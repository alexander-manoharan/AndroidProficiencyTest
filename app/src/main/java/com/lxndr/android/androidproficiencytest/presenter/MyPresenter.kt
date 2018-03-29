package com.lxndr.android.androidproficiencytest.presenter

import android.content.Context
import com.lxndr.android.androidproficiencytest.model.MyModel
import com.lxndr.android.androidproficiencytest.view.MyView

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
}