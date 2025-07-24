var api = require('../../../config/api.js');
var util = require('../../../utils/util.js');
var user = require('../../../utils/user.js');

var app = getApp();
Page({
  data: {
    canIUseGetUserProfile: false,
  },
  onLoad: function (options) {
    // 页面初始化 options为页面跳转所带来的参数
    // 页面渲染完成
    let inviterUserId = null;

    if (options.scene) {
      let scene = decodeURIComponent(options.scene); // 解析出推荐人ID
      // 第一步：按 "=" 分割
      let parts = scene.split("="); // ["inviterId", "8888-abc123"]

      // 第二步：取第二部分，再按 "-" 分割
      inviterUserId = parts[1].split("-")[0]; // "8888"
      wx.setStorageSync('parentInviterId', inviterUserId);
      console.log('扫码识别的推荐人ID:', inviterUserId);
    }else{
      wx.setStorageSync('parentInviterId', 0);
      console.log('无邀请人');
    }

    if (wx.getUserProfile) {
      this.setData({
        canIUseGetUserProfile: true
      })
    }
  },
  onReady: function () {

  },
  onShow: function () {
    // 页面显示
  },
  onHide: function () {
    // 页面隐藏

  },
  onUnload: function () {
    // 页面关闭

  },
  wxLogin: function (e) {
    if (this.data.canIUseGetUserProfile) {
      wx.getUserProfile({
        desc: '用于完善会员资料', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
        success: (res) => {
          res.userInfo.parentInviterId = wx.getStorageSync('parentInviterId')
          this.doLogin(res.userInfo)
        },
        fail: () => {
          util.showErrorToast('微信登录失败');
        }
      })
    }
    else {
      if (e.detail.userInfo == undefined) {
        app.globalData.hasLogin = false;
        util.showErrorToast('微信登录失败');
        return;
      }
      this.doLogin(e.detail.userInfo)
    }
  },
  doLogin: function (userInfo) {
    user.checkLogin().catch(() => {
      user.loginByWeixin(userInfo).then(res => {
        app.globalData.hasLogin = true;
        wx.navigateBack({
          delta: 1
        })
      }).catch((err) => {
        app.globalData.hasLogin = false;
        util.showErrorToast('微信登录失败');
      });
    });
  },
  accountLogin: function () {
    wx.navigateTo({
      url: "/pages/auth/accountLogin/accountLogin"
    });
  }
})