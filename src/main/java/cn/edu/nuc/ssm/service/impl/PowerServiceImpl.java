package cn.edu.nuc.ssm.service.impl;

import cn.edu.nuc.ssm.dao.PowerMapper;
import cn.edu.nuc.ssm.entity.Power;
import cn.edu.nuc.ssm.service.interfaces.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 权限表操作的实现类
 */
@Service
public class PowerServiceImpl implements PowerService {
    @Autowired
    PowerMapper powerMapper;
    @Override
    public int deleteByPrimaryKey(String powerid) {
        return powerMapper.deleteByPrimaryKey(powerid);
    }

    @Override
    public int insert(Power record) {
        return powerMapper.insert(record);
    }

    @Override
    public int insertSelective(Power record) {
        return powerMapper.insertSelective(record);
    }

    @Override
    public Power selectByPrimaryKey(String powerid) {
        return powerMapper.selectByPrimaryKey(powerid);
    }

    @Override
    public int updateByPrimaryKeySelective(Power record) {
        return powerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Power record) {
        return powerMapper.updateByPrimaryKey(record);
    }
}
