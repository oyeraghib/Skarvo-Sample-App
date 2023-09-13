package com.themasked.skarvosampleapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.themasked.skarvosampleapp.models.StockItemModel
import com.themasked.skarvosampleapp.repo.StockRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockItemsViewModel @Inject constructor(private val repository: StockRepository) :
    ViewModel() {

    private val _stocks: MutableLiveData<List<StockItemModel>> = MutableLiveData()
    val stocks: LiveData<List<StockItemModel>> get() = _stocks

    fun getAllStocks() = viewModelScope.launch {
        repository.readAllStock().let {
            _stocks.postValue(it)
        }
    }

    fun addStock(stock: StockItemModel) = viewModelScope.launch {
        repository.addStock(stock)
    }

    fun deleteStock(id: Int) = viewModelScope.launch {
        repository.deleteStock(id)
    }
}