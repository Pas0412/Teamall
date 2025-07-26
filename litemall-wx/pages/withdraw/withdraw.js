// pages/ucenter/withdraw/withdraw.js
var util = require('../../utils/util.js');
var api = require('../../config/api.js');

Page({
  data: {
    currentBalance: 0.00,
    withdrawAmount: '',
    feeRate: 0.00, // 0%
    serviceFee: 0.00,
    actualAmount: 0.00,
    minWithdraw: 1.00, // 最小提现金额
    maxWithdraw: 0.00,
    showTips: false,
    tipsContent: ''
  },

  onLoad: function (options) {
    console.log("123")
    this.getUserBalance();
  },

  getUserBalance: function() {
    let that = this;
    util.request(api.GetBalance).then(function(res) {
      if (res.errno === 0) {
        that.setData({
          currentBalance: res.data.balance,
          maxWithdraw: res.data.balance
        });
      }
    });
  },

  onAmountInput: function(e) {
    const amount = parseFloat(e.detail.value) || 0;
    this.setData({
      withdrawAmount: amount
    });
    this.calculateFee(amount);
  },

  calculateFee: function(amount) {
    if (amount <= 0 || amount > this.data.maxWithdraw) {
      this.setData({
        serviceFee: 0.00,
        actualAmount: 0.00
      });
      return;
    }
    
    // 计算手续费 (保留两位小数)
    const fee = parseFloat((amount * this.data.feeRate).toFixed(2));
    // 实际到账金额
    const actual = parseFloat((amount - fee).toFixed(2));
    
    this.setData({
      serviceFee: fee,
      actualAmount: actual
    });
  },

  allIn: function() {
    this.setData({
      withdrawAmount: this.data.currentBalance
    });
    this.calculateFee(this.data.currentBalance);
  },

  submitWithdraw: function() {
    const amount = parseFloat(this.data.withdrawAmount);
    
    if (isNaN(amount) || amount <= 0) {
      this.showTips('请输入正确的提现金额');
      return;
    }
    
    if (amount < this.data.minWithdraw) {
      this.showTips(`最低提现金额为${this.data.minWithdraw}元`);
      return;
    }
      
    
    // if (amount > this.data.currentBalance) {
    //   this.showTips('提现金额不能超过当前余额');
    //   return;
    // }
    
    wx.showModal({
      title: '确认提现',
      content: `您确定要提现 ${amount} 元吗？\n手续费: ${this.data.serviceFee} 元\n实际到账: ${this.data.actualAmount} 元`,
      confirmText: '确认提现',
      success: (res) => {
        if (res.confirm) {
          this.doWithdraw();
        }
      }
    });
  },

  doWithdraw: function() {
    const that = this;
    wx.showLoading({
      title: '处理中...',
      mask: true
    });
    
    util.request(api.WithdrawInitiate, {
      amount: this.data.withdrawAmount,
      remark: '用户提现申请'
    }, 'POST').then(function(res) {
      wx.hideLoading();
      if (res.errno === 0) {
        wx.showToast({
          title: '提现申请已提交',
          icon: 'success',
          duration: 2000
        });
        
        // 返回上一页
        setTimeout(() => {
          wx.navigateBack();
        }, 2000);
      } else {
        that.showTips(res.errmsg || '提现失败，请重试');
      }
    }).catch(function(err) {
      wx.hideLoading();
      that.showTips('网络错误，请重试');
    });
  },

  showTips: function(content) {
    this.setData({
      showTips: true,
      tipsContent: content
    });
    
    setTimeout(() => {
      this.setData({
        showTips: false
      });
    }, 3000);
  },

  closeTips: function() {
    this.setData({
      showTips: false
    });
  }
});    