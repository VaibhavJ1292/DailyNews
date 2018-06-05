package com.dailynews.ui.feeds

import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.BottomNavigationView
import com.dailynews.R
import com.dailynews.model.response.FeedResponse
import com.dailynews.ui.base.BaseActivity
import com.dailynews.utils.BottomNavigationViewHelper
import com.dailynews.utils.ScreenUtils
import com.mindorks.placeholderview.SwipeDecor
import kotlinx.android.synthetic.main.activity_feed.*

class FeedActivity : BaseActivity<FeedContractor.Presenter>(), FeedContractor.View {

    private val mCategoryBusiness: String = "business"
    private val mCategoryScience: String = "science"
    private val mCategorySports: String = "sports"
    private val mCategoryTechnology: String = "technology"
    private val mCountry: String = "IN"

    override fun getPresenter(): FeedContractor.Presenter {
        return FeedPresenter(this)
    }

    override fun getToolbarTitle(): String? {
        return getString(R.string.title_home)
    }

    override fun onCancel(dialog: DialogInterface?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        BottomNavigationViewHelper.disableShiftMode(navigation)


    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notification -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    private fun setupCardContainerView() {
        val screenWidth = ScreenUtils.getScreenWidth(this)
        val screenHeight = ScreenUtils.getScreenHeight(this)
        newsFeeder.builder
                .setDisplayViewCount(3)
                .setHeightSwipeDistFactor(10f)
                .setWidthSwipeDistFactor(5f)
                .setSwipeDecor(SwipeDecor()
                        .setViewWidth((0.90 * screenWidth).toInt())
                        .setViewHeight((0.75 * screenHeight).toInt())
                        .setPaddingTop(20)
                        .setSwipeRotationAngle(10)
                        .setRelativeScale(0.01f))
        newsFeeder.addItemRemoveListener { count ->
            if (count == 0) {
                Handler(mainLooper).postDelayed({ mPresenter.refreshNewsCards(mCategoryBusiness, mCountry) }, 200)
            }
        }
    }


    override fun displayTopHeadLines(feedResponse: FeedResponse) {

    }
}
