<template>
  <div class="app-container">

    <!-- 查询和其他操作 -->
    <div class="filter-container">
      <el-input
        v-model="listQuery.username"
        clearable
        class="filter-item"
        style="width: 200px;"
        :placeholder="$t('user_user.placeholder.filter_username')"
      />
      <el-input
        v-model="listQuery.userId"
        clearable
        class="filter-item"
        style="width: 200px;"
        :placeholder="$t('user_user.placeholder.filter_user_id')"
      />
      <el-input
        v-model="listQuery.mobile"
        clearable
        class="filter-item"
        style="width: 200px;"
        :placeholder="$t('user_user.placeholder.filter_mobile')"
      />
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">{{
        $t('app.button.search') }}</el-button>
      <el-button
        :loading="downloadLoading"
        class="filter-item"
        type="primary"
        icon="el-icon-download"
        @click="handleDownload"
      >{{ $t('app.button.download') }}</el-button>
    </div>

    <!-- 查询结果 -->
    <el-table
      v-loading="listLoading"
      :data="list"
      :element-loading-text="$t('app.message.list_loading')"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" width="100px" :label="$t('user_user.table.id')" prop="id" sortable />

      <el-table-column align="center" :label="$t('user_user.table.nickname')" prop="nickname" />

      <!-- <el-table-column align="center" :label="$t('user_user.table.balance')" width="80">
        <template slot-scope="scope">
          <el-avatar :src="scope.row.balance" />
        </template>
</el-table-column> -->

      <el-table-column align="center" :label="$t('user_user.table.balance')" prop="balance" />

      <el-table-column align="center" :label="$t('user_user.table.mobile')" prop="mobile" />

      <el-table-column v-if="userDetail.agentRoleId" align="center" :label="$t('user_user.table.agent_role_id')" prop="agentRoleId" />
      <!-- <el-table-column align="center" :label="$t('user_user.table.agent_role_id')" prop="agent_role_id">
        <template slot-scope="scope">
          <el-tag >{{ genderDic[scope.row.agent_role_id] }}</el-tag>
        </template>
      </el-table-column> -->

      <el-table-column align="center" :label="$t('user_user.table.user_level')" prop="userLevel">
        <template slot-scope="scope">
          <el-tag>{{ levelDic[scope.row.userLevel] }}</el-tag>
        </template>
      </el-table-column>

      <el-table-column align="center" :label="$t('user_user.table.parent_inviter_id')" prop="parent_inviter_id" />

      <el-table-column align="center" :label="$t('user_user.table.child_inviter_id')" prop="child_inviter_id" />
      <!-- <el-table-column align="center" :label="$t('user_user.table.status')" prop="status">
        <template slot-scope="scope">
          <el-tag>{{ statusDic[scope.row.status] }}</el-tag>
        </template>
      </el-table-column> -->

      <el-table-column
        align="center"
        :label="$t('user_user.table.actions')"
        width="250"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="handleDetail(scope.row)">{{ $t('app.button.detail')
          }}</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="listQuery.page"
      :limit.sync="listQuery.limit"
      @pagination="getList"
    />
    <!-- 用户编辑对话框 -->
    <el-dialog :visible.sync="userDialogVisible" :title="$t('user_user.dialog.edit')">
      <el-form
        ref="userDetail"
        :model="userDetail"
        status-icon
        label-position="left"
        label-width="100px"
        style="width: 400px; margin-left:50px;"
      >
        <el-form-item :label="$t('user_user.form.username')" prop="username">
          <el-input v-model="userDetail.username" :disabled="true" />
        </el-form-item>
        <el-form-item :label="$t('user_user.form.nickname')" prop="nickname">
          <el-input v-model="userDetail.nickname" />
        </el-form-item>
        <el-form-item :label="$t('user_user.form.mobile')" prop="mobile">
          <el-input v-model="userDetail.mobile" />
        </el-form-item>
        <el-form-item :label="$t('user_user.form.gender')" prop="gender">
          <el-select v-model="userDetail.gender" :placeholder="$t('user_user.placeholder.gender')"><el-option
            v-for="(item, index) in genderDic"
            :key="index"
            :label="item"
            :value="index"
          /></el-select>
        </el-form-item>
        <el-form-item :label="$t('user_user.form.user_level')" prop="userLevel">
          <el-select v-model="userDetail.userLevel" :placeholder="$t('user_user.placeholder.user_level')"><el-option
            v-for="(item, index) in levelDic"
            :key="index"
            :label="item"
            :value="index"
          /></el-select>
        </el-form-item>
        <el-form-item :label="$t('user_user.form.status')" prop="status">
          <el-select v-model="userDetail.status" :placeholder="$t('user_user.placeholder.status')"><el-option
            v-for="(item, index) in statusDic"
            :key="index"
            :label="item"
            :value="index"
          /></el-select>
        </el-form-item>
        <el-form-item :label="$t('user_user.form.is_agent')" prop="isAgent">
          <el-select v-model="userDetail.isAgent" :placeholder="$t('user_user.placeholder.is_agent')"><el-option
            v-for="(item, index) in agentDic"
            :key="index"
            :label="item.label"
            :value="item.value"
          /></el-select>
        </el-form-item>
        <el-form-item v-if="userDetail.isAgent" :label="$t('user_user.form.address')">
          <el-select
            v-model="province"
            :placeholder="$t('user_user.placeholder.province')"
            style="width: 100px;"
            @change="loadCityOptions"
          ><el-option
            v-for="(item, index) in provinceOptions"
            :key="index"
            :label="item.label"
            :value="item.value"
          /></el-select>
          <el-select
            v-model="city"
            :placeholder="$t('user_user.placeholder.city')"
            style="width: 100px;"
            :disabled="!province"
            @change="loadCountyOptions"
          ><el-option
            v-for="(item, index) in cityOptions"
            :key="index"
            :label="item.label"
            :value="item.value"
          /></el-select>
          <el-select
            v-model="county"
            :placeholder="$t('user_user.placeholder.county')"
            style="width: 100px;"
            :disabled="!city"
            @change="updateAgentId"
          ><el-option
            v-for="(item, index) in countyOptions"
            :key="index"
            :label="item.label"
            :value="item.value"
          /></el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="userDialogVisible = false">{{ $t('app.button.cancel') }}</el-button>
        <el-button type="primary" @click="handleUserUpdate">{{ $t('app.button.confirm') }}</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { fetchList, userDetail, updateUser } from '@/api/user'
import { listSubRegion } from '@/api/region' // 假设这是获取省市区数据的 API
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination

export default {
  name: 'User',
  components: { Pagination },
  data() {
    return {
      list: null,
      total: 0,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 20,
        username: undefined,
        mobile: undefined,
        userId: undefined,
        sort: 'add_time',
        order: 'desc'
      },
      downloadLoading: false,
      genderDic: ['未知', '男', '女'],
      levelDic: ['普通用户', 'VIP用户'],
      statusDic: ['可用', '禁用', '注销'],
      agentDic: [
        { label: '否', value: false },
        { label: '是', value: true }
      ],
      userDialogVisible: false,
      userDetail: {
        // isAgent: false,
        // address: []
      },
      province: '',
      city: '',
      county: '',
      provinceOptions: [],
      cityOptions: [],
      countyOptions: []
    }
  },
  created() {
    this.getList()
  },
  mounted() {
  },
  methods: {
    getList() {
      this.listLoading = true
      if (this.listQuery.userId) {
        userDetail(this.listQuery.userId).then(response => {
          this.list = []
          if (response.data.data) {
            this.list.push(response.data.data)
            this.total = 1
            this.listLoading = false
          } else {
            this.list = []
            this.total = 0
            this.listLoading = false
          }
        }).catch(() => {
          this.list = []
          this.total = 0
          this.listLoading = false
        })
      } else {
        fetchList(this.listQuery).then(response => {
          this.list = response.data.data.list
          this.total = response.data.data.total
          this.listLoading = false
        }).catch(() => {
          this.list = []
          this.total = 0
          this.listLoading = false
        })
      }
    },
    handleFilter() {
      this.listQuery.page = 1
      this.getList()
    },
    handleDownload() {
      this.downloadLoading = true
      import('@/vendor/Export2Excel').then(excel => {
        const tHeader = ['用户名', '手机号码', '性别', '生日', '状态']
        const filterVal = ['username', 'mobile', 'gender', 'birthday', 'status']
        excel.export_json_to_excel2(tHeader, this.list, filterVal, '用户信息')
        this.downloadLoading = false
      })
    },
    handleDetail(row) {
      // const isAgent = false
      this.userDetail = {
        ...this.userDetail,
        ...row,
        // 确保 isAgent 为布尔类型
        isAgent: !!row.agentRoleId
      }
      this.userDialogVisible = true
      listSubRegion({ id: 0 }).then(response => {
        this.provinceOptions = response.data.data.list.map(item => ({
          value: item.id,
          label: item.name
        }))
      })
    },
    loadCityOptions() {
      if (this.province) {
        this.userDetail.agentRoleId = this.province
        listSubRegion({ id: this.province }).then(response => {
          this.cityOptions = response.data.data.list.map(item => ({
            value: item.id,
            label: item.name
          }))
        })
      } else {
        this.cityOptions = []
      }
    },
    loadCountyOptions() {
      if (this.city) {
        this.userDetail.agentRoleId = this.city
        listSubRegion({ id: this.city }).then(response => {
          this.countyOptions = response.data.data.list.map(item => ({
            value: item.id,
            label: item.name
          }))
        })
      }
    },
    updateAgentId() {
      if (this.county) {
        this.userDetail.agentRoleId = this.county
      }
    },
    handleUserUpdate() {
      console.log(this.userDetail.isAgent)
      if (!this.userDetail.isAgent) {
        this.userDetail.agentRoleId = 0
      }
      delete this.userDetail.isAgent
      updateUser(this.userDetail)
        .then((response) => {
          this.userDialogVisible = false
          this.$notify.success({
            title: '成功',
            message: '更新用户成功'
          })
        })
        .catch(response => {
          this.$notify.error({
            title: '失败',
            message: response.data.errmsg
          })
        })
    }
  }
}
</script>
