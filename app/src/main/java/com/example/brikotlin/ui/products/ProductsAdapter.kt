package com.example.brikotlin.ui.products

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.brikotlin.R
import com.example.brikotlin.databinding.ProductItemBinding
import com.example.brikotlin.domain.model.main.dynamicsectionone.DynamicSectionVariant

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.MyHolder>() {

    class MyHolder(itemView:ProductItemBinding) : RecyclerView.ViewHolder(itemView.root){
        val binding = itemView
    }
    var context:Context?=null
    var dataList:List<DynamicSectionVariant>?=null
    fun setProductsData(context:Context,dataList:List<DynamicSectionVariant>){
        this.context = context
        this.dataList = dataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding:ProductItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.product_item,parent,false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val dynamicSectionVariant = dataList!![position]
        holder.binding.model = dynamicSectionVariant
        val get = dataList!!.get(position)
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("productsData",get)
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.action_productsFragment_to_productDetailsFragment,bundle)
        }
    }

    override fun getItemCount(): Int {
        return if(dataList !=null) dataList!!.size else 0
    }
}