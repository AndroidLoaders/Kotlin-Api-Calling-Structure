package com.app.myapplication.networkadapter.api.request

import com.app.myapplication.networkadapter.api.repsonse.ApiResponse
import com.app.myapplication.repository.StoresListRepository
import com.google.gson.JsonObject

interface ApiInterceptor {

    fun getStoreList(parameters: JsonObject, apiResponse: ApiResponse<StoresListRepository>)

}
