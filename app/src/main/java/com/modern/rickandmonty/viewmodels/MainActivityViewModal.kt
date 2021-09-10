package com.modern.rickandmonty.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.modern.rickandmonty.network.CharacterData
import com.modern.rickandmonty.network.RetroInstance
import com.modern.rickandmonty.network.RetroServices
import com.modern.rickandmonty.paging.CharacterPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.cache

class MainActivityViewModal():ViewModel() {
    lateinit var retroService: RetroServices

    init {
        retroService = RetroInstance.getRetroInstance().create(RetroServices::class.java)
    }

    fun getListData(): Flow<PagingData<CharacterData>> {
        return Pager (config = PagingConfig(pageSize = 20, maxSize = 200),
            pagingSourceFactory = { CharacterPagingSource(retroService) }).flow.cachedIn(viewModelScope)
    }
}