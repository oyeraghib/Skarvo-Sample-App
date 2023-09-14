package com.themasked.skarvosampleapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.themasked.skarvosampleapp.database.entity.StockItemEntity
import com.themasked.skarvosampleapp.models.StockItemModel

@Dao
interface StockItemDao {

    //Insert a new stock
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStock(stock: StockItemEntity)

    //Get all the stocks from the list
    @Query("SELECT * from stock_item_entity")
    fun getAllStocks(): LiveData<List<StockItemEntity>>?

    //Delete a stock
    @Query("DELETE FROM stock_item_entity where id =:id")
    suspend fun deleteStock(id: Int)
}