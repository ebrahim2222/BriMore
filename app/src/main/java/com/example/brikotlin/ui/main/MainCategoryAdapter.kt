package com.example.brikotlin.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.brikotlin.R
import com.example.brikotlin.databinding.MainCategoryItemBinding
import com.example.brikotlin.domain.model.main.dynamicsectionone.DynamicSectionVariant
import com.example.brikotlin.domain.model.main.maincategory.MainCategoryDetails

class MainCategoryAdapter : RecyclerView.Adapter<MainCategoryAdapter.MyHolder>() {


    class MyHolder(itemView: MainCategoryItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        val binding:MainCategoryItemBinding = itemView
    }
    var context:Context?=null
    var dataList:List<MainCategoryDetails>?=null
    fun setData(context:Context, dataList: ArrayList<MainCategoryDetails>){
        this.context = context
        this.dataList = dataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding:MainCategoryItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.main_category_item,parent,false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.binding.model = dataList!![position]
    }


    override fun getItemCount(): Int {
        return if(dataList!=null)  dataList!!.size else 0
    }
}