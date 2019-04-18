package cn.edu.nuc.ssm.service.impl.power;

import cn.edu.nuc.ssm.dao.power.PowerMapper;
import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.power.Power;
import cn.edu.nuc.ssm.service.interfaces.power.PowerService;
import cn.edu.nuc.ssm.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        String parId = record.getPrapoerid();
        record.setPowerid(StringUtil.getUUId());
        //没有父级目录
        if(StringUtil.isNotEmpty(parId) && parId.equals("0")){
            record.setType("1");
        }else{
            record.setType("0");
        }
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

    @Override
    public List<Power> selectAllParPower(String s,String type) {
        return powerMapper.selectAllParPower(s,type);
    }

    @Override
    public PageInfo<Power> selectPowerByKey(int current, String key, int offset) {
        PageInfo pageInfo = new PageInfo(current);
        pageInfo.setOffset(offset);
        int count = powerMapper.selectPowerCountAll();
        pageInfo.setCount(count);
        String keyMsg = "%"+key+"%";
        List<Power> list = powerMapper.selectPowerByKey(keyMsg,pageInfo.getStart(),pageInfo.getOffset());
        List<Power> powerList = setParPower(list,powerMapper);
        pageInfo.setList(powerList);
        return  pageInfo;
    }

    /**
     * 设置父目录
     * @param list
     * @param powerMapper
     * @return
     */
    private List<Power> setParPower(List<Power> list, PowerMapper powerMapper) {
        for(Power power : list){
            if("0".equals(power.getType())&&StringUtil.isNotEmpty(power.getPrapoerid())){
                Power parPower =  powerMapper.selectByPrimaryKey(power.getPrapoerid());
                power.setParPower(parPower);
            }
        }
        return list;
    }

    @Override
    public List<Power> selectAllPower() {
        List<Power> powerList = powerMapper.selectAllPower("1");
        List<Power> list = setParPower(powerList,powerMapper);
        return list;
    }


}
