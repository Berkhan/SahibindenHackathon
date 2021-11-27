package com.sahibinden.hackathon.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import com.sahibinden.hackathon.R

class CustomView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        val view = View.inflate(context, R.layout.custom_view_layout, this)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.CustomView)

        try {
            val text = ta.getString(R.styleable.CustomView_text)
            val drawableId = ta.getResourceId(R.styleable.CustomView_image, 0)
            if (drawableId != 0) {
                val drawable = AppCompatResources.getDrawable(context, drawableId)
                view.findViewById<ImageView>(R.id.image_thumb).setImageDrawable(drawable)
            }
            view.findViewById<TextView>(R.id.text_title).text = text
        } finally {
            ta.recycle()
        }
    }
}
