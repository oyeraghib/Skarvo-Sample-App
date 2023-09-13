package com.themasked.skarvosampleapp.di

import android.content.Context
import androidx.room.Room
import com.themasked.skarvosampleapp.database.StockItemsDatabase
import com.themasked.skarvosampleapp.database.dao.StockItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): StockItemsDatabase {
        return Room.databaseBuilder(
            context,
            StockItemsDatabase::class.java,
            "stock_items_database"
        )
            .build()
    }

    @Provides
    @Singleton
    fun providesDao(database: StockItemsDatabase): StockItemDao {
        return database.stockItemDao()
    }
}