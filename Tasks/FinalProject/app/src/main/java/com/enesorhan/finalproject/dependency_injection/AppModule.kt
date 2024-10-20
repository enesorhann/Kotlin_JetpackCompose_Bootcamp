package com.enesorhan.finalproject.dependency_injection

import com.enesorhan.finalproject.data.dataSource.DataSource
import com.enesorhan.finalproject.data.repo.FoodsRepo
import com.enesorhan.finalproject.retrofit.ApiUtils
import com.enesorhan.finalproject.retrofit.dao.FoodCart_Dao
import com.enesorhan.finalproject.retrofit.dao.MealsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFoodsRepo(ds:DataSource) : FoodsRepo{
        return FoodsRepo(ds)
    }

    @Provides
    @Singleton
    fun provideDataSource(mealsDao: MealsDao,cartDao: FoodCart_Dao) : DataSource{
        return DataSource(mealsDao,cartDao)
    }

    @Provides
    @Singleton
    fun provideMealsDao() : MealsDao{
        return ApiUtils.getMealsDao()
    }
    @Provides
    @Singleton
    fun provideFoodCart_Dao() : FoodCart_Dao{
        return ApiUtils.getFoodCart_Dao()
    }
}