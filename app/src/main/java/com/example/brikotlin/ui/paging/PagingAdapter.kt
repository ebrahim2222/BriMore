package com.example.brikotlin.ui.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.brikotlin.databinding.PagingItemBinding
import com.example.brikotlin.domain.model.paging.Passenger

class PagingAdapter : PagingDataAdapter<Passenger,PagingAdapter.MyHolder>(diffCallback = diffUtil ) {

    class MyHolder(itemView:PagingItemBinding) : RecyclerView.ViewHolder(itemView.root){
        val binding = itemView
    }


    override fun onBindViewHolder(p0: MyHolder, p1: Int) {
        val item = getItem(p1)
        p0.binding.model = item

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
        val binding:PagingItemBinding = PagingItemBinding.inflate(LayoutInflater.from(p0.context),p0,false)
        return MyHolder(binding)
    }
    companion object{

    val diffUtil = object :DiffUtil.ItemCallback<Passenger>() {
        override fun areItemsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
            return oldItem == (newItem)
        }
    }

    }


}