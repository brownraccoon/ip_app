package com.br.ipapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.ipapp.repository.IpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val ipRepository: IpRepository): ViewModel() {

    fun getIpData(){
        viewModelScope.launch {  ipRepository.getIpData() }

    }
}