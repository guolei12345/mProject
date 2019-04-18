package cn.edu.nuc.ssm.service.impl.move;

import cn.edu.nuc.ssm.dao.movie.TypeMapper;
import cn.edu.nuc.ssm.entity.movie.Type;
import cn.edu.nuc.ssm.service.interfaces.movie.TypeService;
import cn.edu.nuc.ssm.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色表操作的实现类
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;
    @Override
    public int deleteByPrimaryKey(String typeid) {
        return typeMapper.deleteByPrimaryKey(typeid);
    }

    @Override
    public int insert(Type record) {
        return typeMapper.insert(record);
    }

    @Override
    public int insertSelective(Type record) {
        if(!StringUtil.isNotEmpty(record.getTypeid())){
            record.setTypeid(StringUtil.getUUId());
        }
        return typeMapper.insertSelective(record);
    }

    @Override
    public Type selectByPrimaryKey(String typeid) {
        return typeMapper.selectByPrimaryKey(typeid);
    }

    @Override
    public int updateByPrimaryKeySelective(Type record) {
        return typeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Type record) {
        return typeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Type> selectAllType() {
        return typeMapper.selectAllType();
    }
}
