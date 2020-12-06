package com.vanilla.vanillabakery.overview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseListAdapter<D : Any, VH : BaseViewHolder<D>>(
    diffCallback: DiffUtil.ItemCallback<D>
) : ListAdapter<D, VH>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return LayoutInflater.from(parent.context)
                .inflate(getItemLayoutId(), parent, false)
                .let { onCreateViewHolder(it) }
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.setData(getItem(position))
    }

    abstract fun getItemLayoutId(): Int
    abstract fun onCreateViewHolder(view: View): VH
}