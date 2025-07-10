import request from '@/utils/request'

export function listCommission() {
  return request({
    url: '/agent/commission/config/list',
    method: 'get'
  })
}

export function updateCommission(data) {
  return request({
    url: '/agent/commission/config/update',
    method: 'post',
    data
  })
}
