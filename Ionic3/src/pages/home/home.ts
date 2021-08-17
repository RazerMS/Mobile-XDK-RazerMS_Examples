import { Component } from '@angular/core';
import { NavController, Platform } from 'ionic-angular';
import { MolpayPage } from '../molpay/molpay';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})



export class HomePage {
  molpayCallback = function(callbackData){
    console.log(callbackData);
    //timeout alert for ionic to pop the view first before alert show
    setTimeout(()=>{    
      alert(callbackData);
    },500);
  };
  constructor(public navCtrl: NavController, public platform: Platform) {
    
  }

  pay() {
    this.navCtrl.push(MolpayPage,{
      molpayCallback : this.molpayCallback
    });
  }

}
