package com.vanilla.vanillabakery.overview

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vanilla.vanillabakery.R
import com.vanilla.vanillabakery.repository.CakeDto
import kotlinx.android.synthetic.main.item_cake.view.*

class CakeListAdapter: BaseListAdapter<CakeDto,CakeVH>(CakeDiffCallback) {
    override fun getItemLayoutId(): Int {
        return R.layout.item_cake
    }

    override fun onCreateViewHolder(view: View): CakeVH {
        return CakeVH(view)
    }

}

object CakeDiffCallback: DiffUtil.ItemCallback<CakeDto>(){
    override fun areItemsTheSame(oldItem: CakeDto, newItem: CakeDto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CakeDto, newItem: CakeDto): Boolean {
        return oldItem == newItem
    }
}

class CakeVH(itemView: View): BaseViewHolder<CakeDto>(itemView) {
    override fun bind(data: CakeDto) {
        itemView.tv_icing.text = data.icing
    }

}