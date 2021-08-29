package com.example.brikotlin.ui.main

import android.app.ActionBar
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.marginBottom
import androidx.core.view.marginRight
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.brikotlin.R
import com.example.brikotlin.databinding.MainProductItemBinding
import com.example.brikotlin.domain.model.main.dynamicsectionone.DynamicSectionVariant

class MainProductsAdapter : RecyclerView.Adapter<MainProductsAdapter.MyHolder>() {

    class MyHolder(itemView:MainProductItemBinding) :RecyclerView.ViewHolder(itemView.root){
        val binding:MainProductItemBinding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding:MainProductItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.main_product_item , parent , false)

        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.binding.model = productsData!![position]
/*
        if(position == itemCount-1){
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(0,0,0,0)
            holder.binding.mainProductLayout.layoutParams = params
        }

 */
    }

    override fun getItemCount(): Int {
        return if(productsData!=null) productsData!!.size else 0
    }
    var context:Context?=null
    var productsData:List<DynamicSectionVariant>?=null
    fun setMainProductData(context:Context ,productsData:List<DynamicSectionVariant> ){
        this.context = context
        this.productsData = productsData
    }
}