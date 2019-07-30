package com.example.swipeeffectdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.swipeeffectdemo.Utils.loadProfiles
import com.mindorks.placeholderview.SwipeDecor
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.SwipeViewBuilder
import com.mindorks.placeholderview.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipeView.getBuilder<SwipePlaceHolderView, SwipeViewBuilder<SwipePlaceHolderView>>()
            .setDisplayViewCount(3)
            .setSwipeDecor(SwipeDecor()
                .setPaddingTop(20)
                .setRelativeScale(0.01f)
                .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view))
        var list = com.example.swipeeffectdemo.Utils.loadProfiles(this.applicationContext)
        if (list != null) {
            for (profile in list) {
                swipeView.addView(TinderCard(applicationContext, profile, swipeView))
            }
        }

        rejectBtn.setOnClickListener {
            swipeView.doSwipe(false)
        }

        acceptBtn.setOnClickListener {
            swipeView.doSwipe(true)
        }
    }
}
