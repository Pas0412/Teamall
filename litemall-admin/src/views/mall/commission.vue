<template>
  <div class="container">
    <h2>佣金设置</h2>

    <div class="form-group">
      <label for="memberDiscount">注册会员抽成比例 (%)：</label>
      <input
        id="memberDiscount"
        v-model.number="settings.memberDiscount"
        type="number"
        min="0"
        max="100"
      >
    </div>

    <div class="form-group">
      <label for="provinceCommission">省代抽成 (%)：</label>
      <input
        id="provinceCommission"
        v-model.number="settings.provinceCommission"
        type="number"
        min="0"
        max="100"
      >
    </div>

    <div class="form-group">
      <label for="cityCommission">市代抽成 (%)：</label>
      <input
        id="cityCommission"
        v-model.number="settings.cityCommission"
        type="number"
        min="0"
        max="100"
      >
    </div>

    <div class="form-group">
      <label for="countyCommission">县代抽成 (%)：</label>
      <input
        id="countyCommission"
        v-model.number="settings.countyCommission"
        type="number"
        min="0"
        max="100"
      >
    </div>

    <div class="form-group">
      <label for="superiorCommission">上下级抽成 (%)：</label>
      <input
        id="superiorCommission"
        v-model.number="settings.superiorCommission"
        type="number"
        min="0"
        max="100"
      >
    </div>

    <button @click="saveSettings">保存设置</button>
  </div>
</template>

<script>
export default {
  name: 'CommissionSettings',
  data() {
    return {
      settings: {
        memberDiscount: 30,
        provinceCommission: 10,
        cityCommission: 20,
        countyCommission: 15,
        superiorCommission: 10
      }
    }
  },
  methods: {
    async saveSettings() {
      try {
        // 模拟请求接口（请替换为你的真实后端地址）
        const response = await fetch('https://jsonplaceholder.typicode.com/posts', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(this.settings)
        })

        if (response.ok) {
          alert('设置保存成功！')
        } else {
          alert('保存失败，请重试。')
        }
      } catch (error) {
        console.error('保存设置时出错:', error)
        alert('网络错误，请检查连接。')
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
