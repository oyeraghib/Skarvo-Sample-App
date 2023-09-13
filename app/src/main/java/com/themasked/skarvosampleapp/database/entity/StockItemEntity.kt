package com.themasked.skarvosampleapp.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stock_item_entity")
class StockItemEntity {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0

    @ColumnInfo(name = "stock_name")
    var stockName: String = ""

    @ColumnInfo(name = "company_name")
    var companyName: String = ""

    @ColumnInfo(name = "stock_price")
    var stockPrice: Int = 0

    @ColumnInfo(name = "stock_change")
    var stockChange: Float = 0f

}