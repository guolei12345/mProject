package cn.edu.nuc.ssm.controller.movie;

import cn.edu.nuc.ssm.controller.BaseController;
import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.movie.Hall;
import cn.edu.nuc.ssm.entity.movie.Type;
import cn.edu.nuc.ssm.enums.MovieShowPath;
import cn.edu.nuc.ssm.service.interfaces.movie.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/type")
public class TypeController extends BaseController {
    @Autowired
    TypeService typeService;
    /**
     * 请求查询类型
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String getAdd(Model model){
        logger.info("to get add");
        model.addAttribute("movieShowPath", MovieShowPath.values());
        return "/type/add";
    }

    /**
     * 请求查询类型
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String postAdd(Type type ,Model model){
        logger.info("to get add");
        String msg = "";
        int rtn = typeService.insertSelective(type);
        if(rtn>0){
            msg = "添加功能成功！";
        }else   {
            msg = "添加功能失败！";
        }
        model.addAttribute("msg",msg);
        return "/index";
    }

    @RequestMapping(value="/search",method=RequestMethod.GET)
    public String list(@RequestParam(name="current",defaultValue="1") int current,
                       @RequestParam(name="key",defaultValue="")String key,
                       @RequestParam(name="offset",defaultValue="5")int offset,
                       Model model){
        PageInfo<Type> typePageInfo = typeService.selectTypeByKey(current,key,offset);
        model.addAttribute("typePage", typePageInfo);
        return "/type/select";
    }
    /**
     * 修改信息页面
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String getDelete(String typeid, Model model){
        logger.info("to get delete");
        String msg = "";
        int rtn = typeService.deleteByPrimaryKey(typeid);
        if(rtn > 0){
            msg = "删除成功！";
        }else{
            msg = "删除失败！";
        }
        model.addAttribute("msg",msg);
        return list(1,"",5,model);
    }
}
