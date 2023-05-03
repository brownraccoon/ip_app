package com.br.ipapp.network

import com.br.ipapp.networkmodel.IpResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IpApi {
/*    @GET("{ip}/json")
    suspend fun getClientIpInfo( @Path("ip") ip: String
    ): Response<IpResponse>*/

    @GET("/json")
    suspend fun getClientIpInfo(
    ): Response<IpResponse>
}