package com.example.brikotlin.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpaceBetweenItem(val top:Int , val right:Int, val left:Int , val bottom:Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.left = left
        outRect.right = right
        outRect.top = top
        outRect.bottom = bottom

    }
}