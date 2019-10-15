package com.app.myapplication.repository

import com.app.myapplication.models.Store
import com.app.myapplication.networkadapter.api.repsonse.ApiStatus
import com.app.myapplication.networkadapter.apiconstants.ApiConstants
import com.google.gson.annotations.SerializedName

class StoresListRepository(

    @SerializedName(ApiConstants.Stores)
    private val mDataList: MutableList<Store>? = mutableListOf()

) : ApiStatus() {

    val dataList: MutableList<Store>
        get() = mDataList ?: mutableListOf()

}