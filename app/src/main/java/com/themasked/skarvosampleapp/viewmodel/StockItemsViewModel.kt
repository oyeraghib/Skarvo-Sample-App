package com.themasked.skarvosampleapp.viewmodel

import androidx.lifecycle.ViewModel
import com.themasked.skarvosampleapp.repo.StockRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StockItemsViewModel @Inject constructor(private val repository: StockRepository) :
    ViewModel() {
}