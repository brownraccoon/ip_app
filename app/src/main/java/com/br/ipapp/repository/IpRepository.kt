package com.br.ipapp.repository

import com.br.ipapp.network.Resource
import com.br.ipapp.networkmodel.IpResponse
import retrofit2.Response

interface IpRepository {
    suspend fun getIpData(): Resource<IpResponse>
}