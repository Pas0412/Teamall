var util = require('../../../utils/util.js');
var api = require('../../../config/api.js');
var user = require('../../../utils/user.js');
var app = getApp();
Page({
  data: {
    currentBalance: 0.00,
    lastUpdated: '2023-07-05 14:30',
    teamAmount: 0.00,
    agentAmount: 0.00,
    isAgent: false
  },

  onRecharge() {
    // 处理充值逻辑
    wx.showToast({ title: '进入充值页面' });
  },

  onTransfer() {
    // 处理转账逻辑
    wx.showToast({ title: '进入转账页面' });
  },

  onWithdraw() {
    // 处理提现逻辑
    wx.navigateTo({
      url: '/pages/withdraw/withdraw'
    });

  },

  showDetails() {
    // 显示所有交易详情
    wx.navigateTo({
      url: '/pages/transaction-details/transaction-details'
    });
  },

  contactSupport() {
    // 联系客服
    wx.makePhoneCall({
      phoneNumber: '400-123-4567'
    });
  },

  showData() {
    //获取用户的登录信息
    if (app.globalData.hasLogin) {
      let userInfo = wx.getStorageSync('userInfo');
      this.setData({
        userInfo: userInfo,
        hasLogin: true
      });
      this.setData({
        lastUpdated: util.getCurrentDateTime(),
        isAgent: userInfo.agentRoleId == 0? false : true
      })

      let that = this;
      util.request(api.GetBalance).then(function(res) {
        if (res.errno === 0) {
          that.setData({
            currentBalance: res.data.balance,
            teamAmount: res.data.teamAmount,
            agentAmount: res.data.agentAmount
          });
        }
      });
    }
  },

  onRefresh() {
    this.showData();
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {
    this.showData();
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})