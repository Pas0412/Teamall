const util = require('../../utils/util.js');
const api = require('../../config/api.js');
const user = require('../../utils/user.js');

//获取应用实例
const app = getApp();

Page({
  data: {
    newGoods: [],
    hotGoods: [],
    topics: [],
    brands: [],
    groupons: [],
    floorGoods: [],
    banner: [],
    channel: [],
    coupon: [],
    goodsCount: 0,
    isVip: false,
    menuList: [
      {
        id: 1,
        iconUrl: '/static/images/tealeaves.png',
        name: '茶叶'
      },
      {
        id: 2,
        iconUrl: '/static/images/services.png',
        name: '服务'
      },
      {
        id: 3,
        iconUrl: '/static/images/teasets.png',
        name: '茶器'
      },
      {
        id: 4,
        iconUrl: '/static/images/cookies.png',
        name: '茶点'
      },
      {
        id: 5,
        iconUrl: '/static/images/drinks.png',
        name: '酒水'
      },
    ],
    vipList: [
      {
        id: 1,
        picUrl: '/static/images/vip-1.jpeg',
        name: '会员权益',
        url: '/pages/vip/vipHome/vipHome'
      },
      {
        id: 2,
        picUrl: '/static/images/vip-2.jpeg',
        name: '成为会员',
        url: '/pages/vip/becomeVip/becomeVip'
      }
    ]
  },

  onShareAppMessage: function () {
    return {
      title: '南方工匠',
      desc: '南方工匠微信小程序商城',
      path: '/pages/index/index'
    }
  },

  onPullDownRefresh() {
    wx.showNavigationBarLoading() //在标题栏中显示加载
    this.getIndexData();
    wx.hideNavigationBarLoading() //完成停止加载
    wx.stopPullDownRefresh() //停止下拉刷新
  },

  goVip(e) {
    //获取用户的登录信息
    if (app.globalData.hasLogin) {
      let userInfo = wx.getStorageSync('userInfo');
      console.log(app.globalData.isVip)
      if (!app.globalData.isVip) {
        // 已过期
        wx.navigateTo({
          url: '/pages/vip/becomeVip/becomeVip'
        });
      } else if (app.globalData.isVip) {
        wx.navigateTo({
          url: '/pages/vip/vipHome/vipHome'
        });
      } else {
        wx.navigateTo({
          url: e.currentTarget.dataset.item,
        })
      }

    }
    else {
      wx.navigateTo({
        url: "/pages/auth/login/login"
      });
    }
  },

  getIndexData: function () {
    let that = this;
    util.request(api.IndexUrl).then(function (res) {
      if (res.errno === 0) {
        const filteredNewGoods = res.data.newGoodsList.filter(item => item.id !== 1181004);
        that.setData({
          newGoods: filteredNewGoods,
          hotGoods: res.data.hotGoodsList,
          topics: res.data.topicList,
          brands: res.data.brandList,
          floorGoods: res.data.floorGoodsList,
          banner: res.data.banner,
          groupons: res.data.grouponList,
          channel: res.data.channel,
          coupon: res.data.couponList
        });
      }
    });
    util.request(api.GoodsCount).then(function (res) {
      that.setData({
        goodsCount: res.data
      });
    });
  },
  onLoad: function (options) {

    // 页面初始化 options为页面跳转所带来的参数
    if (options.scene) {
      //这个scene的值存在则证明首页的开启来源于朋友圈分享的图,同时可以通过获取到的goodId的值跳转导航到对应的详情页
      var scene = decodeURIComponent(options.scene);
      console.log("scene:" + scene);

      let info_arr = [];
      info_arr = scene.split(',');
      let _type = info_arr[0];
      let id = info_arr[1];

      if (_type == 'goods') {
        wx.navigateTo({
          url: '../goods/goods?id=' + id
        });
      } else if (_type == 'groupon') {
        wx.navigateTo({
          url: '../goods/goods?grouponId=' + id
        });
      } else {
        wx.navigateTo({
          url: '../index/index'
        });
      }
    }

    // 页面初始化 options为页面跳转所带来的参数
    if (options.grouponId) {
      //这个pageId的值存在则证明首页的开启来源于用户点击来首页,同时可以通过获取到的pageId的值跳转导航到对应的详情页
      wx.navigateTo({
        url: '../goods/goods?grouponId=' + options.grouponId
      });
    }

    // 页面初始化 options为页面跳转所带来的参数
    if (options.goodId) {
      //这个goodId的值存在则证明首页的开启来源于分享,同时可以通过获取到的goodId的值跳转导航到对应的详情页
      wx.navigateTo({
        url: '../goods/goods?id=' + options.goodId
      });
    }

    // 页面初始化 options为页面跳转所带来的参数
    if (options.orderId) {
      //这个orderId的值存在则证明首页的开启来源于订单模版通知,同时可以通过获取到的pageId的值跳转导航到对应的详情页
      wx.navigateTo({
        url: '../ucenter/orderDetail/orderDetail?id=' + options.orderId
      });
    }

    this.getIndexData();
  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
    // 页面显示
    if(app.globalData.isVip){
      this.setData({
        isVip: true
      })
    }else{
      this.setData({
        isVip: false
      })
    }
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  },
  getCoupon(e) {
    let couponId = e.currentTarget.dataset.index
    util.request(api.CouponReceive, {
      couponId: couponId
    }, 'POST').then(res => {
      if (res.errno === 0) {
        wx.showToast({
          title: "领取成功"
        })
      }
      else {
        util.showErrorToast(res.errmsg);
      }
    })
  },
})