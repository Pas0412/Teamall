// pages/vip/vipHome/vipHome.js
Page({
  data: {
    expireDate: ''
  },

  onLoad() {
    // 模拟当前时间 + 一年
    const now = new Date();
    const expire = new Date(now.setFullYear(now.getFullYear() + 1));
    this.setData({
      expireDate: this.formatDate(expire)
    });
  },

  formatDate(date) {
    const year = date.getFullYear();
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const day = date.getDate().toString().padStart(2, '0');
    return `${year}-${month}-${day}`;
  },

  handleRenew() {
    wx.showModal({
      title: '确认续费',
      content: '是否续费会员？金额为 ¥100',
      success(res) {
        if (res.confirm) {
          wx.showToast({ title: '续费成功' });
        }
      }
    });
  },

  /**
   * 生命周期函数--监听页面加载
   */

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