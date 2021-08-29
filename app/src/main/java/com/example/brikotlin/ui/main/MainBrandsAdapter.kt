package com.example.brikotlin.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.brikotlin.R
import com.example.brikotlin.databinding.MainBrandsItemBinding
import com.example.brikotlin.domain.model.main.brands.BrandsDetails

class MainBrandsAdapter : RecyclerView.Adapter<MainBrandsAdapter.MyHolder>() {

    class MyHolder(itemView:MainBrandsItemBinding) : RecyclerView.ViewHolder(itemView.root){

        val binding = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding:MainBrandsItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.main_brands_item,parent,false)
        return MyHolder(binding)
    }
    var context:Context ?=null
    var brandsData:List<BrandsDetails>? = null
    fun setBrandsData(context:Context, brandsData:List<BrandsDetails>){
        this.context = context
        this.brandsData  = brandsData
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.binding.model = brandsData!![position]
    }

    override fun getItemCount(): Int {
        return if(brandsData!=null) brandsData!!.size else 0
    }
}