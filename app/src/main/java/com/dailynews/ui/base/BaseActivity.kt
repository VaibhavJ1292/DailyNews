package com.dailynews.ui.base

import android.accounts.NetworkErrorException
import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.TextView
import android.widget.Toast
import com.dailynews.R
import com.dailynews.utils.Logger
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.nio.channels.UnresolvedAddressException

/**
 * Created by Vaibhav Jadhav on 5/29/2018.
 */
abstract class BaseActivity<T : BaseContractor.BasePresenter> : AppCompatActivity(), BaseContractor.BaseView, DialogInterface.OnCancelListener {

    protected lateinit var mPresenter: T

    lateinit var mProgressDialog: ProgressDialog

    //To check activity needs a toolbar
    private var mToolbarRequired: Boolean = false

    //To handle actions on toolbar
    lateinit var mToolbar: Toolbar
    lateinit var mToolbarTitle: TextView

    abstract fun getPresenter(): T
    abstract fun getToolbarTitle(): String?


    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        init()
    }


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    //To set tool bar
    fun setToolbar() {
        mToolbar = findViewById(R.id.toolbarId)

        setSupportActionBar(mToolbar)

        if (getToolbarTitle() != null && mToolbar != null) {
            mToolbarTitle = mToolbar.findViewById(R.id.title) as TextView
            mToolbarTitle.setText(getToolbarTitle())
        }
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    // To getPresenter and set toolbar
    fun init() {
        mPresenter = getPresenter()

        if (mToolbarRequired) {
            setToolbar()
        }
    }

    override fun showProgress() {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(this)
        }
        mProgressDialog.setCancelable(false)
        mProgressDialog.setOnCancelListener(this)
        mProgressDialog.show()
    }

    override fun showCancelableProgress() {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(this)
        }
        mProgressDialog.setCancelable(false)
        mProgressDialog.setOnCancelListener(this)
        mProgressDialog.show()
    }

    override fun hideProgress() {
        mProgressDialog?.let { if (it.isShowing) it.cancel() }

    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun handleError(throwable: Throwable) {
        hideProgress()

        Logger.d("BaseActivity",throwable.message.toString())

        if (throwable is NetworkErrorException){
            showMessage(getString(R.string.no_newtwork))
        }else if (throwable is IOException){
            showMessage(getString(R.string.something_went_wrong))
        }else if (throwable is UnknownHostException){
            showMessage(getString(R.string.something_went_wrong))
        }else if (throwable is SocketTimeoutException){
            showMessage(getString(R.string.action_retry))
        }else{
            showMessage(getString(R.string.something_went_wrong))
        }

    }
}