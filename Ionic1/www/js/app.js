// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
angular.module('starter', ['ionic'])

.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    if(window.cordova && window.cordova.plugins.Keyboard) {
      // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
      // for form inputs)
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);

      // Don't remove this line unless you know what you are doing. It stops the viewport
      // from snapping when text inputs are focused. Ionic handles this internally for
      // a much nicer keyboard experience.
      cordova.plugins.Keyboard.disableScroll(true);
    }
    if(window.StatusBar) {
      StatusBar.styleDefault();
    }


  });
})

.controller("molpay", function($scope){
  $scope.startMolpayButton = true;
  $scope.molpayStarted = false;
  $scope.closeMolpay = false;
  
  $scope.pay = function() {
    $scope.startMolpayButton = false;
    $scope.molpayStarted = true;
    $scope.closeMolpay = true;

    var paymentDetails = {
      'mp_amount': '1.10',
      'mp_username': '',
      'mp_password': '',
      'mp_merchant_ID': '',
      'mp_app_name': '',
      'mp_order_ID': 'M0001',
      'mp_currency': 'MYR',
      'mp_country': 'MY',
      'mp_verification_key': '',
      'mp_channel': '',
      'mp_bill_description': 'Test MOLPay',
      'mp_bill_name': 'molpay',
		  'mp_bill_email': 'email@email.com',
      'mp_bill_mobile': '',

      // 'mp_channel_editing' : false, // Option to allow channel selection.
      // 'mp_editing_enabled' : false, // Option to allow billing information editing.
      // Optional for Escrow
      // 'mp_is_escrow' : '', // Optional for Escrow, put "1" to enable escrow

      // Optional for credit card BIN restrictions
      // 'mp_bin_lock' : ['414170', '414171'], // Optional for credit card BIN restrictions
      // 'mp_bin_lock_err_msg' : 'Only UOB allowed', // Optional for credit card BIN restrictions
      
      // For transaction request use only, do not use this on payment process
      // 'mp_transaction_id' : '', // Optional, provide a valid cash channel transaction id here will display a payment instruction screen.
      // 'mp_request_type' : '', // Optional, set 'Status' when doing a transactionRequest

      // Optional, use this to customize the UI theme for the payment info screen, the original XDK custom.css file is provided at Example project source for reference and implementation. Required cordova-plugin-file to be installed
      // 'mp_custom_css_url' : cordova.file.applicationDirectory + 'www/custom.css',

      // Optional, set the token id to nominate a preferred token as the default selection, set "new" to allow new card only
      // 'mp_preferred_token': '',

      // Optional, credit card transaction type, set "AUTH" to authorize the transaction
      // 'mp_tcctype': '',

      // Optional, set true to process this transaction through the recurring api, please refer the MOLPay Recurring API pdf  
      // 'mp_is_recurring': false,

      // Optional for channels restriction 
      // 'mp_allowed_channels': ['credit', 'credit3'],

      // Optional for sandboxed development environment, set boolean value to enable.
      // 'mp_sandbox_mode': true,

      // Optional, required a valid mp_channel value, this will skip the payment info page and go direct to the payment screen.
      // 'mp_express_mode': true,

      // Optional, enable this for extended email format validation based on W3C standards.
      // 'mp_advanced_email_validation_enabled': true,

      // Optional, enable this for extended phone format validation based on Google i18n standards.
      // 'mp_advanced_phone_validation_enabled': true,

      // Optional, explicitly force disable billing name edit.
      // 'mp_bill_name_edit_disabled': true,

      // Optional, explicitly force disable billing email edit.
      // 'mp_bill_email_edit_disabled': true,

      // Optional, explicitly force disable billing mobile edit.
      // 'mp_bill_mobile_edit_disabled': true,

      // Optional, explicitly force disable billing description edit.
      // 'mp_bill_description_edit_disabled': true,
      
      // Optional, EN, MS, VI, TH, FIL, MY, KM, ID, ZH.
      // 'mp_language': 'EN',

      // Optional, enable for online sandbox testing.
      // 'mp_dev_mode': false
  };

  var molpayCallback = function (transactionResult) {
    // transactionResult return in json;
    console.log('response',response);
        // alert(response);
  }; 

  molpay.startMolpay(paymentDetails, molpayCallback);
  };

  $scope.close = function() {
    $scope.startMolpayButton = true;
    $scope.molpayStarted = false;
    $scope.closeMolpay = false;

    molpay.closeMolpay();
  }
});

