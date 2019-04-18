package cn.edu.nuc.ssm.service.impl.power;

import cn.edu.nuc.ssm.dao.power.RoleMapper;
import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.power.Role;
import cn.edu.nuc.ssm.service.interfaces.power.RoleService;
import cn.edu.nuc.ssm.util.StringUtil;
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
        if(!StringUtil.isNotEmpty(record.getRoleid())){
            record.setRoleid(StringUtil.getUUId());
        }
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

    @Override
    public PageInfo<Role> selectRoleByKey(int current, String key, int offset) {
        PageInfo pageInfo = new PageInfo(current);
        pageInfo.setOffset(offset);
        String keyMsg = "%"+key+"%";
        int count = roleMapper.selectRoleCount(keyMsg);
        pageInfo.setCount(count);
        List<Role> list = roleMapper.selectRoleByKey(keyMsg,pageInfo.getStart(),pageInfo.getOffset());
        pageInfo.setList(list);
        return  pageInfo;
    }
}
