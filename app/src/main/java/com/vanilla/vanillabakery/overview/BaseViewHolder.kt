package com.vanilla.vanillabakery.overview;

import android.view.View
import androidx.recyclerview.widget.RecyclerView

const val ACTION_ITEM = "item"

abstract class BaseViewHolder<D : Any>(
    itemView: View,
    private val onClick: (String, D, Int) -> Unit = { item, action, _ -> }
) : RecyclerView.ViewHolder(itemView) {

    private var _data: D? = null

    private val data: D
        get() = _data!!

    init {
        itemView.setOnClickListener { onClick(ACTION_ITEM, data, adapterPosition) }
    }

    fun setData(data: D) {
        _data = data
        bind(data)
    }

    abstract fun bind(data: D)
}
