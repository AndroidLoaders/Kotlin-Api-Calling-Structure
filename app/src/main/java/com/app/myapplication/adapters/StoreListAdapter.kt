package com.app.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.myapplication.R
import com.app.myapplication.adapters.viewholders.StoreListItemHolder
import com.app.myapplication.callbacks.OnItemClickListener
import com.app.myapplication.models.Store
import com.app.myapplication.networkadapter.apiconstants.ApiConstants
import com.app.myapplication.utility.ImageProcessor

class StoreListAdapter(private val storesList: MutableList<Store>) :
    RecyclerView.Adapter<StoreListItemHolder>(), OnItemClickListener<Int> {

    private val TAG: String = "TAG -- ${StoreListAdapter::class.java.simpleName}"

    companion object {
        const val VIEW_TYPE_DATA: Int = 1
        const val VIEW_TYPE_VIEW_ALL: Int = 0
    }

    override fun getItemViewType(position: Int): Int {
        val store: Store = storesList[position]
        return if (store.viewType == VIEW_TYPE_DATA) {
            VIEW_TYPE_DATA
        } else {
            VIEW_TYPE_VIEW_ALL
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreListItemHolder {
        val customView: View = if (viewType == VIEW_TYPE_DATA) {
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_layout, parent, false)
        } else {
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_all_type_layout, parent, false)
        }
        return StoreListItemHolder(customView, this)
    }

    override fun getItemCount(): Int = storesList.size

    override fun onBindViewHolder(holder: StoreListItemHolder, position: Int) {
        try {
            val store = storesList[position]
            when (getItemViewType(position)) {
                VIEW_TYPE_DATA -> {
                    holder.tvTitle!!.text = store.storeName
                    holder.tvDescription!!.text = store.fullAddress

                    ImageProcessor.loadImage(
                        holder.ivImage!!, ApiConstants.STORE_IMAGE_URL.plus(store.storeImageUrl)
                    )
                }
                VIEW_TYPE_VIEW_ALL -> {
                    holder.tvViewAll!!.text = "View All Data"
                }
            }
        } catch (e: Exception) {
            println("$TAG --> ${e.message}")
        }
    }

    override fun onItemClick(position: Int, data: Int?) {

    }
}