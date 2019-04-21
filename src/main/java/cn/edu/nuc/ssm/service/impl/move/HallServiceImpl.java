package cn.edu.nuc.ssm.service.impl.move;

import cn.edu.nuc.ssm.dao.movie.HallMapper;
import cn.edu.nuc.ssm.dao.movie.MovieMapper;
import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.movie.Hall;
import cn.edu.nuc.ssm.entity.movie.Movie;
import cn.edu.nuc.ssm.service.interfaces.movie.HallService;
import cn.edu.nuc.ssm.service.interfaces.movie.MovieService;
import cn.edu.nuc.ssm.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {
    @Autowired
    private HallMapper hallMapper;
    @Override
    public int deleteByPrimaryKey(String moveid) {
        return hallMapper.deleteByPrimaryKey(moveid);
    }

    @Override
    public int insert(Hall record) {
        return hallMapper.insert(record);
    }

    @Override
    public int insertSelective(Hall record) {
        if(!StringUtil.isNotEmpty(record.getHallid())){
            record.setHallid(StringUtil.getUUId());
        }
        return hallMapper.insertSelective(record);
    }

    @Override
    public Hall selectByPrimaryKey(String moveid) {
        return hallMapper.selectByPrimaryKey(moveid);
    }

    @Override
    public int updateByPrimaryKeySelective(Hall record) {
        return hallMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Hall record) {
        return hallMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Hall> selectHallByKey(int current, String key, int offset) {
        PageInfo pageInfo = new PageInfo(current);
        pageInfo.setOffset(offset);
        String keyMsg = "%"+key+"%";
        int count = hallMapper.selectHallCount(keyMsg);
        pageInfo.setCount(count);
        List<Hall> list = hallMapper.selectHallByKey(keyMsg,pageInfo.getStart(),pageInfo.getOffset());
        pageInfo.setList(list);
        return  pageInfo;
    }
}
