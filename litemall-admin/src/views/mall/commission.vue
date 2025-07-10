<template>
  <div class="container">
    <h2>佣金设置</h2>

    <div class="form-group">
      <label for="memberDiscount">注册会员抽成比例 (%)：</label>
      <input id="memberDiscount" v-model.number="settings.direct_vip" type="number" min="0" max="100">
    </div>

    <div class="form-group">
      <label for="provinceCommission">省代抽成 (%)：</label>
      <input id="provinceCommission" v-model.number="settings.province_agent" type="number" min="0" max="100">
    </div>

    <div class="form-group">
      <label for="cityCommission">市代抽成 (%)：</label>
      <input id="cityCommission" v-model.number="settings.city_agent" type="number" min="0" max="100">
    </div>

    <div class="form-group">
      <label for="countyCommission">县代抽成 (%)：</label>
      <input id="countyCommission" v-model.number="settings.county_agent" type="number" min="0" max="100">
    </div>

    <div class="form-group">
      <label for="superiorCommission">上下级抽成 (%)：</label>
      <input id="superiorCommission" v-model.number="settings.rebuy_under_direct" type="number" min="0" max="100">
    </div>

    <button @click="saveSettings">保存设置</button>
  </div>
</template>

<script>
import { listCommission, updateCommission } from '@/api/agent_commission'

export default {
  name: 'CommissionSettings',
  data() {
    return {
      settings: {
        direct_vip: 10,
        province_agent: 20,
        city_agent: 15,
        county_agent: 10,
        rebuy_under_direct: 5
      },
      configList: []
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      listCommission()
        .then(response => {
          console.log(response.data.data)
          //   将后端返回的数据转换为 settings 对象
          // if (response.data && Array.isArray(response.data.data)) {
          response.data.data.list.forEach(item => {
            this.$set(this.settings, item.configKey, item.configValue)
          })
          this.configList = response.data.data.list
          // } else {
          //     console.error('接口返回数据格式错误', response.data)
          // }
        })
        .catch(error => {
          console.error('获取设置时出错:', error)
          alert('网络错误，请检查连接。')
        })
    },
    saveSettings() {
      for (const item of this.configList) {
        const key = item.configKey

        // 判断 settings 中有这个 key，并且 configValue 不同
        if (Object.prototype.hasOwnProperty.call(this.settings, key) && item.configValue !== this.settings[key]) {
          item.configValue = this.settings[key]

          updateCommission(item)
            .then(response => {
              this.$notify.success({
                title: '成功',
                message: '更新成功'
              })
            })
            .catch(error => {
              console.error('保存设置时出错:', error)
              alert('网络错误，请检查连接。')
            })
        }
      }
    }
  }
}
</script>

<style scoped>
.container {
    max-width: 500px;
    margin: 40px auto;
    background: white;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

h2 {
    text-align: center;
    color: #333;
    margin-bottom: 20px;
}

.form-group {
    margin-bottom: 20px;
}

label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
    color: #555;
}

input[type="number"] {
    width: 100%;
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 6px;
}

button {
    width: 100%;
    padding: 12px;
    font-size: 16px;
    background-color: #42b983;
    color: white;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

button:hover {
    background-color: #369c67;
}
</style>
