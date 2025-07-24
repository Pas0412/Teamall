// pages/ucenter/qrCode/qrCode.js
var api = require('../../../config/api.js');
var util = require('../../../utils/util.js');
var app = getApp();
Page({
  data: {
    qrcodeUrl: null,
    userInfo: {}
  },

  onLoad() {
    // 获取用户的登录信息
    if (app.globalData.hasLogin) {
      let userInfo = wx.getStorageSync('userInfo');
      this.setData({
        userInfo: userInfo,
        hasLogin: true
      });
      this.generateQRCode();
    }
  },

  generateQRCode() {
    const userId = this.data.userInfo.userId;
    if (!userId) {
      wx.showToast({ title: '获取用户ID失败', icon: 'none' });
      return;
    }
    var that = this;
    wx.showLoading({ title: '生成中...' });

    util.request(api.AuthGetQRCode, {inviterId: userId}).then(function(res) {
      console.log("sent")
      if (res.errno === 0) {
        that.setData({
          qrcodeUrl: res.data
        });
        wx.hideLoading();
        console.log(that.data.qrcodeUrl)
      } else {
        wx.showToast({ title: '生成失败', icon: 'none' });
      }
    });
  }
});