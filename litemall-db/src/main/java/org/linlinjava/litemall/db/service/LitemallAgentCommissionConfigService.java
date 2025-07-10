package org.linlinjava.litemall.db.service;

import org.linlinjava.litemall.db.domain.LitemallAgentCommissionConfig;
import org.linlinjava.litemall.db.domain.LitemallAgentCommissionConfigExample;
import org.linlinjava.litemall.db.dao.LitemallAgentCommissionConfigMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LitemallAgentCommissionConfigService {
    @Resource
    private LitemallAgentCommissionConfigMapper agentCommissionConfigMapper;

    /**
     * 根据配置键获取配置信息
     * @param configKey 配置键
     * @return 配置信息
     */
    public LitemallAgentCommissionConfig queryByKey(String configKey) {
        LitemallAgentCommissionConfigExample example = new LitemallAgentCommissionConfigExample();
        example.or().andConfigKeyEqualTo(configKey).andDeletedEqualTo(false);
        return agentCommissionConfigMapper.selectOneByExample(example);
    }

    /**
     * 查询所有未删除的配置信息
     * @return 配置信息列表
     */
    public List<LitemallAgentCommissionConfig> queryAll() {
        LitemallAgentCommissionConfigExample example = new LitemallAgentCommissionConfigExample();
        example.or().andDeletedEqualTo(false);
        return agentCommissionConfigMapper.selectByExample(example);
    }

    /**
     * 更新配置信息
     * @param config 配置信息
     * @return 更新结果
     */
    public int updateById(LitemallAgentCommissionConfig config) {
        config.setUpdateTime(LocalDateTime.now());
        return agentCommissionConfigMapper.updateByPrimaryKeySelective(config);
    }

    /**
     * 添加配置信息
     * @param config 配置信息
     * @return 添加结果
     */
    public int add(LitemallAgentCommissionConfig config) {
        config.setCreateTime(LocalDateTime.now());
        config.setUpdateTime(LocalDateTime.now());
        return agentCommissionConfigMapper.insertSelective(config);
    }

    /**
     * 删除配置信息
     * @param id 配置 ID
     */
    public void deleteById(Integer id) {
        agentCommissionConfigMapper.logicalDeleteByPrimaryKey(id);
    }
}