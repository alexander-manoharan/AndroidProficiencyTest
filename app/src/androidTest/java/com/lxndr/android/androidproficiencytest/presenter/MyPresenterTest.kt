package com.lxndr.android.androidproficiencytest.presenter

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import com.lxndr.android.androidproficiencytest.MainActivity
import com.lxndr.android.androidproficiencytest.utils.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_view_row_item.view.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

/**
 * Created by Alexander Manoharan on 4/1/2018.
 */
class MyPresenterTest {
    @Rule @JvmField
    public val rule : ActivityTestRule<MainActivity> = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun testTitle() {
        Thread.sleep(4000)
        var activity : MainActivity = rule.activity
        assertEquals("About Canada", activity.supportActionBar?.title)
    }

    @Test
    fun testNumberOfRows() {
        var activity : MainActivity = rule.activity
        Thread.sleep(4000)
        var view : RecyclerView = activity.row_item_list
        var count : Int = view.adapter.itemCount
        assertNotEquals(0, count)
    }
}