package org.linlinjava.litemall.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.litemall.db.dao.LitemallRegionMapper;
import org.linlinjava.litemall.db.domain.LitemallRegion;
import org.linlinjava.litemall.db.domain.LitemallRegionExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LitemallRegionService {

    @Resource
    private LitemallRegionMapper regionMapper;

    public List<LitemallRegion> getAll(){
        LitemallRegionExample example = new LitemallRegionExample();
        byte b = 4;
        example.or().andTypeNotEqualTo(b);
        return regionMapper.selectByExample(example);
    }

    public List<LitemallRegion> queryByPid(Integer parentId) {
        LitemallRegionExample example = new LitemallRegionExample();
        example.or().andPidEqualTo(parentId);
        return regionMapper.selectByExample(example);
    }

    public LitemallRegion findById(Integer id) {
        return regionMapper.selectByPrimaryKey(id);
    }

    public Integer findByCounty(String county){
        LitemallRegionExample example = new LitemallRegionExample();
        LitemallRegionExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(county)) {
            criteria.andNameLike("%" + county + "%");
        }
        criteria.andTypeEqualTo((byte) 3);
        List<LitemallRegion> regions = regionMapper.selectByExample(example);
        if (!regions.isEmpty()) {
            // 返回第一个匹配项的 id，或者你可以根据业务逻辑决定返回哪一个
            return regions.get(0).getId();
        }

        return null; // 没有找到匹配项时返回 null
    }

    public List<LitemallRegion> querySelective(String name, Integer code, Integer page, Integer size, String sort, String order) {
        LitemallRegionExample example = new LitemallRegionExample();
        LitemallRegionExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!StringUtils.isEmpty(code)) {
            criteria.andCodeEqualTo(code);
        }

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return regionMapper.selectByExample(example);
    }

}
