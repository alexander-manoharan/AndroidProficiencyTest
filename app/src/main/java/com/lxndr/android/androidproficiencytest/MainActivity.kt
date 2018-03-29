package com.lxndr.android.androidproficiencytest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lxndr.android.androidproficiencytest.model.MyModel
import com.lxndr.android.androidproficiencytest.presenter.MyPresenter
import com.lxndr.android.androidproficiencytest.view.MyView

class MainActivity : AppCompatActivity(), MyView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myPresenter = MyPresenter(this@MainActivity, this)
        myPresenter.start()
    }

    override fun updateTitle() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRowItems(rowItems: MutableList<MyModel.RowItem>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
