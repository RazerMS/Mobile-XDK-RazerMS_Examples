package com.example.molpay_mobiledev.androidstudiokotlin

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.HashMap
import android.content.Intent
import android.util.Log
import com.molpay.molpayxdk.MOLPayActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get reference to button
        val button = findViewById<Button>(R.id.btn_click_me)
        // set on-click listener
        button.setOnClickListener {

            val paymentDetails = HashMap<String, Any>()
            paymentDetails[MOLPayActivity.mp_amount] = "1.10"
            paymentDetails[MOLPayActivity.mp_username] = " "
            paymentDetails[MOLPayActivity.mp_password] = " "
            paymentDetails[MOLPayActivity.mp_merchant_ID] = ""
            paymentDetails[MOLPayActivity.mp_app_name] = ""
            paymentDetails[MOLPayActivity.mp_order_ID] = "M0001"
            paymentDetails[MOLPayActivity.mp_currency] = "MYR"
            paymentDetails[MOLPayActivity.mp_country] = "MY"
            paymentDetails[MOLPayActivity.mp_verification_key] = ""
            paymentDetails[MOLPayActivity.mp_channel] = ""
            paymentDetails[MOLPayActivity.mp_bill_description] = "Test MOLPay"
            paymentDetails[MOLPayActivity.mp_bill_name] = "molpay"
            paymentDetails[MOLPayActivity.mp_bill_email] = "email@email.com"
            paymentDetails[MOLPayActivity.mp_bill_mobile] = ""

//            paymentDetails[MOLPayActivity.mp_channel_editing] = false
//            paymentDetails[MOLPayActivity.mp_editing_enabled] = false
//            paymentDetails[MOLPayActivity.mp_transaction_id] = ""
//            paymentDetails[MOLPayActivity.mp_request_type] = ""
//            val binlock = arrayOf("123456","234567")
//            paymentDetails[MOLPayActivity.mp_bin_lock] = binlock
//            paymentDetails[MOLPayActivity.mp_bin_lock_err_msg] = "Wrong BIN format"
//            paymentDetails[MOLPayActivity.mp_is_escrow] = ""
//            paymentDetails[MOLPayActivity.mp_filter] = "1"
//            paymentDetails[MOLPayActivity.mp_custom_css_url] = "file:///android_asset/custom.css"
//            paymentDetails[MOLPayActivity.mp_preferred_token] = ""
//            paymentDetails[MOLPayActivity.mp_tcctype] = "" // SALS // AUTH
//            paymentDetails[MOLPayActivity.mp_is_recurring] = false
//            val allowedchannels = arrayOf("credit","credit3")
//            paymentDetails[MOLPayActivity.mp_allowed_channels] = allowedchannels
//            paymentDetails[MOLPayActivity.mp_sandbox_mode] = true
//            paymentDetails[MOLPayActivity.mp_express_mode] = true
//            paymentDetails[MOLPayActivity.mp_advanced_email_validation_enabled] = true
//            paymentDetails[MOLPayActivity.mp_advanced_phone_validation_enabled] = true
//            paymentDetails[MOLPayActivity.mp_bill_name_edit_disabled] = true
//            paymentDetails[MOLPayActivity.mp_bill_email_edit_disabled] = true
//            paymentDetails[MOLPayActivity.mp_bill_mobile_edit_disabled] = true
//            paymentDetails[MOLPayActivity.mp_bill_description_edit_disabled] = true
//            paymentDetails[MOLPayActivity.mp_language] = "EN"
//            paymentDetails[MOLPayActivity.mp_dev_mode] = false

            val intent = Intent(this@MainActivity, MOLPayActivity::class.java)
            intent.putExtra(MOLPayActivity.MOLPayPaymentDetails, paymentDetails)
            startActivityForResult(intent, MOLPayActivity.MOLPayXDK)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == MOLPayActivity.MOLPayXDK && resultCode == Activity.RESULT_OK) {
            Log.d(MOLPayActivity.MOLPAY, "MOLPay result = " + data.getStringExtra(MOLPayActivity.MOLPayTransactionResult))
        }
    }
}
