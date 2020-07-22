@file:Suppress("DEPRECATION")

package com.cheerme

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.ImageView
import android.widget.ProgressBar
import com.cheerme.models.WidgetModel
import com.cheerme.retrofit.ApiClient
import com.cheerme.retrofit.ApiInterface
import com.cheerme.utils.CheermeConstants
import com.cheerme.utils.MovableImageButton
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CheerMe {

    companion object {

        private var mLauncherIcon: MovableImageButton? = null

        private var activity: Activity? = null
        private var imageUrl: String? = ""

        /*Customer Id will be @null for Visitors*/
        fun init(
            layout: ViewGroup,
            activity: Activity,
            publicKey: String,
            customerId: String? = null,
            customerToken: String? = null
        ) {
            val service = ApiClient.client.create(ApiInterface::class.java)

            val serviceCall: Call<WidgetModel>?

            serviceCall = if (customerId == null) {
                service.initVisitor(publicKey)
            } else {
                service.initCustomer(publicKey, customerId)
            }

            serviceCall.enqueue(object :
                Callback<WidgetModel> {

                override fun onResponse(call: Call<WidgetModel>, response: Response<WidgetModel>) {
                    if (response.body() != null) {
                        if (response.body()!!.success!!) {
                            imageUrl = response.body()!!.data!!.widgetLayouts!!.launcherIconURL
                            setLauncher(layout, activity, publicKey, customerId, customerToken)
                        }
                    }
                }

                override fun onFailure(call: Call<WidgetModel>, t: Throwable) {
                    Log.d("onFailure online", t.toString())
                }
            })
        }

        @SuppressLint("ResourceType", "NewApi")
        fun setLauncher(
            layout: ViewGroup,
            activity: Activity,
            publicKey: String,
            customerId: String? = null,
            customerToken: String? = null
        ) {

            CheerMe.activity = activity

            // add Floating Action Button
            mLauncherIcon = MovableImageButton(activity)
            mLauncherIcon!!.id = 5
            mLauncherIcon!!.layoutDirection = Gravity.BOTTOM or Gravity.END or Gravity.CENTER

            Picasso.get()
                .load(R.drawable.cheerme)
                .resize(150, 150)
                .centerCrop()
                .into(mLauncherIcon!!)

            //add Floating Action to LinearLayout
            layout.addView(mLauncherIcon)

            mLauncherIcon!!.setOnClickListener {

                mLauncherIcon!!.visibility = View.GONE

                if (customerId == null) {
                    showCheerMeDialog(layout, publicKey)
                } else {
                    showCheerMeDialog(layout, publicKey, customerId, customerToken)
                }
            }
        }

        @SuppressLint("InflateParams", "SetJavaScriptEnabled")
        private fun showCheerMeDialog(
            layout: ViewGroup,
            publicKey: String,
            customerId: String? = null,
            customerToken: String? = null
        ) {
            val dialog = Dialog(activity!!)

            val inflater = activity!!.layoutInflater
            val alertLayout = inflater.inflate(R.layout.dialog_cheerme, null)
            dialog.setContentView(alertLayout)

            val mWebView = alertLayout.findViewById(R.id.webView) as WebView
            val btnCancel = alertLayout.findViewById(R.id.btnCancel) as ImageView

            val progressBar = alertLayout.findViewById<ProgressBar>(R.id.progressBar)

            mWebView.requestFocus()
            mWebView.settings.lightTouchEnabled = true
            mWebView.settings.javaScriptEnabled = true
            mWebView.settings.setGeolocationEnabled(true)
            mWebView.isSoundEffectsEnabled = true
            mWebView.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
            mWebView.settings.useWideViewPort = true

            mWebView.webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)
                    if (newProgress < 100) {
                        progressBar.visibility = View.VISIBLE
                    } else {
                        progressBar.visibility = View.GONE
                    }
                }
            }

            if (customerId == null) {
                mWebView.loadUrl("https://mobile.cheerme.io?publicKey=$publicKey")
            } else {
                mWebView.loadUrl("https://mobile.cheerme.io?publicKey=$publicKey&customerId=$customerId&customerToken=$customerToken")
            }

            dialog.show()

            btnCancel.setOnClickListener {
                dialog.dismiss()
                init(layout, activity!!, publicKey, customerId, customerToken)
            }
        }
    }

}