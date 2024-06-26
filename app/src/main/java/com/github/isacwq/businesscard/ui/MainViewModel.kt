package com.github.isacwq.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.isacwq.businesscard.data.BusinessCard
import com.github.isacwq.businesscard.data.BusinessCardRepository
import java.lang.IllegalArgumentException

class MainViewModel(private val businessCardRepository: BusinessCardRepository) : ViewModel() {
    fun getAll(): LiveData<List<BusinessCard>> {
        return businessCardRepository.getAll()
    }

    fun insert(businessCard: BusinessCard) {
        businessCardRepository.insert(businessCard)
    }
}

class MainViewModelFactory(private val repository: BusinessCardRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}