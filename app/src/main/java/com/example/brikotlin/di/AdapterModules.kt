package com.example.brikotlin.di

import android.content.Context
import com.example.brikotlin.ui.categories.CategoryAdapter
import com.example.brikotlin.ui.main.MainBrandsAdapter
import com.example.brikotlin.ui.main.MainCategoryAdapter
import com.example.brikotlin.ui.main.MainProductsAdapter
import com.example.brikotlin.ui.onboarding.OnBoardingAdapter
import com.example.brikotlin.ui.paging.PagingAdapter
import com.example.brikotlin.ui.products.ProductsAdapter
import com.example.brikotlin.ui.splash.SplashActivity
import com.example.brikotlin.ui.subcategory.SubCategoryAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModules {

    @Singleton
    @Provides
    fun provideMainCateAdapter():MainCategoryAdapter{
        return MainCategoryAdapter()
    }@Singleton
    @Provides
    fun provideMainBrandsAdapter():MainBrandsAdapter{
        return MainBrandsAdapter()
    }@Singleton
    @Provides
    fun provideMainProductsAdapter():MainProductsAdapter{
        return MainProductsAdapter()
    }@Singleton
    @Provides
    fun provideCategoryAdapter():CategoryAdapter{
        return CategoryAdapter()
    }@Singleton
    @Provides
    fun provideSubCategoryAdapter():SubCategoryAdapter{
        return SubCategoryAdapter()
    }@Singleton
    @Provides
    fun provideProductsAdapter():ProductsAdapter{
        return ProductsAdapter()
    }
    @Singleton
    @Provides
    fun providePagingAdapter():PagingAdapter{
        return PagingAdapter()
    }


}