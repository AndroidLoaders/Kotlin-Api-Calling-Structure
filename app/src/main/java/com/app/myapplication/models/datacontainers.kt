package com.app.myapplication.models

import android.os.Parcelable
import com.app.myapplication.adapters.StoreListAdapter
import com.app.myapplication.networkadapter.apiconstants.ApiConstants
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Store(

    @SerializedName(ApiConstants.Id)
    private var mId: String? = "0",

    @SerializedName(ApiConstants.Latitute)
    private var mLatitude: String? = "0.0",

    @SerializedName(ApiConstants.Longitute)
    private var mLongitude: String? = "0.0",

    @SerializedName(ApiConstants.Distance)
    private var mDistance: String? = "0.0",

    @SerializedName(ApiConstants.CommissionRate)
    private var mCommissionRate: String? = "0.0",

    @SerializedName(ApiConstants.StoreType)
    private var mStoreType: String? = "-1",

    @SerializedName(ApiConstants.IsOffer)
    private var mIsOffer: String? = "0",

    @SerializedName(ApiConstants.StoreName)
    private var mStoreName: String? = "",

    @SerializedName(ApiConstants.StoreImage)
    private var mStoreImage: String? = "",

    @SerializedName(ApiConstants.QrCode)
    private var mQrCode: String? = "",

    @SerializedName(ApiConstants.StoreAddress)
    private var mFullAddress: String? = "",

    @SerializedName(ApiConstants.Contact)
    private var mContact: String? = ""

) : Parcelable {

    var id: Int
        get() = if (mId != null && mId!!.isNotEmpty()) mId!!.toInt() else -1
        set(value) {
            mId = value.toString()
        }

    val latitute: Double
        get() = if (mLatitude != null && mLatitude!!.isNotEmpty()) mLatitude!!.toDouble()
        else 0.0

    val longitude: Double
        get() = if (mLongitude != null && mLongitude!!.isNotEmpty()) mLongitude!!.toDouble()
        else 0.0

    val distance: Double
        get() = if (mDistance != null && mDistance!!.isNotEmpty()) mDistance!!.toDouble()
        else 0.0

    val commissionRate: String
        get() = if (mCommissionRate != null && mCommissionRate!!.isNotEmpty()) mCommissionRate!!
        else "0"

    val storeType: String
        get() = if (mStoreType != null && mStoreType!!.isNotEmpty()) mStoreType!! else "0"

    val isOffer: String
        get() = if (mIsOffer != null && mIsOffer!!.isNotEmpty()) mIsOffer!! else "Not Available"

    val storeName: String
        get() = if (mStoreName != null) mStoreName!! else ""

    val storeImageUrl: String
        get() = if (mStoreImage != null) mStoreImage!! else ""

    val qrCode: String
        get() = if (mQrCode != null) mQrCode!! else ""

    val fullAddress: String
        get() = if (mFullAddress != null) mFullAddress!! else "0"

    val contactNumber: String
        get() = if (mContact != null && mContact!!.isNotEmpty()) mContact!!
        else "Not Available"

    var viewType: Int = StoreListAdapter.VIEW_TYPE_DATA
}