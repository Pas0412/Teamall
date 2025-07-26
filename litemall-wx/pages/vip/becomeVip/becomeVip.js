// pages/vip/becomeVip/becomeVip.js
var util = require('../../../utils/util.js');
var api = require('../../../config/api.js');

Page({
  data: {
    vipInfo: {
      id: 1,
      name: '年度会员',
      price: 100,
      description: '12个月会员权益',
      stock: 100000
    },
    isPaying: false
  },

  handlePay() {
    if (this.data.isPaying) return;
    this.setData({ isPaying: true });

    // 1. 将会员商品添加到购物车，获取cartId
    util.request(api.CartFastAdd, {
      goodsId: "1181004", // 会员商品的goodsId
      number: "1",
      productId: "1111111" // 会员商品的productId
    }, "POST")
    .then(res => {
      if (res.errno === 0) {
        const cartId = res.data; // 购物车项ID
        // 2. 将cartId存入本地存储（供订单页面读取）
        wx.setStorageSync('cartId', cartId);
        // 3. 跳转到订单页面
        wx.navigateTo({
          url: '/pages/checkout/checkout' // 订单页面路径（根据实际路径调整）
        });
      } else {
        throw new Error(res.errmsg || '添加会员商品到购物车失败');
      }
    })
    .catch(err => {
      wx.showToast({ title: err.message, icon: 'none' });
      this.setData({ isPaying: false });
    });
  },

  // 其他生命周期函数保持不变...
  onLoad() {},
  onReady() {},
  onShow() {},
  // ...
})