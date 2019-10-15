package com.app.myapplication.networkadapter.apiconstants

object ApiProvider {

    private const val API_EXTENSION = "OTLService.php?Service="

    private const val API_HOST = ApiConstants.BASE_URL + API_EXTENSION

    private const val GET_STORES = "getAllStoresList"
    const val ApiGetStores = API_HOST + GET_STORES

}