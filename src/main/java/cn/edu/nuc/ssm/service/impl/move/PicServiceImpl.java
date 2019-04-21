package cn.edu.nuc.ssm.service.impl.move;

import cn.edu.nuc.ssm.dao.movie.PicMapper;
import cn.edu.nuc.ssm.entity.movie.Pic;
import cn.edu.nuc.ssm.service.interfaces.movie.PicService;
import cn.edu.nuc.ssm.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PicServiceImpl implements PicService {
    @Autowired
    private PicMapper picMapper;
    @Override
    public int deleteByPrimaryKey(String picid) {
        return picMapper.deleteByPrimaryKey(picid);
    }

    @Override
    public int insert(Pic record) {
        if(!StringUtil.isNotEmpty(record.getPicid())){
            record.setPicid(StringUtil.getUUId());
        }
        return picMapper.insert(record);
    }

    @Override
    public Pic insertSelective(Pic record) {
        if(!StringUtil.isNotEmpty(record.getPicid())){
            record.setPicid(StringUtil.getUUId());
        }
        int rtn = picMapper.insertSelective(record);
        if(rtn>0){
            return record;
        }else {
            return null;
        }
    }

    @Override
    public Pic selectByPrimaryKey(String picid) {
        return picMapper.selectByPrimaryKey(picid);
    }

    @Override
    public int updateByPrimaryKeySelective(Pic record) {
        return picMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Pic record) {
        return picMapper.updateByPrimaryKey(record);
    }
}
