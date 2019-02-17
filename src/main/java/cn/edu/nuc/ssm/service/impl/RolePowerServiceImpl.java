package cn.edu.nuc.ssm.service.impl;

import cn.edu.nuc.ssm.dao.RolePowerMapper;
import cn.edu.nuc.ssm.entity.RolePower;
import cn.edu.nuc.ssm.service.interfaces.RolePowerService;
import cn.edu.nuc.ssm.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePowerServiceImpl implements RolePowerService {
    @Autowired
    RolePowerMapper rolePowerMapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return rolePowerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RolePower record) {
        return rolePowerMapper.insert(record);
    }

    @Override
    public int insertSelective(RolePower record) {
        return rolePowerMapper.insertSelective(record);
    }

    @Override
    public RolePower selectByPrimaryKey(String id) {
        return rolePowerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RolePower record) {
        return rolePowerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RolePower record) {
        return rolePowerMapper.updateByPrimaryKey(record);
    }

    @Override
    public int saveOrUpdateRolePower(String roleid, String powerList) {
        String[] strings = powerList.split(",");
        rolePowerMapper.deleteByRoleId(roleid);
        RolePower rolePower;
        int rtn = 0;
        for(String powerid:strings){
            rolePower = new RolePower();
            rolePower.setId(StringUtil.getUUId());
            rolePower.setRoleid(roleid);
            rolePower.setPowerid(powerid);
            rtn = rtn + rolePowerMapper.insertSelective(rolePower);
        }
        return rtn;
    }
}
