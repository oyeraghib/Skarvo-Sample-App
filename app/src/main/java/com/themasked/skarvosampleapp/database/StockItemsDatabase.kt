package com.themasked.skarvosampleapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.themasked.skarvosampleapp.database.dao.StockItemDao
import com.themasked.skarvosampleapp.database.entity.StockItemEntity

@Database(
    entities = [StockItemEntity::class],
    exportSchema = false,
    version = 2
)
abstract class StockItemsDatabase : RoomDatabase() {

    abstract fun stockItemDao(): StockItemDao

}