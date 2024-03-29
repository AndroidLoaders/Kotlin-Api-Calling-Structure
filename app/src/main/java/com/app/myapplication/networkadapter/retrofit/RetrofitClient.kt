package com.app.myapplication.networkadapter.retrofit

import com.app.myapplication.networkadapter.api.request.ApiInterface
import com.app.myapplication.networkadapter.apiconstants.ApiConstants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private var apiInterface: ApiInterface? = null
    private var httpClient: OkHttpClient? = null

    val apiClient: ApiInterface
        get() = initClient()

    private fun initClient(): ApiInterface {
        if (httpClient == null) initOkHttp()

        if (apiInterface == null) {
            apiInterface = Retrofit.Builder().baseUrl(ApiConstants.BASE_URL)
                .client(httpClient!!)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
                .build().create(ApiInterface::class.java)
        }

        return apiInterface!!
    }

    private fun initOkHttp() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpBuilder = OkHttpClient().newBuilder()
            .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(interceptor).addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    /*.addHeader("Accept", "application/json")
                    .addHeader("Request-Type", "Android")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("User-Agent", "Android")*/
                    .build()
                chain.proceed(request)
            }

        httpClient = httpBuilder.build()
    }

    companion object {
        private const val REQUEST_TIMEOUT = 30L
    }
}