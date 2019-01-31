package cn.edu.nuc.ssm.service.impl;

import cn.edu.nuc.ssm.dao.RoleMapper;
import cn.edu.nuc.ssm.dao.RoleMapper;
import cn.edu.nuc.ssm.entity.Role;
import cn.edu.nuc.ssm.service.interfaces.RoleService;
import cn.edu.nuc.ssm.service.interfaces.RoleService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色表操作的实现类
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public int deleteByPrimaryKey(String roleid) {
        return roleMapper.deleteByPrimaryKey(roleid);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public Role selectByPrimaryKey(String roleid) {
        return roleMapper.selectByPrimaryKey(roleid);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Role> selectAllRole() {
        return roleMapper.selectAllRole();
    }
}
