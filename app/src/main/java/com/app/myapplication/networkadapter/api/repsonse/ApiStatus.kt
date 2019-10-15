package com.app.myapplication.networkadapter.api.repsonse

abstract class ApiStatus {

    var status: Int? = 0
        get() = field ?: 0

    var message: String? = ""
        get() = field ?: ""

}
