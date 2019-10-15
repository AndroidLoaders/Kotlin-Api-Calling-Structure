package com.app.myapplication.adapters.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.myapplication.callbacks.OnItemClickListener
import com.app.myapplication.utility.ScreenDimensions
import kotlinx.android.synthetic.main.list_item_layout.view.*
import kotlinx.android.synthetic.main.view_all_type_layout.view.*

class StoreListItemHolder(itemView: View, onItemClick: OnItemClickListener<Int>) :
    RecyclerView.ViewHolder(itemView) {

    val ivImage: ImageView? = itemView.ivImage

    val tvTitle: TextView? = itemView.tvTitle
    val tvDescription: TextView? = itemView.tvDescription

    val tvViewAll: TextView? = itemView.tvViewAll

    init {
        itemView.layoutParams.height = (ScreenDimensions.screenHeight * 0.15).toInt()
        itemView.constraintLayout?.setOnClickListener { onItemClick.onItemClick(adapterPosition) }
    }
}