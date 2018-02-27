package com.example.molpay_mobiledev.molpaytestappkotlin

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
            // your code to perform when the user clicks on the button
            val paymentDetails = HashMap<String, Any>()
            paymentDetails.put(MOLPayActivity.mp_amount, "1.10")
            paymentDetails.put(MOLPayActivity.mp_username, "molpayxdk")
            paymentDetails.put(MOLPayActivity.mp_password, "cT54#Lk@22")
            paymentDetails.put(MOLPayActivity.mp_merchant_ID, "molpayxdk")
            paymentDetails.put(MOLPayActivity.mp_app_name, "molpayxdk")
            paymentDetails.put(MOLPayActivity.mp_order_ID, "3-12-0-004")
            paymentDetails.put(MOLPayActivity.mp_currency, "MYR")
            paymentDetails.put(MOLPayActivity.mp_country, "MY")
            paymentDetails.put(MOLPayActivity.mp_verification_key, "4445db44bdb60687a8e7f7903a59c3a9")
//            paymentDetails.put(MOLPayActivity.mp_channel, "");
            paymentDetails.put(MOLPayActivity.mp_bill_description, "Cordova payment test")
            paymentDetails.put(MOLPayActivity.mp_bill_name, "Developer")
            paymentDetails.put(MOLPayActivity.mp_bill_email, "clewlb@gmail.com")
            paymentDetails.put(MOLPayActivity.mp_bill_mobile, "+647452")

            //paymentDetails.put(MOLPayActivity.mp_channel_editing, false);
            //paymentDetails.put(MOLPayActivity.mp_editing_enabled, false);
            //paymentDetails.put(MOLPayActivity.mp_transaction_id, "");
            //paymentDetails.put(MOLPayActivity.mp_request_type, "");
            //String binlock[] = {"123456","234567"};
            //paymentDetails.put(MOLPayActivity.mp_bin_lock, binlock);
            //paymentDetails.put(MOLPayActivity.mp_bin_lock_err_msg, "Wrong BIN format");
            //paymentDetails.put(MOLPayActivity.mp_is_escrow, "");
            //paymentDetails.put(MOLPayActivity.mp_filter, "1");
            //paymentDetails.put(MOLPayActivity.mp_custom_css_url, "file:///android_asset/custom.css");
            //paymentDetails.put(MOLPayActivity.mp_preferred_token, "");
            //paymentDetails.put(MOLPayActivity.mp_tcctype, ""); // SALS // AUTH
            //paymentDetails.put(MOLPayActivity.mp_is_recurring, false);
            //String allowedchannels[] = {"credit","credit3"};
            //paymentDetails.put(MOLPayActivity.mp_allowed_channels, allowedchannels);
            //paymentDetails.put(MOLPayActivity.mp_sandbox_mode, true);
            //paymentDetails.put(MOLPayActivity.mp_express_mode, true);
            //paymentDetails.put(MOLPayActivity.mp_advanced_email_validation_enabled, true);
            //paymentDetails.put(MOLPayActivity.mp_advanced_phone_validation_enabled, true);
            //paymentDetails.put(MOLPayActivity.mp_bill_name_edit_disabled, true);
            //paymentDetails.put(MOLPayActivity.mp_bill_email_edit_disabled, true);
            //paymentDetails.put(MOLPayActivity.mp_bill_mobile_edit_disabled, true);
            //paymentDetails.put(MOLPayActivity.mp_bill_description_edit_disabled, true);
            //paymentDetails.put(MOLPayActivity.mp_language, "EN");
            //paymentDetails.put(MOLPayActivity.mp_dev_mode, false);

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
