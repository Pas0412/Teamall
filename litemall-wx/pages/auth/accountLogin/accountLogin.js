var api = require('../../../config/api.js');
var util = require('../../../utils/util.js');
var user = require('../../../utils/user.js');

var app = getApp();
Page({
  data: {
    username: '',
    password: '',
    code: '',
    loginErrorCount: 0
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
    } else {
      wx.setStorageSync('parentInviterId', 0);
      console.log('无邀请人');
    }

    // 判断是否已登录
    const token = wx.getStorageSync('token');
    if (token) {
      this.jumpToHome();
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
  accountLogin: function () {
    var that = this;
    const parentInviterId = wx.getStorageSync('parentInviterId');

    if (this.data.password.length < 1 || this.data.username.length < 1) {
      wx.showModal({
        title: '错误信息',
        content: '请输入用户名和密码',
        showCancel: false
      });
      return false;
    }

    wx.request({
      url: api.AuthLoginByAccount,
      data: {
        username: that.data.username,
        password: that.data.password,
        parentInviterId: parentInviterId
      },
      method: 'POST',
      header: {
        'content-type': 'application/json'
      },
      success: function (res) {
        if (res.data.errno == 0) {
          that.setData({
            loginErrorCount: 0
          });
          app.globalData.hasLogin = true;
          wx.setStorageSync('userInfo', res.data.data.userInfo);

          // 当前时间
          const now = new Date();

          // 将输入的时间字符串转换为 Date 对象
          const targetTime = new Date(res.data.data.userInfo.vipExpireTime);

          if (now > targetTime) {
            // 已过期
            app.globalData.isVip = false;
          } else if (now < targetTime) {
            app.globalData.isVip = true;
          }
          wx.setStorage({
            key: "token",
            data: res.data.data.token,
            success: function () {
              wx.switchTab({
                url: '/pages/ucenter/index/index'
              });
            }
          });
        } else {
          that.setData({
            loginErrorCount: that.data.loginErrorCount + 1
          });
          app.globalData.hasLogin = false;
          util.showErrorToast('账户登录失败');
        }
      }
    });
  },
  bindUsernameInput: function (e) {

    this.setData({
      username: e.detail.value
    });
  },
  bindPasswordInput: function (e) {

    this.setData({
      password: e.detail.value
    });
  },
  bindCodeInput: function (e) {

    this.setData({
      code: e.detail.value
    });
  },
  clearInput: function (e) {
    switch (e.currentTarget.id) {
      case 'clear-username':
        this.setData({
          username: ''
        });
        break;
      case 'clear-password':
        this.setData({
          password: ''
        });
        break;
      case 'clear-code':
        this.setData({
          code: ''
        });
        break;
    }
  }
})