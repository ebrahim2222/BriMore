package com.example.brikotlin.di

import com.example.brikotlin.data.repository.RepositoryImp
import com.example.brikotlin.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCase {
    @Provides
    @Singleton
    fun provideLoginUseCase(repositoryImp: RepositoryImp):LoginUseCase{
        return LoginUseCase(repositoryImp)
    }

    @Provides
    @Singleton
    fun provideUserUseCase(repositoryImp: RepositoryImp):UserUseCase{
        return UserUseCase(repositoryImp)
    }
    @Provides
    @Singleton
    fun provideMainUseCase(repositoryImp: RepositoryImp):HomeUseCase{
        return HomeUseCase(repositoryImp)
    }  @Provides
    @Singleton
    fun provideCategoryUseCase(repositoryImp: RepositoryImp):CategoriesUseCase{
        return CategoriesUseCase(repositoryImp)
    }
    @Provides
    @Singleton
    fun provideSubCategoryUSeCase(repositoryImp: RepositoryImp):SubCategoryUseCase{
        return SubCategoryUseCase(repositoryImp)
    }
    @Provides
    @Singleton
    fun provideProductsUseCase(repositoryImp: RepositoryImp):ProductsUseCase{
        return ProductsUseCase(repositoryImp)
    }
    @Provides
    @Singleton
    fun providePagingUseCase(repositoryImp: RepositoryImp):PagingUseCase{
        return PagingUseCase(repositoryImp)
    }

}