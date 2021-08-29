package com.example.brikotlin.ui.subcategory

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.brikotlin.R
import com.example.brikotlin.databinding.SubcategoryItemBinding
import com.example.brikotlin.domain.model.main.maincategory.MainCategoryDetails

class SubCategoryAdapter :  RecyclerView.Adapter<SubCategoryAdapter.MyHolder>(){

    class MyHolder constructor(itemView:SubcategoryItemBinding) : RecyclerView.ViewHolder(itemView.root){
        val binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding:SubcategoryItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.subcategory_item,parent,false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.binding.model = dataList!![position]
        val mainCategoryDetails = dataList!!.get(position)
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("subCatId",mainCategoryDetails)
            val navController:NavController = Navigation.findNavController(it)
            navController.navigate(R.id.action_subCategoryFragment_to_productsFragment,bundle)
        }
    }
    var context:Context ?=null
    var dataList:List<MainCategoryDetails> ?=null
    fun setSubCatData(context: Context, dataList:List<MainCategoryDetails>){

        this.context = context
        this.dataList = dataList

    }

    override fun getItemCount(): Int {
        return if(dataList!=null) dataList!!.size else 0
    }
}