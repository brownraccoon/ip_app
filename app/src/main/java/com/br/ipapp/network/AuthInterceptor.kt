package com.br.ipapp.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val req = chain.request()

        try {
            val url = chain
                .request()
                .url
                .newBuilder()
                .build()
            chain.proceed(chain.request().newBuilder().url(url).build())

        } catch (ex: Exception) {
            throw Exception(ex)
        }
        return chain.proceed(req)
    }
}