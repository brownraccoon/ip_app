package com.br.ipapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.ipapp.repository.IpRepository
import com.br.ipapp.usecase.IpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val ipUseCase: IpUseCase): ViewModel() {

    fun getIpData(){
        viewModelScope.launch {  ipUseCase.getIpData() }

    }
}