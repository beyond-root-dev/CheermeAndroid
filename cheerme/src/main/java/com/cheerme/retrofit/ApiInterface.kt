package com.cheerme.retrofit

import com.cheerme.models.WidgetModel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("api/Public/Widget/Get")
    fun initVisitor(@Header("PublicKey") publicKey: String) : Call<WidgetModel>

    @GET("api/Public/Widget/Get")
    fun initCustomer(@Header("PublicKey") publicKey: String,
                    @Header("CustomerId") customerId: String) : Call<WidgetModel>

}