package com.themasked.skarvosampleapp.repo

import androidx.lifecycle.LiveData
import com.themasked.skarvosampleapp.database.dao.StockItemDao
import com.themasked.skarvosampleapp.models.StockItemModel
import javax.inject.Inject

class StockRepository @Inject constructor(private val dao: StockItemDao) {

    //read all stocks
    fun readAllStock(): LiveData<List<StockItemModel>> = dao.getAllStocks()

    //add a stock
    suspend fun addStock(stock: StockItemModel) = dao.addStock(stock = stock)

    //delete a stock
    suspend fun deleteStock(id: Int) = dao.deleteStock(id)
}