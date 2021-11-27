package com.sahibinden.hackathon.util

import android.view.animation.Animation

abstract class CustomAnimationListener : Animation.AnimationListener {

    override fun onAnimationStart(animation: Animation?){}

    override fun onAnimationRepeat(animation: Animation?) {}

    override fun onAnimationEnd(animation: Animation?) {}
}