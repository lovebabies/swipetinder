package com.example.swipeeffectdemo

import android.annotation.SuppressLint
import android.content.Context
import android.support.annotation.LayoutRes
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import com.mindorks.placeholderview.annotations.swipe.SwipeOut
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState
import com.mindorks.placeholderview.annotations.swipe.SwipeInState
import com.mindorks.placeholderview.annotations.swipe.SwipeIn
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState



@Layout(R.layout.tinder_card_view)
public class TinderCard(val context: Context, val profile: Profile, val swipeView: SwipePlaceHolderView) {
    @View(R.id.profileImageView)
    lateinit var profileImageView: ImageView

    @View(R.id.nameAgeTxt)
    lateinit var nameAgeTxt: TextView

    @View(R.id.locationNameTxt)
    lateinit var locationNameTxt: TextView

    @Resolve
    fun onResolved() {
        Glide.with(context).load(profile.url).override(600,800).placeholder(R.mipmap.ic_launcher_round).into(profileImageView)
        nameAgeTxt.text = profile.name + ", " + profile.age
        locationNameTxt.text = profile.location
    }

    @SwipeOut
    fun onSwipeOut() {
        Log.d("EVENT", "onSwipeOut")
        swipeView.addView(this)
    }

    @SwipeCancelState
    fun onSwipeCancelState() {
        Log.d("EVENT", "onSwipeCancelState")
    }

    @SwipeIn
    fun onSwipeIn() {
        Log.d("EVENT", "onSwipedIn")
    }

    @SwipeInState
    fun onSwipeInState() {
        Log.d("EVENT", "onSwipeInState")
    }

    @SwipeOutState
    fun onSwipeOutState() {
        Log.d("EVENT", "onSwipeOutState")
    }
}