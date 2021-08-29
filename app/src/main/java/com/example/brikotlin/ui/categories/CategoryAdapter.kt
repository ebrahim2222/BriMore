package com.example.brikotlin.ui.categories

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.brikotlin.R
import com.example.brikotlin.databinding.CategoryItemBinding
import com.example.brikotlin.domain.model.main.maincategory.MainCategoryDetails

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.MyHolder>() {

    class MyHolder(itemView:CategoryItemBinding) : RecyclerView.ViewHolder(itemView.root){
        val binding:CategoryItemBinding = itemView
    }
    var context:Context?=null
    var categoryData:List<MainCategoryDetails>?=null
    fun setCategoryData(context:Context,categoryData:List<MainCategoryDetails>){
        this.context = context
        this.categoryData = categoryData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding:CategoryItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.category_item,parent,false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.binding.categoryModel = categoryData!![position]
        val data = categoryData!!.get(position)
        val bundle = Bundle()
        bundle.putParcelable("categoryID",data)
        holder.itemView.setOnClickListener {
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.action_categoriesFragment_to_subCategoryFragment,bundle)
        }
    }

    override fun getItemCount(): Int {
        return if(categoryData!=null) categoryData!!.size else 0
    }
}