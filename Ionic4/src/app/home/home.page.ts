import { Component } from '@angular/core';
import { Platform, AlertController } from '@ionic/angular';

declare var molpay;

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  constructor(public platform: Platform, public alertCtrl: AlertController) {}

  ionViewWillEnter() {
    console.log('ionViewWillEnter');
  }

  ionViewDidEnter(){

    console.log('ionViewDidEnter');

    this.platform.ready().then((readySource) => {
      console.log('The platform is ready');
      if(readySource === "cordova"){
        console.log('Android detected');
        // MOLPay payment details
        var paymentDetails = {
          
          // Mandatory String. Values obtained from MOLPay.
          'mp_username' : '',
          'mp_password' : '',
          'mp_merchant_ID' : '',
          'mp_app_name' : '',
          'mp_verification_key' : '', 
      
          // Mandatory String. Payment values.
          'mp_amount' : '1.10', // Minimum 1.01
          'mp_order_ID' : '1523765091', 
          'mp_currency' : 'MYR',
          'mp_country' : 'MY',  
          
          // Optional String.
          'mp_channel' : 'multi',
          'mp_bill_description' : 'description',
          'mp_bill_name' : 'name',
          'mp_bill_email' : 'email',
          'mp_bill_mobile' : 'mobile',
          
          // Enabled Sandbox Credentials 
          // 'mp_dev_mode': true,
        }; 

        var molpayCallback = (response: string) => { this.presentAlert(response); }
        molpay.startMolpay(paymentDetails, molpayCallback);
      }

    }); 
  }

  ionViewWillLeave() {
    console.log('ionViewWillLeave');
  }

  ionViewDidLeave() {
    console.log('ionViewDidLeave');
  }

  closeMolpay(){
    molpay.closeMolpay();
  }

  async presentAlert(result: string) {
    const alert = await this.alertCtrl.create({
      header: 'Result',
      message: result,
      buttons: ['OK']
    });

    await alert.present();
  }
}
