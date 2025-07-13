// pages/ucenter/qrCode/qrCode.js
var app = getApp();
Page({
  data: {
    qrcodeUrl: null
  },

  onLoad() {
    // 获取用户的登录信息
    if (app.globalData.hasLogin) {
      let userInfo = wx.getStorageSync('userInfo');
      this.setData({
        userInfo: userInfo,
        hasLogin: true
      });
    }
  },

  generateQRCode() {
    const userId = this.data.userInfo.userId;
    if (!userId) {
      wx.showToast({ title: '获取用户ID失败', icon: 'none' });
      return;
    }

    wx.showLoading({ title: '生成中...' });

    wx.request({
      url: 'https://your-api.com/api/generate-qr',
      method: 'POST',
      data: { userId },
      success: (res) => {
        if (res.statusCode === 200 && res.data.qrcodeUrl) {
          this.setData({ qrcodeUrl: res.data.qrcodeUrl });
          wx.hideLoading();
        } else {
          wx.showToast({ title: '生成失败', icon: 'none' });
        }
      },
      fail: () => {
        wx.showToast({ title: '网络错误', icon: 'none' });
      }
    });
  }
});