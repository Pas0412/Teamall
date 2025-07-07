Page({
  data: {
    currentBalance: 1580.50,
    lastUpdated: '2023-07-05 14:30',
    transactions: [
      { id: 1, type: '充值', date: '07-05', amount: 500 },
      { id: 2, type: '转账支出', date: '07-04', amount: -300 },
      { id: 3, type: '工资收入', date: '07-03', amount: 2000 },
      { id: 4, type: '提现', date: '07-02', amount: -500 },
      { id: 5, type: '消费', date: '07-01', amount: -120 }
    ]
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
    wx.showToast({ title: '进入提现页面' });
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