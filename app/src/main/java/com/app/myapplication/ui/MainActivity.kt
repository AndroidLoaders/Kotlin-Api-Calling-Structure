package com.app.myapplication.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.app.myapplication.R
import com.app.myapplication.adapters.StoreListAdapter
import com.app.myapplication.models.Store
import com.app.myapplication.networkadapter.api.ApiManager
import com.app.myapplication.networkadapter.api.repsonse.ApiResponse
import com.app.myapplication.networkadapter.api.request.ApiInterceptor
import com.app.myapplication.networkadapter.apiconstants.ApiConstants
import com.app.myapplication.repository.StoresListRepository
import com.app.myapplication.utility.ScreenDimensions
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG: String = "TAG -- ${MainActivity::class.java.simpleName}"

    private val apiInterface: ApiInterceptor = ApiManager()

    private val storesList: MutableList<Store> = mutableListOf()
    private val adapter: StoreListAdapter = StoreListAdapter(storesList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ScreenDimensions.getScreenDimensions(this)

        rvList.adapter = adapter

        getList()
    }

    private fun getList() {

        val params = JsonObject()
        params.addProperty(ApiConstants.Latitude, "42.4163593")
        params.addProperty(ApiConstants.Longitude, "-71.1562321")
        params.addProperty(ApiConstants.LastStoreId, "0")

        progressBar.visibility = View.VISIBLE

        apiInterface.getStoreList(params, object : ApiResponse<StoresListRepository> {
            override fun onSuccess(apiTag: String, apiResponse: StoresListRepository) {
                if (apiResponse.status == 1) {
                    storesList.addAll(apiResponse.dataList)

                    val store = Store()
                    store.viewType = StoreListAdapter.VIEW_TYPE_VIEW_ALL
                    storesList.add(store)

                    adapter.notifyDataSetChanged()
                }
                progressBar.visibility = View.GONE
            }

            override fun onFailed(apiTag: String, message: String) {
                progressBar.visibility = View.GONE
                println("$TAG --> $message")
            }

            override fun onFailed(apiTag: String, throwable: Throwable) {
                progressBar.visibility = View.GONE
                println("$TAG --> ${throwable.message}")
            }
        })
    }
}
