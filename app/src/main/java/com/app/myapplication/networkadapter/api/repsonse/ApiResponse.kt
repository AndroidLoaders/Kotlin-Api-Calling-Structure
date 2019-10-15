package com.app.myapplication.networkadapter.api.repsonse

interface ApiResponse<ResponseClass : ApiStatus> {
    fun onSuccess(apiTag: String, apiResponse: ResponseClass)
    fun onFailed(apiTag: String, message: String)
    fun onFailed(apiTag: String, throwable: Throwable)
}