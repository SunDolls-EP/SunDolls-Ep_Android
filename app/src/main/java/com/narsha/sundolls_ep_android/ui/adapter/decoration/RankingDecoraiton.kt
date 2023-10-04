package com.narsha.sundolls_ep_android.ui.adapter.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RankingDecoraiton: RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val count = state.itemCount
        if(position == count-1) {
            outRect.top = 10
        } else if(position == 0){
            outRect.bottom = 10
        } else {
            outRect.top = 10
            outRect.bottom = 10
        }
    }
}