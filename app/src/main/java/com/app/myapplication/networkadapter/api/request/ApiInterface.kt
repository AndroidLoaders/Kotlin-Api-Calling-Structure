package com.app.myapplication.networkadapter.api.request

import com.app.myapplication.networkadapter.apiconstants.ApiProvider
import com.app.myapplication.repository.StoresListRepository
import com.google.gson.JsonObject

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST(ApiProvider.ApiGetStores)
    fun getRefreshToken(@Body parameters: JsonObject): Call<StoresListRepository>

}
