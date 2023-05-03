package com.br.ipapp.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()

        try {
            val url = chain
                .request()
                .url
                .newBuilder()
                .addQueryParameter("key", "")
                .build()
            req = req.newBuilder().url(url).build()
            chain.proceed(req)
        } catch (ex: Exception) {
            throw Exception(ex)
        }
        return chain.proceed(req)
    }
}