package com.app.myapplication.networkadapter.api

import androidx.annotation.NonNull
import com.app.myapplication.networkadapter.api.repsonse.ApiResponse
import com.app.myapplication.networkadapter.api.repsonse.ApiStatus
import com.app.myapplication.networkadapter.api.request.ApiInterceptor
import com.app.myapplication.networkadapter.api.request.ApiInterface
import com.app.myapplication.networkadapter.apiconstants.ApiProvider
import com.app.myapplication.networkadapter.retrofit.RetrofitClient
import com.app.myapplication.repository.StoresListRepository
import com.google.gson.JsonObject

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiManager : ApiInterceptor {

    private val apiInterface: ApiInterface = RetrofitClient().apiClient

    override fun getStoreList(
        parameters: JsonObject, apiResponse: ApiResponse<StoresListRepository>
    ) {
        apiInterface.getRefreshToken(parameters).enqueue(object : Callback<StoresListRepository> {
            override fun onResponse(
                @NonNull call: Call<StoresListRepository>, @NonNull response: Response<StoresListRepository>
            ) = onNext(ApiProvider.ApiGetStores, response, apiResponse)

            override fun onFailure(@NonNull call: Call<StoresListRepository>, @NonNull throwable: Throwable) {
                apiResponse.onFailed(ApiProvider.ApiGetStores, throwable)
                call.cancel()
            }
        })
    }

    private fun <ResponseClass : ApiStatus> onNext(
        apiTag: String, @NonNull response: Response<ResponseClass>,
        apiResponse: ApiResponse<ResponseClass>
    ) =
        if (response.isSuccessful && response.body() != null)
            apiResponse.onSuccess(apiTag, response.body()!!)
        else
            apiResponse.onFailed(apiTag, response.message())
}
